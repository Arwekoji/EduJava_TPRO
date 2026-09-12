package base;

import assist.AdvancedText;
import assist.CodeMetrics;
import assist.TestData;

import java.util.Random;

/**
 * Хранение и оперирование записями температур в формате Цельсия
 */
public class Temperature {
    private static final double ABSOLUTE_ZERO = 273.15;

    private double celsius;

    /**
     * Конструктор с параметром
     *
     * @param celsius Температура для заполнения
     */
    public Temperature(double celsius) {
        try {
            if (celsius < -1 * ABSOLUTE_ZERO)
                throw new IllegalArgumentException("Температура по Цельсию не может быть ниже абсолютного нуля!");
            this.celsius = celsius;
        } catch (IllegalArgumentException error) {
            CodeMetrics.printError(error);
            this.celsius = 0;
        }
    }

    /**
     * Упрощенный конструктор без параметра - температура выставляется случайно
     */
    public Temperature() {
        this(new Random().nextDouble(TestData.TEMPERATURE_RANGE[0], TestData.TEMPERATURE_RANGE[1]));
    }

    /**
     * Геттер значения температуры по шкале Цельсия
     *
     * @return Значение температура по шкале Цельсия
     */
    public double getCelsius() {
        return celsius;
    }

    /**
     * Геттер значения температуры по шкале Кельвина
     *
     * @return Значение температуры по шкале Кельвина
     */
    public double getKelvin() {
        return celsius + ABSOLUTE_ZERO;
    }

    /**
     * Геттер значения температуры по шкале Кельвина
     *
     * @return Значение температуры по шкале Фаренгейта
     */
    public double getFahrenheit() {
        return 32 + (celsius * 9 / 5);
    }

    /**
     * Сеттер температуры из Цельсия в Цельсий
     *
     * @param celsius Температура для записи
     */
    public void setCelsius(double celsius) {
        try {
            if (celsius < -1 * ABSOLUTE_ZERO)
                throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля!");
            this.celsius = celsius;
        } catch (IllegalArgumentException error) {
            CodeMetrics.printError(error);
        }
    }

    /**
     * Сеттер температуры из Кельвина в Цельсий
     *
     * @param kelvin Температура для записи, по шкале Кельвина
     */
    public void setKelvin(double kelvin) {
        try {
            if (kelvin < 0)
                throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля!");
            celsius = kelvin - ABSOLUTE_ZERO;
        } catch (IllegalArgumentException error) {
            CodeMetrics.printError(error);
        }
    }

    /**
     * Сеттер температуры из Фаренгейта в Цельсий
     *
     * @param fahrenheit Температура для записи, по шкале Фаренгейта
     */
    public void setFahrenheit(double fahrenheit) {
        celsius = (fahrenheit - 32) * 5 / 9;
        try {
            if (ABSOLUTE_ZERO + (fahrenheit - 32) * 5 / 9 < 0)
                throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля!");
            celsius = (fahrenheit - 32) * 5 / 9;
        } catch (IllegalArgumentException error) {
            CodeMetrics.printError(error);
        }
    }

    /**
     * Переопределение функции toString для вывода
     *
     * @return Данные о записанной температуре в формате трёх шкал в одной строке
     */
    public String toString() {
        return String.format("%.2f°C /  %.2f°F / %.2fK", getCelsius(), getFahrenheit(), getKelvin());
    }

    /**
     * Тестовая процедура для демонстрации возможностей класса
     */
    public static void testClass() {
        Temperature tempRecord = new Temperature();
        AdvancedText.println("[r]Температура[r]: " + tempRecord);

        System.out.println("Ниже будут произведена попытка конвертации температуры в " + TestData.TEMPERATURE_EXAMPLES[0] + "°K");
        tempRecord.setKelvin(TestData.TEMPERATURE_EXAMPLES[0]);
        AdvancedText.println("[r]Температура[r]: " + tempRecord);

        System.out.println("Ниже будут произведена попытка создания новой записи температуры в " + TestData.TEMPERATURE_EXAMPLES[1] + "°С");
        tempRecord = new Temperature(TestData.TEMPERATURE_EXAMPLES[1]);
        AdvancedText.println("[r]Температура[r]: " + tempRecord);

        System.out.println("Ниже будут произведена попытка конвертации последней температуры в " + TestData.TEMPERATURE_EXAMPLES[2] + "°F");
        tempRecord.setFahrenheit(TestData.TEMPERATURE_EXAMPLES[2]);
        AdvancedText.println("[r]Температура[r]: " + tempRecord);

        System.out.println("Ниже будут произведена попытка конвертации последней температуры в " + TestData.TEMPERATURE_EXAMPLES[3] + "°C");
        tempRecord.setCelsius(TestData.TEMPERATURE_EXAMPLES[3]);
        AdvancedText.println("[r]Температура[r]: " + tempRecord);
    }
}

/*
Задача 2. Класс Temperature с инкапсуляцией.
Создайте класс Temperature где единственное private поле celsius хранит температуру.
- Добавьте геттеры getCelsius, getFahrenheit, getKelvin которые вычисляют значения на лету.
- Добавьте сеттеры setCelsius, setFahrenheit, setKelvin — каждый пересчитывает и сохраняет значение в celsius.
- Добавьте валидацию: температура не может быть ниже абсолютного нуля (-273.15 по Цельсию).
- Реализуйте метод toString возвращающий строку вида "23.00°C / 73.40°F / 296.15K".
 */