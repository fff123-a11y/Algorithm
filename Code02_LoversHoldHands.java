package Zhenkai;

public class Code02_LoversHoldHands {
    public int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            int cp1 = row[i];
            int cp2 = cp1 % 2 == 0 ? cp1 + 1 : cp1 - 1;

            if (row[i + 1] == cp2) {
                continue;
            }
            for (int j = i + 2; j < row.length; j++) {
                if (row[j] == cp2) {
                    row[j] = row[i + 1];
                    row[i + 1] = cp2;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
