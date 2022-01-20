public class RootedTreeNode {
    private RootedTreeNode parent;
    private RootedTreeNode left_child;
    private RootedTreeNode right_sibling;
    private GraphNode refToSelfInGraph;
    private int key;

    public GraphNode getRefToSelfInGraph() {
        return refToSelfInGraph;
    }

    public void setRefToSelfInGraph(GraphNode refToSelfInGraph) {
        this.refToSelfInGraph = refToSelfInGraph;
    }

    public RootedTreeNode(int key){
        parent=null;
        left_child=null;
        right_sibling=null;
        this.key =key;
    }

    public RootedTreeNode(RootedTreeNode parent, RootedTreeNode left_child, RootedTreeNode right_sibling, int key) {
        this.parent = parent;
        this.left_child = left_child;
        this.right_sibling = right_sibling;
        this.key = key;
    }


    public RootedTreeNode addSibling(GraphNode node){
        if(right_sibling==null){
            right_sibling = new RootedTreeNode(this.parent, null, null, node.key);
            right_sibling.setRefToSelfInGraph(node);
            return right_sibling;
        }else
            return right_sibling.addSibling(node);
    }


    public RootedTreeNode addChild(GraphNode node){
        if(this.left_child==null) {
            left_child = new RootedTreeNode(this, null, null, node.key);
            left_child.setRefToSelfInGraph(node);
            return left_child;
        }
        else
            return left_child.addSibling(node);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public RootedTreeNode getParent() {
        return parent;
    }

    public RootedTreeNode getLeft_child() {
        return left_child;
    }

    public RootedTreeNode getRight_sibling() {
        return right_sibling;
    }

    public void setParent(RootedTreeNode parent) {
        this.parent = parent;
    }

    public void setLeft_child(RootedTreeNode left_child) {
        this.left_child = left_child;
    }

    public void setRight_sibling(RootedTreeNode right_sibling) {
        this.right_sibling = right_sibling;
    }
}
