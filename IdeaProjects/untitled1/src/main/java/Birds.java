import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class Birds {

    static String name;


    protected Birds(String name) {
        Birds.name = name;
    }

    public Birds() {
    }

    public void walk() {

        System.out.println("Ho ho ho");

    }

    public void play() {
        System.out.println("Play with Toy");
    }


    public static void main(String[] args) {

        try {
            throw new IOException();
        } catch (Exception e) {
            System.out.println("In the Exception catch block");
        }


        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread()
                .getName());
        Thread.currentThread().

                Music mc = Music.METAL;

        for (Music e :
                Music.values()) {

            System.out.println(e);


        }


        int i = 12;

        Integer b = i;

        Birds bird1 = new Birds();

        Birds bird2 = new Pigeon();

        Pigeon bird3 = new Pigeon();

        bird1.walk();
        bird2.walk();
        bird3.fly();

        Predicate<Integer> predicate = x -> x > 5;

        Birds birds = new Pigeon();

        List<Birds> list = new ArrayList<>();

        List<Birds> list2 = new LinkedList<>();

        Set<String> set = new TreeSet<>();

        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("one");

        for (String str :
                set) {
            System.out.println(str);
        }


        birds.play("sfsdf");


    }

    public void play(String s) {

        System.out.println(s + " sfsfsf");

    }

}
