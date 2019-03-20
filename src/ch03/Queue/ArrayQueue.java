package ch03.Queue;

import ch02.Array.Array;

// 数组队列
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    public ArrayQueue(int capacity){
        this.array = new Array<>(capacity);
    }

    public ArrayQueue(){
        this.array = new Array<>();
    }

    @Override
    // 入队,添加到队首
    public void enqueue(E e) {
        this.array.addLast(e);
    }

    @Override
    // 队首元素出队
    public E dequeue() {
        return this.array.removeFirst();
    }

    @Override
    // 获取队首的元素
    public E getFront() {
        return this.array.getFirst();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public int getCapacity(){
        return this.array.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("Queue: ");
        str.append("front [");
        for(int i = 0; i < this.getSize(); i++){
            str.append(this.array.get(i));
            if(i != this.getSize() - 1){
                str.append(", ");
            }
        }
        str.append("] tail");

        return str.toString();
    }
}
