package skillbox.amkiri.module5.hw1.hospital;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Создать массив с температурами 30-ти пациентов (от 32 до 40 градусов).
 * Написать код, рассчитывающий среднюю температуру по больнице и количество здоровых пациентов (с температурой от 36,2 до 36,9).
 */
public class Main {
    public static void main(String[] args) {

        Double[] tempretures = {5.1, 36.6, 40.5, 31.0, 36.3, 47.2};

        long numberOfHealthPeople = Arrays.stream(tempretures)
                .filter(t -> t >= 36.2 && t <= 36.9)
                .count();

        Double average = Arrays.stream(tempretures)
                .collect( Collectors.averagingDouble(value -> value) );

        System.out.printf("Average tempreture: %3.1f\n", average);
        System.out.println("Number of health people: " + numberOfHealthPeople);

    }
}
