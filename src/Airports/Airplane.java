package Airports;


/*
Класс аэропорт,который имеет терминалы,количество самолетов,рейсы.В данном случает у аэропорта есть имя
*/
public class Airplane {
    private String name;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "name "+name;
    }

}
