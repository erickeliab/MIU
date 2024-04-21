import java.util.ArrayList;
import java.util.List;
import java.util.DoubleSummaryStatistics;

public class Main {

    public static void main(String[] args) {

        List<ExamData> data = new ArrayList<ExamData>();
        data.add(new ExamData("George",91.3));
        data.add(new ExamData("Tom",88.9));
        data.add(new ExamData("Rick",80));
        data.add(new ExamData("Harold",90.8));
        data.add(new ExamData("Ignatius",60.9));
        data.add(new ExamData("Anna",77));
        data.add(new ExamData("Susan",87.3));
        data.add(new ExamData("Phil",99.1));
        data.add(new ExamData("Alex",84));

        DoubleSummaryStatistics stats = data.stream().mapToDouble(ExamData::getTestScore).summaryStatistics();

        if (stats.getCount() > 0) {
            System.out.println("The top score is: " + stats.getMax());
            System.out.println("The lowest score is: " + stats.getMin());
            System.out.println("The average score is: " + stats.getAverage());
        } else {
            System.out.println("No exam data available.");
        }
    }
}