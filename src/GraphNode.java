public class GraphNode
{
    public DoubleLinkedNode OutNeighbors;
    public DoubleLinkedNode InNeighbors;
    public int key;

    public GraphNode()
    {
        this.OutNeighbors = null;
        this.InNeighbors = null;
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
    }


    public int getOutDegree()
    {
        DoubleLinkedNode temp = OutNeighbors;
        int count = 0;
        while(temp != null)
        {
            temp = temp.son;
            count++;
        }
        return count;
    }

    public int getInDegree()
    {
        DoubleLinkedNode temp = InNeighbors;
        int count = 0;
        while(temp != null)
        {
            temp = temp.son;
            count++;
        }
        return count;
    }
}
