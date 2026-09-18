package base;

import utils.ConsoleFormat;

import java.time.LocalDateTime;

/**
 * Запись о банковской транзакции
 */
public class Transaction {
    private final String type, description;
    private final double amount, balanceAfter;
    private final String timestamp;

    /**
     * Конструктор с автоматическим определением времени транзакции
     *
     * @param type         Тип транзакции (Депозит / Снятие)
     * @param amount       Сумма транзакции
     * @param balanceAfter Сумма баланса счёта после транзакции
     * @param description  Комментарий к транзакции
     */
    public Transaction(String type, double amount, double balanceAfter, String description) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.description = description;
        this.timestamp = LocalDateTime.now().withNano(0).toString();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return ConsoleFormat.getCols(
                String.format("<D>%s:<D> [%s] COL %.2f ₽ COL Остаток: **%.2f** COL <[]> %s <[]>",
                        getTimestamp(), getType(), getAmount(), getBalanceAfter(), getDescription()
                ),
                "COL", "", new int[]{46, 15, 30}
        );
    }
}

/*
Transaction
├── type: String              — "DEPOSIT" или "WITHDRAW"
├── amount: double            — сумма
└── timestamp: String         — дата/время
 */

/* Задание 4.6 — Мини-проект: Банковская система

Реализуйте банковскую систему по архитектуре описанной в статье.
Используйте классы Transaction, BankAccount и Bank как основу.
Вы можете расширить систему по своему усмотрению, но базовые требования обязательны.

Обязательные требования:
 - Класс Transaction должен быть неизменяемым (все поля private final) и содержать информацию о
    типе операции, сумме, балансе после операции и описании.
 - Класс BankAccount должен хранить историю транзакций в массиве, не допускать отрицательного баланса при снятии, не допускать отрицательных сумм операций.
    Номер счёта генерируется автоматически через статический счётчик. Метод printStatement выводит все операции с форматированием.
 - Класс Bank должен хранить массив счетов, поддерживать открытие нового счёта и поиск по ID.
    Метод printReport выводит сводку по всем счетам с суммарным балансом.

В методе main продемонстрируйте:
- открытие минимум трёх счетов для разных владельцев
- серию пополнений и снятий
- перевод между счетами
- попытку снять больше чем есть на счёте (показать обработку ошибки)
- вывод выписок по каждому счёту
- вывод общего отчёта банка

Расширения на дополнительный балл:
1. Добавьте тип счёта SAVINGS с начислением процентов: метод addInterest принимает double rate и начисляет проценты на текущий баланс.
2. Реализуйте поиск счёта с максимальным балансом в классе Bank.
3. Добавьте метод в Bank который выводит все счета конкретного владельца по имени.

 Нельзя снять больше, чем есть на счёте
• Нельзя пополнить на отрицательную сумму
• После перевода сумма корректно списывается с одного счёта и зачисляется на другой
• История транзакций корректно записывается и выводится
• Общий отчёт показывает правильный суммарный баланс

Ожидаемый результат
Критерии оценки:
- классы разбиты по файлам, каждый в своём .java файле
- все поля private, доступ только через методы
- невозможно создать транзакцию или счёт с некорректными данными
- перевод корректно работает в обе стороны и фиксируется в истории обоих счетов
- код читаемый: методы короткие, имена переменных понятные
- вывод отформатирован и удобен для чтения
 */