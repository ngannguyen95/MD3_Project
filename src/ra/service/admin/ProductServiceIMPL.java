package ra.service.admin;

import ra.config.Config;
import ra.model.Product;

import java.util.List;

public class ProductServiceIMPL implements IProductService {
    List<Product> productList =new Config<Product>().readFromFile(Config.PATH_PRODUCT);

    @Override
    public List findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getId()) == null) {
            productList.add(product);
        } else {
            // ngược lại thì update
            productList.set(productList.indexOf(findById(product.getId())), product);
        }
        // đọc file product
        new Config<Product>().writerFile(Config.PATH_PRODUCT,productList);
    }

    @Override
    public Product findById(int id) {
        for (Product pro : productList) {
            if (pro.getId() == id) {
                return pro;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (Product pro : productList) {
            if (pro.getId() == id) {
                productList.remove(pro);
                new Config<Product>().writerFile(Config.PATH_PRODUCT, productList);
                break;
            }
        }
    }
}
