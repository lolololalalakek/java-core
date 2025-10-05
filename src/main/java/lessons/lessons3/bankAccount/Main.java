package lessons.lessons3.bankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount firstAccount = new BankAccount("Juraev Jamshid", 18282, 200.5);

        double firstAccountBalance = firstAccount.getBalance();
        System.out.println("Баланс: " + firstAccountBalance);
        firstAccount.deposit(700);
        double secondAccountBalance = firstAccount.getBalance();
        System.out.println("Баланс: "+ secondAccountBalance);
        firstAccount.withdraw(531);
        double thirdAccountBalance = firstAccount.getBalance();
        System.out.println(thirdAccountBalance);
    }
}
