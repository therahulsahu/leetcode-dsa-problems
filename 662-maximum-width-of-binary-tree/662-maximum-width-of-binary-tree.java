/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    TreeNode node;
    int num;
    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int mmin = queue.peek().num;         // to make the id start from zero
            int first = 0, last = 0;
            for(int i = 0; i < size; ++i) {
                int curId = queue.peek().num - mmin;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i == 0) {
                    first = curId;
                }
                if(i == size - 1) {
                    last = curId;
                }
                if(node.left != null) {
                    queue.add(new Pair(node.left, curId * 2 + 1));
                }
                if(node.right != null) {
                    queue.add(new Pair(node.right, curId * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}















