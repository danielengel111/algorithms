import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree
{
    private RootedTreeNode root;
    public RootedTree(){
        this.root = null;
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
                        if (currentNode.getRight_sibling() != null) {
                            out.writeBytes(String.valueOf(currentNode.getKey()));
                        }
                    } else {
                        out.writeBytes(String.valueOf(currentNode.getKey()) + ",");
                    }
                    if (currentNode.getLeft_child() != null) {
                        q.insert(currentNode.getLeft_child());
                        countNextToPrint++;
                    }
                    currentNode = currentNode.getRight_sibling();
                }
            }
            // if we'll need to remove the final new line then add if(q.isEmpty())
            out.writeBytes("\n");
        }
    }
    public void preorderPrint(DataOutputStream out)throws IOException
    {

    }

}
