package base;

/**
 * Класс для анализа заданных чисел
 */
public class DigitAnalyzer {

    private record DigitData(byte digitQuantity, byte digitMax, int digitSum) {}

    /**
     * Процедура анализа заданного числа и вывода в консоль его результатов
     *
     * @param num Вводимое число для анализа типа Integer
     */
    public static void showStatsAboutNumber(int num) {
        DigitData digitData = DigitAnalyzer.analyzeNumber(num);

        boolean isPalindrome = DigitAnalyzer.isPalindrome(num, digitData.digitQuantity);

        DigitAnalyzer.printResult(num, digitData, isPalindrome);
    }

    /**
     * Функция вычисления количества и суммы цифр, а также наибольшей цифры в данном числе
     *
     * @param num Число для анализа типа int
     * @return Вывод записи с количеством и суммой цифр, и наибольшей среди них
     */
    public static DigitData analyzeNumber(int num) {
        byte digitQuantity = 0, digitMax = 0;
        int digitSum = 0;

        int numCalculated = num;
        while (numCalculated > 0) {//Вычисляем дополнительную информацию по заданной цифре
            digitMax = (byte) ((numCalculated % 10 > digitMax) ? numCalculated % 10 : digitMax); // Вычисляем наибольшую цифру
            digitSum += numCalculated % 10;
            digitQuantity++;
            numCalculated /= 10;
        }

        return new DigitData(digitQuantity, digitMax, digitSum);
    }

    /**
     * Функция проверки на палиндромность
     *
     * @param num           Число для анализа типа Integer
     * @param digitQuantity Заранее вычисленное количество цифр
     * @return boolean статус палиндрома
     */
    public static boolean isPalindrome(int num, byte digitQuantity) {
        for (byte i = 1; i <= digitQuantity / 2; i++) {
            int left = (int) ((num / Math.pow(10, digitQuantity - i)) % 10);        // Вычисляем левую цифру
            int right = (int) (num % Math.pow(10, i)) / (int) Math.pow(10, i - 1);  // Зеркально вычисляем правую цифру

            if (left != right)
                return false;
        }
        return true;
    }

    /**
     * Вывод информации о данном числе в консоль
     *
     * @param num          Анализируемое число
     * @param digitData    Запись о количестве и сумме цифр, а также наибольшей из них
     * @param isPalindrome Результат проверки числа на статус палиндрома
     */
    public static void printResult(int num, DigitData digitData, boolean isPalindrome) {
        System.out.printf("""
                        Число: %d
                        #Цифр: %d
                        Сумма цифр: %d
                        Максимальная цифра: %d
                        Палиндром: %s
                        """,
                num, digitData.digitQuantity, digitData.digitSum, digitData.digitMax,
                isPalindrome ? "да" : "нет"
        );
    }
}
