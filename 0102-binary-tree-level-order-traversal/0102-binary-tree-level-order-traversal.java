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
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int qSize = queue.size();
            System.out.println("Queue size : " + qSize);

            for(int i=0;i<qSize;i++){
                TreeNode tn = queue.poll();
                arr.add(tn.val);
                System.out.println("Value : " + tn.val);
                if(tn.left != null) queue.add(tn.left);
                if(tn.right != null) queue.add(tn.right);
            }

            System.out.println("Arr : " + arr);
            result.add(arr);
            System.out.println("result : " + result);
        }

        return result;
    }

}