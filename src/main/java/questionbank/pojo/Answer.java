package questionbank.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class Answer {

    @Getter
    @Setter
    private int qid;

    @Getter @Setter private String answer;

}
