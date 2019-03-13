package ch02.Array;

public class Main {


    public static void main(String[] args) {

        Array<Integer> arr = new Array<Integer>(10);
        for(int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.addLast(100);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }

    // 数组类测试
    public static void main02(String[] args){

        Array<Integer> arr = new Array<Integer>(20);
        for(int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        System.out.println(arr.getSize());
        System.out.println(arr.getCapacity());

        arr.add(4, 40);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        System.out.println(arr.get(3));

        arr.set(4,4000);
        System.out.println(arr);

        System.out.println(arr.remove(3));
        System.out.println(arr);

        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr);

        arr.removeElement(4000);
        System.out.println(arr);
    }

    public static void main01(String[] args) {

        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i * 10;
        }
        for(int val : arr){
            System.out.println(val);
        }
    }
}
