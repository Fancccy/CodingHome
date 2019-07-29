package BinaryTrevase;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTreval {
    //中序遍历递归
    List<Integer> list=new LinkedList<>();
    public List<Integer> inOrder(Node root){
      if(root==null){
          return list;
      }
      inOrder(root.left);
      list.add(root.val);
      inOrder(root.right);
      return list;
    }
    //中序遍历递归用到栈
    public List<Integer> UnrinOrder(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
    }
}
