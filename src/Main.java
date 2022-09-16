import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print(statistics("src/file.txt"));
    }

    public static Map<String, Integer> statistics(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        Map<String, Integer> res = new HashMap<>();
        while (sc.hasNextLine()){
            String[] line = sc.nextLine().split(" ");
            Statistics person = new Statistics(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
            if (5 <= person.attempt && person.attempt <= 10){
                person.score = person.score / 2;
            } else if (person.attempt > 10) {
                person.score = 1;
            }
            if (res.containsKey(person.surname)){
                res.put(person.surname, res.get(person.surname) + person.score);
            }
            else {
                res.put(person.surname, person.score);
            }
        }
        return res;
    }
}