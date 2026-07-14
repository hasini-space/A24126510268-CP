import java.util.Arrays;

public class CountingSort {

    public static void sorty(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Nothing to sort
        }

        
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        
        int range = max - min + 1;
        int[] count = new int[range];
        int[] b = new int[arr.length]; // Output array

        
        for (int num : arr) {
            count[num - min]++;
        }

        
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentVal = arr[i];
            int countIndex = currentVal - min;
            b[count[countIndex] - 1] = currentVal;
            count[countIndex]--;
        }

        
        System.arraycopy(b, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};
        
        sorty(arr);

        
        for (int i = 0; i < arr.length; i++) {
            System.print(arr[i] + (i < arr.length - 1 ? " " : ""));
        }
        System.out.println();
    }
}
