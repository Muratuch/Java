public class DLL {
    Node head;

    public void insertFirst(int val){
        Node node =new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null) head.prev=node;
        head=node;
    }

    public void insertLast(int val){
        Node node =new Node(val);
        Node last=head;
        node.next=null;

        if(head==null) {
            insertFirst(val);
            return;
        }

        while (last.next!=null){
            last=last.next;
        }

        last.next=node;
        node.prev=last;
    }

    public void insert(int after,int val){
        Node p =find(after);
        if(p==null) {
            System.out.println("Does not exist");
            return;
        }

        Node node =new Node(val);
        node.next=p.next;
        p.next= node;
        node.prev=p;
        if(node.next!=null){
            node.next.prev=node;
        }

    }

    public Node find(int val){
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
        Node node=head;
        Node last=null;

        while (node!=null){
            System.out.print(node.value+" -> ");
            last=node;
            node=node.next;
        }
        System.out.println("END");

        System.out.println("Print reversed");

        while (last!=null){
            System.out.print(last.value+" -> ");
            last=last.prev;
        }
        System.out.println("Start");

    }





    private class Node{
        private int value;
        private Node next;
        private Node prev;
        public Node(int value){
            this.value=value;
        }
        public Node(int value, Node next, Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
    }
}
