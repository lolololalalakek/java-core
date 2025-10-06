package lessons.lessons3.bankSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankSystem {
    private final Map<Integer, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            System.out.println("Аккаунт с таким номером уже существует!");
        } else {
            accounts.put(account.getAccountNumber(), account);
            System.out.println("Аккаунт успешно добавлен: " + account.getFio());
        }
    }

    public void deleteAccount(int accountNumber) {
        if (accounts.remove(accountNumber) != null) {
            System.out.println("Аккаунт удален!");
        } else {
            System.out.println("Аккаунт с таким номером не найден!");
        }
    }

    public BankAccount getAccountInfo(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void replenishAccount(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
                System.out.println("Баланс пополнен. Новый баланс: " + account.getBalance());
            } else {
                System.out.println("Сумма пополнения должна быть положительной!");
            }
        } else {
            System.out.println("Аккаунт не найден!");
        }
    }

    public void transferMoneyBetweenAccounts(int fromAccount, int toAccount, double amount) {
        BankAccount sender = accounts.get(fromAccount);
        BankAccount receiver = accounts.get(toAccount);

        if (sender == null || receiver == null) {
            System.out.println("Один из аккаунтов не найден!");
            return;
        }

        if (amount <= 0) {
            System.out.println("Сумма перевода должна быть положительной!");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Недостаточно средств на счете отправителя!");
            return;
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        System.out.println("Перевод выполнен успешно!");
        System.out.println("Новый баланс отправителя: " + sender.getBalance());
        System.out.println("Новый баланс получателя: " + receiver.getBalance());
    }

    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }
}
