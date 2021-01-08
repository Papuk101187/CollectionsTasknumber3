import javax.swing.text.html.parser.Parser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String user = "-7006755 закупка аппаратуры\n" +
                "-150 услуги почты\n" +
                "+2000 продажа товара\n" +
                "-200876 услуги почты\n" +
                "-100 неплановые расходы\n" +
                "+7525 продажа товара\n" +
                "END";

        Programs programs = new Programs(user);
        programs.getProces();
        programs.getCheck();



    }


}

