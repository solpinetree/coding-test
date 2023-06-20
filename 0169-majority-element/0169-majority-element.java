class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(map.get(num) != null){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        
        int max = 0;
        Integer max_value = null;
        
        for(int key : map.keySet()){
            int value = map.get(key);
            if(value>max){
                max = value;
                max_value = key;
            }
        }
        
        return max_value;
    }
}