/*
http://usaco.org/index.php?page=viewproblem2&cpid=1205
*/

import java.util.*;
public class u202202_q3_blocks {
    /* public static void setUpPerms(){
        perms[1] = new char[24][1];
        perms[2] = new char[432][2];
        for(int a = 0; a < 6; a++) {
            for (int i = 0; i < 4; i++) {
                perms[1][a * 4 + i][0] = blocks[i][a];
                for (int b = 0; b < 6; b++) {
                    for(int j = i + 1; j < i + 4; j = j % 4) {
                        perms[2][a * 72 + b * 12 + i * 3 + j][0] = blocks[a];

                        for (int c = 0; c < 6; c++) {
                            for (int d = 0; d < 6; d++) {
                            }
                        }
                    }
                }
            }
        }
    }*/
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
            System.out.println(i);
        }
    }

    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n * factorial((n - 1));
    }

    public static int[] concat(int[] arr1, int[] arr2){
        int[] fArr = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++){
            fArr[i] = arr1[i];
        }
        for(int i = arr1.length; i < arr1.length + arr2.length; i++){
            fArr[i] = arr2[i - arr1.length];
        }
        return fArr;
    }

    public static int[] slicing(int[] arr, int a, int b){
        int[] fArr = new int[b - a];
        for(int i = a; i < b; i++){
            fArr[i - a] = arr[i];
        }
        return fArr;
    }

    public static void permute(int[] prefix, int[] remaining){
        if(remaining.length == 0){
            perms[progress] = prefix;
            progress++;
            return;
        }

        for(int i = 0; i < remaining.length; i++){
            permute(concat(prefix, new int[]{remaining[i]}), concat(slicing(remaining, 0, i), slicing(remaining, i + 1, remaining.length)));
        }
    }

    public static int[] incArr(int n){
        int[] fArr = new int[n];
        for(int i = 0; i < n; i++){
            fArr[i] = i;
        }
        return fArr;
    }

    public static void setUpPerms(int n){
        int f = factorial(n);
        perms = new int[f][n];
        permute(new int[]{}, incArr(n));
    }

    static int progress = 0;

    static int[][] perms;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        setUpPerms(4);

        ArrayList<HashSet<String>> blocks = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            String line = in.next();
            HashSet<String> block = new HashSet<String>();
            for(int k = 0; k < 6; k++){
                block.add(line.charAt(k) + "");
            }
            blocks.add(block);
        }

        for(int i = 0; i < n; i++){
            String word = in.next();

            boolean success = false;
            for(int[] p: perms){
                success = true;
                for(int x = 0; x < word.length(); x++){
                    if(!blocks.get(p[x]).contains(word.charAt(x) + "")){//blocks
                        success = false;
                        break;
                    }
                }
                if(success) break;
            }
            System.out.println(success ? "YES" : "NO");
        }
    }
}
