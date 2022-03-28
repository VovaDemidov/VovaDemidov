public class Car {


    String color;
    int doors;
    CarInt2 carInt2;

    private Car(String color) {
        this.color = color;
    }

    public Car(int doors) {
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


    public void brbr() {

        this.carInt2.doSomthing ();
    }

}
