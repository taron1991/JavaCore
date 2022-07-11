package Airports;


/**
*Класс самолет с сеттером и геттером
**/
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
