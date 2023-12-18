import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] m = {1,2,3,4,3,3,8,9,14,5,120,87,3};
        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
//        System.out.println(prob1431.kidsWithCandies(m, 10));
        Prob1679 prob1679 = new Prob1679();
        System.out.println(prob1679.maxOperations(m, 6));
    }
}


