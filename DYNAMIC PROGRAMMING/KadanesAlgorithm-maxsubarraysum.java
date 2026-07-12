public class KadaneAlgorithm {
    public static int maxSubarraySum(int[] arr) {
        int max = arr[0];     
        int currentMax = arr[0];   

        for (int i = 1; i < arr.length; i++) {
              currentSum += arr[i];

           
            if (currentSum > max) {
                max = currentSum;
            }

            
            if (currentSum < 0) {
                currentSum = 0;
            }
         
   

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubarraySum(arr));
    }
}
