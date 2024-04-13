
import javax.swing.*;
import java.util.regex.*;
import java.util.List;
class Ch9PMCountJava2 {

    public static void main(String[] args) {
        String document = JOptionPane.showInputDialog(null, "Sentence:");
        String wordToSearch = "java"; // Change this to the word you want to search for
        List<Integer> positions = PatternMatcher.myCount(document, wordToSearch);
        if (positions.isEmpty()) {
            System.out.println("'" + wordToSearch + "' not found in the sentence.");
        } else {
            for (Integer position : positions) {
                System.out.println(wordToSearch + " found at position " + position);
            }
        }
    }
}
