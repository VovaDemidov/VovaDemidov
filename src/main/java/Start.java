import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Start {

    public static void main(String[] args) {

        List < Animals > animals = getAnimals ( );

        List < Animals > carnivore = new ArrayList <> ( );

        for (int i = 0; i < animals.size ( ); i++) {


        }

        for (Animals animal :
                animals) {
            if (animal.getClasification ( )
                    .equals (Clasification.CARNIVORE)) {

                carnivore.add (animal);


            }


        }

        for (Animals animal :
                carnivore) {

            System.out.println (animal.getName ( ) + " " +
                    animal.getAge ( ) + " " +
                    animal.getClasification ( ));

        }


        carnivore.forEach (System.out::println);

        System.out.println ("__________________________________________");


        List < Animals > herbivore = animals.stream ( )
                .filter (animal -> animal.getClasification ( )
                        .equals (Clasification.HERBIVORE))
                .collect (Collectors.toList ( ));

        herbivore.forEach (System.out::println);

        System.out.println ("__________________________________________");

        List < Animals > sortedAnimals = animals.stream ( )
                .sorted (Comparator.comparing (Animals::getAge))
                .collect (Collectors.toList ( ));

        sortedAnimals.forEach (System.out::println);

        boolean allMatch = animals.stream ( )
                .allMatch (animal -> animal.getAge ( ) > 10);

        System.out.println ("__________________________________________");

        System.out.println (allMatch);


        System.out.println ("__________________________________________");

        Map < Clasification, List < Animals > > clasificationAnimals = animals.stream ( )
                .collect (Collectors.groupingBy (Animals::getClasification));

        for (Map.Entry < Clasification, List < Animals > > pair :
                clasificationAnimals.entrySet ( )) {

            String key = pair.getKey ( )
                    .toString ( );
            String value = pair.getValue ( )
                    .toString ( );

            System.out.println (key);
            System.out.println (value);

            System.out.println ("__________________________________________");

        }

        println (animals, new CheckIfHopper ( ));

        System.out.println ("__________________________________________");

        println (animals, a -> a.isCanSwim ( ));

        System.out.println ("__________________________________________");




        System.out.println ("__________________________________________");

    }


    private static List < Animals > getAnimals() {


        return List.of (
                new Animals ("Elephant", 20, Clasification.HERBIVORE, true, true),
                new Animals ("Lion", 10, Clasification.CARNIVORE, true, false),
                new Animals ("Hound", 5, Clasification.CARNIVORE, true, true),
                new Animals ("Giraffe", 8, Clasification.HERBIVORE, false, true),
                new Animals ("Gibbon", 12, Clasification.OMNIVORE, true, true),
                new Animals ("Horse", 3, Clasification.HERBIVORE, true, true),
                new Animals ("Human", 30, Clasification.OMNIVORE, true, true),
                new Animals ("Lynx", 4, Clasification.CARNIVORE, true, true),
                new Animals ("Dino", 200, Clasification.CARNIVORE, false, false)


        );

    }

    private static void println(List < Animals > animals, CheckTrait checkTrait) {

        for (Animals animal :
                animals) {

            if (checkTrait.test (animal)) {

                System.out.println (animal.toString ( ));
            }

        }


    }


}
