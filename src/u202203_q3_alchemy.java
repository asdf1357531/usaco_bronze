import java.util.*;
public class u202203_q3_alchemy {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void printNestedArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null)
                printArray(arr[i]);
            else
                System.out.println();
        }
    }

    public static boolean metalsLeft2(int[][] recipes, int[] metalsINPUT, int n){
        int[] metals = metalsINPUT;
        System.out.println(n);
        if(recipes[n] != null) {
            printArray(metals);
            metals[n]++;
            for (int i = 0; i < recipes[n].length; i++) {
                int r = recipes[n][i];
                System.out.println("i: " + i);
                if (metals[r] > 0) {
                    System.out.println("in if statement:" + n);
                    metals[r]--;
                } else {
                    return metalsLeft(recipes, metals, r);
                }
                if(recipes[r] == null){
                        return false;
                }
            }
        }
        return true;
        /*
6
2 0 0 1 1 0
4
5 2 3 4
2 1 1
3 1 2
6 2 1 5

         */
    }

    public static boolean metalsLeft(int[][] recipes, int[] metalsINPUT, int n){
        int[] metals = metalsINPUT;
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] metals = new int[n + 1];
        for(int i = 1; i < n + 1; i++){metals[i] = in.nextInt();}

        int k = in.nextInt();

        int[][] recipes = new int[n + 1][];
        for(int i = 0; i < k; i++){
            int l = in.nextInt();
            int m = in.nextInt();
            recipes[l] = new int[m];
            for(int j = 0; j < m; j++){recipes[l][j] = in.nextInt();}
        }
        printNestedArray(recipes);
        while(metalsLeft(recipes, metals, n)) {}

        System.out.println(metals[n] - 1);
    }
}
