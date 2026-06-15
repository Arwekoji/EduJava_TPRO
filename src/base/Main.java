package base; //IDE автоматически привязала пакет (Нельзя, чтобы классы висели без пакета)

/**
 * My test class
 *
 * @author Arthur
 * @version 1.0
 *
 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**
     * My entry point
     *
     * @param args entry point arguments
     * @author Arthur
     *
     */



    public static void main(String[] args) {
        int a = 3;
        float b = 7.15f;
        for (String arg : args) {
            
        }
        float c = 1.0f;
        //breakpont;
        System.out.println("Hello, на данном этапе ничего не произошло, но вы можете посмотреть что у меня есть");
        c = b;
        System.out.println("Here я уже должен поменять значение одной из переменных");
    }
}