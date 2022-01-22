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
        DoubleLinkedNode list=DFS();
        RootedTree tree = DFS_transpose(list);
        return tree;
    }

    public RootedTree DFS_transpose(DoubleLinkedNode list){
        DoubleLinkedNode curNode = list;
        while(curNode!=null) {
            curNode.value.setColor(Color.white);
            curNode.value.setD(-1);
            curNode.value.setF(-1);
            curNode.value.setParent(null);
            curNode = curNode.son;
        }
        int time = 0;
        curNode = list;
        RootedTree tree = new RootedTree(new RootedTreeNode(0));
        while(curNode!=null){
            if(curNode.value.getColor()==Color.white) {
                tree.getRoot().addChild(curNode.value);
                DFS_visit_transpose(curNode.value, time);
            }
            curNode = curNode.son;
        }
        return tree;
    }

    public void DFS_visit_transpose(GraphNode u, int time){
        time++;
        u.setD(time);
        u.setColor(Color.grey);
        DoubleLinkedNode v = u.InNeighbors;
        GraphNode curNode;
        while(v!=null){
            curNode = v.value;
            if(curNode.getColor()==Color.white){
                curNode.setParent(u);
                u.getRefToRootedSelf().addChild(curNode);
                DFS_visit_transpose(curNode, time);
                time = curNode.getF();
            }
            v = v.son;
        }
        u.setColor(Color.black);
        time++;
        u.setF(time);
    }

    public DoubleLinkedNode DFS(){
        DoubleLinkedNode curNode = nodes;
        while(curNode!=null) {
            curNode.value.setColor(Color.white);
            curNode.value.setD(-1);
            curNode.value.setF(-1);
            curNode.value.setParent(null);
            curNode = curNode.son;
        }
        int time = 0;
        curNode = nodes;
        DoubleLinkedNode list = null;
        while(curNode!=null){
            if(curNode.value.getColor()==Color.white) {
                list = DFS_visit(curNode.value, time, list);
            }
            curNode = curNode.son;
        }
        return list;
    }

    public DoubleLinkedNode DFS_visit(GraphNode u, int time,
                                      DoubleLinkedNode list){
        time++;
        u.setD(time);
        u.setColor(Color.grey);
        DoubleLinkedNode v = u.OutNeighbors;
        GraphNode curNode;
        while(v!=null){
            curNode = v.value;
            if(curNode.getColor()==Color.white){
                curNode.setParent(u);
                list = DFS_visit(curNode, time, list);
                time = curNode.getF();
            }
            v = v.son;
        }
        u.setColor(Color.black);
        time++;
        u.setF(time);
        list = new DoubleLinkedNode(null, list, u);
        return list;
    }

    public RootedTree bfs(GraphNode source)
    {
        RootedTree bfsTree = BFSInitialize(source);
        Queue<GraphNode> q = new Queue<>();
        q.insert(source);
        GraphNode curNode;
        while(!q.isEmpty()){
            GraphNode u = q.remove();
            DoubleLinkedNode v = u.OutNeighbors;
            while(v!=null){
                curNode = v.value;
                if(curNode.getColor()==Color.white){
                    curNode.setColor(Color.grey);
                    curNode.setParent(u);
                    curNode.setD(u.getD()+1);
                    q.insert(curNode);
                    u.getRefToRootedSelf().addChild(curNode);
                }
                v = v.son;
            }
            u.setColor(Color.black);
        }
        return bfsTree;
    }
    private RootedTree BFSInitialize(GraphNode source){
        RootedTreeNode root  = new RootedTreeNode(source.key);
        source.setRefToRootedSelf(root);
        RootedTree bfsTree = new RootedTree(root);
        DoubleLinkedNode curNode = nodes;
        while(curNode!=null){
            if(curNode.value == source)
                continue;
            curNode.value.setColor(Color.white);
            curNode.value.setD(-1); // -1 means the vertex is not reachable from source
            curNode.value.setParent(null);
            curNode = curNode.son;
        }
        source.setD(0);
        source.setColor(Color.grey);
        source.setParent(null);
        return bfsTree;
    }
}
