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
        max_depth = 0
        if root is None:
            return max_depth
        
        q = deque()
        q.append((root,1))
        
        while q:
            cur_node, cur_depth = q.popleft()

            if cur_node.left:
                q.append((cur_node.left, cur_depth+1))
            if cur_node.right:
                q.append((cur_node.right, cur_depth+1))
                
            max_depth = max(cur_depth, max_depth)
          
        return max_depth
        
        
        
        