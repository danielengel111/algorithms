public class RootedTreeNode {
    private RootedTreeNode parent;
    private RootedTreeNode left_child;
    private RootedTreeNode right_sibling;
    private int key;


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


    public void addSibling(GraphNode node){
        if(right_sibling==null){
            right_sibling = new RootedTreeNode(this.parent, null, null, node.key);
            node.setRefToRootedSelf(right_sibling);
            return;
        }else
            right_sibling.addSibling(node);
    }


    public void addChild(GraphNode node){
        if(this.left_child==null) {
            left_child = new RootedTreeNode(this, null, null, node.key);
            node.setRefToRootedSelf(left_child);
            return;
        }
        else
            left_child.addSibling(node);
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
