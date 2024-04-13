import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class PatternMatcher {

    public static boolean myMatches(String regex, String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static String myReplaceAll(String regex, String replacement, String str){
        return str.replaceAll(regex, replacement);
    }

    public static int myFind(String regex, String str) {
        int count = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static List<Integer> myCount(String document, String wordToSearch) {
        List<Integer> positions = new ArrayList<>();
        Pattern pattern = Pattern.compile(wordToSearch, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(document);
        while (matcher.find()) {
            positions.add(matcher.start());
        }
        return positions;
    }


}
