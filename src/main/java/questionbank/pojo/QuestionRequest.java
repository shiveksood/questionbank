package questionbank.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by shivek on 13/7/17.
 */
@ToString
public class QuestionRequest {
    @Getter
    @Setter
    Question question;
    @Getter
    @Setter
    Answer answer;
}
