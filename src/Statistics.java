import java.util.Objects;

public class Statistics {
    String surname;
    int taskNum;
    int attempt;
    int score;
    int finalScore;

    public Statistics(String surname, int taskNum, int attempt, int score) {
        this.surname = surname;
        this.taskNum = taskNum;
        this.attempt = attempt;
        this.score = score;
    }

    public Statistics(String surname, int taskNum, int attempt, int score, int finalScore) {
        this.surname = surname;
        this.taskNum = taskNum;
        this.attempt = attempt;
        this.score = score;
        this.finalScore = finalScore;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "surname='" + surname + '\'' +
                ", taskNum=" + taskNum +
                ", attempt=" + attempt +
                ", score=" + score +
                ", finalScore=" + finalScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return taskNum == that.taskNum && attempt == that.attempt && score == that.score && finalScore == that.finalScore && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, taskNum, attempt, score, finalScore);
    }
}
