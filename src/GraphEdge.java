public class GraphEdge
{
    private GraphNode from;
    private GraphNode to;
    private DoubleLinkedNode fromReference=null;
    private DoubleLinkedNode toReference=null;
    public GraphEdge(GraphNode from, GraphNode to){
        this.from = from;
        this.to=to;
    }

    public GraphNode getFrom() {
        return from;
    }

    public void setFrom(GraphNode from) {
        this.from = from;
    }

    public GraphNode getTo() {
        return to;
    }

    public void setTo(GraphNode to) {
        this.to = to;
    }

    public DoubleLinkedNode getFromReference() {
        return fromReference;
    }

    public void setFromReference(DoubleLinkedNode fromReference) {
        this.fromReference = fromReference;
    }

    public DoubleLinkedNode getToReference() {
        return toReference;
    }

    public void setToReference(DoubleLinkedNode toReference) {
        this.toReference = toReference;
    }
}
