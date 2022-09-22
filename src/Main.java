import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print(getStatistics("src/file.txt"));
    }

    public static List<Statistics> countFinalScore(List<Statistics> people){
        for (Statistics person : people) {  // Вычисление итогового балла отдельно для каждого задания
            if (5 <= person.attempt && person.attempt <= 10) {
                person.finalScore = person.score / 2;
            } else if (person.attempt > 10) {
                person.finalScore = 1;
            } else {
                person.finalScore = person.score;
            }
        }
        return people;
    }

    public static Map<String, Integer> createMap(List<Statistics> people){
        // Составление мапы
        Map<String, Integer> res = new HashMap<>();

        for (Statistics person : people) {
            if (res.containsKey(person.surname)) {
                res.put(person.surname, res.get(person.surname) + person.finalScore);
            } else {
                res.put(person.surname, person.finalScore);
            }
        }
        return res;
    }

    public static List<Statistics> fromFileToList(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
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
        return people;
    }

    public static Map<String, Integer> getStatistics(String filename) throws FileNotFoundException {
        List<Statistics> people = fromFileToList(filename);
        return createMap(countFinalScore(people));
    }
}