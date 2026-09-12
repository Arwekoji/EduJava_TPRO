package base;

import assist.AdvancedText;
import assist.CodeMetrics;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static assist.TestData.*;

/**
 * Частично защищенный класс банковского аккаунта
 */
public class BankAccount {
    private static final int HISTORY_SIZE = 100;
    private static long totalAccounts = 0L; // Это приватная банковская информация!

    private String[] transactionHistory = new String[HISTORY_SIZE];
    private int totalLastTransactions = 0; // В связи с указанием использовать статичный массив, я вижу необходимость в данном счетчике
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
    protected void deposit(double addition) {
        try {
            if (addition < 0)
                throw new IllegalArgumentException("Пополнение не может быть отрицательным! Операция отменена");
            balance += addition;
            updateHistory(String.format("Депозит (%.2f)", addition));
        } catch (IllegalArgumentException error) {
            CodeMetrics.printError(error);
        }
    }

    /**
     * Операция снятия средств со счёта. Нельзя снять отрицательную сумму или если запрошенная сумма больше имеющейся
     *
     * @param subtrahend Сумма, запрошенная для снятия
     */
    protected void withdraw(double subtrahend) {
        try {
            if (subtrahend < 0)
                throw new IllegalArgumentException("Снятие не может быть отрицательным! Операция отменена");
            if (subtrahend > balance)
                throw new IllegalArgumentException("На балансе не хватает средств! Операция отменена");

            balance -= subtrahend;
            updateHistory(String.format("Снятие (%.2f)", subtrahend));
        } catch (IllegalArgumentException error) {
            CodeMetrics.printError(error);
        }
    }

    /**
     * Сеттер истории транзакций
     *
     * @return Копия истории транзакций
     */
    private void updateHistory(String operation) {
        if (totalLastTransactions == HISTORY_SIZE) {
            for (int i = 0; i < HISTORY_SIZE - 1; i++)
                transactionHistory[i] = transactionHistory[i + 1];

            transactionHistory[HISTORY_SIZE - 1] = getTransactionMessage(operation);
        } else {
            transactionHistory[totalLastTransactions] = getTransactionMessage(operation);
            totalLastTransactions++;
        }
    }

    /**
     * Сеттер имени владельца счёта
     *
     * @param newName Новое имя (ФИО или другой формат) владельца счёта
     */
    protected void setOwner(String newName) {
        owner = new String(newName);
    }

    /**
     * Геттер текущего количества счетов в банке
     *
     * @return Количество счетов в банке
     */
    static protected long getTotalAccounts() {
        return totalAccounts;
    }

    /**
     * Геттер баланса счёта
     *
     * @return Баланс счёта
     */
    protected double getBalance() {
        return balance;
    }

    /**
     * Геттер номера счёта
     *
     * @return Номер счёта
     */
    protected String getId() {
        return new String(id);
    }

    /**
     * Геттер имени владельца счёта
     *
     * @return Имя владельца счёта
     */
    protected String getOwner() {
        return new String(owner);
    }

    /**
     * Геттер истории транзакций
     *
     * @return Копия истории транзакций
     */
    protected String[] getTransactionHistory() {
        return Arrays.copyOf(transactionHistory, totalLastTransactions);
    }

    /**
     * Метод для формирования полноценной записи о выполненной операции
     *
     * @param operation Тип операции
     * @return Отформатированная строка, содержащая тип операции и время её выполнения
     */
    private static String getTransactionMessage(String operation) {
        return LocalTime.now().withNano(0) + ": " + operation;
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
        for (short i = 0; i < BANK_ACCOUNTS_QUANTITY; i++) {
            System.out.println();
            AdvancedText.println("- - - **[b]АНАЛИТИКА НОВОГО АККАУНТА В БАНКЕ[b]** - - -");

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

            System.out.println("• Производится тестовая попытка сменить имя владельца счёта");
            account.setOwner("Аноним Анонимович");
            account.printStatement();

            System.out.println("История транзакций:");
            for (String record : account.getTransactionHistory())
                System.out.println(record);
        }

        System.out.println("* * *");
        AdvancedText.println("**__Всего счетов зарегистрировано__**: " + BankAccount.getTotalAccounts());
        System.out.println("* * *");
    }
}

/*
Задача 1. Класс BankAccount с инкапсуляцией.
Переработайте класс BankAccount из задания 4.1 применив принципы инкапсуляции:
 - Все поля сделайте private. Добавьте геттеры для всех полей.
 - Реализуйте сеттеры только там где это имеет смысл: имя владельца можно изменить, номер счёта — нельзя.
 - Добавьте валидацию в методы deposit (сумма должна быть положительной) и withdraw (сумма положительная и не превышает баланс).
 - Для истории транзакций добавьте private массив String[] transactionHistory на 100 записей и метод getTransactionHistory возвращающий
                                                                                                        копию заполненной части массива.
 - При каждом пополнении и снятии добавляйте запись в историю.
 */