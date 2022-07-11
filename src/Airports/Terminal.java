package Airports;

import Airports.Airplane;
import Airports.Flight;

import java.util.ArrayList;
import java.util.List;

/**
Класс терминал,который имеет список полетов,список самолетов,имя самого терминала
**/
public class Terminal {
    private List<Flight> flightList = new ArrayList<>();
    private List<Airplane> airplanesOnTheStop = new ArrayList<>();
    private String name;

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Airplane> getAirplanesOnTheStop() {
        return airplanesOnTheStop;
    }

    public void setAirplanesOnTheStop(List<Airplane> airplanesOnTheStop) {
        this.airplanesOnTheStop = airplanesOnTheStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
