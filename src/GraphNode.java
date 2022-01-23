enum Color{white, grey, black}
public class GraphNode
{
    public DoubleLinkedNode OutNeighbors;
    public DoubleLinkedNode InNeighbors;
    private int outDegree;
    private int inDegree;
    private DoubleLinkedNode refToDynamicSelf = null;
    public int key;
    private GraphNode parent = null;
    private int d = 0;
    private int f =0;
    private Color color = Color.white;
    private RootedTreeNode refToRootedSelf = null;

    public RootedTreeNode getRefToRootedSelf() {
        return refToRootedSelf;
    }

    public void setRefToRootedSelf(RootedTreeNode refToRootedSelf) {
        this.refToRootedSelf = refToRootedSelf;
    }

    public GraphNode getParent() {
        return parent;
    }

    public void setParent(GraphNode parent) {
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


    public DoubleLinkedNode getRefToDynamicSelf() {
        return refToDynamicSelf;
    }

    public void setRefToDynamicSelf(DoubleLinkedNode refToDynamicSelf) {
        this.refToDynamicSelf = refToDynamicSelf;
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
            DoubleLinkedNode temp = new DoubleLinkedNode(null, this.OutNeighbors, node);
            this.OutNeighbors.parent = temp;
            this.OutNeighbors = temp;
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
            DoubleLinkedNode temp = new DoubleLinkedNode(null, this.InNeighbors, node);
            this.InNeighbors.parent = temp;
            this.InNeighbors = temp;
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
