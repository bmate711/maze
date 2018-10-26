import java.util.ArrayList;


public class Step implements Stepable {
    private Stepable previous;
    private Field field;
    private int roadDistance;
    private int estimatedDistance;


    public Step(Stepable previous, Field field, int estimatedDistance) {
        this.previous = previous;
        this.field = field;
        this.estimatedDistance = estimatedDistance;
        roadDistance =  previous.getRoadDistance() + 1;
    }


    @Override
    public ArrayList<Field> road(ArrayList<Field> fields) {
        fields.add(field);
        return previous.road(fields);
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
        return estimatedDistance + roadDistance;
    }


}
