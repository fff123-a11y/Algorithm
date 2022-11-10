package Shibing;

import java.util.HashMap;

public class Code08_TheAddingOfTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];

        //����k-v,һһ��Ӧ�Ĺ�ϣ��
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
