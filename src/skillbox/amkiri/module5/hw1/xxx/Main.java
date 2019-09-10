package skillbox.amkiri.module5.hw1.xxx;

/*
 * Создайте массив массивов строк таким образом, чтобы при его распечатке в консоли печатался крестик из крестиков:
 * x     x
 *
 *  x   x
 *
 *   x x
 *
 *    x
 *
 *   x x
 *
 *  x   x
 *
 * x     x
 */
public class Main {
    public static void main(String[] args) {

        String[][] xxx = {
                {"X", "     ", "X"},
                {" ", "X", "   ", "X"},
                {"  ", "X", " ","X"},
                {"   ", "X"},
                {"  ", "X", " ","X"},
                {" ", "X", "   ", "X"},
                {"X", "     ", "X"}
        };


        for (String[] row: xxx) {

            for (String s: row) {
                System.out.print(s);
            }

            System.out.println();
        }

    }

}
