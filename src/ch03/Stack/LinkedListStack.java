package ch03.Stack;

import ch04.LinkedList.LinkedList;

// 链表栈
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack(){
        this.linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return this.linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        this.linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return this.linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return this.linkedList.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        string.append("Stack top: ");
        string.append(this.linkedList);
        return string.toString();
    }
}
