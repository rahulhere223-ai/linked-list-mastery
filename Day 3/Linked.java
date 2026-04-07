import java.util.Stack;

class Node{
    int data;
    Node next;

    public Node(int data,Node next){
        this.data=data;
        this.next=null;
    }
    public Node(int data){
        this.data=data;
        this.next=null;
    }
    public static int size;
    public static Node head;
    public static Node tail;;

}
public class Linked{
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
    public static Node add2no(Node head1,Node head2){
        Node dummy=new Node(-1);
        Node temp1=head1;
        Node temp2=head2;
        Node curr=dummy;
        int carry=0;

        while(temp1 != null || temp2 != null){
            int sum=carry;
            if(temp1 != null) sum = sum + temp1.data;
            if(temp2 != null) sum=sum + temp2.data;

            Node newnode=new Node(sum%10);
            carry=sum/10;
            curr.next=newnode;
             curr=newnode;

             if(temp1 != null) temp1=temp1.next;
             if(temp2 != null) temp2=temp2.next;
        }

        if(carry >0){
            Node newnode=new Node(carry);
            curr.next=newnode;
        }

        return dummy.next;
        
    }
    public static Node reversell1(Node head1){
        Stack<Integer> stack=new Stack<>();
        Node temp=head1;

        while(temp != null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head1;

        while(temp != null){
            temp.data=stack.peek();
            stack.pop();
            temp=temp.next;
        }
        return head1;
    }
    public static Node reverseall2(Node head1){
        Node curr=head1;
        Node prev=null;

        while(curr != null){
            Node front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
    // public static Node reverseall3(Node head1){
    //     if(head1 ==null || head1.next == null){
    //         return head1;
    //     }
    //     Node newHead=reverseall3(head1.next);
    //     Node front=head1.next;
    //     head1.next=null;

    //     return newHead;
    // }
    public static Node middleofll(Node head){
        Node slow=head;
        Node fast=head;

        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node deletemoiddleofll(Node head){
        Node slow=head;
        Node fast=head;
        Node prev=null;

        while(fast != null && fast.next != null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={2,4,6};
        Node head1=convert2arr(arr1);
        // Node head2=convert2arr(arr2);
        // print(head);
        // System.out.println(sizeofll(head));

        // Node head3=add2no(head1, head2);
        // print(head3);

        // Node head=reversell1(head1);
        // print(head);

        // Node head=reverseall2(head1);
        // print(head);

        // Node head=middleofll(head1);
        // print(head);

        Node head=deletemoiddleofll(head1);
        print(head);





        
    }
}