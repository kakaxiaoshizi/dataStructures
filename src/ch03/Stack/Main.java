package ch03.Stack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // testStack(new ArrayStack<Integer>());
        // testStack(new LinkedListStack<Integer>());

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStackPerformance(arrayStack, opCount);
        System.out.println("ArrayStack:" + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStackPerformance(linkedListStack, opCount);
        System.out.println("LinkedListStack:" + time2 + " s");
        // LinkedListStack 包含更多的new Node()操作

        System.out.println("ArrayStack and LinkedListStack difference:" + Math.round(time1 / time2));
    }

    private static void testStack(Stack stack){

        for(int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
    }

    // 测试ArrayStack和LinkedListStack的性能,单位秒
    private static double testStackPerformance(Stack stack, int opCount){

        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0; i < opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));

        for(int i =0 ; i < opCount; i++)
            stack.pop();

        long endTime = System.nanoTime();

        // 毫微秒转成秒,除以10的9次方
        return (endTime - startTime) / 1000000000.0;
    }
}
