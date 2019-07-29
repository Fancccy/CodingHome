import javax.swing.tree.TreeNode;
import java.util.*;

public class MyBinaryTree {
    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void display() {
            System.out.print(this.data + "\t");
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return String.valueOf(this.data);
        }
    }

    private Node root;

    public MyBinaryTree(int data) {
        this.root = new Node(data);
        root.left = null;
        root.right = null;
    }

    public MyBinaryTree() {
        this.root = null;
    }

    //查询操作
    public Node findValue(int value) {
        Node current = root;
        while (true) {
            if (this.root.data == value) {
                return this.root;
            } else if (root.data < value) {
                this.root = this.root.right;
            } else if (root.data > value) {
                this.root = this.root.left;
            }


            if (current == null) {
                return null;
            }
        }
    }

    //添加操作
    public void add(int value) {
        Node node = new Node(value);
        Node current = this.root;
        if (this.root == null) {
            this.root = node;
            this.root.left = null;
            this.root.right = null;
        } else {
            Node parent = null;
            current = this.root;
            while (true) {
                if (current.left == null) {
                    parent = current;
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        break;
                    }
                } else if (current.right == null) {
                    parent = current;
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("having the same number!");
                }
            }
        }
    }

    //中序遍历
    public void inOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        root.display();
        inOrderTraverse(root.right);
    }

    //中序遍历非递归
    public void inOrderTraverseUnre(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current.display();
                current = current.right;
            }

        }
        System.out.println();

    }

    //后序遍历非递归
    void postOrderUnr(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        Node preNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.peek().right;
                if (current == null || current == preNode) {
                    current = stack.pop();
                    current.display();
                    preNode = current;
                    current = null;
                }
            }
        }
        System.out.println();
    }

    //前序遍历
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        root.display();
        preOrder(root.left);
        preOrder(root.right);
    }
    //前序遍历非递归

    public void preOrderTreval(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current.display();
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }

    }

    //后序遍历
    public void postOrderTrevel(Node root) {
        if (root == null) {
            return;
        }
        postOrderTrevel(root.left);
        postOrderTrevel(root.right);
        root.display();
    }

    MyBinaryTree createTestTree(String s) {
        int i = 0;
        MyBinaryTree root = null;
        //1、如果对应字符不是#的话  那么创建一个新的节点
        //2、如果对应字符是#的话 直接下标++
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                add(s.charAt(i));
            } else {
                i++;
            }
        }

        return root;
    }

    int getSize(Node root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }

    int getLeafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    int getKLevelSize(Node root, int k) {
        if (k == 1) {
            return 1;
        }
        if (root == null) {
            return 0;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    Node find(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (value == root.data) {
            return root;
        }
        Node r = find(root.left, value);
        if (r == null) {
            r = find(root.right, value);
        }
        return r;
    }
//ABC##DE#G##F##

    //二叉树的高度
    int height(Node root) {
        if (root == null) {
            return 0;
        }
        int a = height(root.left);
        int b = height(root.right);
        return a > b ? a + 1 : b + 1;
    }

    //层序遍历二叉树
    void binaryTreeLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        while (root != null || !queue.isEmpty()) {
            if (root != null) {
                queue.offer(root);
            }
            while (!queue.isEmpty()) {
                Node cuurent = queue.peek();
                if (cuurent != null) {
                    cuurent.display();
                }
                queue.poll();
                if (cuurent.right != null) {
                    queue.offer(root.right);
                }
                if (cuurent.left != null) {
                    queue.offer(root.left);
                }
            }
        }
    }

    int binaryTreeComplete(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node cuurent = queue.peek();
            if (cuurent != null) {
                cuurent.display();
            }
            queue.poll();
            if (cuurent.left != null) {
                queue.offer(root.left);
            }
            if (cuurent.right != null) {
                queue.offer(root.right);
            }
            if (cuurent.left == null) {
                break;
            }
        }
        if (!queue.isEmpty()) {
            return -1;
        }
        return 0;
           /* Queue<Node> queue = new LinkedList<>();
            if(root != null) {
                queue.offer(root);//add  offer
            }

            while (!queue.isEmpty()) {
                Node cur = queue.poll();//A 这个节点
                if(cur != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else {
                    break;
                }
            }
            //出队  只要不是空  就说明不是满二叉树
           while(!queue.isEmpty()){
                Node cur=queue.poll();
                if(cur==null){
                    break;
                }
           }
           if(!queue.isEmpty()){
                return -1;
           }
           return 0;*/
    }

    //检查两个二叉树是否相同
    boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        } else if (q != null && p == null) {
            return false;
        } else if (q == null && p != null) {
            return false;
        } else if (q.data == p.data) {
            return true;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        if (left && right) {
            return true;
        }
        return false;
    }
    //判断一个树是否是对称的树
    boolean isSymmetricChild(Node left,Node right){//递归左右子树  将其相比
        if(left==null&&right==null){
            return true;
        }
        if(left!=null&&right==null){
            return false;
        }
        if(left.left==null&&right!=null){
            return false;
        }
        return left.data==right.data&isSymmetricChild(left.left,right.right)&&isSymmetricChild(left.right,right.left);
    }
    boolean isSymmeTric(Node root){
        if(root==null){
            return  true;
        }
        return isSymmetricChild(root.left,root.right);
    }
    //采用前序遍历将一颗二叉树加成括号输出 [1,2,3,4]  1(2(4))(3)
    StringBuilder res = new StringBuilder();
    String tree2str(Node root){
        if(root==null){
            return res.toString();
        }
        if(root!=null){
            res.append(root);
        }
        if(root.left==null&&root.right==null){
            return res.toString();
        }

      if(root.left!=null){
          res.append('(');
          tree2str(root.left);
          res.append(')');
      }else{
            if(root.right==null&&root.left==null){
                return res.toString();
            }else if(root.left==null&&root.right!=null){

            }
      }
      if(root.right!=null){
            res.append("(");
            tree2str(root.right);
            res.append(')');
      }
      return res.toString();
    }
    //二叉树的最近公共祖先
}
