package base;

import java.math.BigDecimal;

/**
 * Точка входа
 *
 * @author Артур Федьвереш
 */
public class Main {
    static final double CELSIUS_BOILING_WATER = 100; // Являются публичными по причине использования при вызове методов другого класса
    static final double CELSIUS_FREEZE_WATER = 0;
    static final double CELSIUS_BODY_TEMPERATURE = 37;
    static final double CELSIUS_CROSS_FAHRENHEIT = -40;

    /**
     * Точка входа в программу
     *
     * @author Артур Федьвереш
     */
    public static void main(String[] args) {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setStudentInfo('B', (short) 13, (byte) 2, 1996, 5550505L, 2.3f, 2.21, false);
        System.out.println(studentProfile);

        System.out.println("- - - -");

        Overflow overflowDemonstration = new Overflow();
        overflowDemonstration.integerDemonstrations();

        System.out.println("- - - -");

        Finance financeDemonstration = new Finance();
        financeDemonstration.inaccurateSumABC(0.1, 0.2, 0);
        financeDemonstration.inaccurateSumABC(10.0, -9.0, -0.9);
        financeDemonstration.sumABC(new BigDecimal("0.1"), new BigDecimal("0.2"), new BigDecimal("0"));
        financeDemonstration.sumABC(new BigDecimal("10.0"), new BigDecimal("-9.0"), new BigDecimal("-0.9"));

        System.out.println("- - - -");

        // Код был сделан до замечаний по первой главе. Методы класса теперь static
        System.out.printf("Конвертер: Температура %.0fС° = %.2fK или %.2fF",
                CELSIUS_BOILING_WATER, TempConverter.convertCelsiusToKelvin(CELSIUS_BOILING_WATER), TempConverter.convertCelsiusToFahrenheit(CELSIUS_BOILING_WATER));
        System.out.println();
        System.out.printf("Конвертер: Температура %.0fС° = %.2fK или %.2fF",
                CELSIUS_FREEZE_WATER, TempConverter.convertCelsiusToKelvin(CELSIUS_FREEZE_WATER), TempConverter.convertCelsiusToFahrenheit(CELSIUS_FREEZE_WATER));
        System.out.println();
        System.out.printf("Конвертер: Температура %.0fС° = %.2fK или %.2fF",
                CELSIUS_BODY_TEMPERATURE, TempConverter.convertCelsiusToKelvin(CELSIUS_BODY_TEMPERATURE), TempConverter.convertCelsiusToFahrenheit(CELSIUS_BODY_TEMPERATURE));
        System.out.println();
        System.out.printf("Конвертер: Температура %.0fС° = %.2fK или %.2fF",
                CELSIUS_CROSS_FAHRENHEIT, TempConverter.convertCelsiusToKelvin(CELSIUS_CROSS_FAHRENHEIT), TempConverter.convertCelsiusToFahrenheit(CELSIUS_CROSS_FAHRENHEIT));
        System.out.println();
        System.out.println("Интересный факт: -40 градусов это точка пересечения шкал Цельсия и Фаренгейта, т.е. в этой точке обозначение температур одинаковое");
    }

}
