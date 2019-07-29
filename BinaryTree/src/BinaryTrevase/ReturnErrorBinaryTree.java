package BinaryTrevase;

public class ReturnErrorBinaryTree {
    //将一颗源二叉树变成源二叉树的镜像
  public Node returnMirror(Node root,Node node){
        if(root==null){
            return node;
        }
        node.left=root.right;
        node.right=root.left;
        returnMirror(root.right,node.left);
        returnMirror(root.left,node.right);
        return node;
    }
    public void Mirror(Node root) {
        if(root==null){
            return;
        }
        Node tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        Mirror(tmp);
        Mirror(root.left);

    }
}
