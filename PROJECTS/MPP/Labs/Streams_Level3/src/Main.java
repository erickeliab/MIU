
//3)    a)  Implement  a method with the following signature and return type:
//public int countWords(List<String> words, char c, char d, int len)
//which counts the number of words in the input list words that have length equal to len, that contain the character c, and that do not contain the character d.  Create a solution that uses a lambda expression.
//Hint :  Look at ALL of the methods that are available in the String class.  This will make it easier for you.
//
//        b)  Use reduce to concatenate the Strings in the Stream below to form a single, space-separated String.  Print the result to the console.
//public static void main(String[] args) {
//    Stream strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");
//}
//
//c)  The many Java standard methods that are in the files I gave you; create programs to use  them and make sure the results are correct!  (For example, test findfirst, findany, the Optional object (use generics here), orElse inside an Optional, and others …
//
//


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Main {

    public static int countWords(List<String> words, char c, char d, int len){

        return (int) words.stream().filter(e -> e.length() == len).filter(e -> e.contains(Character.toString(c))).filter(e -> !e.contains(Character.toString(d))).count();

    }

    public static void main(String[] args) {
        // Test cases
        List<String> wordList1 = List.of("apple", "banana", "cherry", "date", "fig");
        char c1 = 'a';
        char d1 = 'e';
        int len1 = 5;

        List<String> wordList2 = List.of("cat", "dog", "elephant", "lion", "tiger");
        char c2 = 't';
        char d2 = 'e';
        int len2 = 3;

        System.out.println("Question 3 (a)");
        System.out.println("Number of words with length " + len1 + ", containing '" + c1 + "' and not containing '" + d1 + "': " + countWords(wordList1, c1, d1, len1));
        System.out.println("Number of words with length " + len2 + ", containing '" + c2 + "' and not containing '" + d2 + "': " + countWords(wordList2, c2, d2, len2));


        Stream<String> strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");

        String result = strings.reduce("", (partialString, nextString) -> {
            if (partialString.isEmpty()) {
                return nextString;
            } else {
                return partialString + " " + nextString;
            }
        });
        System.out.println("Question 3 (b)");
        System.out.println(result);
        System.out.println("Question 3 (c)");

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig");

        // Using findFirst
        Optional<String> firstWordStartingWithB = words.stream()
                .filter(word -> word.startsWith("b"))
                .findFirst();
        System.out.println("First word starting with 'b': " + firstWordStartingWithB.orElse("No word found"));

        // Using findAny
        Optional<String> anyWordContainingC = words.stream()
                .filter(word -> word.contains("c"))
                .findAny();
        System.out.println("Any word containing 'c': " + anyWordContainingC.orElse("No word found"));

        // Using Optional with generics
        Optional<Integer> optionalNumber = Optional.of(42);
        System.out.println("Optional value: " + optionalNumber.orElseThrow(() -> new RuntimeException("Value is not present")));

        // Using orElse inside an Optional
        Optional<String> optionalString = Optional.empty();
        String results = optionalString.orElse("Default value");
        System.out.println("Value inside Optional: " + results);
    }
}