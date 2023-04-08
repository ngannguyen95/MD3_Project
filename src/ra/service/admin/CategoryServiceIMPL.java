package ra.service.admin;

import ra.config.Config;
import ra.model.Category;

import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {
    List<Category> categoryList = new Config<Category>().readFromFile(Config.PATH_CATEGORY);

    @Override
    public List findAll() {
        return categoryList;
    }

    //thực hiện chức năng thêm và update
    @Override
    public void save(Category category) {
        if (findById(category.getId()) == null) {
            categoryList.add(category);
        } else {
            categoryList.set(categoryList.indexOf(findById(category.getId())), category);
        }
        new Config<Category>().writerFile(Config.PATH_CATEGORY, categoryList);
    }

    // trả về category theo id
    @Override
    public Category findById(int id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                categoryList.remove(category);
                new Config<Category>().writerFile(Config.PATH_CATEGORY, categoryList);
                return;
            }
        }
    }
}
