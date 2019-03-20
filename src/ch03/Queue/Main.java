package ch03.Queue;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // testQueue(new ArrayQueue<Integer>());
        // testQueue(new LoopQueue<Integer>());
        //testQueue(new LinkedListQueue<Integer>());

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueuePerformance(arrayQueue, opCount);
        System.out.println("ArrayQueue:" + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueuePerformance(loopQueue, opCount);
        System.out.println("LoopQueue:" + time2 + " s");

        System.out.println("ArrayQueue and LoopQueue difference:" + Math.round(time1 / time2));

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueuePerformance(linkedListQueue, opCount);
        System.out.println("LinkedListQueue:" + time3 + " s");
    }

    private static void testQueue(Queue queue){

        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    // 测试ArrayQueue和LoopQueue的性能,单位秒
    private static double testQueuePerformance(Queue<Integer> queue, int opCount){

        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0; i < opCount; i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));

        for(int i =0 ; i < opCount; i++)
            queue.dequeue();

        long endTime = System.nanoTime();

        // 毫微秒转成秒,除以10的9次方
        return (endTime - startTime) / 1000000000.0;
    }

}
