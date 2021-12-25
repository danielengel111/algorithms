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

}
