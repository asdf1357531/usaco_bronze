import java.util.*;
public class u202002_q3_swapitySwap {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int K = in.nextInt();

        int a1 = in.nextInt();
        int a2 = in.nextInt();

        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int[] cows = new int[N + 1];

        for(int i = 1; i < N + 1; i++){cows[i] = i;}

        //Swapping B1->B2 and then A1-A2
        for(int i = b1; i < (b1 + b2 - 1)/2 + 1; i++){
            int buffer = cows[i];
            cows[i] = cows[b1 + b2 - i];
            cows[b1 + b2 + - i] = buffer;
        }

        for(int i = a1; i < (a1 + a2 - 1)/2 + 1; i++){
            int buffer = cows[i];
            cows[i] = cows[a1 + a2 - i];
            cows[a1 + a2 - i] = buffer;
        }

        //Finding the length of all loops
        int[] swaps = new int[N + 1];
        for(int i = 1; i < N + 1; i++){
            int j = i;
            int len = 0;
            do{
                j = cows[j];
                len++;
            }while(j != i);
            swaps[i] = len;
        }

        for(int i = 1; i < N + 1; i++){
            int j = i;
            while(K % swaps[i] --> 0){
                j = cows[j];
            }
            System.out.println(j);
        }
    }
}
