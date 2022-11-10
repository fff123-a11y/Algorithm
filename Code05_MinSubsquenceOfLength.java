package Zhenkai;

import java.util.LinkedList;
import java.util.List;

public class Code05_MinSubsquenceOfLength {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        int[] Counter = new int[101]; // Max_Value = 100
        int sum = 0;
        for(int i : nums){
            Counter[i]++;
            sum += i;
        }
        sum /= 2;
        int candidateSum = 0;
        int index = 0;
        List<Integer> ans = new LinkedList<>();
        outside:for(int i = 100; i >= 0; i--){
            while(Counter[i] > 0){
                Counter[i]--;
                ans.add(i);
                candidateSum += i;
                if(candidateSum > sum) break outside;
            }
        }
        return ans;
    }
}
