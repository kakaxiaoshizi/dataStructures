package ch03.Stack;

import ch02.Array.Array;

// 数组栈
public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack(int capacity){
        this.array = new Array<>(capacity);
    }

    public ArrayStack(){
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public void push(E e) {
        this.array.addLast(e);
    }

    @Override
    // 弹出栈最后一个元素
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    // 获取栈最后一个元素
    public E peek() {
        return this.array.getLast();
    }

    // 获取栈的容量
    public int getCapacity(){
        return this.array.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("Stack: ");
        str.append('[');
        for(int i = 0; i < this.getSize(); i++){
            str.append(this.array.get(i));
            if(i != this.getSize() - 1){
               str.append(", ");
            }
        }
        str.append("] top");

        return str.toString();
    }
}
