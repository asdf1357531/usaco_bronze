import java.util.*;
import java.io.*;

class socialDistancing1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int d = 100000;
        int hd1 = 1;
        int hd2 = 1;
        int hda = 1;
        int beg = -1;
        for (int i = 0; i < n; i++) {
            boolean cchar = s.charAt(i) == '1';
            if (cchar) {
                if(beg == -1) {
                    hd1 = Math.max(hd1, i);
                    hda = Math.max(hda, i/2);
                    beg = i;
                }
                else {
                    int j = (i-beg)/2;
                    if (j >= hd1) {
                        hd2 = hd1;
                        hd1 = j;
                    }
                    else if (j > hd2) {
                        hd2 = j;
                    }
                    hda = Math.max(hda, (i-beg)/3);
                    d = Math.min(d, i-beg);
                    beg = i;
                }
            }
        }
        if (beg == -1) {
            hda = Math.max(hda, n-1);
        }
        else {
            int j = n-beg-1;
            if (j >= hd1) {
                hd2 = hd1;
                hd1 = j;
            }
            else if (j > hd2) {
                hd2 = j;
            }
        }
        hda = Math.max(hda, (n-beg-1)/2);
        System.out.println("" + Math.min(Math.max(Math.min(hd1, hd2), hda), d));
    }
}