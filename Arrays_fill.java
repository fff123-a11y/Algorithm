package Zhenkai;
import java.util.Arrays;

public class Arrays_fill {
    public static void main(String[] args)
    {
        int[] a = new int[10];
        Arrays.fill(a, 999);
        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        Arrays.fill(a, 3, 3 + 4 + 1, 100);
        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
