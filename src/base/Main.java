package base;

import java.math.BigDecimal;

/**
 * Точка входа
 *
 * @author Артур Федьвереш
 */
public class Main {
    static final double CELSIUS_BOILING_WATER = 100;
    static final double CELSIUS_FREEZE_WATER = 0;
    static final double CELSIUS_BODY_TEMPERATURE = 37;
    static final double CELSIUS_CROSS_FAHRENHEIT = -40;
    /**
     * Точка входа в программу
     *
     * @author Артур Федьвереш
     */
    public static void main(String[] args) {
        StudentProfile SP = new StudentProfile();
        SP.returnStudentInfo();

        System.out.println("- - - -");

        Overflow OverflowDemonstration = new Overflow();
        OverflowDemonstration.integerDemonstrations();

        System.out.println("- - - -");

        Finance FinanceDemonstration = new Finance();
        FinanceDemonstration.inaccurateSumABC(0.1, 0.2, 0);
        FinanceDemonstration.inaccurateSumABC(10.0, -9.0, -0.9);
        FinanceDemonstration.sumABC(new BigDecimal("0.1"), new BigDecimal("0.2"), new BigDecimal("0"));
        FinanceDemonstration.sumABC(new BigDecimal("10.0"), new BigDecimal("-9.0"), new BigDecimal("-0.9"));

        System.out.println("- - - -");

        TempConverter TC = new TempConverter();
        TC.convertC2F(CELSIUS_BOILING_WATER);
        TC.convertC2K(CELSIUS_BOILING_WATER);
        TC.convertC2F(CELSIUS_FREEZE_WATER);
        TC.convertC2K(CELSIUS_FREEZE_WATER);
        TC.convertC2F(CELSIUS_BODY_TEMPERATURE);
        TC.convertC2K(CELSIUS_BODY_TEMPERATURE);
        TC.convertC2F(CELSIUS_CROSS_FAHRENHEIT);
        TC.convertC2K(CELSIUS_CROSS_FAHRENHEIT);
        System.out.println("Интересный факт: -40 градусов это точка пересечения шкал Цельсия и Фаренгейта, т.е. в этой точке обозначение температур одинаковое");
    }

}