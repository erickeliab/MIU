public class Prog3 {


    private static String[] removeDuplicate(String[] inputArray) {
        int index = 0;
        for (String s : inputArray) {
            if (s != null) {
                int compareIndex = index + 1;
                for (String next : inputArray) {
                    if (compareIndex < inputArray.length && next != null && s.equals(next)) {
                        inputArray[compareIndex] = null;
                    }
                    compareIndex++;
                }
            }
            index++;
        }


        int count = 0;
        for (String s : inputArray) {
            if (s != null) {
                count++;
            }
        }


        String[] resultArray = new String[count];
        int resultIndex = 0;
        for (String s : inputArray) {
            if (s != null) {
                resultArray[resultIndex++] = s;
            }
        }

        return resultArray;
    }

    public static void main(String[] args) {
        String[] sampleArray = {"horse", "dog", "cat", "horse", "dog", "cat"};
        String[] resultArray = removeDuplicate(sampleArray);

        for (String s : resultArray) {
            System.out.println(s);
        }
    }
}
