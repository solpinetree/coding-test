class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        
        for(int num : nums) {
            map.put(num, num);
        }
        
        for(int num : nums) {
            int cnt = 1;
            if(map.get(num-1) == null){
                while(map.get(num+1) != null){
                    cnt++;
                    num++;
                }
            }
            
            longest = Math.max(longest, cnt);
        }
        
        return longest;
    }
}