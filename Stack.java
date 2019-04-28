import java.util.Queue;
public class Stack {//两个队实现一个栈
       private MyQueue stack1;
       private MyQueue stack2;
       private int usedsize;
       public Stack(){
           this.stack1=new MyQueue();
           this.stack2=new MyQueue();
           this.usedsize=0;
       }
        public void push(int x) {
           if(stack1!=null){
               stack1.add(x);
               this.usedsize++;
           }else{
               stack2.add(x);
               this.usedsize++;
           }
        }
        //出栈
        public int pop() {
           if(empty()){
               throw new UnsupportedOperationException("队列为空");
           }
           int data=0;
          if(stack1!=null){
              for(int i=0;i<usedsize-1;i++){
                  stack2 .add(stack1.poll());
              }
              data=stack1.poll();
              this.usedsize--;
          }else{
              for(int i=0;i<usedsize-1;i++){
                  stack1 .add(stack2.poll());
              }
              data=stack2.poll();
              this.usedsize--;
          }
          return data;
        }

        /** Get the top element.*/
        public int top() {
            if(empty()){
                throw new UnsupportedOperationException("队列为空");
            }
            int data=0;
            for(int i=-0;i<=usedsize -1;i++){
                if(stack1.empty()){
                    data=stack2.poll();
                    stack1.add(data);
                }else{
                    data=stack1.poll();
                    stack2.add(data);
                }
            }
            return data;
        }

        public boolean empty() {
           return this.usedsize==0;
        }

        public int size(){
           return this.usedsize;
    }

    public static void main(String[] args) {
        Stack S=new Stack();
        S.push(10);
        S.push(20);
        S.push(30);
        S.push(40);
        System.out.println(S.pop());
        System.out.println(S.usedsize);
    }
}

