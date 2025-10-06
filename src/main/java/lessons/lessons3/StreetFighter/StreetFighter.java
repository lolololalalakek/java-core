package lessons.lessons3.StreetFighter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class StreetFighter {

    private int code;
    private String name;
    private int health;
    private int attack;

    public void fight(StreetFighter opponent) {
        if (this.health > 0) {
            opponent.health -= this.attack;
            System.out.println(this.name + " атакует " + opponent.name +
                " на " + this.attack + " урона.");
            if (opponent.health <= 0) {
                opponent.health = 0;
                System.out.println(opponent.name + " побежден!");
            } else {
                System.out.println("У " + opponent.name + " осталось " + opponent.health + " HP.");
            }
        } else {
            System.out.println(this.name + " уже не может сражаться.");
        }
    }


    public String getFighterInfo() {
        return "Fighter{" +
            "code=" + code +
            ", name='" + name + '\'' +
            ", health=" + health +
            ", attack=" + attack +
            '}';
    }

    // Статический метод: вывод всех бойцов
    public static void getFighters(StreetFighter[] fighters) {
        for (StreetFighter f : fighters) {
            System.out.println(f.getFighterInfo());
        }
    }

}
