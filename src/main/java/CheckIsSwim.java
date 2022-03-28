public class CheckIsSwim implements CheckTrait {


    @Override
    public boolean test(Animals a) {
        return a.isCanSwim ();
    }
}
