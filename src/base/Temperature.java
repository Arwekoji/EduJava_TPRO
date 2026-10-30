package base;

/**
 * Записи температур с фабрикаторами и конверторами
 */
public class Temperature {
    public static final double TEMPERATURE_EXAMPLE = 0;

    double celsiusValue;

    /**
     * Конструктор, с указанием значения и типа температуры
     *
     * @param celsiusValue Значение температуры по шкале Цельсия
     */
    public Temperature(double celsiusValue) {
        this.celsiusValue = celsiusValue;
    }

    /**
     * Фабрикатор, принимающий на вход температуру в цельсиях
     *
     * @param celsiusValue Температура в цельсиях
     * @return Объект записи температуры в цельсиях
     */
    public static Temperature fromCelsius(double celsiusValue) {
        return new Temperature(celsiusValue);
    }

    /**
     * Фабрикатор, принимающий на вход температуру в фаренгейтах
     *
     * @param fahrenheitValue Температура в фаренгейтах
     * @return Объект записи температуры в цельсиях
     */
    public static Temperature fromFahrenheit(double fahrenheitValue) {
        return new Temperature(toCelsius(fahrenheitValue, TemperatureTypes.FAHRENHEIT));
    }

    /**
     * Фабрикатор, принимающий на вход температуру в кельвинах
     *
     * @param kelvinValue Температура в кельвинах
     * @return Объект записи температуры в цельсиях
     */
    public static Temperature fromKelvin(double kelvinValue) {
        return new Temperature(toCelsius(kelvinValue, TemperatureTypes.KELVIN));
    }

    /**
     * Конвертация температуры в значение по шкале Цельсия
     *
     * @param value Изначальное значение температуры
     * @param currentType Указание из какого типа нужно конвертировать температуру
     */
    public static double toCelsius(double value, TemperatureTypes currentType) {
        return switch (currentType) {
            case FAHRENHEIT -> (value - 32) * 5 / 9;
            case KELVIN -> value - 273.15;
            default -> value;
        };
    }

    /**
     * Конвертация температуры в значение по шкале Фаренгейта
     *
     * @param value Изначальное значение температуры
     * @param currentType Указание из какого типа нужно конвертировать температуру
     */
    public static double toFahrenheit(double value, TemperatureTypes currentType) {
        return switch (currentType) {
            case CELSIUS -> 32 + value * 9 / 5;
            case KELVIN -> 32 + (value - 273.15) * 9 / 5;
            default -> value;
        };
    }

    /**
     * Конвертация температуры в значение по шкале Кельвина
     *
     * @param value Изначальное значение температуры
     * @param currentType Указание из какого типа нужно конвертировать температуру
     */
    public static double toKelvin(double value, TemperatureTypes currentType) {
        return switch (currentType) {
            case CELSIUS -> value + 273.15;
            case FAHRENHEIT -> ((value - 32) * 5 / 9) + 273.15;
            default -> value;
        };
    }

    /**
     * Вывод информации о записи в формате Цельсия, Фаренгейта и Кельвина
     */
    public void printAll() {
        System.out.printf("""
                Температура (%.2f):
                (C°): %.2f
                (F):  %.2f
                (K): %.2f
                
                """, celsiusValue,
                toCelsius(celsiusValue, TemperatureTypes.CELSIUS),
                toFahrenheit(celsiusValue, TemperatureTypes.CELSIUS),
                toKelvin(celsiusValue, TemperatureTypes.CELSIUS));
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
