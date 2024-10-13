public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size=0;
    }

    public void insertFront(int val){
        Node node = new Node(val);
        node.next=head;
        head=node;
 
        if(tail==null) tail=head;
        size++;
    }

    public void insertLast(int val){
        if(tail==null) {
            insertFront(val);
            return;
        }

        Node node = new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    public void insert(int val, int index){
        if(index==0) {
            insertFront(val);
            return;
        }
        if(index==size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head= head.next;
        if(head==null) {
            tail=null;
        }
        else {
            size--;
        }
        return val;
    }


    public int deleteLast(){
        if(size<=1)return deleteFirst();
        Node secondLast= getIndex(size-2);
        int val=tail.value;
        tail=secondLast;
        tail.next=null;
        return val;

    }

    public int deleteIndex(int index){
        if(index==0) return deleteFirst();
        if(index==size-1) return deleteLast();
        Node nodePrev= getIndex(index-1);
        int val= nodePrev.next.value;
        nodePrev.next=nodePrev.next.next;
        return val;
    }

    public Node getIndex(int index){
        Node node = head;

        for (int i=0;i<index;i++){
            node=node.next;
        }

        return node;
    }


    public Node findValue(int val){
        Node node = head;

        while (node!=null){
            if (node.value==val){
                return node;
            }
            node=node.next;
        }

        return null;
    }


    public void display(){
        Node temp =head;
        while (temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println("END");

    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }

        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }

}
