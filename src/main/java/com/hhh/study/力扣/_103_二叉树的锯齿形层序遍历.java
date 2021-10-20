package com.hhh.study.力扣;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _103_二叉树的锯齿形层序遍历 {


    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public static void main(String[] args) {

       
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()){

            List<Integer> list = new ArrayList<>();
            while(!stack1.isEmpty()){
                TreeNode pop = stack1.pop();
                list.add(pop.val);
                if (pop.left != null){
                    stack2.push(pop.left);
                }
                if (pop.right != null){
                    stack2.push(pop.right);
                }

            }
            if (list.size() > 0){
                result.add(list);
                list = new ArrayList<>();
            }
            while(!stack2.isEmpty()){
                TreeNode pop = stack2.pop();

                list.add(pop.val);
                if (pop.right != null){
                    stack1.push(pop.right);
                }
                if (pop.left != null){
                    stack1.push(pop.left);
                }
            }
            if (list.size() > 0){
                result.add(list);
                list = new ArrayList<>();
            }

        }
        return result;


    }


}
