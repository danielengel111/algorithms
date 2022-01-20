enum Color{white, grey, black}
public class GraphNode
{
    public DoubleLinkedNode OutNeighbors;
    public DoubleLinkedNode InNeighbors;
    private int outDegree;
    private int inDegree;
    private DoubleLinkedNode refToSelf = null;
    public int key;
    private RootedTreeNode parent = null;
    private int d = 0;
    private int f =0;
    private Color color = Color.white;

    public RootedTreeNode getParent() {
        return parent;
    }

    public void setParent(RootedTreeNode parent) {
        this.parent = parent;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

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

    public DoubleLinkedNode addOutNeighbor(GraphNode node)
    {
        if(this.OutNeighbors == null)
        {
            this.OutNeighbors = new DoubleLinkedNode(null, null, node);
        }
        else
        {
            this.OutNeighbors = new DoubleLinkedNode(null, this.OutNeighbors, node);
        }
        outDegree++;
        return OutNeighbors;
    }
    public DoubleLinkedNode addInNeighbor(GraphNode node)
    {
        if(this.InNeighbors == null)
        {
            this.InNeighbors = new DoubleLinkedNode(null, null, node);
        }
        else
        {
            this.InNeighbors = new DoubleLinkedNode(null, this.InNeighbors, node);
        }
        inDegree++;
        return InNeighbors;
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
    public void decreaseInDegree(){
        inDegree--;
    }
    public void decreaseOutDegree(){
        outDegree--;
    }
}
