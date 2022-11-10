package Zhenkai;

public class MaxScoreOfDividing {
    public int maxScore(String s) {
        int n = s.length();
        int sum0 = 0, sum1 = 0;
        int res = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1')
                sum1++;
        }
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)=='0')
                sum0++;
            else if(s.charAt(i)=='1')
                sum0--;
            res = Math.max(res, sum0+sum1);
        }
        return res;
    }
}
