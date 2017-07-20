package questionbank.dataaccess;

import lombok.extern.java.Log;
import questionbank.SQLConnection;
import questionbank.exceptions.DAOException;
import questionbank.exceptions.EntryNotFound;
import questionbank.pojo.Answer;
import questionbank.pojo.Category;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

@Log
public class CategoryDao {

    SQLConnection sqlConnection = SQLConnection.getInstance();

    public void createCategory(Category category) throws DAOException {
        String query = String.format("INSERT INTO `category`(`cat_name`) VALUES (\"%s\");", category.getCatName());
        log.log(Level.INFO, query);
        if (!sqlConnection.execute(query)) {
            throw new DAOException();
        }
    }
    public List<Category> getAllCategory() throws DAOException {
        String query = "SELECT `catid`, `cat_name` FROM `category'";
        log.log(Level.INFO, query);
        ResultSet rs = sqlConnection.executeQuery(query);
        List<Category> categoryList = new ArrayList<>();
        try {
            while (rs.next()) {
                Category category = new Category();
                category.setCatid(rs.getInt("catid"));
                category.setCatName(rs.getString("cat_name"));
                categoryList.add(category);
            }
            return categoryList;
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public Category getCategory(int catid) throws EntryNotFound, DAOException {
        String query = String.format("SELECT `catid`, `cat_name` FROM `category` WHERE catid=%d", catid);
        log.log(Level.INFO, query);
        ResultSet rs = sqlConnection.executeQuery(query);
        Category category = new Category();
        try {
            if (rs.next()) {
                category.setCatid(rs.getInt("catid"));
                category.setCatName(rs.getString("cat_name"));
                return category;
            }
            throw new EntryNotFound();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }
}
