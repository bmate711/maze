import java.util.ArrayList;


public class Field {
    int x;
    int y;
    boolean item;
    ArrayList<Field> neighbors = new ArrayList<>();
    String number;

    public Field(int x, int y, int number){
        this.x = x;
        this.y = y;
        this.number = Integer.toBinaryString(number);
        while (this.number.length() != 5)
            this.number = "0"+ this.number;
        if('1' == (this.number.charAt(0)) )
            item = true;
    }

    public ArrayList<Field> getNeighbors() {
        return neighbors;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public String getNumber(){
        return number;
    }

    public void addNeighbor(Field f){
        neighbors.add(f);
    }

    public void print() {
        System.out.println(y + " " + x);
        if (item) {
            System.out.println("felvesz");
            item = false;
        }
    }
}
