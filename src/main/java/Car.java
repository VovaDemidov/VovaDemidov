public class Car {


    String color;
    int doors;

    private Car(String color) {
        this.color = color;
    }

    private Car(int doors) {
        this.doors = doors;

    }

    public static Car getWhiteCar() {
        return new Car ("white");

    }

    public static Car getSpotCar() {
        return new Car (2);

    }

    public static void Drive() {

        System.out.println ("vrvrvrvrv");
    }

}
