package base;

public class Palindrome {

    public static void check (String input) {
        System.out.printf("Строка \"%s\" - ", input);

        input = input.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();

        System.out.println(
                input.equals(new StringBuilder(input).reverse().toString()) ? "палиндром" : "не палиндром"
        );
    }
}
