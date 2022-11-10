package Shibing;


// Leetcode 494题
public class Code07_TargetSum {
    public static int findTargetSumWays1(int[] arr, int s) {
        return process(arr, 0, s);
    }

    //可以自由使用arr[index...]所有的数字
    //弄出rest这个数，方法数是多少？返回
    private static int process(int[] arr, int index, int rest) {
        if(index == arr.length) { //没数了！
            return rest == 0 ? 1 : 0;
        }
        return process(arr, index + 1, rest - arr[index] + process(arr, index+1, rest+arr[index]));
    }

}
