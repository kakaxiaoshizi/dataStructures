package ch03.Queue;

// 循环队列
public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front, tail; // 队首和队尾的索引
    private int size; // 队列元素的个数

    public LoopQueue(int capacity){
        // 牺牲一个单元来区分队空和队满,因此实际容量要+1
        this.data = (E[])new Object[capacity + 1];
        this.front = this.tail = this.size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    // 获取队列的容量
    public int getCapacity(){
        // 牺牲一个单元来区分队空和队满,因此实际容量要-1
        return this.data.length - 1;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    // 判断 front 和 tail 是否相等
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    @Override
    public void enqueue(E e) {

        // 队列满了,扩容为原来的2倍
        // 队满的条件: (tail + 1) % QueueSize == front
        if((this.tail + 1) % this.data.length == this.front){
            resize(2 * this.getCapacity());
        }

        // 在队列的末尾添加元素
        this.data[this.tail] = e;
        // 计算tail的偏移量
        this.tail = (this.tail + 1) % this.data.length;
        // 队列的元素个数+1
        this.size++;
    }

    // 扩容
    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < this.size; i++){
            newData[i] = data[(i + this.front) % this.data.length];
        }
        this.data = newData;
        this.front = 0; // front重新置为0
        this.tail = this.size; // tail等于队列元素的个数
    }

    @Override
    public E dequeue() {

        if(this.isEmpty()){
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }

        E e = this.data[this.front];
        this.front = (this.front + 1) % this.data.length;
        this.size--;

        // this.getCapacity() / 2 != 0 判断队列的元素是否为1
        // 如果队列的size是原来容量的1/4, 并且队列元素个数不为1, 缩容为原来的1/2
        if(this.size == this.getCapacity() / 4 && this.getCapacity() / 2 != 0){
            resize(this.getCapacity() / 2);
        }

        return e;
    }

    @Override
    public E getFront(){

        if(this.isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }

        return this.data[this.front];
    }

    @Override
    public String toString(){

        StringBuilder str = new StringBuilder();
        str.append(String.format("Queue: size = %d, capacity = %d\n", this.size, this.getCapacity()));

        str.append("front [");
        // int i = front; i != tail; 判断队列是否为空
        // i = (i + 1) % data.length; i != tail; 队列的下一个元素的索引 != tail,判断队列是否满了
        for(int i = this.front; i != this.tail; i = (i + 1) % this.data.length){
            str.append(data[i]);
            // 队首的下一个索引 不等于 队尾, 队列没满,继续...
            if((i + 1) % this.data.length != this.tail){
                str.append(", ");
            }
        }
        str.append("] tail");

        return str.toString();
    }
}
