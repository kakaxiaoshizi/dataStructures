package ch02.Array;

public class Array<E> {

    private E[] data;
    private int size; // 数组实际存放元素的个数

    public Array(int capacity){
        this.data = (E[])(new Object[capacity]); // 泛型类实例化
        this.size = 0;
    }

    public Array(){
        this(10);
    }

    // 获取数组中元素个数
    public int getSize(){
        return this.size;
    }

    // 获取数组的容量
    public int getCapacity(){
        return this.data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }

    // 在数组末尾添加元素
    public void addLast(E e){
        this.add(this.size, e);
    }

    // 在数组头部添加元素
    public void addFirst(E e){
        this.add(0, e);
    }

    // 在指定索引index位置添加元素
    public void add(int index, E e){

        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("Illegal index, that should be index < 0 or index > size");
        }

        if(this.size == this.data.length){
            // throw new IllegalArgumentException("Array is full");
            // 数组扩容为原来的两倍
            resize(2 * this.data.length);
        }

        // 移动指定位置的元素
        for(int i = size - 1; i >= index; i--){
            // 把当前索引i位置的元素往后挪1位
            data[i + 1] = data[i];
        }

        this.data[index] = e;
        this.size++;
    }

    // 获取指定index的元素
    public E get(int index){

        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("Illegal index");
        }

        return this.data[index];
    }

    // 设置指定index的元素的值
    public void set(int index, E e){

        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("Illegal index");
        }

        this.data[index] = e;
    }

    // 检测数组中是否包含某个元素
    public boolean contains(E e){

        for(int i = 0; i < this.size; i++){
            if(this.data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查找元素在数组中的索引,如果元素不存在,返回-1
    public int findIndex(E e){

        for(int i = 0; i <= this.size; i++){
            if(this.data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除索引为index的元素,返回删除的元素
    public E remove(int index){

        if(index < 0 || index >= this.size){
            throw new IllegalArgumentException("Illegal index");
        }

        E e = this.data[index];
        // 把当前索引i位置的元素往前挪1位
        for(int i = index; i < this.size - 1; i++){
            data[i] = data[i + 1];
        }
        this.size--;
        this.data[this.size] = null; // loitering objects(游离对象)
        // 设置为null,让垃圾回收机制回收掉

        // 当size为数组长度的1/4 并且 数组的长度不等于1
        // 数组扩容为原来的一半
        if(this.size == this.data.length / 4 && this.data.length / 2 != 0){
            resize(this.data.length / 2);
        }

        return e;
    }

    // 删除数组中的第一个的元素,返回删除的元素
    public E removeFirst(){
        return this.remove(0);
    }

    // 删除数组中的最后一个的元素,返回删除的元素
    public E removeLast(){
        return this.remove(this.size - 1);
    }

    // 从数组中删除元素(如果被删除的元素有多个,只删除第一个),成功返回true,失败返回false
    public boolean removeElement(E e){

        int index = this.findIndex(e);
        if(index != -1){
            this.remove(index);
            return true;
        }
        return false;
    }

    // 两个索引的值交换
    public void swap(int i, int j){

        if(i < 0 || i > this.getSize() || j < 0 || j > this.getSize())
            throw new IllegalArgumentException("index is illegal");

        E e = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = e;
    }

    @Override
    public String toString(){

        StringBuilder str = new StringBuilder();
        str.append(String.format("Array: size = %d, capacity = %d\n", this.size, this.data.length));

        str.append('[');
        for(int i = 0; i < this.size; i++){
            str.append(data[i]);
            if(i != this.size-1){
                str.append(", ");
            }
        }
        str.append(']');

        return str.toString();
    }

    // 扩容
    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity];

        // 把原数组的元素复制到新的数组里
        for(int i = 0; i < this.size; i++){
            newData[i] = this.data[i];
        }

        // 原数组的指针指向新的数组
        this.data = newData;
    }

    // 获取数组第一个元素
    public E getFirst(){
        return this.get(0);
    }

    // 获取数组最后一个元素
    public E getLast(){
        return this.get(this.size - 1);
    }
}
