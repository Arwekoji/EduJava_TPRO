package base;

/**
 * Класс для анализа заданных чисел
 *
 * @author Артур Федьвереш
 */
public class DigitAnalyzer {

    /**
     * Метод для вычисления и отображения проанализированных данных по данному числу типа int
     *
     * @param num Число для анализа типа int
     * @author Артур Федьвереш
     */
    public void analyze(int num) {
        System.out.println("Число: " + num);
        byte digitQuantity = 0; // Даже long формат имеет меньше символов, чем вмещает максимум для Byte типа. Так зачем тратить доп память?
        int digitSum = 0;
        byte digitMax = 0; //Зачем тратить дополнительную память, если число в диапазоне от 0 до 9?
        boolean isPalindrome = true; // Можно ли заменить boolean на byte для триггеров в целях экономии памяти или это считается плохой практикой?

        int numCalculated = num;
        while (numCalculated > 0) {//Вычисляем дополнительную информацию по заданному числу
            digitMax = (byte) ((numCalculated % 10 > digitMax) ? numCalculated % 10 : digitMax); // Вычисляем наибольшую цифру
            digitSum += numCalculated % 10;
            digitQuantity++;
            numCalculated /= 10;
        }

        //Теперь, когда известна длина числа (ака Число цифр), можно выяснить полиндром ли это
        numCalculated = num; // Повторно использует для вычислений
        System.out.print("Проверка пар цифр: ");
        for (byte i = 1; i <= digitQuantity / 2; i++) {
            // Вычисляем левую цифру
            int left = (int) ((num / Math.pow(10, digitQuantity - i)) % 10);
            //Зеркально вычисляем правую цифру
            int right = (int) (num % Math.pow(10, i)) / (int) Math.pow(10, i - 1);

            if (left != right) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("#Цифр: " + digitQuantity);
        System.out.println("Сумма цифр: " + digitSum);
        System.out.println("Наибольшая цифра: " + digitMax);
        System.out.println("Это палиндром? - " + isPalindrome);

    }
}
