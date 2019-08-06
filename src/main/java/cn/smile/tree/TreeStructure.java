package cn.smile.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeStructure {

    public static TreeNode createTree(LinkedList<Integer> inputList){
        TreeNode node = null;

        if(inputList == null || inputList.isEmpty()){
            return null;
        }

        Integer data = inputList.removeFirst();
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = createTree(inputList);
            node.rightChild = createTree(inputList);
        }
        return node;
    }

    public static void preOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }

        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    public static void inOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }

        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    public static void postOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }

        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    public static void preOrderTraveralWithStack(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while(treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶的节点，访问节点的右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void levelOrderTraveral(TreeNode root){
        //使用一个队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //根节点入队
        queue.offer(root);

        //队列不为空的情况下
        while(!queue.isEmpty()){
            //取出队列中的节点
            TreeNode node = queue.poll();
            //访问队列的节点
            System.out.println(node.data);
            //当前节点有左孩子节点，则入队
            if(node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if(node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }

    public static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }
}
