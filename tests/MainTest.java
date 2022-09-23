import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {

    @Test
    public void getStatisticsTest() throws FileNotFoundException {
        Map<String, Integer> result = Main.getStatistics("tests/testFile.txt");
        Map<String, Integer> expectations = new HashMap<>();
        expectations.put("s", 10);
        expectations.put("Safina", 31);


        Assertions.assertEquals(result, expectations);
    }

    @Test
    public void createMapTest() {
        List<Statistics> list = new ArrayList<>();
        list.add(new Statistics("s", 1, 7, 15));
        list.add(new Statistics("Safina", 1, 1, 20));
        list.add(new Statistics("Safina", 2, 9, 23));
        list.add(new Statistics("s", 2, 1, 3));
        Main.countFinalScore(list);

        Map<String, Integer> expectations = new HashMap<>();
        expectations.put("s", 10);
        expectations.put("Safina", 31);

        Map<String, Integer> result = Main.createMap(list);

        Assertions.assertEquals(expectations, result);
    }

    @Test
    public void fromFileToListTest() throws FileNotFoundException {
        List<Statistics> result = Main.fromFileToList("tests/testFile.txt");
        List<Statistics> expectations = new ArrayList<>();

        expectations.add(new Statistics("s", 1, 7, 15));
        expectations.add(new Statistics("Safina", 1, 1, 20));
        expectations.add(new Statistics("Safina", 2, 9, 23));
        expectations.add(new Statistics("s", 2, 1, 3));

        Assertions.assertEquals(result, expectations);
    }

    @Test
    public void countFinalScoreTest() throws FileNotFoundException{
        List<Statistics> result = new ArrayList<>();
        List<Statistics> expectations = new ArrayList<>();

        expectations.add(new Statistics("s", 1, 7, 15, 7));
        expectations.add(new Statistics("s1", 1, 11, 100, 1));
        result.add(new Statistics("s", 1, 7, 15));
        result.add(new Statistics("s1", 1, 11, 100));


        Main.countFinalScore(result);

        Assertions.assertEquals(result, expectations);
    }
}
