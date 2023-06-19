# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # bfs - level order 문제
        if root is None:
            return 0
        
        q = deque()
        q.append((root,1))
        res = 1
        
        while q:
            cur_node_level = q.popleft()
            cur_node = cur_node_level[0]
            cur_level = cur_node_level[1]
            if cur_node.left:
                q.append((cur_node.left, cur_level+1))
            if cur_node.right:
                q.append((cur_node.right, cur_level+1))
            
            if res < cur_level: 
                res = cur_level
            
        return res
        
        
        
        