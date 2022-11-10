public class _0325_1 {


    public static void main(string[] args) throws IOException {
        BufferReader br = new BufferReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] powers = new int[n];
        Sring[] lines = br.readLine().split(regex:" ");
        for (int i = 0; i < n; i++) {
            powers[i] = Integer.parseInt(lines[i];
        }
        int k = Integer.parseInt(br.readLine());
        mem = new int[n];
        int ans = dfs(idx:0, powers);
        if (ans <= k) System.out.println(-1);

    }

    private static int dfs(int idx, int[] powers) {
        if (idx >= powers.length - 1) return 0;
        int ans = 100001;
        for (int i = 1; i < n; i++) {
            int tmp = dfs(idx:idx + i, powers);
            if (tmp != 100001) ans = Math.min(ans, tmp + 1);
        }
        return ans;
    }

    private static int dfs(int idx, int[] powers) {
        if (idx >= powers.length - 1) return 0;
        if (powers[idx] == 0) return 100001;
        int maxstep = 0, nextidx = 0;
        for (int i = 1; i <= powers[idx]; i++) {
            if (idx + i >= powers.length - 1) return 1;
            if (powers[idx] + i + idx > maxstep) {
                maxstep = powers[idx + i] + i + idx;
                nextidx = idx + i;
            }
        }
        return dfs(nextidx, powers) + 1;
    }
}
