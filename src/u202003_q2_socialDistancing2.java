//http://usaco.org/index.php?page=viewproblem2&cpid=1036

import java.util.*;
public class u202003_q2_socialDistancing2 {
    static int m = 1000001;

    // If the Ith cow is within r distance of x
    // set x to i and check if there is a cow within r distance of i and keep on repeating
    // until there is not a cow that fits these requirements
    // Return the value of x
    public static int nextCow(int[] cows, int x, int r){
        for(int i = x + 1; i < Math.min(x + r, m); i++){
            if(cows[i] == 1){
                return nextCow(cows, i, r);
            }
        }
        return x;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        int[] cows = new int[m];
        Arrays.fill(cows, -1);

        //If no healthy cows are found, radius will stay at 1000000
        int r = m - 1;

        //taking inputs
        while(n-->0){
            int position = in.nextInt();
            int cowState = in.nextInt();
            cows[position] = cowState;
        }

        int x = 1;
        int prevInfected = -1;
        int prevHealthy = -1;

        //finding radius
        while(x < m){
            //find next plot with cow in it
            while(cows[x] < 0 && x < m - 1){
                x++;
            }

            if(cows[x] == 0)
                prevHealthy = x;

            if(cows[x] == 1)
                prevInfected = x;

            //If at least 1 healthy cow has been found, check if distance from infected cow to healthy cow is less than the current radius
            if(prevHealthy > 0)
                r = Math.min(r, Math.abs(prevInfected - prevHealthy));
            x++;
        }
        x = 1;

        System.out.println("radius: " + r);

        //Originally infected cows
        //When the last cow is not infected, set to -1 to prevent overCounting
        int originalCows = cows[m - 1] == 1 ? 0:-1;

        while(x < m){
            //Find the next currently infected cow
            while(x < m){
                if(cows[x] == 1){
                    break;
                }
                x++;
            }

            x = nextCow(cows, x, r) + 1;
            originalCows++;
        }
        System.out.println("Number of Originally Sick Cows: " + originalCows);
    }
}
