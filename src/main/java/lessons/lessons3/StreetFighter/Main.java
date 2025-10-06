package lessons.lessons3.StreetFighter;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StreetFighter f1 = new StreetFighter(1, "T-800", 700, 40);
        StreetFighter f2 = new StreetFighter(2, "T-1000", 1000, 70);

        StreetFighter[] fighters = {f1, f2};
        StreetFighter.getFighters(fighters);

        System.out.println("\nНачинается бой!");

        Random r = new Random();
        boolean firstAttack = r.nextBoolean(); // кто начнёт бой

        while (f1.getHealth() > 0 && f2.getHealth() > 0) {
            if (firstAttack) {
                f1.fight(f2);
                if (f2.getHealth() <= 0) break;
                f2.fight(f1);
            } else {
                f2.fight(f1);
                if (f1.getHealth() <= 0) break;
                f1.fight(f2);
            }
        }

        System.out.println("Бой завершён!");
        System.out.println();
        System.out.println(f1.getFighterInfo());
        System.out.println(f2.getFighterInfo());
    }
}
