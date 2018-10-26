import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        try {
            int itemNumber = 0;
            int height = 0;
            List<Field> items = new ArrayList<>();
            List<Field> fields = new ArrayList<>();
            ArrayList<Field> rout = new ArrayList<>();
            String s;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while ((s = br.readLine()) != null && s.length() != 0) {
                String[] arg = s.split(" ");
                if (arg.length != 1) {
                    for(int i = 0; i < arg.length; ++i){
                        fields.add(new Field(i, height, Integer.parseInt(arg[i])));
                    }
                    height++;
                }
                else itemNumber = Integer.parseInt(arg[0]);
            }
            items.add(fields.get(0));
            for(int i = 0; i < fields.size(); ++i){
                if(fields.get(i).getX() != 0 && '0' == (fields.get(i).getNumber().charAt(1))) //Nyugat
                    fields.get(i).addNeighbor(fields.get(i-1));
                if(fields.get(i).getX() != height-1 && '0' == (fields.get(i).getNumber().charAt(3))) //Kelet
                    fields.get(i).addNeighbor(fields.get(i+1));
                if(fields.get(i).getY() != 0 && '0' == (fields.get(i).getNumber().charAt(4))) //Észak
                    fields.get(i).addNeighbor(fields.get(i-height));
                if(fields.get(i).getY() != (fields.size()/height)-1 && '0' == (fields.get(i).getNumber().charAt(2))) //Dél
                    fields.get(i).addNeighbor(fields.get(i+height));
                if( '1' == (fields.get(i).getNumber().charAt(0)))
                    items.add(fields.get(i));
            }

            items.add(fields.get(fields.size() - 1));

            if(itemNumber + 2 != items.size())
                throw new Exception("alma");

            for(int i = 0; i < items.size() - 1; ++i) {
                AStar star = new AStar(items.get(i), items.get(i + 1));
                star.start();
                if (rout.size() > 0)
                    rout.remove(rout.size() - 1);
                rout.addAll(star.getRout());
            }

            for(int i = 1; i < rout.size(); i++)
                rout.get(i).print();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
