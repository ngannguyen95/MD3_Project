package ra.view.admin;

import ra.config.InputMethod;
import ra.controller.category.CategoryController;
import ra.model.Category;

import java.util.List;

public class CategoryView {

    public CategoryView() {
        System.out.println("****************  Quản lí danh mục sách  ***************");
        System.out.print("1.Hiển thị danh mục     ");
        System.out.print("2.Thêm danh mục     ");
        System.out.print("3.Sửa     ");
        System.out.print("4.Xóa     ");
        System.out.println("5.Trở về trang ADMIN");
        int choise = InputMethod.getInteger();
        switch (choise) {
            case 1:
                //show list
                showFormCategoryList();
                break;
            case 2:
                //create
                formCreateCategory();
                break;
            case 3:
                //update
                formUpdateCategory();
                break;
            case 4:
                //delete
                deleteCategory();
                break;
            case 5:
                new AdminPage();
                break;
            default:
                System.out.println("Vui lòng chọn lại...");
                break;


        }
    }

    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    //hiển thị danh mục
    public void showFormCategoryList() {
        System.out.println("---------- Thông tin danh mục ----------");
        System.out.println("---- ID ---- Tên danh mục ----");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println("---- " + categoryList.get(i).getId() + "---- " + categoryList.get(i).getCategoryName());
        }

        new CategoryView();
//
    }

    //thêm mới danh mục sản phẩm
    public void formCreateCategory() {
        while (true) {
            int id = 0;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập vào tên danh mục: ");
            String name = InputMethod.getString();
            Category category = new Category(id, name);
            categoryController.createCategoryToDB(category);
            System.out.println("Thêm mới thành công !!");
            new CategoryView();
        }
    }

    //update
    public void formUpdateCategory() {
        while (true) {
            System.out.println("Nhập vào id danh mục cần sửa:");
            int id = InputMethod.getInteger();
            if (categoryController.detailCategory(id) == null) {
                System.out.println("Id không ồn tại!! Vui lòng thử lại ");
            } else {
                System.out.println("Nhập vào tên danh mục:");
                String name = InputMethod.getString();
                Category category = new Category(id, name);
                categoryController.updateCategory(category);
                System.out.println("Cập nhật thành công");
                System.out.printf("----Id:"+category.getId()+" -----Tên danh mục:  "+category.getCategoryName()+"\n");
                new CategoryView();
            }
        }
    }

    public void deleteCategory() {
        while (true) {
            System.out.println("Nhập vào id cần xóa: ");
            int id = InputMethod.getInteger();
            if (categoryController.detailCategory(id) == null) {
                System.out.println("Id không tồn tại, vui lòng nhập lại");
            } else {
                categoryController.deleteCategory(id);
                System.out.println("Xóa thành công");
            }
            new CategoryView();
        }
    }


}
