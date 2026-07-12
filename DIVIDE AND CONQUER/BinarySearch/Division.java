public class DivisionUsingBinarySearch {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;

        long a = dividend < 0 ? -((long) dividend) : (long) dividend;
        long b = divisor < 0 ? -((long) divisor) : (long) divisor;

        int left = 0, right = (int) a, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * b <= a) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));   
        System.out.println(divide(43, -8));  
        System.out.println(divide(-20, -4)); 
        System.out.println(divide(-15, 2));  
    }
}
