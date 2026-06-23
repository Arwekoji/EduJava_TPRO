package base;

import java.math.BigDecimal;
import java.sql.SQLOutput;

/**
 * Точка входа
 *
 * @author Артур Федьвереш
 */
public class Main {
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
        TC.convertC2F(100);
        TC.convertC2K(100);
        TC.convertC2F(0);
        TC.convertC2K(0);
        TC.convertC2F(37);
        TC.convertC2K(37);
        TC.convertC2F(-40);
        TC.convertC2K(-40);
        System.out.println("Интересный факт: -40 градусов это точка пересечения шкал Цельсия и Фаренгейта, т.е. в этой точке обозначение температур одинаковое");
    }

}