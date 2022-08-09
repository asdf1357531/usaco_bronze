//http://usaco.org/index.php?page=viewproblem2&cpid=989

import java.util.*;
public class u202001_q3_race {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int N = in.nextInt();
        while(N-->0){
            int x = in.nextInt();
            int t = 0;
            int s = 0;
            int d = 0;
            System.out.print("\n X: " + x + " || ");
            while(d < K){
                if(d + ((s + 2) * (s + 1))/2 - (x * (x - 1))/2 <= K)
                    s++;
                else if(d + (s * (s + 1))/2 - (x * (x + 1))/2 >= K && s > x)
                    s--;
                d += s;
                t++;
                System.out.print("(" + s + ", " + d + ") ");
            }
            System.out.print("Time: " + t);
        }
    }
}