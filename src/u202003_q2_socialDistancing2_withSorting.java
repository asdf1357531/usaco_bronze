import java.util.*;

public class u202003_q2_socialDistancing2_withSorting {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = 1000000;
        ArrayList<Integer> infected = new ArrayList<>();
        ArrayList<Integer> healthy = new ArrayList<>();
        while(n-->0){
            int position = in.nextInt();
            int state = in.nextInt();
            if(state == 0)
                healthy.add(position);
            else
                infected.add(position);
        }
        int cows = infected.size() + healthy.size();
        Collections.sort(infected);
        Collections.sort(healthy);
        int cInfected = 0;
        int cHealthy = 0;
        while(cInfected < infected.size() && cHealthy < healthy.size()){
            int posInfected = infected.get(cInfected);
            int posHealthy = healthy.get(cHealthy);
            if(posInfected > posHealthy){
                cHealthy++;
            } else {
                cInfected++;
            }
            r = Math.min(r, Math.abs(posInfected - posHealthy));
        }
        System.out.println("radius: " + r);
        int originalCows = 1;
        for(int i = 1; i < infected.size(); i++){
            if(infected.get(i) - infected.get(i - 1) >= r){
                originalCows++;
            }
        }
        System.out.println(originalCows);
    }
}
