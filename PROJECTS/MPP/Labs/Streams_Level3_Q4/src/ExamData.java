public class ExamData {

    private String studentName;
    private Double testScore;

    public ExamData(String name, double score){
        studentName = name;
        testScore = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public Double getTestScore() {
        return testScore;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTestScore(Double testScore) {
        this.testScore = testScore;
    }
}
