import java.util.Arrays;

public class MyPeopleList {

    private final int INITIAL_LENGTH = 4;
    private Person[] currentArray;
    private int numOfElements;

    public MyPeopleList(){
        currentArray = new Person[INITIAL_LENGTH];
        numOfElements = 0;

    }


//    Add elements in last

    public void add(Person s){
        if (s == null ) return;
        if(numOfElements == currentArray.length){
            resize();
        }

        currentArray[numOfElements] = s;
        numOfElements = numOfElements + 1;
    }

    public Person get(int i){
        if (i < 0 || i >= numOfElements) return null;

        return currentArray[i];
    }

    private void resize(){
        System.out.println("resizing");
        int len = currentArray.length;
        int newlen = 2 * len;
        Person[] newArray = new Person[newlen];

        System.arraycopy(currentArray,0,newArray,0,len);
        currentArray = newArray;
    }

    public boolean isEmpty(){
        return (numOfElements == 0);
    }

    public boolean find(String s){
        if (s == null) return false;

        for (int i = 0; i < numOfElements; i++){
            if (currentArray[i].getLast().equals(s)) return true;
        }

        return false;
    }

    public void insert(Person s, int pos){
        if (s == null) return;
        if(pos > numOfElements || pos < 0) return;
        if (numOfElements == currentArray.length){
            resize();
        }

        Person[] temp = new Person[currentArray.length];
        System.arraycopy(currentArray,0,temp,0,pos);
        temp[pos] = s;

        System.arraycopy(currentArray,0,temp,pos + 1,currentArray.length - (pos + 1));
        currentArray = temp;
        ++numOfElements;
    }


    public boolean remove(Person s){
        if(numOfElements == 0) return false;
        if(s == null) return false;
        int index = -1;
        for (int i = 0; i < numOfElements; i++){
            if (currentArray[i].equals(s)){
                index = i;
                break;
            }
        }

        if (index == -1) return false;
        Person[] temp = new Person[currentArray.length];
        System.arraycopy(currentArray,0,temp,0,index);
        System.arraycopy(currentArray,index+1,temp,index,currentArray.length-(index+1));
        currentArray = temp;
        --numOfElements;
        return true;
    }



    public String toString(){
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < numOfElements - 1; ++i){
            sb.append(currentArray[i].toString()+", ");
        }
        sb.append(currentArray[numOfElements - 1].toString() + "]");
        return sb.toString();
    }


    public int size(){
        return numOfElements;
    }

    public Object clone(){
        Person[] temp = Arrays.copyOf(currentArray,numOfElements);

        return temp;
    }

    public static void main(String[] args) {
        MyPeopleList l = new MyPeopleList();
        l.add(new Person("Joseph","Janeth",27));
        l.add(new Person("Hassan","Mwakinyo",14));
        l.add(new Person("Gideon","Robert",22));
        l.add(new Person("Jackson","Samuel",34));
        l.insert(new Person("Peterson","Dwayne",56),2);
        l.insert(new Person("Kimmnel","Cleopatra",9),3);
        System.out.println("Find: " + l.find("Jacob"));
        System.out.println("At index 3: " + l.get(3));
        l.remove(new Person("Peterson","Dwayne",56));
        l.remove(new Person("Kimmnel","Cleopatra",9));
        System.out.println(l.toString());
    }

    public void addAtHead(int i) {

    }
}
