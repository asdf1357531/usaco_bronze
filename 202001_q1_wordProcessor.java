import java.util.*;
public class wordProcessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int charCount = 0;
        String nextLine = "";
        for(int i = 0; i < n; i++){
            String nextWord = in.next();
            if(charCount + nextWord.length() > k || charCount == 0){
                charCount = nextWord.length();
                System.out.println(nextLine);
                nextLine = nextWord;
            } else {
                charCount += nextWord.length();
                nextLine += " " + nextWord;
            }

        }
        System.out.println();
    }
}
