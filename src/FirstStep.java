import java.util.ArrayList;



public class FirstStep implements Stepable {
    private Field field;
    private int roadDistance;
    private int estimatedDistance;

    public FirstStep(Field field, int estimatedDistance) {
        this.field = field;
        this.estimatedDistance = estimatedDistance;
        roadDistance = 0;
    }

    @Override
    public ArrayList<Field> road(ArrayList<Field> fields) {
        fields.add(field);
        return fields;
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public int getRoadDistance() {
        return roadDistance;
    }

    @Override
    public int getDistance() {
        return roadDistance;
    }
}