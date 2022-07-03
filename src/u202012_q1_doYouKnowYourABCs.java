import java.util.*;

public class u202012_q1_doYouKnowYourABCs {
    public static void getabc(int[] inputs){
        int min = 2147483647;
        int min2 = 2147483647;
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
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] inputs = {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
        getabc(inputs);
    }
}