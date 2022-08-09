import java.util.*;
public class u202003_q3_cowntactTracing {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        final int N = in.nextInt();//2 <= N <= 100
        final int T = in.nextInt();//1 <= T <= 250

        String input_cows = in.next();
        int[] cows = new int[N + 1];
        for(int i = 0; i < N; i++){
            if(input_cows.charAt(i) == '1')
                cows[i + 1] = 1;
        }

        ArrayList<int[]> record = new ArrayList<>();
        for(int i = 0; i < T; i++){
            record.add(new int[]{in.nextInt(), in.nextInt(), in.nextInt()});
            for(int j = i - 1; j >= 0; j--){
                if(record.get(j)[0] > record.get(i)[0]){
                    int[] b = record.get(j);
                    record.set(j, record.get(i));
                    record.set(i, b);
                } else {
                    break;
                }
            }
        }

        int x = 0;//The number of possible cows that could've been patient zero
        int y = T + 1;//The smallest possible value of K
        int z = 0;//The largest possible value of K

        for(int c = 1; c < N; c++){
            //If the Cth cow is not infected in the original cow sequence, it cannot be patient zero
            if (cows[c] == 1){
                boolean notAdded = true;//Makes sure patient zero is not double counted
                for(int k = 0; k < T + 1; k++){
                    int[] handShakes = new int[N + 1];
                    int[] ccows = new int[N + 1];
                    //Set Patient Zero to infected
                    ccows[c] = 1;

                    for(int i = 0; i < T; i++) {
                        int a = record.get(i)[1];
                        int b = record.get(i)[2];
                        int preState = ccows[b];
                        //If one of the cows is infected and has not been "turned off", set the other to infected
                        if(ccows[a] == 1 && handShakes[a] < k){
                            ccows[b] = 1;
                            handShakes[a]++;
                        }
                        if(preState == 1 && handShakes[b] < k){
                            ccows[a] = 1;
                            handShakes[b]++;
                        }
                    }
                    //Update X Y Z if original cow sequence equals current cow sequence
                    if(Arrays.equals(cows, ccows)){
                        if(notAdded){
                            x++;
                            notAdded = false;
                        }
                        y = Math.min(k, y);
                        z = Math.max(k, z);
                    }
                }
            }
        }
        String out = x + " " + y + " ";
        //No cow can have more than T handshakes, thus if Z equals T, there is no difference when it is infinity
        if(z >= T){
            out += "Infinity";
        } else {
            out += z;
        }
        System.out.println(out);
    }
}
