//On^2
class Sub {
    
       public int maxSubarraySum(int arr[], int n) {
        
        int max = Integer.MIN_VALUE; 
        
        for (int i = 0; i < n; i++) {
            int sum = 0; // Reset sum for the new subarray starting at index i
            
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                
                               if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Sub obj = new Sub();
              int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        
        int result = obj.maxSubarraySum(arr, n);
        System.out.println("Maximum Subarray Sum is: " + result);
    }
}
