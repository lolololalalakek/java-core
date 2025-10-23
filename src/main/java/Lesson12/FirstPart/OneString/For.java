package Lesson12.FirstPart.OneString;

import java.util.List;

public class For {
    public static void main(String[] args) {
        List<String> names = List.of("Tom", "Jerry", "Spike");

        String result = "";
        for (int i = 0; i < names.size(); i++) {
            result += names.get(i);
            if (i < names.size() - 1) { // чтобы не ставить запятую после последнего имена (после Спайка)
                result += ", ";
            }
        }
        System.out.println(names);
        System.out.println(result);
    }
}
