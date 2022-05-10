package Airports;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Нужно сгенерировать аэропорт количество терминалов от 5!а может и быть больше!
 *     в каждом терминале зотя бы от 150 рейсов половина на прилет а вторая половина на вылет и хотя бы 50 самолетов на парковке
 */
public class Airport {

    private String namesOfAirport;
    private List<Terminal> terminalList = new ArrayList<>();

    public Airport(String namesOfAirport)  {
        this.namesOfAirport = namesOfAirport;
        generateTerminals();
    }

    public String getNamesOfAirport() {
        return namesOfAirport;
    }

    public List<Terminal> getTerminalList() {
        return terminalList;
    }

    private void generateTerminals()  {
        String[] arrays = {"A", "B", "C", "D", "E"};

        for (int i = 0; i < 5; i++) {
            terminalList.add(generateTerminal(arrays[i]));
        }


    }

    private Terminal generateTerminal(String name)  {
        List<Flight> flightList = new ArrayList<>();
        List<Airplane> onTheStop = new ArrayList<>();

        Terminal terminal = new Terminal();

        for (int i = 0; i < 50; i++) {
            onTheStop.add(generateAircraft());
        }

        for (int i = 0; i < 75; i++) {
            flightList.add(generateRandomFlight(Type.ARRIVAl));
        }
        for (int i = 0; i < 75; i++) {
            flightList.add(generateRandomFlight(Type.DEPARTURE));
        }

        terminal.setFlightList(flightList);
        terminal.setAirplanesOnTheStop(onTheStop);
        terminal.setName(name);

        return terminal;
    }

    private Flight generateRandomFlight(Type type)  {
        Flight flight = new Flight();
        flight.setType(type);
        flight.setDateOfFlight(generateDate());
        flight.setNumberOfFlight(generateRandomCode());
        flight.setAirplane(generateAircraft());
       // flight.setDurationofTheFlight(generateDurationOfFlight());

        return flight;
    }


   /* private  Date generateDurationOfFlight() throws ParseException {

        int hours = (int) (Math.random() * 12 + 0);
        if (hours <= 1) {
            Calendar now = Calendar.getInstance();
             int minutes = (int) (Math.random() * 14 + 45);
            //int minutes = (int) (Math.random() * 1 + 58);
            int nan = (int) (Math.random() * 1 + 58);
            int seconds = (int) (Math.random() * 58 + 1);
            now.set(2021, Calendar.DECEMBER, 26, 0, minutes, nan);
            Date time = now.getTime();
            return time;
        } else {
            Calendar now = Calendar.getInstance();
            int minutes = (int) (Math.random() * 1 + 58);
            int seconds = (int) (Math.random() * 58 + 1);
            now.set(2021, Calendar.DECEMBER, 26, hours, minutes, seconds);
            Date time = now.getTime();
            return time;
        }
    }*/



    private Airplane generateAircraft() {
        Airplane airplane = new Airplane();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("airbus");
        arrayList.add("airbus320");
        arrayList.add("airbus770");
        arrayList.add("boeingjet");
        arrayList.add("boeing779");
        arrayList.add("boeing611");

        int v = (int) (Math.random() * arrayList.size());

        String s = arrayList.get(v);
        airplane.setName(s);

        return airplane;
    }


    private static String generateRandomCode() {
        String c = " ";
        for (int i = 0; i < 2; i++) {
            c += (char) (Math.random() * 25 + 65);

        }

        for (int i = 0; i < 4; i++) {
            c += (int) (Math.random() * 9);

        }
        return c;
    }

    private static Date generateDate() {
        Date date = new Date();
        long time = date.getTime();

        int random = (int) (Math.random() * 10);
        for (int i = 0; i < random; i++) {
            if (i % 2 == 0) {
                long v2 = (long) (Math.random() * (1000 * 60 * 60 * 24 * 2));
                time -= v2;
            } else {
                long v = (long) (Math.random() * (1000 * 60 * 60 * 24 * 2));
                time += v;
            }
        }

        return new Date(time);
    }
}



