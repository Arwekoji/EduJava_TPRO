package base;

import utils.CodeMetrics;
import utils.ConsoleFormat;

/**
 * Банковский аккаунт / счёт
 */
public class BankAccount {
    private static final int MAX_TRANSCATIONS = 100;
    private static int nextId = 1000;

    private final String id, type; // "DEBIT" или "SAVINGS"
    private final Transaction[] transactions; // final означает, что нельзя присвоить новый массив. Но данный менять можно

    private String owner;
    private double balance;
    private int transactionCount; // Работает быстрее и защищеннее, чем динамический массив, ценой статичности

    /**
     * Конструктор, с параметрами имени владельца и типом счёта
     *
     * @param owner Имя владельца (В любом формате)
     * @param type  Тип счёта (DEBIT / SAVINGS)
     */
    public BankAccount(String owner, String type) {
        this.id = "ACC-" + (++nextId);
        this.owner = owner;
        this.type = type;
        this.balance = 0.0;
        this.transactions = new Transaction[MAX_TRANSCATIONS];
        this.transactionCount = 0;
    }

    /**
     * Пополняет счёт на указанную сумму с комментарием и регистрирует запись в истории транзакций
     *
     * @param amount      Сумма пополнения. Не может быть меньше или равна нулю
     * @param description Комментарий к данному типу транзакции
     * @return Успешность транзакции
     */
    public boolean deposit(double amount, String description) {
        if (amount <= 0) {
            CodeMetrics.printError("Сумма пополнения должна быть положительной");
            return false;
        }
        balance += amount;
        addTransaction("<g>ПОПОЛНЕНИЕ<g>", amount, description);
        CodeMetrics.printLog(ConsoleFormat.getCols(
                String.format("Счёт %s <g>пополнен<g> на *%.2f* ₽ COLБаланс: **%.2f** COL<[]> %s <[]>", id, amount, balance, description),
                "COL", "", new int[]{55, 30}
        ));
        return true;
    }

    /**
     * Снимает со счёта указанную сумму с комментарием и регистрирует запись в истории транзакций
     *
     * @param amount      Сумма снятия. Не может быть меньше или равна нулю
     * @param description КОмментарий к снятию
     * @return Успешность транзакции
     */
    public boolean withdraw(double amount, String description) {
        if (amount <= 0) {
            CodeMetrics.printError("Сумма снятия должна быть положительной");
            return false;
        }
        if (amount > balance) {
            CodeMetrics.printError(ConsoleFormat.getCols(
                    String.format("Недостаточно средств. Запрошено: *%.2f* COLБаланс: **%.2f** COL<[]> %s <[]>", amount, balance, description),
                    "COL", "", new int[]{47, 30}
            ));
            return false;
        }
        balance -= amount;
        addTransaction("<y>СНЯТИЕ<y>", amount, description);
        CodeMetrics.printLog(ConsoleFormat.getCols(
                String.format("Со счёта %s <y>снято<y> *%.2f* ₽ COLБаланс: **%.2f** COL<[]> %s <[]>", id, amount, balance, description),
                "COL", "", new int[]{55, 30}
        ));
        return true;
    }

    /**
     * Переводит с одного счёта на другой указанную сумму и регистрирует на обоих запись в истории транзакций
     *
     * @param target Целевой счёт
     * @param amount Сумма для перевода
     * @return Успешность транзакции
     */
    public boolean transfer(BankAccount target, double amount) {
        if (this.withdraw(amount, "Перевод на счёт " + target.getId())) {
            target.deposit(amount, "Перевод со счёта " + this.id);
            return true;
        }
        return false;
    }

    /**
     * Добавляет запись в историю транзакций
     *
     * @param type        Тип транзакции
     * @param amount      Сумма транзакции
     * @param description Комментарий к транзакции
     */
    private void addTransaction(String type, double amount, String description) {
        if (transactionCount < MAX_TRANSCATIONS)
            transactions[transactionCount++] = new Transaction(type, amount, balance, description);
    }

    /**
     * Добавляет проценты на накопительный счёт
     *
     * @param rate Процентная ставка
     * @return Успешность транзакции / пополнения счёта
     */
    public boolean addIntent(double rate) {
        if (!getType().equals("SAVINGS")) {
            CodeMetrics.printError("Эта операция на данном счёте недоступна");
            return false;
        }
        double deposit = balance * rate / 100;
        balance += deposit;
        addTransaction("<g>ПОПОЛНЕНИЕ<g>", deposit, "Проценты по накопительному счёту");

        return true;
    }

    /**
     * Сформировывает строку с историей транзакций данного аккаунта
     *
     * @return Строка с историей транзакций
     */
    private String getTransactionHistory() {
        StringBuilder history = new StringBuilder();

        for (int i = 0; i < transactionCount; i++)
            history.append(transactions[i]).append(String.format("%n"));

        return history.toString();
    }

    /**
     * Вывод в консоль выписку данного счёта
     */
    public void printStatement() {
        ConsoleFormat.println(String.format("""
                        <y>ВЫПИСКА СЧЁТА **#%s**<y>
                        %s
                        Тип: **%-20s** Владелец: **%s**
                        Баланс: **%.2f ₽**
                        ------
                        *История транзакций:*
                        %s
                        %s
                        """, id,
                ConsoleFormat.getLine("=", 110),
                getType(), getOwner(),
                getBalance(),
                (transactionCount == 0) ? "Операций нет" : getTransactionHistory(),
                ConsoleFormat.getLine("=", 110)
        ));
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }
}

/*
BankAccount
├── id: String                — номер счёта
├── owner: String             — владелец
├── balance: double           — баланс
├── type: AccountType         — тип счёта
└── transactions: Transaction[] — история

Обязательные требования:
 - Класс BankAccount должен хранить историю транзакций в массиве, не допускать отрицательного баланса при снятии, не допускать отрицательных сумм операций.
    Номер счёта генерируется автоматически через статический счётчик. Метод printStatement выводит все операции с форматированием.

Расширения на дополнительный балл:
1. Добавьте тип счёта SAVINGS с начислением процентов: метод addInterest принимает double rate и начисляет проценты на текущий баланс.
2. Реализуйте поиск счёта с максимальным балансом в классе Bank.
3. Добавьте метод в Bank который выводит все счета конкретного владельца по имени.
 */

/* Ожидаемый результат
Критерии оценки:
- классы разбиты по файлам, каждый в своём .java файле
- все поля private, доступ только через методы
- невозможно создать транзакцию или счёт с некорректными данными
- перевод корректно работает в обе стороны и фиксируется в истории обоих счетов
- код читаемый: методы короткие, имена переменных понятные
- вывод отформатирован и удобен для чтения
 */