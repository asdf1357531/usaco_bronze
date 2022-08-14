//http://usaco.org/index.php?page=viewproblem2&cpid=1229

/*
6
2 0 0 1 1 0
4
5 2 3 4
2 1 1
3 1 2
6 2 1 5
*/
import java.util.*;
public class u202203_q3_alchemy {
    static int[][] recipes;
    static int[] metals;

    public static boolean metalsLeft(int n){
        if(recipes[n] != null){
            for(int i = 0; i < recipes[n].length; i++){
                System.out.print("N: " + n + " || I: " + i + " || ");
                for(int j = 1; j < metals.length; j++){
                    System.out.print(metals[j] + " ");
                }
                System.out.println();
                if(metals[recipes[n][i]] > 0){
                    metals[recipes[n][i]]--;
                    continue;
                } else {
                    if(metalsLeft(recipes[n][i]))continue;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        metals = new int[n + 1];
        for(int i = 1; i < n + 1; i++){metals[i] = in.nextInt();}

        int k = in.nextInt();
        recipes = new int[n + 1][];
        for(int i = 0; i < k; i++){
            int l = in.nextInt();
            int m = in.nextInt();
            recipes[l] = new int[m];
            for(int j = 0; j < m; j++){recipes[l][j] = in.nextInt();}
        }
        while(metalsLeft(n)){
            metals[n]++;
        }

        System.out.println(metals[n]);
    }
}
