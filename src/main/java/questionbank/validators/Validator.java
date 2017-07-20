package questionbank.validators;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Validator {

    private Validator() {

    }

    public static void notNullOrEmpty(String str) {
        checkNotNull(str);
        checkArgument(str.length() > 0);
    }

    public static void notNull(Object o) {
        checkNotNull(o);
    }

    public static void notEmpty(String str) {
        checkArgument(str.length() > 0);
    }


}
