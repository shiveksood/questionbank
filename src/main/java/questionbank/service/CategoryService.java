package questionbank.service;

import lombok.extern.java.Log;
import questionbank.dataaccess.CategoryDao;
import questionbank.exceptions.DAOException;
import questionbank.exceptions.EntryNotFound;
import questionbank.pojo.Category;

import java.util.List;
import java.util.logging.Level;

import static com.google.common.base.Preconditions.checkNotNull;

@Log
public class CategoryService {

    CategoryDao categoryDao = new CategoryDao();

    public Category getCategory(int catid) {
        try {
            return categoryDao.getCategory(catid);
        } catch (EntryNotFound entryNotFound) {
            entryNotFound.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Category> getAllCategory() {
        try {
            return categoryDao.getAllCategory();
        } catch (DAOException e) {
            log.log(Level.SEVERE, "Unable to fetch all the category");
        }
        return null;
    }

    public Category createCategory(Category category) {
        validate(category);
        try {
            categoryDao.createCategory(category);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return category;
    }

    private void validate(Category category) {
        checkNotNull(category);
        checkNotNull(category.getCatName());
    }

}
