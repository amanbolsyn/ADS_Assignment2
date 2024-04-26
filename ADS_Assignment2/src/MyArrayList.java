import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 15;
    private T[] array;


    // Creating MyArrayList array
    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }


    public MyArrayList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        array = (T[]) new Object[capacity];
        size = 0;
    }

    // Returns the size of the array
    @Override
    public int size() {
        return size;
    }

    private void isEmpty() {
        if (size == 0) {

            throw new NoSuchElementException("List is empty");
        }
    }


    // Checks if array can be populated or not
    public void checkForCapacity(){
        if(size == array.length){

            T[] newArray = (T[]) new Object[size + 3];
            for(int i = 0; i<size; i++){

                newArray[i] = (T) array[i];
            }
            array = newArray;
        }
    }

    // Adds new element to an array
    @Override

    public void add(T item){
        checkForCapacity();
        array[size] = item;
        size++;
    }

    //Adds new element at the end of an array
    @Override
    public void addLast(T item){

        checkForCapacity();
        array[size] = item;
        size++;

    }

    // Adds new element at 0 index and shifts all the previous elements to the right
    @Override
    public void addFirst(T item){
        checkForCapacity();

        for( int i = size; i > 0; i--){
            array[i] = array[i-1];
        }
        array[0] = item;
        size++;


    }

    //checks if index is invalid
    private void Exception(int index){
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
    }



    @Override
    public void add(int index, T item){
        Exception(index);
        checkForCapacity();
        for(int i = size; i>index; i--){
            array[i] = array[i-1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void remove(int index){
        Exception(index);
        for( int i = index; i<size-1; i++){
            array[i] = array[i+1];
        }
        array[size - 1] = null; // prevents the memory leak
        size--;
    }

    //Removes first item of an array and shift all other elements to the left by creating new array
    @Override
    public void removeFirst() {
        isEmpty();

        for (int i = 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        array[--size] = null;
    }

    // Converts last element to null
    @Override
    public void removeLast() {
        isEmpty();
        array[--size] = null;
    }

    @Override
    public Object set(int index, T item){
        Exception(index);
        return array[index] = item;
    }

    //Get item by its index
    @Override
    public T get(int index){
        Exception(index);
        return (T) array[index];
    }

    //Get the first element of an array
    @Override
    public T getFirst(){
        isEmpty();
        return (T) array[0];
    }

    //Get the last element of an array
    @Override
    public T getLast(){
        isEmpty();
        return (T) array[size-1];
    }


    //Clears an array and changes array size to 0 and all elements are null
    @Override
    public void clear(){
        for( int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean exists(Object object) {

        for (int i = 0; i < size; i++) {
            if (array[i] == null && object == null) {

                return true;
            } else if (array[i] != null && array[i].equals(object)) {

                return true;
            }
        }
        return false;
    }
    @Override
    public Object[] toArray(){

        Object[] result = new Object[size];

        for( int i = 0; i< size; i++){
            result[i] = array[i];
        }
        return result;
    }

    //Create Iterator
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index = 0;

            // Is there next element
            @Override
            public boolean hasNext() {
                return index < size;
            }


            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) array[index++];
            }
        };
    }



    @Override
    public void sort() {
        T temp;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (((Comparable<T>) array[j]).compareTo(array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    @Override
    public int indexOf(Object object){
        if( object == null){
            for (int i = 0; i < size; i++)
            {
                if (array[i] == null)
                    return i;
            }
        }else
        {
            for (int i = 0; i < size; i++)
            {
                if(object.equals(array[i]))
                    return i;
            }
        }
        return -1;
    }

    // last index of array
    @Override
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }






}
