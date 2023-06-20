class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            Integer idx = map.get(nums[i]);
            
            if(idx != null){
                if(i-idx <= k)
                    return true;
            }
                
            map.put(nums[i], i);
        }
        
        return false;
    }
}