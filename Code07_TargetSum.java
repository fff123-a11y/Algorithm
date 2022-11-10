package Shibing;


// Leetcode 494��
public class Code07_TargetSum {
    public static int findTargetSumWays1(int[] arr, int s) {
        return process(arr, 0, s);
    }

    //��������ʹ��arr[index...]���е�����
    //Ū��rest��������������Ƕ��٣�����
    private static int process(int[] arr, int index, int rest) {
        if(index == arr.length) { //û���ˣ�
            return rest == 0 ? 1 : 0;
        }
        return process(arr, index + 1, rest - arr[index] + process(arr, index+1, rest+arr[index]));
    }

}
