package cn.smile.tree;

import java.util.LinkedList;

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


    public static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }
}
