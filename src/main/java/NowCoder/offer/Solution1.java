package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-25.
 */
public class Solution1 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        TreeLinkNode node = null;
        if(pNode.right!=null){
            node =pNode.right;
            while(node.left!=null){
                node= node.left;
            }
        }else if(pNode.next!=null){
            TreeLinkNode current = pNode;
            TreeLinkNode parent = pNode.next;
            while(parent!=null&&current!=parent.left){
                current = parent;
                parent= current.next;
            }
            node = parent;
        }
        return node;
    }
}
