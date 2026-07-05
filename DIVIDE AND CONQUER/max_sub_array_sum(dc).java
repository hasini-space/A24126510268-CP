//O(nlogn)
class SubarrayDivideAndConquer {

    
    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    
    public int maxcrosssubarray(int arr[], int left, int mid, int right) {
               int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

               int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        
        return leftSum + rightSum;
    }

   
    public int maxsubarray(int arr[], int left, int right) {
                if (left == right) {
            return arr[left]; 
        }

       
        int mid = (left + right) / 2;

        
        int leftmax = maxsubarray(arr, left, mid);
        int rightmax = maxsubarray(arr, mid + 1, right);
        int crossmax = maxcrosssubarray(arr, left, mid, right);

                return max(leftmax, rightmax, crossmax);
    }

    public static void main(String args[]) {
        SubarrayDivideAndConquer solver = new SubarrayDivideAndConquer();
        
                int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        
        int max_sum = solver.maxsubarray(arr, 0, n - 1);
        System.out.println("Maximum Subarray Sum is: " + max_sum);
    }
}