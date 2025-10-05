package lessons.lessons5.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Абстракция
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
abstract class Question {
    private String text;

    // Полиморфизм
    public abstract boolean checkAnswer(String answer);
}

// Наследование
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
class TextQuestion extends Question {
    private String correctAnswer;

    public TextQuestion(String text, String correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }
}

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
class ChoiceQuestion extends Question {
    private List<String> options = new ArrayList<>();
    private int correctIndex;

    public ChoiceQuestion(String text, List<String> options, int correctIndex) {
        super(text);
        this.options = options;
        this.correctIndex = correctIndex;
    }

    @Override
    public boolean checkAnswer(String answer) {
        try {
            int choice = Integer.parseInt(answer) - 1;
            return choice == correctIndex;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Team {
    private String name;
    private int score = 0;

    public void addScore(int points) {
        score += points;
    }
}

public class Quiz {
    private String title;
    private final List<Question> questions = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quiz is starting: " + title);

        for (Question q : questions) {
            System.out.println("\nQuestion is : " + q.getText());

            if (q instanceof ChoiceQuestion choiceQ) {
                List<String> opts = choiceQ.getOptions();
                for (int i = 0; i < opts.size(); i++) {
                    System.out.println((i + 1) + ") " + opts.get(i));
                }
            }

            for (Team t : teams) {
                System.out.print("Answer of team " + t.getName() + ": ");
                String answer = scanner.nextLine();

                if (q.checkAnswer(answer)) {
                    System.out.println("Right!");
                    t.addScore(1);
                } else {
                    System.out.println("Wrong!");
                }
            }
        }

        System.out.println("\n=== Results ===");
        for (Team t : teams) {
            System.out.println(t.getName() + ": " + t.getScore() + " scores");
        }
    }
}



