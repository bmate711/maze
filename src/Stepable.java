import java.util.ArrayList;


public interface Stepable {
    public abstract ArrayList<Field> road(ArrayList<Field> fields);

    public abstract Field getField();

    public abstract int getRoadDistance();

    public abstract int getDistance();
}

