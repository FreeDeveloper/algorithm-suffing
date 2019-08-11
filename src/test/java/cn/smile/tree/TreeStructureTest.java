package cn.smile.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class TreeStructureTest {

    //二叉树遍历
    @Test
    public void traveralTest(){
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer []{3,2,9,null,null,10,null,null,8,null,4}));
        TreeStructure.TreeNode node = TreeStructure.createTree(inputList);
        System.out.println("前序遍历：");
        TreeStructure.preOrderTraveral(node);
        System.out.println("栈前序遍历：");
        TreeStructure.preOrderTraveralWithStack(node);

        System.out.println("中序遍历：");
        TreeStructure.inOrderTraveral(node);

        System.out.println("后序遍历：");
        TreeStructure.postOrderTraveral(node);

        System.out.println("层序遍历：");
        TreeStructure.levelOrderTraveral(node);
    }
}


