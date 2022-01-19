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
        newNode.setRefToSelf(nodes);
        return newNode;
    }
    public void deleteNode(GraphNode node)
    {
        if(node.getInDegree()!=0 || node.getOutDegree()!=0)
            return;
        if(node.getRefToSelf().isSingle()) {
            nodes = null;
            node.setRefToSelf(null);
        }else{
            node.getRefToSelf().delete();
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
    public rootedTree scc()
    {
        return null;
    }
    public RootedTree bfs()
    {
        return null;
    }

}
