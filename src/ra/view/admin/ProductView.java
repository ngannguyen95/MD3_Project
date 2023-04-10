package ra.view.admin;

import ra.config.InputMethod;
import ra.controller.category.CategoryController;
import ra.controller.category.ProductController;
import ra.model.Category;
import ra.model.Product;

import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.getListProduct();

    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void productView() {
        while (true) {
            System.out.println("-----------  Quản lí sản phẩm  ------------");
            System.out.print("1.Hiển thị sản phẩm     ");
            System.out.print("2.Thêm sản phẩm theo danh mục    ");
            System.out.print("3.Sửa     ");
            System.out.print("4.Xóa     ");
            System.out.println("5.Trở về trang ADMIN");
            System.out.println("Nhập vào lựa chọn: ");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    showFormProduct();
                    break;
                case 2:
                    formCreateProduct();
                    break;
                case 3:
                    formUpdateProduct();
                    break;
                case 4:
                    formDeleteProduct();
                    break;
                case 5:
                    new AdminPage();
                default:
                    System.out.println("Vui lòng nhập lại!!!");
                    break;
            }
        }

    }

    public void showFormProduct() {
        System.out.println("------------------- PRODUCT ----------------------");
        System.out.println("     ID      PRODUCT NAME      PRICE     CATERORY     STATUS");
        for (Product product : productList) {
            System.out.println("     " + product.getId() + "      " + product.getProductName() + "      " + product.getPrice() + "    " + product.getCategory().getCategoryName()+"     "+product.isStatus());
        }
        System.out.println("---------------------------------------------------\n");
    }

    public void formCreateProduct() {

            Product product = new Product();
            if (productList.size() == 0) {
                product.setId(1);
            } else {
                product.setId(productList.get(productList.size() - 1).getId() + 1);
            }
            System.out.print("Nhập vảo tên sản phẩm: ");
            product.setProductName(InputMethod.getString());
            System.out.println("Nhập vào giá sản phẩm: ");
            product.setPrice(InputMethod.getFloat());
            for (Category cata : categoryList) {
                System.out.println(cata);
            }
            System.out.println("Chọn Catagory theo id:");
            int id = InputMethod.getInteger();
            for (Category cata : categoryList) {
                if (cata.getId() == id) {
                    product.setCategory(cata);
                }
            }
            productController.createProduct(product);
            System.out.println("Thêm vào thành công.");

        new ProductView();

    }

    public void formUpdateProduct() {
        System.out.println("Nhập vào id sản phẩm cần sửa: ");
        int id = InputMethod.getInteger();
        if (productController.detailProduct(id) == null) {
            System.out.println("Id không tồn tại, vui lòng nhập lại!!");
        } else {
            System.out.println("Nhập vào tên cần sửa: ");
            String productName = InputMethod.getString();
            System.out.println("Nhập vào giá cần sửa:");
            Float price = InputMethod.getFloat();
            for (Category c : categoryList) {
                System.out.println(c);
            }
            Category category = null;
            System.out.println("Nhập vào id Caterory cần sửa:  ");
            int idUpdate = InputMethod.getInteger();
            for (Category cata : categoryList) {
                if (cata.getId() == idUpdate) {
                    category = cata;
                }
            }
            System.out.println("Nhập vào trạng thái sản  phẩm: ");
            Boolean status = InputMethod.getBoolean();
            Product product = new Product(id, productName, price, category, status);
            productController.updateProduct(product);
        }
    }

    public void formDeleteProduct() {
        System.out.println("Nhập vào id sản phẩm cần xóa: ");
        int id = InputMethod.getInteger();
        if (productController.detailProduct(id) == null) {
            System.err.println("Id không tồn tại.");
            return;
        }
        productController.deleteProduct(id);
        System.out.println("Xóa thành công..");
    }

    public void formSearchProduct() {
        System.out.println("Nhập vào id sản phẩm: ");
        int id=InputMethod.getInteger();
        if (productController.detailProduct(id) == null) {
            System.err.println("Id không tồn tại.");
            return;
        }else {
            System.out.println(productController.detailProduct(id));
        }
    }
}
