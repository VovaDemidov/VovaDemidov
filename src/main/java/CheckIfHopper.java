public class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animals a) {
        return a.isCanHop ();
    }
}
