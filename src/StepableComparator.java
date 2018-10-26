import java.util.Comparator;

public class StepableComparator implements Comparator<Stepable> {

    @Override
    public int compare(Stepable first, Stepable second) {
        return first.getDistance() - second.getDistance();
    }
}
