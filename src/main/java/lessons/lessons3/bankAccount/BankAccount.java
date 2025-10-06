package lessons.lessons3.bankAccount;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BankAccount {

    private String fio;
    private int accountNumber;
    private double balance;

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снято " + amount);
        } else if (amount > balance) {
            System.out.println("Недостаточно средств для снятия.");
        } else {
            System.out.println("Сумма должна быть положительной.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Пополнено на " + amount);

        } else {
            System.out.println("Сумма должна быть положительной.");
        }
    }


}
