package Airports;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    static Airport airport = new Airport("airport1");

    public static void main(String[] args) {

        /**
         * Найти все рейсы с терминала А
         */
        airport.getTerminalList().stream().filter(x -> x.getName().equals("A")).flatMap(x -> x.getFlightList().stream()).
                filter(x -> x.getType() == Type.ARRIVAl).forEach(x -> System.out.println(x));

        /**
         * Найти все рейсы и отсортировать по длительности полета и дате
         */
        airport.getTerminalList().stream().flatMap(x -> x.getFlightList().stream())
                .sorted(Comparator.comparing(Flight::getDurationofTheFlight).thenComparing(Flight::getDateOfFlight))
                .forEach(x -> System.out.println(x));


        /**
         * 1 временной отрезок
         */
        Calendar instance1 = Calendar.getInstance();
        instance1.set(2021, Calendar.DECEMBER, 22, 0, 0, 0);
        Date time2 = instance1.getTime();

        /**
         * 2 временной отрезок
         */
        Calendar instance2 = Calendar.getInstance();
        instance2.set(2021, Calendar.DECEMBER, 23, 0, 0, 0);
        Date time3 = instance2.getTime();


        /**
         * Найти все рейсы в указанный временной отрезок
         */
        airport.getTerminalList().stream().flatMap(x -> x.getFlightList().stream()).
                filter(x -> x.getDateOfFlight().after(time2) && x.getDateOfFlight().before(time3)).forEach(x -> System.out.println("yesterday " + x));


        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, 8);
        Date time = instance.getTime();

        /**
         * Найти все рейсы после определенного времени
         */
        airport.getTerminalList().stream().flatMap(x -> x.getFlightList().stream()).filter(x -> x.getDateOfFlight().after(time))
                .forEach(x -> System.out.println("after 8 hours " + x));

        /**
         * Найти все рейсы с терминала А в промежутке времени
         */
        airport.getTerminalList().stream().filter(x -> x.getName().equals("A")).flatMap(x -> x.getFlightList().stream()).
                filter(x -> x.getType() == Type.ARRIVAl).filter(x -> x.getDateOfFlight().before(time) && x.getDateOfFlight().after(new Date()))
                .forEach(x -> System.out.println(x));

        /**
         * Найти все рейсы из терминала А по определенному промежутку времени с самолетом Боинг с типом(вылет)
         */
        airport.getTerminalList().stream().filter(x -> x.getName().equals("A")).flatMap(x -> x.getFlightList().stream())
                .filter(x -> x.getDateOfFlight().after(time2) && x.getDateOfFlight().before(time3))
                .filter(x -> x.getAirplane().getName().contains("boeing"))
                .filter(x -> x.getType() == Type.DEPARTURE)
                .count();


        /**
         * Самый часто совершающий вылеты самолет(имя)
         */
        Optional<Map.Entry<String, Long>> first = airport.getTerminalList().stream().flatMap(x -> x.getFlightList().stream()).
                collect(Collectors.groupingBy(x -> x.getAirplane().getName(), Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).findFirst();


        Calendar noww = Calendar.getInstance();
        Date nowaday = noww.getTime();
        Calendar instance3 = Calendar.getInstance();
        instance3.add(Calendar.HOUR, -12);
        Date time1 = instance3.getTime();

        /**
         * Найти имена самолетов по заданному промежутку времени,на прилет
         */
        List<String> stringStream = airport.getTerminalList().stream().flatMap(x -> x.getFlightList().stream())
                .filter(x -> x.getDateOfFlight().before(nowaday) && x.getDateOfFlight().after(time1))
                .filter(x -> x.getType() == Type.ARRIVAl)
                .map(x -> x.getAirplane().getName())
                .collect(Collectors.toList());

    }


    public static void deleteDepartures() {

        Calendar noww2 = Calendar.getInstance();
        Date nowaday2 = noww2.getTime();
        Calendar instance42 = Calendar.getInstance();
        instance42.add(Calendar.HOUR, 12);
        Date time34 = instance42.getTime();

        List<Flight> collect = airport.getTerminalList().stream().flatMap(x -> x.getFlightList().stream())
                .filter(x -> x.getDateOfFlight().after(nowaday2) && x.getDateOfFlight().before(time34)).collect(Collectors.toList());

        collect.removeIf(next -> next.getType() == Type.DEPARTURE);

        System.out.println(collect);

    }

    public static String recurrent(List<String> s) {
        String often = " ";
        int count = 0;
        for (int i = 0; i < s.size(); i++) {
            int countNew = 0;
            for (int j = 0; j < s.size(); j++) {
                if (s.get(i).equals(s.get(j))) {
                    countNew++;
                }
            }
            if (countNew > count) {
                count = countNew;
                often = s.get(i);
            }
        }
        return often + " " + count;

    }
}