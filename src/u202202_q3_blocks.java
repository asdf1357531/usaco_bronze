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

    static int[][] perms = {
        {0, 1, 2, 3}, {0, 1, 3, 2}, {0, 2, 1, 3}, {0, 2, 3, 1}, {0, 3, 1, 2}, {0, 3, 2, 1},
        {1, 0, 2, 3}, {1, 0, 3, 2}, {1, 2, 0, 3}, {1, 2, 3, 0}, {1, 3, 0, 2}, {1, 3, 2, 0},
        {2, 0, 1, 3}, {2, 0, 3, 1}, {2, 1, 0, 3}, {2, 1, 3, 0}, {2, 3, 0, 1}, {2, 3, 1, 0},
        {3, 0, 1, 2}, {3, 0, 2, 1}, {3, 1, 0, 2}, {3, 1, 2, 0}, {3, 2, 0, 1}, {3, 2, 1, 0}
    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] blocks = new int[4][26];
        for(int i = 0; i < 4; i++){
            String line = in.next();
            for(int k = 0; k < 6; k++){
                int id = line.charAt(k) - 'A';
                blocks[i][id] = 1;
            }
        }

        for(int i = 0; i < n; i++){
            String word = in.next();

            boolean success = false;
            for(int[] p: perms){
                success = true;
                for(int x = 0; x < word.length(); x++){
                    int id = word.charAt(x) - 'A';
                    if(blocks[p[x]][id] == 0){
                        success = false;
                        break;
                    }
                }
                if(success) break;
            }
            System.out.println(success ? "YES" : "NO");
        }

        /*
        for(int i = 0; i < 4; i++){
            blocks[i] = in.next().toCharArray();
        }

        setUpPerms();

        for(int i = 0; i < n; i++){
            boolean permFound = false;
            String iword = in.next();
            char[] word = iword.toCharArray();

            outerloop:
            for(int j = 0; j < perms[word.length].length; j++){
                String nperm = "";

                for(int k = 0; k < word.length; k++){
                    nperm += "" + perms[word.length][j][k];
                    System.out.println(i + " : " + j + " : " + k);
                }
                System.out.println(" : " + nperm);

                if(iword.equals(nperm)){
                    permFound = true;
                    break outerloop;
                }

            }

            if(permFound) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }

         */
    }
}
