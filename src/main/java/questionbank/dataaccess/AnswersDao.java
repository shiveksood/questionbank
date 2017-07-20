package questionbank.dataaccess;

import lombok.extern.java.Log;
import questionbank.SQLConnection;
import questionbank.exceptions.DAOException;
import questionbank.exceptions.EntryNotFound;
import questionbank.pojo.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;


@Log
public class AnswersDao {

    SQLConnection sqlConnection = SQLConnection.getInstance();

    public void createAnswer(Answer ans) throws DAOException {

        String query = String.format("INSERT INTO `answers`(`qid`, `answer`) VALUES (%d,\"%s\");", ans.getQid(), ans.getAnswer());
        log.log(Level.INFO, query);
        if (!sqlConnection.execute(query)) {
            throw new DAOException();
        }
    }

    public Answer getAnswer(int qid) throws EntryNotFound, DAOException {
        String query = String.format("SELECT `qid`, `answer` FROM `answers` WHERE qid=%d", qid);
        log.log(Level.INFO, query);
        ResultSet rs = sqlConnection.executeQuery(query);
        Answer ans = new Answer();
        try {
            if (rs.next()) {
                ans.setQid(rs.getInt("qid"));
                ans.setAnswer(rs.getString("answer"));
                return ans;
            }
            throw new EntryNotFound();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public boolean deleteAnswer(int qid) throws DAOException {
        String query = String.format("DELETE FROM `answers` WHERE qid=%d", qid);
        log.log(Level.INFO, query);
        if (!sqlConnection.execute(query)) {
            throw new DAOException();
        }
        return false;
    }
}
