package ch04.LinkedList;

public class LinkedList<E> {

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

    private Node dummyHead; // 虚拟头结点
    private int size;  // 链表的大小

    public LinkedList(){
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    // 在链表的index位置添加元素(练习用)
    public void add(int index, E e){

        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("add fail, illegal index");
        }

        Node prev = dummyHead; // 初始指向dummyHead
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        // for循环结束后,prev就是节点e的前一个节点

        Node node = new Node(e);
        node.next = prev.next; // node.next 指向 prev.next
        prev.next = node;      // prev.next 指向 node

        this.size++;
    }

    // 在链表头部添加元素
    public void addFirst(E e){
        this.add(0, e);
    }

    // 在链表尾部添加元素
    public void addLast(E e){
        this.add(this.size, e);
    }

    // 获取链表中索引为index的元素(练习用)
    public E get(int index){

        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("get fail, illegal index");
        }

        // cur默认为虚拟头结点的next,也就是索引为0的元素
        Node cur = this.dummyHead.next;

        // 使用for循环遍历找到索引为index的元素
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }

        return cur.e;
    }

    // 获取链表的第一个元素
    public E getFirst(){
        return this.get(0);
    }

    // 获取链表的最后一个元素
    public E getLast(){
        return this.get(this.size - 1);
    }

    // 设置链表索引为index的元素的值(练习用)
    public void set(int index, E e){

        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("set fail, illegal index");
        }

        Node cur = this.dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    // 判断链表是否包含元素e
    public boolean contains(E e){

        Node cur = this.dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            // 继续查找链表的下一个元素
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除索引为index的元素(练习用)
    public E remove(int index){

        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("remove fail, illegal index");
        }

        Node prev = this.dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        // for循环结束后,prev就是待删除元素的前一个元素

        // prev.next就是待删除的元素
        Node delNode = prev.next;
        // prev.next 重新指向 待删除元素的next
        prev.next = delNode.next;
        // delNode.next设置为null,等待垃圾回收
        delNode.next = null;

        // 待删除元素前一个元素的next 等于 待删除元素的next
        // prev.next = prev.next.next

        this.size--;
        return delNode.e;
    }

    // 删除链表的第一个元素
    public E removeFirst(){
        return this.remove(0);
    }

    // 删除链表的最后一个元素
    public E removeLast(){
        return this.remove(this.size - 1);
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        for(Node cur = this.dummyHead.next; cur != null; cur = cur.next){
            str.append(cur + " -> ");
        }
        str.append("NULL");

        return str.toString();
    }

    // 从链表中删除元素
    public void removeElement(E e){

        Node prev = this.dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        // 存在两种情况:
        // 1. while循环结束后,prev就是待删除元素的前一个元素
        // 2. 链表里没有待删除的元素(需要判断prev.next是否为null)

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            this.size--;
        }
    }
}
