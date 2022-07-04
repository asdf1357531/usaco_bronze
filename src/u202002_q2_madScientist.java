import java.util.*;
/*
http://usaco.org/index.php?page=viewproblem2&cpid=1012
*/
public class u202002_q2_madScientist {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String i1 = in.next();
        String i2 = in.next();
        char[] a = i1.toCharArray();
        char[] b = i2.toCharArray();
        int count = 0;
        int lowerbound = 0;
        int upperbound = n - 1;
        while(lowerbound <= upperbound) {
            //update lowerbound
            for(int i = lowerbound; i < n; i++){
                if(a[i] == b[i]){
                    lowerbound++;
                } else {
                    break;
                }
            }
            //update upperbound
            for(int i = upperbound; i > 0; i--){
                if(a[i] == b[i]){
                    upperbound--;
                } else {

                    break;
                }
            }
            //reverse Gs and Hs
            for(int i = lowerbound;i <= upperbound; i++){
                if(b[i] == 'G'){
                    b[i] = 'H';
                } else {
                    b[i] = 'G';
                }
            }
            System.out.println(lowerbound + " : " + upperbound + " : " + count);
            count++;
        }
        System.out.println(count - 1);
    }
}
