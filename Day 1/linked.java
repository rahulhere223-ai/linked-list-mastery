public class linked{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
              this.data=data;
              this.next=null;
        }    
}
  public static Node head;
        public static Node tail;
        public static int size;


    public void addFirst(int data){
       Node newnode=new Node(data);
       if(head == null){
        head=tail=newnode;
        return;
       }
       newnode.next=head;
       head=newnode;
    }    
    public int sizeofll(Node head){
        Node temp=head;
        int size=0;

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
    }
    public static Node deleteHead(Node head){

        if(head == null){
            return head;
        }
     head=head.next;

     return head;
    }
    public static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp=head;

        while(temp.next.next != null){
            temp=temp.next;
        }
        temp.next=null;

        return head;
    }
    public static Node removeKthNode(Node head,int k){
        if(head == null) return head;

        if(k==1){
            head=head.next;
            return head;
        }
        int cnt=0;
        Node temp=head;
        Node prev=null;

        while(temp != null){
          cnt++;
          if(cnt == k){
            prev.next=prev.next.next;
            break;
          }
          prev=temp;
          temp=temp.next;
        }
        return head;
    }
    public static Node removetheval(Node head,int el){
        if(head == null) return head;

        if(head.data ==  el){
            head=head.next;
            return head;
        }

        Node temp=head;
        Node prev=null;

        while(temp != null){
            if(temp.data == el){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
    public static Node insertin1(int val,Node head){
        Node newnode=new Node(val);
        if(head == null){
            head=newnode;
            return head;
        }
        newnode.next=head;
        head=newnode;
        return head;
    }
    public static Node insertatlast(int val,Node head){
        Node newnode=new Node(val);
        if(head==null){
            head=tail=newnode;
            return head;
        }
        Node temp=head;

        while(temp.next !=null){
            temp=temp.next;
        }
        temp.next=newnode;

        return head;
    }
    public static Node insertatk(Node head,int val,int k){
        Node newnode=new Node(val);

        if(head == null){
            return newnode;
        }
        if(k == 1){
            newnode.next=head;
            head=newnode;
            return head;
        }
        Node temp=head;
        int cnt=0;

        while(temp != null){
            cnt++;
            if(cnt == k-1){
                newnode.next=temp.next;
                temp.next=newnode;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        linked ll=new linked();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        // System.out.println(ll.sizeofll(head));
        // head=ll.deleteHead(head);
        // ll.print(head);

        // head=removeTail(head);
        // ll.print(head);

        // head=removeKthNode(head, 3);
        // ll.print(head);


        // head=removetheval(head, 3);
        // ll.print(head);

        // head=insertin1(9, head);
        // ll.print(head);

        // head=insertatlast(0, head);
        // ll.print(head);

        head=insertatk(head, 15, 5);
        ll.print(head);












    }
}