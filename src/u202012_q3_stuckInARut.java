import java.util.*;
public class u202012_q3_stuckInARut {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] dirs = new int[N][2];
        ArrayList<int[]> northCows = new ArrayList<>();
        ArrayList<int[]> eastCows = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String dir = in.next();
            int x = in.nextInt();
            int y = in.nextInt();
            if(dir.equals("E")) {
                dirs[i][0] = 1;
                dirs[i][1] = eastCows.size();
                eastCows.add(new int[]{x, y, i});
            } else {
                dirs[i][0] = 2;
                dirs[i][1] = northCows.size();
                northCows.add(new int[]{x, y, i});
            }
        }

        System.out.println("=====East Cows=====");
        for(int i = 0; i < eastCows.size(); i++){
            for(int j = 0; j < 3; j++){
                System.out.print(eastCows.get(i)[j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("=====West Cows=====");
        for(int i = 0; i < northCows.size(); i++){
            for(int j = 0; j < 3; j++){
                System.out.print(northCows.get(i)[j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        ArrayList<int[]> collisions = new ArrayList();
        //Collisions

        /*
         * EastCow and NorthCow
         *
         * Must satisfy conditions: northCow is to the southEast of eastCow
         *
         * Find interval "T" that EastCow and NorthCow collide
         * if eastCow is farther from center, set T to eastCowY - northCowY
         * else if northCow is farther from center, set T to northCowX - eastCowX
         *
         * */
        for(int i = 0; i < northCows.size(); i++){
            int x = northCows.get(i)[0];
            int y = northCows.get(i)[1];
            for(int j = 0; j < eastCows.size(); j++){
                int idn = northCows.get(i)[2];
                int a = eastCows.get(j)[0];
                int b = eastCows.get(j)[1];
                int ide = eastCows.get(j)[2];

                int t = 0;
                if(x > a && y < b){
                    if(x + y > a + b){
                        t = x - a;
                    }

                    if(a + b > x + y){
                        t = b - y;
                        int buffer = ide;
                        ide = idn;
                        idn = buffer;
                    }
                }
                if(t > 0){
                    collisions.add(new int[]{t, ide, idn, x, b});//time, crashed, non-crashed, x, y
                }

                for(int c = collisions.size() - 1; c > 0; c--){
                    if(collisions.get(c)[0] < collisions.get(c - 1)[0]){
                        Collections.swap(collisions, c, c - 1);
                    }
                }
            }
        }
        System.out.println("=====Collisions=====");
        for(int i = 0; i < collisions.size(); i++){
            for(int j = 0; j < 5; j++){
                System.out.print(collisions.get(i)[j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[] collided = new int[N];

        System.out.println("=====Efficient Simulation=====");
        for(int i = 0; i < collisions.size(); i++){
            int t = collisions.get(i)[0];
            int collidingCow = collisions.get(i)[1];
            int nonCollidingCow = collisions.get(i)[2];
            int x = collisions.get(i)[3];
            int y = collisions.get(i)[4];
            if(collided[collidingCow] == 0){
                //Case 1: Neither cow has collided
                if(collided[nonCollidingCow] == 0) {
                    System.out.println("Case 1");
                    collided[collidingCow] = t;
                }
                //Case 2: Closer Cow has collided
                else {
                    System.out.println("Case 2");
                    if(dirs[nonCollidingCow][0] == 1){
                        if(eastCows.get(dirs[nonCollidingCow][1])[0] + collided[nonCollidingCow] > x){
                            System.out.println("Case 2.1");
                            collided[collidingCow] = t;
                        } else {
                            System.out.println("Case 2.1 Failed");
                        }
                    } else {
                        if(northCows.get(dirs[nonCollidingCow][1])[1] + collided[nonCollidingCow] > y){
                            System.out.println("Case 2.2: " + (northCows.get(dirs[nonCollidingCow][1])[1] + t));
                            collided[collidingCow] = t;
                        } else {
                            System.out.println("Case 2.2 Failed");
                        }
                    }
                }
                for(int k = 0; k < N; k++){
                    if(collided[k] == 0){
                        System.out.print("Infinity ");
                    } else {
                        System.out.print(collided[k] + " ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("=====ANSWER=====");
        for(int i = 0; i < N; i++){
            if(collided[i] == 0){
                System.out.println("Infinity");
            } else {
                System.out.println(collided[i]);
            }
        }
    }
}
