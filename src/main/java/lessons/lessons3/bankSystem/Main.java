package lessons.lessons3.bankSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        BankAccount acc1 = new BankAccount(1001, "Брюс Ли", 1000);
        BankAccount acc2 = new BankAccount(1002, "Брэд Питт", 500);

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        System.out.println();

        BankAccount firstAccount = bank.getAccountInfo(1001);
        System.out.println(firstAccount);

        bank.replenishAccount(1002, 200);
        System.out.println();

        System.out.println(acc1.getBalance());
        System.out.println();

        bank.transferMoneyBetweenAccounts(1001, 1002, 300);
        System.out.println();

        BankAccount secondAccount = bank.getAccountInfo(1001);
        System.out.println(secondAccount);

        BankAccount thirdAccount = bank.getAccountInfo(1002);
        System.out.println(thirdAccount);

        bank.deleteAccount(1001);
        System.out.println();

        BankAccount fourthAccount = bank.getAccountInfo(1001);
        System.out.println(fourthAccount);
        System.out.println();

        List<BankAccount> allAccounts = bank.getAllAccounts();
        System.out.println(allAccounts);
    }
}
