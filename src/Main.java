import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print(statistics("src/file.txt"));
    }

    public static Map<String, Integer> statistics(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        Map<String, Integer> res = new HashMap<>();
        List<Statistics> people = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            // Новая попытка человека -->
            Statistics personFromFile = new Statistics(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));

            boolean isNewPersonOrTask = true;

            for (Statistics curPerson : people) {
                if (Objects.equals(curPerson.surname, personFromFile.surname) && curPerson.taskNum == personFromFile.taskNum) {
                    curPerson.attempt = Math.max(curPerson.attempt, personFromFile.attempt);
                    curPerson.score = Math.max(curPerson.score, personFromFile.score);
                    isNewPersonOrTask = false;
                    break;
                }
            }
            if (isNewPersonOrTask) {
                people.add(personFromFile);  // Добавляем нового человека в список
            }
        }

        for (Statistics person : people) {  // Вычисление итогового балла
            if (5 <= person.attempt && person.attempt <= 10) {
                person.finalScore = person.score / 2;
            } else if (person.attempt > 10) {
                person.finalScore = 1;
            } else {
                person.finalScore = person.score;
            }
        }

        // Составление мапы
        for (Statistics person : people) {  // Вычисление итогового балла
            if (res.containsKey(person.surname)) {
                res.put(person.surname, res.get(person.surname) + person.finalScore);
            } else {
                res.put(person.surname, person.finalScore);
            }
        }
        return res;
    }
}