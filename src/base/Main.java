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
        FizzBuzz rowReplacer = new FizzBuzz();
        rowReplacer.getReplacedByteRow();

        System.out.println("\n- - - - - -");

        DigitAnalyzer DA = new DigitAnalyzer();
        DA.analyze(5071705);

        System.out.println("- - - - - -");

        Patterns drawer = new Patterns();
        drawer.square((byte) 5);

        System.out.println();

        drawer.rightTriangle((byte) 5);

        System.out.println();

        drawer.pyramid((byte) 5);

        System.out.println("- - - - - -");

        PrimeNumbers PN = new PrimeNumbers();
        PN.getSimpleNumber((byte) 100);
    }
}