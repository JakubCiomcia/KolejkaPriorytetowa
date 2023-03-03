package KolejkaPriorytetowa.abc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CustomQueue<T> {

    private final Deque<T> queue;
    private final Deque<T> queueVip;
    private final Map<String, Integer> counterMap = new HashMap<>();

    public CustomQueue(Deque<T> queue, Deque<T> queueVip) {
        this.queue = queue;
        this.queueVip = queueVip;
    }


    public void welcomeVip(T item) {
        boolean isAdded = queue.offer(item);
        System.out.printf("%s came to the vip queue: %s%n", item, isAdded);
        printTotalQueue();
    }

    public void welcome(T item) {
        boolean isAdded = queue.offer(item);
        System.out.printf("%s came to the queue: %s%n", item, isAdded);
        printTotalQueue();
    }


    Integer getAndIncrementCounter(String personKey) {
        Integer tempCounter = counterMap.getOrDefault(personKey, 0);
        counterMap.put(personKey, ++tempCounter);
        return tempCounter;
    }

    public void enter() {
        if (queueVip.isEmpty()) {
            System.out.println("No items in VIP the queue.");
            return;
        } else {
            handleEnterByQueue(queueVip);
        }
        if (queue.isEmpty()) {
            System.out.println("No items in the queue.");
            return;
        }
        handleEnterByQueue(queue);
    }

    private void handleEnterByQueue(Deque<T> queue) {
        T itemEntered = queue.poll();
        System.out.printf("Processing queue: %s arrived at the store %n", itemEntered);
        printTotalQueue();
        System.out.println();
    }

    public void leave(T item) {
        if (queueVip.contains(item)) {
            queueVip.remove(item);
            System.out.println(item + " is in the queue");
            printTotalQueue();
        }
        if (queue.contains(item)) {
            queue.remove(item);
            System.out.println(item + " is in the queue");
            printTotalQueue();
        } else {
            System.out.println(item + " not in the queue");
            printTotalQueue();
        }
    }

    private void printTotalQueue() {
        ArrayList<T> totalList = new ArrayList<>(queueVip);
        totalList.addAll(queue);
        System.out.println(totalList);
        System.out.println();
    }
}
