package skillbox.amkiri.module5.hw1.rainbow;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Повторить создание массива и заполнение цветами радуги, как показано в видео, а затем написать код, переворачивающий этот массив.
 */
public class Main {

    public static void main(String[] args) {
        String[] colors = {
                "красный",
                "оранжевый",
                "желтый",
                "зелёный",
                "голубой",
                "синий",
                "фиолетовый"
        };


        // Using just arrays

        System.out.println("\nFirst way: ");

        String[] invertedRainbow = new String[colors.length];

        for (int i = 0; i < colors.length; i++) {
            invertedRainbow[colors.length - i - 1] = colors[i];
        }

        printRainbow(Arrays.asList(invertedRainbow));


        // Other way to do it

        System.out.println("\nSecond way: ");

        List<String> invertedRainbowList = Arrays.asList(colors);
        Collections.reverse(invertedRainbowList);

        printRainbow(invertedRainbowList);

    }

    private static void printRainbow(Collection array) {
        for (Object s:
                array) {
            System.out.println("\t" + s);
        }
    }
}
