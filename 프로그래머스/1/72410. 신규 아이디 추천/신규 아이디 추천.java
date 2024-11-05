class Solution {
    // 아이디의 길이 = 3자 이상 15자 이하 {3, 15}
    // [a-z\-\_\.]
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        new_id = new_id.replaceAll("\\.{2,}", ".");
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");
        new_id = new_id.length() == 0 ? "a" : new_id;
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }
        if(new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length() - 1);
            while(new_id.length() != 3) {
                new_id = new_id + c;
            }
        }
        return new_id;
    }
}