import java.util.HashMap;
import java.util.ArrayList;

public class Counter {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int get(int key) { return this.map.get(key); }

    public HashMap<Integer, Integer> getMap() { return this.map; }
    
    public void count(ArrayList<Integer> array) {
        for (int i=0; i<array.size(); i++) {
            int curr_key = array.get(i);
            if (!this.map.containsKey(array.get(i))) {
                this.map.put(curr_key, 0);
            }
            int curr_val = this.map.get(curr_key);
            this.map.replace(curr_key, curr_val + 1);
        }
    }
}
