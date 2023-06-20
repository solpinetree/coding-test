class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = 1;
        Integer max_value = null;
        
        for(int num : nums){
            Integer temp = map.get(num);
            int curCnt = temp == null ? 1 : temp + 1;
            map.put(num, curCnt);
            
            if(curCnt >= max){
                max = curCnt;
                max_value = num;
                
                if(max > nums.length/2){
                    return max_value;
                }
            }
        }
        
        return max_value;
    }
}