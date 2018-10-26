import java.util.*;

public class AStar {
    private Field end;
    private List<Stepable>  closedSet = new ArrayList<>();
    private List<Stepable> openSet = new ArrayList<>();
    private ArrayList<Field> rout = new ArrayList<>();

    public AStar(Field start, Field end) {
        this.end = end;
        openSet.add(new FirstStep(start, distance(start, end)));
    }

    private int distance(Field start, Field end) {
        return  Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY());
    }

    public ArrayList<Field> getRout() {
        Collections.reverse(rout);
        return rout;
    }

    public void start() {
        Stepable current = openSet.get(0);
        StepableComparator stepableComparator = new StepableComparator();
        while ( !openSet.isEmpty() ) {
            if(current.getField() == end) {
                rout =  current.road(new ArrayList<>());
                break;
            }
            removeOpenSet(current);
            closedSet.add(current);
            for( Field f : current.getField().getNeighbors()) {
                if(!inClosedSet(f)) {
                    openSet.add(new Step(current, f, distance(f, end)));
                }
            }
            if(!openSet.isEmpty()){
                openSet.sort(stepableComparator);
                current = openSet.get(0);
            }
        }
    }

    private boolean inClosedSet(Field field){
        for( Stepable s : closedSet) {
            if(s.getField().getX() == field.getX() && s.getField().getY() == field.getY())
                return true;
        }
        return false;
    }


    private  void removeOpenSet(Stepable step){
        for(int i = openSet.size() -1; i >=0 ; i--){
            if(openSet.get(i).getField().getX() == step.getField().getX() && openSet.get(i).getField().getY() == step.getField().getY())
                openSet.remove(i);
        }

    }
}
