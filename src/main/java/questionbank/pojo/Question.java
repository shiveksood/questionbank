package questionbank.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class Question {

    @Getter
    @Setter
    private int qid;
    @Getter
    @Setter
    private String question;
    @Getter
    @Setter
    private String options;
    @Getter
    @Setter
    private String hash;
    @Getter
    @Setter
    private int catid;

}
