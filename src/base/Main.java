package base;

import java.math.BigDecimal;

/**
 * Точка входа
 *
 * @author Артур Федьвереш
 */
public class Main {

    /**
     * Точка входа
     *
     * @author Артур Федьвереш
     */
    public static void main(String[] args) {
        //Задача №1
        GradeConverter grade = new GradeConverter();
        byte[] examplesByte = {95, 80, 65, 45, 100, 0, -5, 101};

        for (byte i : examplesByte)
            System.out.println(i + " = " + grade.convert2TextByIf(i) + " / " + grade.convert2TextBySwitch(i) );

        System.out.println("- - - - - -");

        //Задача №2
        TimeOfDay timeConvert = new TimeOfDay();
        timeConvert.analyseTime((byte)12, (byte)4);

        System.out.println("- - - - - -");

        //Задача №3 c рекурсией примеров
        SmartCalc calculator = new SmartCalc();
        char[] exampleOperators = {'+', '-', '*', '/', '%'};
        String[] exampleOperands = {"10", "6", "0"};

        for (String aString : exampleOperands)
            for (String bString : exampleOperands) {
                BigDecimal a = new BigDecimal(aString);
                BigDecimal b = new BigDecimal(bString);
                for (char i : exampleOperators)
                    System.out.print(a + " " + i + " " + b + " = " + calculator.calculate(a, i, b) + " | ");
                System.out.println();
        }

        System.out.println("- - - - - -");

        GuessGame GG = new GuessGame();
        GG.guess(42);
        GG.guess(41);

    }
}