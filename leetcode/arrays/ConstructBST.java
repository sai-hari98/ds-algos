package arrays;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 * Problem Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class ConstructBST {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    public static void main(String[] args){
        new ConstructBST().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }

    public TreeNode createBST(int[] nums, int left, int right){
        /* The recursion ending condition is this.
        If the left becomes greater than right i.e start becomes greater than end, the tree construction ends there.*/
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        /* Taking the middle element of the array since it will be the element to balance the BST */
        TreeNode root = new TreeNode(nums[mid]);
        /* Using recursion to build the left subtree.
        The algo will again choose the center and the left right elements with the left subarray */
        root.left = createBST(nums, left, mid-1);
        /* Same again, but with right sub array */
        root.right = createBST(nums, mid+1, right);
        return root;
    }
}
