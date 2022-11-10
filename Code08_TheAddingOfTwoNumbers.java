package Shibing;

import java.util.HashMap;

public class Code08_TheAddingOfTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];

        //建立k-v,一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i])) {
                index[0] = i;
                index[1] = hash.get(nums[i]);
                return index;
            }
            hash.put(target-nums[i], i);
        }
        return index;
    }
}
