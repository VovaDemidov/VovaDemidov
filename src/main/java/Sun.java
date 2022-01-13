public class Sun {


    private static final Sun sun = new Sun();

    private Sun() {

        System.out.println("Sun");
    }

    public static Sun getInst() {

        return sun;
    }


}
