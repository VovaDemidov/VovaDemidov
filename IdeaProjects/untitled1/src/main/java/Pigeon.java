public class Pigeon extends Birds {

    public Pigeon(String name) {
        Birds.name = name;
    }

    public Pigeon(){};

    public void hide() {

        System.out.println("hide pigeon");

    }


    @Override
    public void play() {
        System.out.println("Play with Doll");
    }


    public void play(String s) {
        System.out.println(s + " is playing with Doll");
    }


    @Override
    public void walk() {
        System.out.println("Bla Bla");
    }

    public void  fly() {

        System.out.println("Gogogoog");

    };

}
