package ch03.Queue;

// 链表队列
public class LinkedListQueue<E> implements Queue<E> {

    // 节点类
    private class Node{

        public E e; // 元素
        public Node next; // 指向下一个元素的引用

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return this.e.toString();
        }
    }

    // 头元素和尾元素
    private Node head, tail;
    // 队列的元素个数
    private int size;

    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    // 在队列尾部插入元素
    public void enqueue(E e) {

        // 如果tail为空,说明队列为空
        if(this.tail == null){
            this.tail = new Node(e);
            // 头同时指向Node
            this.head = this.tail;
        }else{
            // 队列不为空,tail.next指向Node
            this.tail.next = new Node(e);
            // tail指针指向tail.next(也就是Node)
            this.tail = this.tail.next;
        }
        this.size++;
    }

    @Override
    // 在队列头部删除元素
    public E dequeue() {

        if(this.isEmpty()){
            throw new IllegalArgumentException("can not dequeue from empty queue");
        }

        // 待删除的元素node
        Node node = this.head;
        // head 重新指向 被删除元素的下一个元素
        this.head = node.next;
        node.next = null; // node.next设置为null,等待垃圾回收

        // 如果队列只有一个元素,那么tail也要设置为null.
        if(this.head == null){
            this.tail = null;
        }
        this.size--;
        return node.e;
    }

    @Override
    public E getFront() {

        if(this.isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }

        return this.head.e;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("Queue: ");
        str.append("front [");
        Node cur = head;
        while(cur != null){
            str.append(cur + " -> ");
            cur = cur.next;
        }
        str.append("NULL ] tail");

        return str.toString();
    }
}
