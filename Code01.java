package Shibing;

import java.util.Arrays;

public class Code01 {

    static final int num = (int) 1e9 + 7;

    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] letter = new int[26];
        long[] preidx = new long[n + 1];
        Arrays.fill(letter, -1);
        for (int i = 0; i < n; i++) {
            int res = s.charAt(i) - 'a';
            if (letter[res] == -1) {
                preidx[i + 1] = (preidx[i] * 2 + 1) % num;
            } else {
                preidx[i + 1] = (preidx[i] * 2 - preidx[letter[res]] + num) % num;
            }
            letter[res] = i;
        }
        return (int) (preidx[n] % num);
    }
}

