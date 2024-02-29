import java.util.Arrays;
public class Prog5 {

    public static int[] combine(int[] a, int[] b){

        int[] res = new int[a.length + b.length];

        System.arraycopy(a,0,res,0,a.length);

        System.arraycopy(b,0,res,a.length,b.length);

        return res;
    }


    public static void main(String[] args) {

        int[] sample1 = {5,6,-4,3,1};
        int[] sample2 = {3,8,9,11};

        System.out.println(Arrays.toString(combine(sample1,sample2)));


    }
}
