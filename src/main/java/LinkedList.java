class Node{

    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

class LinkedList{
    Node head;
    public void push(int new_data){
        Node new_node=new Node(new_data);
        if(head==null){
            head=new_node;
        }
        else
        {
            new_node.next=head;
            head=new_node;
        }

    }
    public void insertafter(Node node,int new_data){
        Node new_node=new Node(new_data);
        if(head==null){
            head=new_node;
        }
        else
        {
            new_node.next=node.next;
            node.next=new_node;
        }
    }
    public void append(int new_data){
        Node new_node=new Node(new_data);
        if(head==null){
            head=new_node;
            return;
        }
        else{
            new_node.next=null;
            Node node=head;
            while(node.next!=null){
                node=node.next;
            }
            node.next=new_node;
            return;
        }

    }
    public void delete(int key){
        Node temp=head,prev=null;
        if(temp!=null && temp.data==key){
            head=temp.next;
            return;
        }
        while(temp!=null&&temp.data!=key){
            prev=temp;
            temp=temp.next;
        }
        if(temp==null)
            return;

        prev.next=temp.next;

    }
    public void del(int pos){
        Node temp=head,prev=null;
        int count=0;
        while(temp.next!=null&&count!=pos){
            count++;
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
    }
    public boolean search(int n){
        Node temp=head;
        if(head==null){
            return false;
        }
        while(temp!=null){
            if(temp.data==n){
                return true;
            }
            temp=temp.next;
        }
        return false;


    }

    public Node getNth(int index)
    {
        Node current = head;
        int count = 0;
        while (current != null)
        {
            if (count == index)
                return current;
            count++;
            current = current.next;
        }
        return null;
    }
    void deleteList()
    {
        head = null;
    }
    int nodeFreq(int search_for)
    {
        Node current = head;
        int count = 0;
        while (current != null)
        {
            if (current.data == search_for)
                count++;
            current = current.next;
        }
        return count;
    }

    public void printList(){
        if(head==null){
            System.out.println("no nodes in list");
        }
        else
        {
            Node node=head;
            while(node!=null){
                System.out.print(node.data+" ");
                node=node.next;
            }
        }
    }
    Node middle(Node h)
    {
        if (h == null){
            return h;
        }
        Node fast_ptr = h;
        Node slow_ptr = h;

        while (fast_ptr != null && fast_ptr.next != null)
        {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        return slow_ptr;
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.push(1);
        ll.push(2);
        ll.push(3);
        ll.push(4);
        ll.push(5);
        ll.push(5);
        ll.push(5);
        ll.insertafter(ll.head.next,6);
        ll.append(9);
        ll.printList();
        ll.delete(6);
        ll.del(3);
        System.out.println();
        ll.printList();
        System.out.println();
        System.out.println(ll.nodeFreq(5));
        Node res=ll.middle(ll.head);
        System.out.println("middle ele="+res.data);

    }
}