import java.util.*;
/*
http://usaco.org/index.php?page=viewproblem2&cpid=1059
*/
public class u202012_q1_doYouKnowYourABCs {
    /*public static void getabc(int[] inputs){
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < 7; i++){
            if(inputs[i] < min2){
                min2 = inputs[i];
            } else if(inputs[i] < min){
                min = min2;
                min2 = inputs[i];
            }
            if(inputs[i] > max){
                max = inputs[i];
            }
        }
        System.out.println(min + " " + min2 + " " + (max - min - min2));
    }*/
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] inputs = {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};

        Arrays.sort(inputs);
        System.out.println(inputs[0] + " " + inputs[1] + " " + (inputs[6] - inputs[1] - inputs[0]));
    }
}