package Airports;

import Airports.Airplane;

import java.util.Date;


/*
Класс Полет,который имеет дату вылета,номер билета,енам(вылет или прилет),тип самолета,продолжительность полета
*/
public class Flight {
    private Date dateOfFlight;
    private String numberOfFlight;  //2 буквы и 4 цифры
    private Type type;
    private Airplane airplane;
    private Date durationofTheFlight;

    public  Date getDurationofTheFlight(){
        return durationofTheFlight;
    }

    public void setDurationofTheFlight(Date durationofTheFlight){
        this.durationofTheFlight = durationofTheFlight;
    }


    public void setType(Type type) {
        this.type = type;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public String getNumberOfFlight() {
        return numberOfFlight;
    }

    public void setNumberOfFlight(String numberOfFlight) {
        this.numberOfFlight = numberOfFlight;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "dateOfFlight=" + dateOfFlight +
                ", numberOfFlight='" + numberOfFlight + '\'' +
                ", type=" + type +
                ", airplane=" + airplane +
                ", duration=" + durationofTheFlight +
                '}';
    }
}
