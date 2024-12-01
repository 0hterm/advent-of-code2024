import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Date;

public class ListDistance {
    public static void main(String[] args) {
        long start_time = new Date().getTime();
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] res = line.split("\\s+");
                list1.add(Integer.parseInt(res[0]));
                list2.add(Integer.parseInt(res[1]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        

        ArrayList<Integer> list1_copy = new ArrayList<>(list1);
        ArrayList<Integer> list2_copy = new ArrayList<>(list2);

        //Pt.1 (Distance)
        int distance = 0;
        while (!list1_copy.isEmpty() && !list2_copy.isEmpty()) {
            int list1_min = Collections.min(list1_copy);
            int list1_min_index = list1_copy.indexOf(list1_min);
            int list2_min = Collections.min(list2_copy);
            int list2_min_index = list2_copy.indexOf(list2_min);
            
            distance += Math.abs(list1_copy.remove(list1_min_index) - list2_copy.remove(list2_min_index));
        }
        

        // Pt.2 (Similarity Score)
        Counter counter = new Counter();
        int n = list1.size();
        int score = 0;
        counter.count(list2);
        for (int i=0; i<n; i++) {
            int curr_key = list1.get(i);
            score += curr_key * counter.getMap().getOrDefault(curr_key, 0);
        }

        long end_time = new Date().getTime();
        
        System.out.println("Distance: " + distance);
        System.out.println("Similarity Score: " + score);

        System.out.println("Runtime: " + (end_time - start_time) + "ms");
        
    }
}