import java.util.*;

class Node{
    int data;
    Node next;

    public Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    public Node(int data){
        this.data=data;
        this.next=next;
    }
}
public class Linkedlist{
    public static  Node convert2arr(int arr[]){
       Node head=new Node(arr[0]);
       Node mover=head;

       for(int i=1;i<arr.length;i++){
        Node temp=new Node(arr[i]);
        mover.next=temp;
        mover=temp;
       }
       return head;
    }
    public static int sizeofll(Node head){
        int size=0;
        Node temp=head;

        while(temp != null){
            temp=temp.next;
            size++;
        }
        return size;
    }
    public static void print(Node head){
        Node temp=head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }    
    public static Node oddandeven1(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp=head;
        ArrayList<Integer> list=new ArrayList<>();

        while(temp != null && temp.next != null){
            list.add(temp.data);
            temp=temp.next.next;
        }
        if(temp != null)list.add(temp.data);
        temp=head.next;

        while(temp.next != null && temp.next != null){
            list.add(temp.data);
            temp=temp.next.next;
        }
        if(temp != null) list.add(temp.data);
        temp=head;
        int i=0;
        while(temp != null){
            temp.data=list.get(i);
            temp=temp.next;
            i++;
        }
        return head;
    }
    public static Node oddandeven2(Node head){
        Node odd=head;
        Node even=head.next;
        Node evenhead=head.next;

        while(even != null && even.next != null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
        return  head;
    }
    public static Node sort012sNode(Node head){
         Node temp=head;
         int cnt0=0;
         int cnt1=0;
         int cnt2=0;

         while(temp != null){
            if(temp.data == 0) cnt0++;
            else if(temp.data == 1) cnt1++;
            else cnt2++;
            temp=temp.next;
         }
         temp=head;

         while(temp != null){
            if(cnt0 != 0){
                temp.data=0;
                cnt0--;
            }
            else if(cnt1 !=0){
                temp.data=1;
                cnt1--;
            }
            else{
                temp.data=2;
                cnt2--;
            }
            temp=temp.next;
         }
         return head;
    }
    public static Node sort012s2(Node head){
        Node temp=head;
        Node zerohead=new Node(-1);
        Node onehead=new Node(-1);
        Node twohead=new Node(-1);
        Node zero=zerohead;
        Node one=onehead;
        Node two=twohead;

        while(temp != null){
            if(temp.data == 0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data == 1){
                one.next=temp;
                one=one.next;
            }
            else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next= (onehead.next != null ) ? onehead.next:twohead.next;
        one.next=twohead.next;
        two.next=null;

        return zerohead.next;
    }
    public static Boolean ispalindrome(Node head){
     Node temp=head;
     Stack<Integer> stack=new Stack<>();

     while(temp != null){
        stack.push(temp.data);
        temp =temp.next;
     }
     temp=head;

     while(temp != null){
        if(temp.data != stack.peek()){
            return false;
        }
        stack.pop();
        temp=temp.next;
     }
     return true;
    }
    public static boolean ispalindrome2(Node head){
        
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,3,2,1};
        Node head=convert2arr(arr);
        // print(head);

        // oddandeven1(head);
        // print(head);

        // oddandeven2(head);
        // print(head);

        // sort012sNode(head);
        // print(head);

        // sort012s2(head);
        // print(head);

        // System.out.println(ispalindrome(head));


    }
}