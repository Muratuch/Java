public class index {
    public static void main(String[] args) {
        //Implementation of singly Linked List
//        LL list= new LL();
//        list.insertFront(12);
//        list.insertFront(121);
//        list.insertFront(1212);
//        list.insertFront(121212);
//        list.insertFront(12121212);
//        list.display();
//        LL newList= new LL();
//        newList.insertLast(1);
//        newList.insertLast(12);
//        newList.insertLast(121);
//        newList.display();
//        list.insert(12121,2);
//        list.display();
//        list.deleteFirst();
//        list.display();
//        list.deleteLast();
//        list.display();
//        list.deleteIndex(2);
//        list.display();

        //Implementation of the doubly Liked List
//        DLL list= new DLL();
//        list.insertFirst(12);
//        list.insertFirst(121);
//        list.insertFirst(1212);
//        list.insertFirst(121212);
//        list.insertFirst(12121212);
//        list.display();
//        list.insertLast(111);
//        System.out.println();
//        list.display();
//        System.out.println();
//        list.insert(1212,12121);
//        list.display();

        //Implementation of circular Linked List


        CLL list= new CLL();
        list.insert(12);
        list.insert(121);
        list.insert(1212);
        list.insert(121212);
        list.insert(12121212);
        list.display();
        list.delete(1212);
        list.display();
    }
}
