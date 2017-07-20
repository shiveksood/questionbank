package questionbank.service;

import questionbank.dataaccess.QuestionDao;
import questionbank.exceptions.DAOException;
import questionbank.exceptions.DuplicateEntryException;
import questionbank.exceptions.EntryNotFound;
import questionbank.pojo.Question;

import static com.google.common.base.Preconditions.checkNotNull;


public class QuestionService {

    private static final QuestionDao questiondao = new QuestionDao();


    public Question addNewQuestion(Question question) {
        validateQuestion(question);
        try {
            questiondao.createQuestion(question);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (DuplicateEntryException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void validateQuestion(Question question) {
        checkNotNull(question);
        checkNotNull(question.getQuestion());
        checkNotNull(question.getOptions());
        checkNotNull(question.getCatid());
    }

    public Question getQuestionWithId(int qid) {
        try {
            return questiondao.getQuestion(qid);
        } catch (EntryNotFound entryNotFound) {
            entryNotFound.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteQuestion(int qid) {
        try {
            questiondao.deleteQuestion(qid);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


}
