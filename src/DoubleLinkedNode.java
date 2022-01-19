public class DoubleLinkedNode
{
    public DoubleLinkedNode parent;
    public DoubleLinkedNode son;
    public GraphNode value;

    public DoubleLinkedNode(DoubleLinkedNode parent, DoubleLinkedNode son, GraphNode value)
    {
        this.parent = parent;
        this.son = son;
        this.value = value;
    }
    public void delete(){
        if(this.parent!=null)
            this.parent.son = this.son;
        if(this.son!=null)
            this.son.parent=this.parent;
    }
    public boolean isSingle(){
        return parent==null && son==null;
    }
}
