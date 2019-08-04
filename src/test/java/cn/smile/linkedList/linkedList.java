package cn.smile.linkedList;

import org.junit.Test;

public class linkedList {

    @Test
    public void linkedListTest(){
        LinkedListStructure linkedListStructure = new LinkedListStructure();
        linkedListStructure.insert(3,0);
        linkedListStructure.insert(7,1);
        linkedListStructure.insert(9,2);
        linkedListStructure.insert(5,3);
        linkedListStructure.insert(6,1);
        linkedListStructure.output();
        System.out.println("--------------------------------------------------");
        linkedListStructure.remove(0);
        linkedListStructure.output();
    }

    /**
     * 是否是回文字符串检测
     * 比如字符串abcdefedcba
     *
     * */
    @Test
    public void palindromeTest(){
        LinkedListStringStructure linkedListStructure = new LinkedListStringStructure("abcdefedcba");
        System.out.println(linkedListStructure.isPalindrome());

    }

    @Test
    public void reverseLinkTest(){
        LinkedListStringStructure linkedListStructure = new LinkedListStringStructure("abcdef");
        linkedListStructure.reverseLink();
    }

    /**
     * 两个有序集合的合并
     * */
    @Test
    public void mergeTwoLink(){
        LinkedListStringStructure linkedListStructure1 = new LinkedListStringStructure("abcdef");
        LinkedListStringStructure linkedListStructure2 = new LinkedListStringStructure("acdgh");
        LinkedListStringStructure.output(LinkedListStringStructure.mergeTwoLists(linkedListStructure1.head,linkedListStructure2.head));
    }

}
