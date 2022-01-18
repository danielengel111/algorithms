public class GraphNode
{
    public DoubleLinkedNode OutNeighbors;
    public DoubleLinkedNode InNeighbors;
    private int outDegree;
    private int inDegree;
    private DoubleLinkedNode refToSelf = null;
    public int key;

    public GraphNode(int key)
    {
        this.OutNeighbors = null;
        this.InNeighbors = null;
        outDegree = 0;
        inDegree = 0;
        this.key = key;
    }

    public DoubleLinkedNode getRefToSelf() {
        return refToSelf;
    }

    public void setRefToSelf(DoubleLinkedNode refToSelf) {
        this.refToSelf = refToSelf;
    }

    public int getKey()
    {
        return key;
    }

    public void addOutNeighbor(GraphNode node)
    {
        if(this.OutNeighbors == null)
        {
            this.OutNeighbors = new DoubleLinkedNode(null, null, node);
        }
        else
        {
            this.OutNeighbors.son = new DoubleLinkedNode(this.OutNeighbors, null, node);
        }
        outDegree++;
    }
    public void addInNeighbor(GraphNode node)
    {
        if(this.InNeighbors == null)
        {
            this.InNeighbors = new DoubleLinkedNode(null, null, node);
        }
        else
        {
            this.InNeighbors.son = new DoubleLinkedNode(this.InNeighbors, null, node);
        }
        inDegree++;
    }


    public int getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(int outDegree) {
        this.outDegree = outDegree;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }
}
