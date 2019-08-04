package cn.smile.stackAndQueue;

public class LinkedListQueue {

    private Node head;
    private Node tail;

    public boolean enQueue(String a){
        Node newNode = new Node(a);

        if(head == null){
            head = newNode;
            tail = newNode;
            return true;
        }

        tail.next = newNode;
        tail = newNode;

        return true;
    }

    public Node deQueue(){

        if(head == null){
            return null;
        }

        Node temp = head;
        head = head.next;

        if(head == null){
            tail = null;
        }

        temp.next = null;
        return temp;
    }



    private class Node{
        String data;
        Node next;

        public Node(String a){
            this.data = a;
        }
    }
}
