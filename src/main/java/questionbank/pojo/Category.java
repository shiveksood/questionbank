package questionbank.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Category {
    @Getter
    @Setter
    private int catid;

    @Getter
    @Setter
    private String catName;
}
