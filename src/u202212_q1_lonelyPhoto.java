import java.util.*;
public class u202212_q1_lonelyPhoto {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String cows = in.next();
        int lonelyPhotos = 0;
        for(int i = 0; i < n - 2; i++){
            int gs = 0;
            int hs = 0;
            char last = cows.charAt(i);
            for(int j = i + 1; j < n; j++){
                last = cows.charAt(j);
                if((gs > 1 && hs > 1) || j == n - 1){
                    lonelyPhotos += j - i - 2;
                    break;
                }
                if(cows.charAt(j) == 'G'){gs++;}
                else {hs++;}
            }
        }
        System.out.println(lonelyPhotos);
    }
}