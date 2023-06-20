class Solution {
    public boolean containsDuplicate(int[] nums) {
     
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(map.containsKey(num)){
                return true;
            }else{
                map.put(num, num);
            }
        }
        
        return false;
    }
}