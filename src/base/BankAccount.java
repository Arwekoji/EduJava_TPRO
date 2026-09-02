package base;

import java.util.concurrent.ThreadLocalRandom;

import static base.Main.FIRST_NAME_EXAMPLES;
import static base.Main.LAST_NAME_EXAMPLES;

/**
 * Частично защищенный класс банковского аккаунта
 */
public class BankAccount {
    static protected final short ACCOUNTS_QUANTITY = 3; // totalAccounts и ACCOUNTS_QUANTITY в данной ситуации равны, но ACCOUNTS_QUANTITY является отладочной константой

    static private long totalAccounts = 0L; // Это приватная банковская информация!

    private String id, owner; // ID сильно упрощен
    private double balance = 0;

    /**
     * Конструктор, базовый, без указания стартового баланса
     *
     * @param owner Имя владельца счета
     * @param id    Сформированный номер счета
     */
    protected BankAccount(String owner, String id) { // Нельзя создать счет в банке с деньгами до первого пополнения
        this.owner = owner;
        this.id = id;
        totalAccounts++;
    }

    /**
     * Конструктор, случайный. Для тестовых целей
     */
    protected BankAccount() {
        this(String.format("(ТЕСТОВЫЙ) %s %s",
                        FIRST_NAME_EXAMPLES[ThreadLocalRandom.current().nextInt(0, FIRST_NAME_EXAMPLES.length)],
                        LAST_NAME_EXAMPLES[ThreadLocalRandom.current().nextInt(0, LAST_NAME_EXAMPLES.length)]),
                String.valueOf(totalAccounts + 1000));
        balance = (double) ThreadLocalRandom.current().nextInt(0, 1000000);
    }

    /**
     * Операция пополнения счёта
     *
     * @param addition Сумма для пополнения счёта. Не может быть меньше нуля
     */
    protected void deposit(int addition) {
        balance += Math.max(addition, 0);
    }

    /**
     * Операция снятия средств со счёта. Не может быть больше 0
     *
     * @param subtrahend Сумма, запрошенная для снятия
     */
    protected void withdraw(int subtrahend) {
        if (subtrahend <= balance)
            balance -= Math.min(0, subtrahend);
        else
            System.out.println("Для данной операции на балансе не хватает средств!");
    }

    /**
     * Вывод баланса счёта
     *
     * @return Баланс счёта
     */
    protected double getBalance() {
        return new Double(balance);
    }

    /**
     * Вывод текущего количества счетов в банке
     *
     * @return Количество счетов в банке
     */
    static protected long getTotalAccounts() {
        return new Long(totalAccounts);
    }

    /**
     * Вывод информации о счёте в консоль
     */
    protected void printStatement() {
        System.out.printf("""
                        ———————————————
                        Счёт #%s
                        Владелец: %s
                        Баланс: %.2f ₽
                        ———————————————
                        """,
                id, owner, getBalance()
        );
    }

    /**
     * Тестовый метод для демонстрации возможностей класса
     */
    public static void testClass() {
        for (short i = 0; i < BankAccount.ACCOUNTS_QUANTITY; i++) {
            BankAccount account = new BankAccount();
            account.printStatement();
            System.out.println("• Производится тестовая попытка произвести депозит на 1 000 ₽");
            account.deposit(1000);
            System.out.println(String.format("Текущий баланс: %.2f", account.getBalance()));
            System.out.println("• Производится тестовая попытка снять со счёта сумму на 2 000 ₽");
            account.withdraw(2000);
            System.out.println(String.format("Текущий баланс: %.2f", account.getBalance()));
            System.out.println("• Производится тестовая попытка снять со счёта сумму на 2 000 000 ₽");
            account.withdraw(2000000);
            System.out.println(String.format("Текущий баланс: %.2f", account.getBalance()));
        }

        System.out.println("* * *");
        System.out.println("Всего счетов зарегистрировано: " + BankAccount.getTotalAccounts());
        System.out.println("* * *");
    }
}
