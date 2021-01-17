package intro;

import java.util.Scanner;

public class PrefixSumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] arr = new int[N];
        int[] prefixSum = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (i == 0) {
                prefixSum[0] = arr[0];
            } else {
                prefixSum[i] = arr[i] + prefixSum[i - 1];
            }
        }
        /*
        Index values 0 <= l <= r < N
         */
        int l, r;
        while (Q > 0) {
            Q -= 1;
            l = sc.nextInt();
            r = sc.nextInt();
            if (l < 0 || l >= N || r < 0 || r >= N || r < l) {
                System.out.println("Invalid inputs");
            } else {
                int ans;
                if (l == r) {
                    ans = arr[l];
                } else if (l == 0) {
                    ans = prefixSum[r];
                } else {
                    ans = prefixSum[r] - prefixSum[l - 1];
                }
                System.out.println("Range sum is : " + ans);
            }
        }
    }
}

/**
 * 3
 * 4
 * -1
 * 0
 * 5
 * 8
 * 11
 * -13
 * 4
 * -17
 **/