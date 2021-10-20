package com.hhh.study.力扣;

import java.util.LinkedList;
import java.util.Queue;

public class _222_完全二叉树的节点个数 {


    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public static void main(String[] args) {

    }

    public static int countNodes(TreeNode root) {
        int size = 0;
        if (root == null){
            return size;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        size++;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!=null){
                queue.add(node.left);
                size++;
            }else {
                return size;
            }

            if (node.right!=null){
                queue.add(node.right);
                size++;
            }else {
                return size;
            }
        }
        return size;
    }

}
