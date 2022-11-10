package Zhenkai;

import java.util.Arrays;

public class Code04_Drive {
    // ���ϵ��ֳ��汾
    // income -> N * 2 �ľ��� N��ż����
    // 0 [9, 13]
    // 1 [45,60]
    public static int maxMoney1(int[][] income) {
        if (income == null || income.length < 2 || (income.length & 1) != 0) {
            return 0;
        }
        int N = income.length; // ˾������һ����ż�������Բ���ƽ�֣�A N /2 B N/2
        int M = N >> 1; // M = N / 2 ҪȥA�������
        return process1(income, 0, M);
    }

    // index.....���е�˾������A��B������䣡
    // A������rest������!
    // ���ذ�index...˾���������꣬��������A��B����ͬ���������£�index...��Щ˾����������������Ƕ��٣�
    public static int process1(int[][] income, int index, int rest) {
        if (index == income.length) {
            return 0;
        }
        // ��ʣ��˾����
        if (income.length - index == rest) {
            return income[index][0] + process1(income, index + 1, rest - 1);
        }
        if (rest == 0) {
            return income[index][1] + process1(income, index + 1, rest);
        }
        // ��ǰ˾��������ȥA������ȥB
        int p1 = income[index][0] + process1(income, index + 1, rest - 1);
        int p2 = income[index][1] + process1(income, index + 1, rest);
        return Math.max(p1, p2);
    }

    // �ϸ�λ�������Ķ�̬�滮�汾
    public static int maxMoney2(int[][] income) {
        int N = income.length;
        int M = N >> 1;
        int[][] dp = new int[N + 1][M + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= M; j++) {
                if (N - i == j) {
                    dp[i][j] = income[i][0] + dp[i + 1][j - 1];
                } else if (j == 0) {
                    dp[i][j] = income[i][1] + dp[i + 1][j];
                } else {
                    int p1 = income[i][0] + dp[i + 1][j - 1];
                    int p2 = income[i][1] + dp[i + 1][j];
                    dp[i][j] = Math.max(p1, p2);
                }
            }
        }
        return dp[0][M];
    }

    // ������̰�Ĳ��� :
    // ����һ����10��˾����˼·����������˾��ȥA���õ�һ��������
    // Ȼ�󿴿���5��˾���Ļ���ͥ(ȥB)�����Ի�����Ķ�������
    // �������̰�Ĳ��ԣ������ҵ���
    // �����ҿ����ᵽ�ļ�����������
    // �����������½ⷨ����ʡȥ�����Ķ����������ʡʱ��
    // �����л¬ʥ��ͬѧ
    public static int maxMoney3(int[][] income) {
        int N = income.length;
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = income[i][1] - income[i][0];
            sum += income[i][0];
        }
        Arrays.sort(arr);
        int M = N >> 1;
        for (int i = N - 1; i >= M; i--) {
            sum += arr[i];
        }
        return sum;
    }

    // �������len*2��С����������
    // ֵ��0~value-1֮��
    public static int[][] randomMatrix(int len, int value) {
        int[][] ans = new int[len << 1][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = (int) (Math.random() * value);
            ans[i][1] = (int) (Math.random() * value);
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 10;
        int value = 100;
        int testTime = 500;
        System.out.println("���Կ�ʼ");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * N) + 1;
            int[][] matrix = randomMatrix(len, value);
            int ans1 = maxMoney1(matrix);
            int ans2 = maxMoney2(matrix);
            int ans3 = maxMoney3(matrix);
            if (ans1 != ans2 || ans1 != ans3) {
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                System.out.println("Oops!");
            }
        }
        System.out.println("���Խ���");
    }
}
