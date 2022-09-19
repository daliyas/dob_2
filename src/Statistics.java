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
}
