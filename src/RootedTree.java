import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree
{
    private RootedTreeNode root;
    public RootedTree(){
        this.root = null;
    }

    public RootedTree(RootedTreeNode root){
        this.root=root;
    }

    public RootedTreeNode getRoot() {
        return root;
    }

    public void setRoot(RootedTreeNode root) {
        this.root = root;
    }

    public void printByLayer(DataOutputStream out)throws IOException
    {
        Queue<RootedTreeNode> q = new Queue<>();
        RootedTreeNode currentNode;
        int countCurrentPrint=0, countNextToPrint = 0;
        if(root==null)
            return;
        q.insert(root);
        countNextToPrint++;
        while(!q.isEmpty()){
            countCurrentPrint = countNextToPrint;
            countNextToPrint = 0;
            while(countCurrentPrint!=0){
                currentNode = q.remove();
                countCurrentPrint--;
                while(currentNode!=null) {
                    if (countCurrentPrint == 0) {
                        if (currentNode.getRight_sibling() == null) {
                            out.writeBytes(String.valueOf(currentNode.getKey()));
                        }
                    } else {
                        out.writeBytes(String.valueOf(currentNode.getKey()));
                        out.writeBytes(",");
                    }
                    if (currentNode.getLeft_child() != null) {
                        q.insert(currentNode.getLeft_child());
                        countNextToPrint++;
                    }
                    currentNode = currentNode.getRight_sibling();
                }
            }
            // if we'll need to remove the final new line then add if(q.isEmpty())
            if(!q.isEmpty())
                out.writeBytes("\n");
        }
        // perhaps add out.flush()
    }
    public void preorderPrint(DataOutputStream out)throws IOException
    {
        this.preorder(out, true);
    }
    private void preorder(DataOutputStream out, boolean couldBeLast)throws IOException{
        if(this.root == null)
            return;
        out.writeBytes(String.valueOf(this.root.getKey()));
        if(!couldBeLast)
            out.writeBytes(",");
        else {
            if(this.root.getRight_sibling() != null || this.root.getLeft_child() != null) {
                out.writeBytes(",");
            }
        }
        RootedTreeNode child = root.getLeft_child();
        while(child!=null){
            if(child.getRight_sibling()==null)
                (new RootedTree(child)).preorder(out, couldBeLast);
            else
                (new RootedTree(child)).preorder(out, false);
            child=child.getRight_sibling();
        }
    }
}
