import java.util.Stack;

class Node{
        int data;
        Node next;
        Node back;
        public Node(int data,Node next,Node back){
            this.data=data;
            this.next=next;
            this.back=back;
        }
        public Node(int data){
            this.data=data;
            this.next=next;
            this.back=back;
        }
    }
public class doubly{
    public static Node convertarr2dl(int arr[]){
        Node head=new Node(arr[0], null, null);
        Node prev=head;

        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i], null, prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }
    public static  void print(Node head){
        Node temp=head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static Node removehead(Node head){
        if(head== null || head.next == null){
            return null;
        }

        Node prev=head;
        head=head.next;
        head.back=null;
        prev.next=null;
        return head;

    }
    public static Node removetail(Node head){
        if(head == null || head.next == null) return null;

        Node tail=head;

        while(tail.next != null){
            tail=tail.next;
        }
        Node prev=tail.back;
        tail.back=null;
        prev.next=null;
        return head;

    }
    public static Node removeatNth(Node head,int k){
     if(head == null || head.next == null) return null;

     if(k==1){
        Node prev=head;
        head=head.next;
        prev.next=null;
        return head;
     }

     Node temp=head;
     int cnt=0;

     while(temp != null){
        cnt++;
        if(cnt == k) break;
       temp=temp.next;
     }

     Node prev=temp.back;
     Node front=temp.next;

     if(front == null){
        return removetail(head);
     }
     prev.next=temp.next;
     front.back=temp.back;
     temp.back=null;
     temp.next=null;
     return head;
    }

    public static void removebyVal(Node temp){
        Node prev=temp.back;
        Node front=temp.next;

        if(front== null){
            prev.next=null;
            temp.back=null;
            return;
        }
        
        prev.next=temp.next;
        front.back=prev;
        temp.back=null;
        temp.next=null;
        return;
    }
    public static Node insertbeforehead(Node head,int val){
        Node newHead=new Node(val,head,null);
        head.back=newHead;
        return newHead;
    }
    public static Node insertbeforetail(Node head,int val){
    Node tail=head;
    while(tail.next != null){
        tail=tail.next;
    }
    Node prev=tail.back;
    Node newNode=new Node(val,tail,prev);
    prev.next=newNode;
    tail.back=newNode;

    return head;
    }
    public static Node insertatKth(Node head,int k,int val){
        if(k==1){
            return insertbeforehead(head, val);
        }
        Node temp=head;
        int cnt=0;

        while(temp != null){
            cnt++;
            if(cnt == k)break;
            temp=temp.next;
        }
        Node prev=temp.back;
    
        Node newNode=new Node(val, temp, prev);
        prev.next=newNode;
        temp.back=newNode;

        return head;

    }
    // Brute force
    // reverse a dll
    public static Node reversedll1(Node head){
       Stack<Integer> st=new Stack<>();
       Node temp=head;

       while(temp != null){
           st.push(temp.data);
           temp=temp.next;
       }

       temp=head;

       while(temp != null){
        temp.data=st.peek();
        st.pop();
        temp=temp.next;
       }
       return head;
    }
    // optimal
    public static Node reverseadll2(Node head){
        if(head == null || head.next == null) return null;

        Node curr=head;
        Node last=null;

        while(curr != null){
            last=curr.back;
            curr.back=curr.next;
            curr.next=last;
            curr=curr.next;
        }
        return last.back;
    }
   public static void main(String[] args) {
       int arr[]={1,2,3,4,5};

      Node head= convertarr2dl(arr);
    //    print(head);


    // head=removehead(head);
    // print(head);

    // head=removetail(head);
    // print(head);

    //    head=removeatNth(head, 3);
    //    print(head);
    

    // removebyVal(head.next.next);
    // print(head);

    // head=insertbeforehead(head, 10);
    // print(head);

    // head=insertbeforetail(head, 45);
    // print(head);

    // head=insertatKth(head, 5, 12);
    // print(head);

    // head=reversedll1(head);
    // print(head);

    head=reverseadll2(head);
    print(head);



   }
}