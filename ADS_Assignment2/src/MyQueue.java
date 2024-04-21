public class MyQueue<T> {
    private MyLinkedList<T> queue = new MyLinkedList<>();


    //Returns whether the queue is empty
    public boolean isEmpty() {

        return queue.size() == 0;

    }

    //Returns the size of the queue
    public int size() {

        return queue.size();
    }

    // Adds the element at the end of the queue
    public T enqueue(T newItem) {

        queue.addLast(newItem);
        return newItem;

    }

    // Retrieves and deletes the front element of the queue

    public T dequeue(){

        T removingItem = peek();
        queue.removeFirst();
        return removingItem;

    }

    //Returns the last stack element
    public T peek(){
        //If stack is empty returns null
        if(isEmpty()){
            return null;
        }
        return queue.getFirst();
    }

}
