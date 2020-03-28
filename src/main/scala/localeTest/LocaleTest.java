package localeTest;

import java.util.Arrays;
import java.util.Locale;

public class LocaleTest {

    public static void main(String[] args) {

        Object a = getTUserLocale();
        System.out.println(a);

        for (Object b : Locale.getISOLanguages()) {
            System.out.println(b);
        }
    }

    public static Locale getTUserLocale() {
        return new Locale(Arrays.stream(Locale.getISOLanguages()).filter(l -> "ja_GR".startsWith(l)).findFirst().orElse("ko"));
    }
}
