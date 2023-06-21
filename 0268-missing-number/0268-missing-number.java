class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int[] arr = new int[size+1];
        
        for(int num: nums){
            arr[num]++;
        }
        
        for(int i = 0; i < size+1 ; i++){
            if(arr[i]==0){
                return i;
            }
        }
        
        return size;
    }
}