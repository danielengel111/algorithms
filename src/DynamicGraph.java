public class DynamicGraph
{
    private DoubleLinkedNode nodes;
    public DynamicGraph()
    {
        nodes = null;
    }
    public GraphNode insertNode(int nodeKey)
    {
        GraphNode newNode = new GraphNode(nodeKey);
        nodes = new DoubleLinkedNode(null, nodes, newNode);
        newNode.setRefToDynamicSelf(nodes);
        return newNode;
    }
    public void deleteNode(GraphNode node)
    {
        if(node.getInDegree()!=0 || node.getOutDegree()!=0)
            return;
        if(node.getRefToDynamicSelf().isSingle()) {
            nodes = null;
            node.setRefToDynamicSelf(null);
        }else{
            node.getRefToDynamicSelf().delete();
        }
    }

    public GraphEdge insertEdge(GraphNode from, GraphNode to)
    {
        GraphEdge newEdge = new GraphEdge(from, to);
        newEdge.setFromReference(to.addInNeighbor(from));
        newEdge.setToReference(from.addOutNeighbor(to));
        return newEdge;
    }
    public void deleteEdge(GraphEdge edge)
    {
        edge.getFromReference().delete();
        edge.getTo().decreaseInDegree();
        edge.setFromReference(null);

        edge.getToReference().delete();
        edge.getFrom().decreaseOutDegree();
        edge.setToReference(null);
    }
    public RootedTree scc()
    {
        return null;
    }
    public RootedTree bfs(GraphNode source)
    {
        RootedTree bfsTree = BFSInitialize(source);

        return null;
    }
    private RootedTree BFSInitialize(GraphNode source){
        RootedTreeNode root  = new RootedTreeNode(source.key);
        root.setRefToSelfInGraph(source);
        RootedTree bfsTree = new RootedTree(root);
        DoubleLinkedNode curNode = nodes;
        while(curNode!=null){
            if(curNode.value == source)
                continue;
            curNode.value.setColor(Color.white);
            curNode.value.setD(-1); // -1 means the vertex is not reachable from source
            curNode.value.setParent(null);
        }
        source.setD(0);
        source.setColor(Color.grey);
        source.setParent(null);
        return bfsTree;
    }
}
