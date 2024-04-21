
public class Main {
    public static void main(String[] args) {

        MyStack<String> firstStack = new MyStack<>();
        firstStack.push("First Stack");
        firstStack.push("Second Stack");


       MyMinHeap<String> firstMinHeap = new MyMinHeap<>();
        firstMinHeap.insert("43");
        firstMinHeap.insert("40");

        System.out.println(firstMinHeap.getMin());

        MyQueue<String> firstQueue= new MyQueue<>();
        firstQueue.enqueue("First Stack");
        firstQueue.enqueue("Second Stack");

        }
    }
