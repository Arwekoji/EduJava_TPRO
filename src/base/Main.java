package base;

/**
 * Точка входа в программу
 *
 * @author Артур Федьвереш
 */
public class Main {

    /**
     * Точка входа в программу
     *
     * @param args Аргументы входа в программу
     * @author Артур Федьвереш
     */
    public static void main(String[] args) {
        FizzBuzz.printFizzBuzz(100);

        System.out.println("- - - - - -");

        DigitAnalyzer.showStatsAboutNumber(5071705);

        System.out.println("- - - - - -");

        Patterns.square((byte) 5);
        System.out.println();
        Patterns.rightTriangle((byte) 5);
        System.out.println();
        Patterns.pyramid((byte) 5);

        System.out.println("- - - - - -");

        PrimeNumbers.searchAndShowPrimeNumbers((byte) 100);
    }
}