package Zhenkai;

import java.util.*;

public class FourNumbersAdding {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        Set<Integer> third = new HashSet<>();

        // ±éÀúkey-value
        // È¥ÖØ£¬¼ôÖ¦
        for(int a = 0; a < nums.length-3; a++){
            if(!first.contains(nums[a])){
                first.add(nums[a]);
                for(int b = a+1; b < nums.length-2; b++){
                    if(!second.contains(nums[b])){
                        second.add(nums[b]);
                        for(int c = b+1; c < nums.length-1; c++){
                            if(!third.contains(nums[c])){
                                third.add(nums[c]);
                                int sum = nums[a]+nums[b]+nums[c];
                                for(int d = c+1; d < nums.length; d++){
                                    if(sum+nums[d] > target){
                                        break;
                                    }else if(sum+nums[d] == target){
                                        List<Integer> combine = new ArrayList<>(4);
                                        combine.add(nums[a]);
                                        combine.add(nums[b]);
                                        combine.add(nums[c]);
                                        combine.add(nums[d]);
                                        result.add(combine);
                                        break;
                                    }
                                }
                            }
                        }
                        third.clear();
                    }
                }
                second.clear();
            }
        }
        return result;
    }
}
