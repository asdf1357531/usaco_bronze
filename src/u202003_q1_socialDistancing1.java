import java.util.*;
public class u202003_q1_socialDistancing1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int d = 1;
        int ld = 2147483647;
        int hd1 = 0;
        int hd2 = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '1'){
                if(d > hd1){
                    hd2 = hd1;
                    hd1 = d;
                } else if(d > hd2){hd2 = d;}
                if(d < ld){ld = d;}
                d = 0;
            }
            d++;
        }
        if(hd1 >= 3 * ld) {
            System.out.println(ld);
        } else if(hd1 >= 2 * ld & hd2 >= 2 * ld) {
            System.out.println(ld);
        } else {
            System.out.println(Math.round(hd2/2));
        }

    }
}
