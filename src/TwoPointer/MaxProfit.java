package TwoPointer;
import java.util.*;

public class MaxProfit {
    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        int ans= maxProfitAssignment(difficulty,profit,worker);
        System.out.println(ans);
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> jobProfile = new ArrayList<>();
        for(int i=0;i<profit.length-1;i++){
            jobProfile.add(new int[] { difficulty[i], profit[i] });
        }
        Arrays.sort(worker);
        jobProfile.sort((a, b) -> Integer.compare(a[0], b[0]));

        int netProfit=0,maxProfit=0,index=0;
        for (int i = 0; i < worker.length; i++) {
            while ( index < difficulty.length && worker[i] >= jobProfile.get(index)[0])
            {
                maxProfit = Math.max(maxProfit, jobProfile.get(index)[1]);
                index++;
            }
            netProfit += maxProfit;
        }
        return netProfit;
    }
}
