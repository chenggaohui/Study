package com.hhh.study.力扣;

import java.util.Stack;

public class _129_求根到叶子节点数字之和 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));

    }
    public static int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null){
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();

        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!(stack1.isEmpty() && stack2.isEmpty())){

            while (!stack1.isEmpty()){

                TreeNode pop = stack1.pop();
                if(pop.right == null && pop.left == null){
                    result += pop.val;
                    continue;
                }
                if (pop.right != null){
                    pop.right.val += pop.val * 10;
                    stack2.push(pop.right);
                }
                if (pop.left != null){
                    pop.left.val += pop.val * 10;
                    stack2.push(pop.left);
                }


            }

            while (!stack2.isEmpty()){
                TreeNode pop = stack2.pop();
                if(pop.right == null && pop.left == null){
                    result += pop.val;
                    continue;
                }
                if (pop.right != null){
                    pop.right.val += pop.val * 10;
                    stack1.push(pop.right);
                }
                if (pop.left != null){
                    pop.left.val += pop.val * 10;
                    stack1.push(pop.left);
                }
            }
        }
        return result;

    }

}
