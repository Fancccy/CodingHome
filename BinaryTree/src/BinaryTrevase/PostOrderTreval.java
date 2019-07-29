package BinaryTrevase;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTreval {
    //递归后序遍历
    List<Integer> list=new LinkedList<>();
    public List<Integer> postOrder(Node root){
        if(root==null){
            return list;
        }
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
        return list;
    }
    //后序遍历非递归
    public List<Integer> UnrpostOrder(Node root){
        Stack<Node> stack= new Stack<>();
        Node cur=root;
        Node pre = null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right==pre) {
                list.add(cur.val);
                stack.pop();
                pre = cur;//代表cur已经打印
                cur = null;
            }else {
                cur = cur.right;
            }
        }
        return list;
    }
}
