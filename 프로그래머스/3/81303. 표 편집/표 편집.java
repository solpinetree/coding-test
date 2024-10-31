import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        Node cur = null;
        Node prev = null; 
        ArrayDeque<Node> trash = new ArrayDeque<>();
        
        for (int i = 0;i<n;i++){
            Node node = new Node(prev, null, i);
            if(prev != null) {
                prev.setNext(node);   
            }
            if (i == k) {
                cur = node;
            }
            prev = node;
        }
        
        for (String c : cmd) {
            if (c.split(" ")[0].equals("U")) {
                int x = Integer.parseInt(c.split(" ")[1]);
                
                for (int i=0;i<x;i++){
                    cur = cur.getPrev();
                }
            } else if(c.split(" ")[0].equals("D")) {
                int x = Integer.parseInt(c.split(" ")[1]);
                
                for (int i=0;i<x;i++){
                    cur = cur.getNext();
                }
            } else if(c.equals("C")) {
                trash.push(cur);
                answer[cur.getValue()] = 'X';
                if(cur.getNext() != null) {
                    if(cur.getPrev()!= null) {
                        cur.getPrev().setNext(cur.getNext());    
                    }
                    cur.getNext().setPrev(cur.getPrev());
                    cur = cur.getNext();
                } else {
                    cur.getPrev().setNext(null);
                    cur = cur.getPrev();
                }
            } else { // Z
                Node re = trash.pop();
                answer[re.getValue()] = 'O';
                if(re.getPrev()!=null) {
                    re.getPrev().setNext(re);    
                }
                if(re.getNext()!=null){
                    re.getNext().setPrev(re);    
                }
            }
        }
        
        return new String(answer);
    }
    
    public class Node{
        Node prev;
        int value;
        Node next;
        
        Node(Node prev, Node next, int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
        
        public void setPrev(Node prev) {
            this.prev = prev;
        }
        
        public void setNext(Node next) {
            this.next =next;
        }
        
        public Node getPrev() {
            return prev;
        }
        
        public Node getNext() {
            return next;
        }
        
        public int getValue() {
            return value;
        }
    }
}