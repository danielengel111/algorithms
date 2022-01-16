public class Queue<T> {
    private LinkedList<T> first=null;
    private LinkedList<T> last=null;
    public void insert(T x){
        LinkedList<T> temp = new LinkedList<>(null, null, x);
        if(first==null)
            first=temp;
        else {
            temp.setPrev(last);
            last.setNext(temp);
        }
        last = temp;
    }
    public T remove(){
        if(first == null)
            return null;
        T x = first.getValue();
        first = first.getNext();
        if(first==null)
            last=null;
        return x;
    }
    public T head(){
        if(first==null)
            return null;
        return first.getValue();
    }
    public boolean isEmpty(){
        return first == null;
    }
}
