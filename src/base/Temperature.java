package base;

/**
 * Записи температур с фабрикаторами и конверторами
 */
public class Temperature {
    public static final double TEMPERATURE_EXAMPLE = 0;

    double value;

    /**
     * Фабрикатор, принимающий на вход температуру в цельсиях
     *
     * @param value Температура в цельсиях
     * @return Запись температуры в цельсиях
     */
    public static Temperature fromCelsius(double value) {
        return new Temperature(value);
    }

    /**
     * Фабрикатор, принимающий на вход температуру в фаренгейтах
     *
     * @param value Температура в фаренгейтах
     * @return Запись температуры в цельсиях
     */
    public static Temperature fromFahrenheit(double value) {
        Temperature temperature = new Temperature(value);
        temperature.toCelsius("Fahrenheit");
        return temperature;
    }

    /**
     * Фабрикатор, принимающий на вход температуру в кельвинах
     *
     * @param value Температура в кельвинах
     * @return Запись температуры в цельсиях
     */
    public static Temperature fromKelvin(double value) {
        Temperature temperature = new Temperature(value);
        temperature.toCelsius("Kelvin");
        return temperature;
    }

    /**
     * Конструктор, с указанием значения температуры
     *
     * @param value Значение температуры (Безразмерно)
     */
    public Temperature(double value) {
        this.value = value;
    }

    /**
     * Конвертация содержимого записи в значение по шкале Цельсия
     *
     * @param currentType Указание из какого типа нужно конвертировать температуру
     */
    public void toCelsius(String currentType) {
        switch (currentType) {
            case "Fahrenheit":
                value = (value - 32) * 5 / 9;
                break;
            case "Kelvin":
                value -= 273.15;
                break;
        }
    }

    /**
     * Конвертация содержимого записи в значение по шкале Фаренгейта
     *
     * @param currentType Указание из какого типа нужно конвертировать температуру
     */
    public void toFahrenheit(String currentType) {
        switch (currentType) {
            case "Celsius":
                value = 32 + value * 9 / 5;
                break;
            case "Kelvin":
                value = 32 + (value - 273.15) * 9 / 5;
                ;
                break;
        }
    }

    /**
     * Конвертация содержимого записи в значение по шкале Кельвина
     *
     * @param currentType Указание из какого типа нужно конвертировать температуру
     */
    public void toKelvin(String currentType) {
        switch (currentType) {
            case "Celsius":
                value = value - 273;
                break;
            case "Fahrenheit":
                value = ((value - 32) * 5 / 9) + 273.15;
                break;
        }
    }

    /**
     * Вывод информации о записи в формате Цельсия, Фаренгейта и Кельвина
     */
    public void printAll() {
        System.out.printf("""
                Температура: 
                (C°): %.2f
                """, value);
        toFahrenheit("Celsius");
        System.out.println(String.format("(F): %.2f", value));
        toKelvin("Fahrenheit");
        System.out.println(String.format("(K): %.2f", value));
        System.out.println();
        toCelsius("Kelvin"); // Даже несмотря на то, что в тесте объект больше не будет использоваться, нужно привести его в изначальную форму
    }

    /**
     * Тестовый метод для демонстрации его возможностей
     */
    public static void testClass() {
        Temperature[] temperatureRecords = {
                Temperature.fromCelsius(TEMPERATURE_EXAMPLE), Temperature.fromFahrenheit(TEMPERATURE_EXAMPLE), Temperature.fromKelvin(TEMPERATURE_EXAMPLE)
        };

        for (Temperature tempRecord : temperatureRecords)
            tempRecord.printAll();
    }
}
