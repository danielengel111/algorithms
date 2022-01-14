public class LinkedList<T> {
    private LinkedList<T> prev;
    private LinkedList<T> next;
    private T value;
    public LinkedList(LinkedList<T> prev, LinkedList<T> next, T value){
        this.prev=prev;
        this.next=next;
        this.value=value;
    }

    public LinkedList<T> getPrev() {
        return prev;
    }

    public void setPrev(LinkedList<T> prev) {
        this.prev = prev;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
