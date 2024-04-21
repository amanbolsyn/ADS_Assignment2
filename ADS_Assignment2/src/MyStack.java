public class MyStack<T>{
private MyArrayList<T> stack = new MyArrayList<>();


//Checks if stack is empty
public boolean isEmpty(){

    return stack.size() == 0;
}
//Returns stack size
public int size() {

    return stack.size();
}

// pushes or add new element
public T push(T newItem) {
    stack.addLast(newItem);
    return newItem;
}

//Returns the last stack element
public T peek(){
    //If stack is empty returns null
    if (isEmpty()) {
        return null;
    }

    return stack.get(stack.size() - 1 );
}

// Removes the head of the linked list
public T pop(){

    //If stack is empty returns null
    if (isEmpty()) {
        return null;
    }

    //Get topmost item
    T removingItem = peek();
    //Remove topmost item
    stack.removeLast();
    //Return just removed item
    return removingItem;
}

}