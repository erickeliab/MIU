public class MyTable {
    private Entry[] entries;

    public MyTable() {
        entries = new Entry[26];
    }

    public String get(char c) {
        int index = c - 'a';
        if (index >= 0 && index < entries.length && entries[index] != null) {
            return entries[index].toString();
        }
        return null;
    }


    public void add(char c, String s) {
        int index = c - 'a';
        if (index >= 0 && index < entries.length) {
            entries[index] = new Entry(c, s);
        }
    }

    public String toString() {

        String str = "";
        for (Entry entry : entries) {
            if (entry != null) {
                str += entry.toString() + " \n";

            }
        }

        return entries.length > 0 ? str : null;
    }

    private static class Entry {
        char ch;
        String str;

        Entry(char ch, String str) {
            this.ch = ch;
            this.str = str;
        }


        public String toString() {
            return ch + "->" + str;
        }
    }

    public static void main(String[] args) {
        MyTable t = new MyTable();
        t.add('a', "Andrew");
        t.add('b', "Billy");
        t.add('w', "Willie");
        System.out.println(t);
    }
}
