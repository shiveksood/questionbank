package questionbank.dataaccess;

import lombok.extern.java.Log;
import questionbank.SQLConnection;
import questionbank.exceptions.DAOException;
import questionbank.exceptions.DuplicateEntryException;
import questionbank.exceptions.EntryNotFound;
import questionbank.pojo.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

@Log
public class QuestionDao {

    SQLConnection sqlConnection = SQLConnection.getInstance();

    public void createQuestion(Question question) throws DAOException, DuplicateEntryException {
        checkDuplicate(question);
        String query = String.format("INSERT INTO `question`(`qid`, `catid`, `question`, `options`, `hash`) VALUES (%d,%d,%s,%s,%s)", question.getQid(), question.getCatid(),
                question.getQuestion(), question.getOptions(), question.getHash());
        log.log(Level.INFO, query);
        if (!sqlConnection.execute(query)) {
            throw new DAOException();
        }
    }

    private void checkDuplicate(Question question) throws DuplicateEntryException {
        String query = String.format("SELECT `qid`, `catid`, `question`, `options`, `hash` FROM `question` WHERE hash=%d", question.getHash());
        log.log(Level.INFO, query);
        if (sqlConnection.execute(query)) {
            throw new DuplicateEntryException();
        }
    }

    public Question getQuestion(int qid) throws EntryNotFound, DAOException {
        String query = String.format("SELECT `qid`, `catid`, `question`, `options`, `hash` FROM `question` WHERE qid=%d", qid);
        log.log(Level.INFO, query);
        ResultSet rs = sqlConnection.executeQuery(query);
        Question question = new Question();
        try {
            if (rs.next()) {
                question.setQid(rs.getInt("qid"));
                question.setCatid(rs.getInt("catid"));
                question.setQuestion(rs.getString("question"));
                question.setHash(rs.getString("hash"));
                question.setOptions(rs.getString("options"));
                return question;
            }
            throw new EntryNotFound();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public boolean deleteQuestion(int qid) throws DAOException {
        String query = String.format("DELETE FROM `question` WHERE qid=%d", qid);
        log.log(Level.INFO, query);
        if (!sqlConnection.execute(query)) {
            throw new DAOException();
        }
        return false;
    }
}
