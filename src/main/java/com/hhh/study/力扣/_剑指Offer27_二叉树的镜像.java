package com.hhh.study.力扣;

import java.util.Stack;

public class _剑指Offer27_二叉树的镜像 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }


    public static void main(String[] args) {

    }


    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop.left != null){
                stack.push(pop.left);
            }
            if (pop.right != null){
                stack.push(pop.right);
            }
            TreeNode left = pop.left;
            pop.left = pop.right;
            pop.right = left;

        }
        return root;

    }
}
