package cn.smile.stackAndQueue;

/**
 * 基于数组实现的循环队列
 * 队列满的条件是 tail+1 & n = head
 * */
public class CircleArrayQueue {
    private String [] items;
    int n;
    private int head;
    private int tail;

    public CircleArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    public void enQueue(String element){
        if((tail+1) % n == head){
            System.out.println("当前对了已满");
        }

        items[tail] = element;

        tail = (tail+1) % n;
    }

    public String deQueue(){
        //队列已空
        if(tail == head){
            return  null;
        }

        String temp = items[head];

        head = (head + 1) % n;

        return temp;
    }


}
