package ra.controller.category;

import ra.model.Product;
import ra.service.admin.IProductService;
import ra.service.admin.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    public IProductService productService=new ProductServiceIMPL();
    public List<Product> getListProduct(){
        return productService.findAll();
    }
    // xây dựng phương thức này cả thêm mới và sửa
    public void createProduct(Product product){
        productService.save(product);
    }
    public void updateProduct(Product product){
        productService.save(product);
    }
    // phương thức show
    public Product detailProduct(int id){
        return productService.findById(id);
    }
    public void deleteProduct(int id){
        productService.deleteById(id);
    }

}
