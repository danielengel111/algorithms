public class RootedTreeNode {
    private RootedTree parent;
    private RootedTree left_child;
    private RootedTree right_sibling;

    public RootedTreeNode(){
        parent=null;
        left_child=null;
        right_sibling=null;
    }

    public RootedTree getParent() {
        return parent;
    }

    public RootedTree getLeft_child() {
        return left_child;
    }

    public RootedTree getRight_sibling() {
        return right_sibling;
    }

    public void setParent(RootedTree parent) {
        this.parent = parent;
    }

    public void setLeft_child(RootedTree left_child) {
        this.left_child = left_child;
    }

    public void setRight_sibling(RootedTree right_sibling) {
        this.right_sibling = right_sibling;
    }
}
