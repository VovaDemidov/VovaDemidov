public class Animals {


    private final String name;
    private final int age;
    private final Clasification clasification;
    private boolean canHop;
    private boolean canSwim;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Clasification getClasification() {
        return clasification;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public Animals(String name, int age, Clasification clasification, boolean canHop, boolean canSwim) {
        this.name = name;
        this.age = age;
        this.clasification = clasification;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }


    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", clasification=" + clasification +
                ", canHop=" + canHop +
                ", canSwim=" + canSwim +
                '}';
    }

}
