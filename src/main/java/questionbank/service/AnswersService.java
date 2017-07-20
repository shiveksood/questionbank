package questionbank.service;


import questionbank.dataaccess.AnswersDao;
import questionbank.exceptions.DAOException;
import questionbank.exceptions.EntryNotFound;
import questionbank.pojo.Answer;

import static com.google.common.base.Preconditions.checkNotNull;

public class AnswersService {

    private static final AnswersDao answerDao = new AnswersDao();


    public Answer getAnswerById(int qid) {
        try {
            answerDao.getAnswer(qid);
        } catch (EntryNotFound entryNotFound) {
            entryNotFound.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Answer createAnswer(Answer answer) {
        validateAnswer(answer);
        try {
            answerDao.createAnswer(answer);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void validateAnswer(Answer answer) {
        checkNotNull(answer);
        checkNotNull(answer.getAnswer());
    }
}
