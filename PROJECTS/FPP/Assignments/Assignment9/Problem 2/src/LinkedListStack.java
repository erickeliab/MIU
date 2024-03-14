public class LinkedListStack {

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public LinkedListStack() {
        this.top = null;
    }

    public void push(Object item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Object item = top.data;
        top = top.next;
        return item;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(45);
        System.out.println(stack.peek());

        stack.push(42);
        stack.push(-3);
        stack.push(17);
        System.out.println(stack.pop());
    }
}
