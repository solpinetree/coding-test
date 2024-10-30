class Solution {
    public int getSum(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        return result;
    }
    
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length) {
            return 1;
        } else if(arr1.length < arr2.length) {
            return -1;
        } else {
            int arr1_sum = getSum(arr1);
            int arr2_sum = getSum(arr2);
            
            if(arr1_sum > arr2_sum){
                return 1;
            } else if(arr1_sum < arr2_sum) {
                return -1;
            } 
        }
        
        return 0;
    }
}