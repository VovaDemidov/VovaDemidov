import java.util.HashSet;
import java.util.Set;

interface Converter {

    Raccoon convert(Dog t);

    static boolean isNotNull(Dog t) {
        return t != null;
    }

    default void writeToConsole(Dog t) {
        System.out.println("Текущий объект - " + t.toString());
    }

    boolean equals(Object obj);
}

class Dog {
    String name;
    int age;
    int weight;

    public Dog(final String name, final int age, final int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class Raccoon {
    String name;
    int age;
    int weight;

    public Raccoon(final String name, final int age, final int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("Bobbie", 5, 3);

        Converter converter = (Dog x) -> new Raccoon(x.name, x.age, x.weight);

        Raccoon raccoon = converter.convert(dog);

        System.out.println("Raccoon has parameters: name - " + raccoon.name + ", age - " + raccoon.age + ", weight - " + raccoon.weight);
            }
}