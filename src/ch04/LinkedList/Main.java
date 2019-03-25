package ch04.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < 5; i++){
            list.addFirst(i);
            System.out.println(list);
        }

        System.out.println(list.contains(4));
        list.set(3, 300);
        System.out.println(list);

        System.out.println(list.get(2));

        list.addFirst(100);
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.removeElement(3);
        list.removeElement(100);
        System.out.println(list);
    }
}
