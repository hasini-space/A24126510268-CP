import java.util.*;

public class Main {

    static int ternarySearch(int a[], int key) {

        int left = 0;
        int right = a.length - 1;

        while (left <= right) {

            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (a[mid1] == key)
                return mid1;

            if (a[mid2] == key)
                return mid2;

            if (key < a[mid1]) {
                right = mid1 - 1;
            }
            else if (key > a[mid2]) {
                left = mid2 + 1;
            }
            else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter sorted elements:");

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        int result = ternarySearch(a, key);

        if (result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");
    }
}
