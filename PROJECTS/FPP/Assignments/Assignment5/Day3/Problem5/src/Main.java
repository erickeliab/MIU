//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Computer c1 = new Computer("DELL", "INTEL", 16,26.2);
        Computer c2 = new Computer("PHP", "INTEL", 16,26.2);

        String res1 = c1.equals(c2) ? "The two computer object are equals " : "The two computer object are not equals ";

        String res2 = c1.equals(c2) ? "The hash codes of two objects are equals" : "The hash codes of two objects are not equals";


        System.out.println(res1);
        System.out.println(res2);
    }
}