package skillbox.amkiri.module7.hw2;

import skillbox.amkiri.module7.hw1.Employee;
import skillbox.amkiri.module7.hw2.airport.Airport;
import skillbox.amkiri.module7.hw2.airport.Flight;
import skillbox.amkiri.module7.hw2.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static skillbox.amkiri.module7.hw1.Loader.loadStaffFromFile;

public class Main {

    public static void main(String[] args) {

        /// В проекте с сотрудниками с помощью Stream API рассчитать максимальную зарплату тех, кто пришёл в 2017 году.

        ArrayList<Employee> staff = loadStaffFromFile();
        OptionalInt maxSalary = staff.stream()
                .filter(employee -> employee.getWorkStart().getYear() == 2017)
                .mapToInt(Employee::getSalary)
                .max();

        if (maxSalary.isPresent()) {
            System.out.println("Max salary in 2017: " + maxSalary.getAsInt());
        } else {
            System.out.println("No employees has been hired in 2017.");
        }


        /// Используя библиотеку airport.jar, распечатать время вылета и модели самолётов, вылетающие в ближайшие 2 часа.

        Airport airport = Airport.getInstance();

        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime twoHoursLater = nowDate.plusHours(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");

        System.out.println();
        System.out.println("Local time: " + nowDate.getHour() + ":" + nowDate.getMinute());

        airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)

                // Stream<Flight>
                .filter(flight -> {
                    LocalDateTime dt = toLocalDateTime(flight.getDate());
                    return flight.getType().equals(Flight.Type.DEPARTURE)
                            && dt.isAfter(nowDate)
                            && dt.isBefore(twoHoursLater);
                })

                .forEach(flight -> {
                    LocalDateTime dt = toLocalDateTime(flight.getDate());
                    System.out.println(
                            dt.format(formatter)
                                    + "\t"
                                    + flight.getAircraft().getModel()
                    );
                });

    }

    private static LocalDateTime toLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
