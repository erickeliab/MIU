//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayQueueImpl queue = new ArrayQueueImpl();
        System.out.println("Enqueuing elements...");
        for (int i = 1; i <= 15; i++) {
            queue.enqueue(i);
            System.out.println("Enqueued: " + i);
        }
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeuing elements...");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
        System.out.println("Peek: " + queue.peek());
    }
}