package BinaryTrevase;

import javax.swing.tree.TreeNode;
import java.util.*;
class Node{
    Node left;
    Node right;
    int val;
    Node(){
        this.val=0;
    }
    Node(int val){
        this.val=val;
    }
}
public class PreOrderTrevase {
    //前序遍历递归
   public void PreOrder(Node root){
       if(root==null){
           return;
       }
       System.out.println(root);
       PreOrder(root.left);
       PreOrder(root.right);
   }
   //力扣测试题   用list来储存   运用递归遍历
    List<Integer> list=new LinkedList<>();
   //将其写成一个全局变量是因为方法内要做递归  list每次都会更新 无法连续存储
    public List<Integer> PreOrderByList(Node root){
       if(root==null){
         return list;
       }
       list.add(root.val);
       PreOrder(root.left);
       PreOrder(root.right);
       return list;
    }
    //前序遍历递归

    public List<Integer> UnrPreOrderTrevas(Node root){
        List<Integer> list=new LinkedList<>();
       Stack<Node> stack=new Stack<>();
       Node cur=root;
       while(!stack.isEmpty()||cur!=null){
           if(cur!=null){    //将左子树全部压入栈
               list.add(cur.val);
               stack.push(cur);
               cur=cur.left;
           }else{
               cur=stack.pop();
               cur=cur.right;
           }
       }
       return list;
    }

    public static void main(String[] args) {

    }
}
