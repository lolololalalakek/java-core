package lessons.lessons5.Quiz;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Quiz quiz = new Quiz("Java Basics Quiz");

        // Добавляем вопросы
        quiz.addQuestion(new TextQuestion("Who is a creator of Java?", "James Gosling"));
        quiz.addQuestion(new ChoiceQuestion(
            "What kind of data types usually uses at programming?",
            Arrays.asList("String", "int", "boolean", "double"),
            1 // правильный индекс: int (0-based)
        ));

        // Добавляем команды (используем конструктор Team(String name, int score))
        quiz.addTeam(new Team("Los-Angeles Lakers", 0));
        quiz.addTeam(new Team("Chicago Bulls", 0));

        // Запуск квиза
        quiz.start();
    }
}


