
import java.util.*;

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

    public static Node sortall(Node head){
        Node temp=head;
       ArrayList<Integer> list=new ArrayList<>();

       while(temp != null){
        list.add(temp.data);
        temp=temp.next;
       }

       Collections.sort(list);
       temp=head;
       int i=0;

       while(temp != null){
        temp.data=list.get(i);
        temp=temp.next;
        i++;
       }
       return head;
    } 
    public static Node merge2ll(Node head1,Node head2){

    }
    public static void main(String[] args) {
        int arr[]={2,4,3,1,5};
        int arr2[]={8,9,6,10,7};
        Node head1=convert2arr(arr);
        Node head2=convert2arr(arr2);
        // print(head);

        // sortall(head);
        // print(head);

        



    }
}