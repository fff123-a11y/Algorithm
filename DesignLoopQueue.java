package Zhenkai;

public class DesignLoopQueue {
    private int[] elements;
    private int size = 0, head = 0, tail;

    public void MyCircularDeque(int k) {
        elements = new int[k];
        tail = k - 1;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        elements[head = head == 0 ? elements.length - 1 : head - 1] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        elements[tail = tail == elements.length - 1 ? 0 : tail - 1] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        head = head == elements.length - 1 ? 0 : head + 1;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail = tail == 0 ? elements.length - 1 : tail - 1;
        size--;
        return true;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        return elements[head];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        return elements[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

}
