import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Programs {

    String string;
    List<String> lists;
    HashMap<String, Integer> conteiner = new HashMap();

    public Programs(String str) {
        string = str;
    }

    void getProces() {

        lists = Arrays.asList(string.split("\n"));

        List<Expenserecord> expense = lists.stream()  // расход
                .filter(s -> s.startsWith("-"))//фильтруем
                .map(s -> s.substring(1)) //убираем первый елемент
                .map(parts -> new Expenserecord(getStrin(parts), getIn(parts))) //формируем объеты
                .collect(Collectors.toList());


        //for (Expenserecord expenserecord : expense) {
        // System.out.println("запись " + expenserecord.summ);
        // }


        List<Incomerecord> income = lists.stream() // доход
                .filter(s -> s.startsWith("+"))//фильтруем
                .map(s -> s.substring(1)) //убираем первый елемент
                .map(s -> s.substring(0, 4))
                .map(parts -> new Incomerecord(parts.substring(4), Integer.parseInt(parts.substring(0, 4)))) //формируем объеты
                .collect(Collectors.toList());


        int sumone = 0;
        String names = "Всего дохода";

        for (Incomerecord s : income) {


            sumone = sumone + s.summ;

            if (!conteiner.containsKey(s.name)) {
                conteiner.put(names, s.summ);
            } else {
                int integer = (Integer) conteiner.get(s.name);
                int i = integer + s.summ;
                conteiner.put(names, i);
            }
            conteiner.put(names, sumone);

        }


        int sum = 0;
        int sumexpense = conteiner.get(names);
        String name = "Доход с учётом расхода";


        for (Expenserecord s : expense) {
            sumexpense = sumexpense - s.summ;

            if (!conteiner.containsKey(s.name)) {
                conteiner.put(s.name, s.summ);
            } else {
                int integer = (Integer) conteiner.get(s.name);
                int i = integer + s.summ;
                conteiner.put(s.name, i);
            }
            conteiner.put(name, sumexpense);

        }
    }

    void getCheck() {
        for (final Map.Entry<String, Integer> entry : conteiner.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }

    private int getIn(String parseInt) {
        Pattern pattern = Pattern.compile("([0-9]++)");
        Matcher matcher = pattern.matcher(parseInt);
        Integer number = 0;

        while (matcher.find()) {
            // System.out.println("выбрали число "+ matcher.group());
            number = Integer.parseInt(matcher.group());
        }
        return number;
    }


    private String getStrin(String substring) {

        Pattern pattern = Pattern.compile("[а-я ]++");
        Matcher matcher = pattern.matcher(substring);
        String name = "";

        while (matcher.find()) {
            name = (matcher.group());
        }
        return name;
    }


}
