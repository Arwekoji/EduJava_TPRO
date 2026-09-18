package base;

import utils.CodeMetrics;
import utils.ConsoleFormat;

import java.util.ArrayList;

/**
 * Банковская структура
 */
public class Bank {
    private static final int MAX_ACCOUNTS = 50; // Общее правило для всех банков

    private final String name; // Имя банка
    private final BankAccount[] accounts; // final: !Формально! не может быть присвоен чужой список, но данный может изменять свое содержимое

    private int accountCount; // Счетчик аккаунтов в данном банке

    /**
     * Конструктор, с параметром названия
     *
     * @param name Название банка
     */
    public Bank(String name) {
        this.name = name;
        this.accounts = new BankAccount[MAX_ACCOUNTS]; // Статичный массив менее удобен, чем динамичный, но выигрывает в оперативной скорости
        this.accountCount = 0;
    }

    /**
     * Открывает счёт в данном банке для указанного пользователя
     *
     * @param owner Потенциальный владелец счёта
     * @param type  Тип счёта (DEBIT / SAVINGS)
     * @return Статус открытия счёта (Провал или нет)
     */
    public BankAccount openAccount(String owner, String type) {
        if (accountCount >= MAX_ACCOUNTS) {
            CodeMetrics.printWarn("Достигнут лимит счетов");
            return null;
        }
        BankAccount account = new BankAccount(owner, type);
        accounts[accountCount++] = account;
        CodeMetrics.printLog("Открыт счёт " + account.getId() + " для " + owner);
        return account;
    }

    /**
     * Ищет аккаунт в банке по заданному id
     *
     * @param id Идентификатор банковского аккаунта
     * @return null или банковский аккаунт с искомым ID
     */
    public BankAccount findAccount(String id) {
        for (int i = 0; i < accountCount; i++)
            if (accounts[i].getId().equals(id))
                return accounts[i];
        return null;
    }

    /**
     * Ищет аккаунт в банке с наибольшим балансом
     *
     * @return null или банковский аккаунт с наибольшим балансом на счету
     */
    public BankAccount findMaxBalance() {
        BankAccount richAccount = accounts[0];
        if (richAccount == null)
            return null;

        for (int i = 0; i < accountCount; i++)
            if (accounts[i].getBalance() > richAccount.getBalance())
                richAccount = accounts[i];
        return richAccount;
    }

    /**
     * Ищет все аккаунты в банке, принадлежащие указанному владельцу
     *
     * @param owner Имя владельца аккаунтов
     * @return null или список аккаунтов указанного владельца
     */
    public ArrayList<BankAccount> findOwnerAccounts(String owner) {
        if (owner == null || owner.isBlank() || accountCount == 0)
            return null;

        ArrayList<BankAccount> ownerAccounts = new ArrayList<>();
        for (int i = 0; i < accountCount; i++)
            if (accounts[i].getOwner().equals(owner))
                ownerAccounts.add(accounts[i]);

        return (ownerAccounts.isEmpty()) ? null : ownerAccounts;
    }

    /**
     * Выводит в консоль сформированный отчёт о структуре банка
     */
    public void printReport() {
        ConsoleFormat.println(String.format("""
                        
                        <D>%s<D>
                        %sОТЧЁТ БАНКА <y>***%s***<y>
                        <D>%s<D>
                        __Всего счетов:__ %d
                        """,
                ConsoleFormat.getLine("="), " ".repeat(ConsoleFormat.LINE_LENGTH / 3), name,
                ConsoleFormat.getLine("="), accountCount
        ));

        double totalBalance = 0;
        for (int i = 0; i < accountCount; i++) {
            totalBalance += accounts[i].getBalance();
            ConsoleFormat.println(String.format("%-12s | %-21s | %10.2f ₽",
                    accounts[i].getId(),
                    accounts[i].getOwner(),
                    accounts[i].getBalance()
            ));
        }

        BankAccount richestAccount = findMaxBalance();
        ConsoleFormat.println(String.format("""
                        <D>%s<D>
                        Суммарный баланс: **%.2f** ₽
                        Аккаунт с наибольшим балансом: <y>**%s**<y>
                        <D>%s<D>
                        """,
                ConsoleFormat.getLine(),
                totalBalance,
                (richestAccount != null) ? richestAccount.getId() : "Отсутствует",
                ConsoleFormat.getLine("=")
        ));
    }

    /**
     * Запускает скрипт для демонстрации возможностей банковской структуры
     */
    public static void testScript() {
        Bank bank = new Bank("Альфа-Банк");
        bank.printReport();
        ConsoleFormat.println("***__Тестовое открывание счетов:__***");

        // Открываем счета
        BankAccount
                alice = bank.openAccount("Алиса Иванова", "DEBIT"),
                bob = bank.openAccount("Боб Петров", "SAVINGS"),
                carol = bank.openAccount("Кэрол Смирнова", "DEBIT"),
                andy1 = bank.openAccount("Энди Дюфрейн", "DEBIT"),
                andy2 = bank.openAccount("Энди Дюфрейн", "DEBIT"),
                andy3 = bank.openAccount("Энди Дюфрейн", "SAVINGS");

        ConsoleFormat.println("***__Тестовые транзакции:__***");
        // Операции
        alice.deposit(13000, "Зарплата");
        alice.deposit(10000, "Фриланс");
        alice.withdraw(15000, "Аренда квартиры");
        alice.withdraw(50000, "Продукты");

        bob.deposit(100000, "Накопления");
        bob.addIntent(13);

        alice.transfer(carol, 8000);

        ConsoleFormat.printEmptyLine();
        ConsoleFormat.println("***__Тестовые выписки:__***");
        // Выписки
        alice.printStatement();
        bob.printStatement();
        carol.printStatement();

        // Общий счёт
        bank.printReport();

        ConsoleFormat.printEmptyLine();
        ConsoleFormat.println("***__Аккаунты Энди Дюфрейна:__***");
        // Поиск аккаунтов по имени владельца и выписка счетов по ним
        ArrayList<BankAccount> andyAccounts = bank.findOwnerAccounts("Энди Дюфрейн");
        if (andyAccounts != null) for (BankAccount andyAccount : andyAccounts)
            andyAccount.printStatement();
    }
}
/* В методе main продемонстрируйте:
- открытие минимум трёх счетов для разных владельцев
- серию пополнений и снятий
- перевод между счетами
- попытку снять больше чем есть на счёте (показать обработку ошибки)
- вывод выписок по каждому счёту
- вывод общего отчёта банка

Bank
├── accounts: BankAccount[] — массив счетов
└── Методы управления счетами

Обязательные требования:
 - Класс Bank должен хранить массив счетов, поддерживать открытие нового счёта и поиск по ID.
    Метод printReport выводит сводку по всем счетам с суммарным балансом.

Расширения на дополнительный балл:
1. Добавьте тип счёта SAVINGS с начислением процентов: метод addInterest принимает double rate и начисляет проценты на текущий баланс.
2. Реализуйте поиск счёта с максимальным балансом в классе Bank.
3. Добавьте метод в Bank который выводит все счета конкретного владельца по имени.

Критерии оценки:
- классы разбиты по файлам, каждый в своём .java файле
- все поля private, доступ только через методы
- невозможно создать транзакцию или счёт с некорректными данными
- перевод корректно работает в обе стороны и фиксируется в истории обоих счетов
- код читаемый: методы короткие, имена переменных понятные
- вывод отформатирован и удобен для чтения
 */