import java.util.*;

public class Main {

    // Counting Sort according to digit
    static void countingSort(int a[], int n, int pos) {

        int count[] = new int[10];
        int b[] = new int[n];

        // Count frequency of digits
        for (int i = 0; i < n; i++) {
            count[(a[i] / pos) % 10]++;
        }

        // Cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            b[count[(a[i] / pos) % 10] - 1] = a[i];
            count[(a[i] / pos) % 10]--;
        }

        // Copy back
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    // Radix Sort
    static void radixSort(int a[], int n) {

        int max = a[0];

        // Find maximum element
        for (int i = 1; i < n; i++) {
            if (a[i] > max)
                max = a[i];
        }

        // Apply counting sort for every digit
        for (int pos = 1; max / pos > 0; pos *= 10) {
            countingSort(a, n, pos);
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        radixSort(a, n);

        System.out.println("Sorted Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
} 
