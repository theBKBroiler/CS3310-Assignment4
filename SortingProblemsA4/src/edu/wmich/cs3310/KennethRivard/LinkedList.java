package edu.wmich.cs3310.KennethRivard;

/**
 * Created by Kenneth Rivard on 11/2/16.
 */

public class LinkedList<E extends Comparable> implements Comparable {
    
    public int size;
    protected Node head;
    protected Node tail;
    protected Node first;
    
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }//end LinkedList

    public Node extractFirst() {
        return head;
    }

    public void append(Node result){
        head = result;
    }

    /*check if list in empty*/
    public boolean isEmpty() {
        return head == null;
    }//end isEmpty()

    /*keep track of list size*/
    public int getSize() {
        return size;
    }//end getSize()


    /*insert at head of linked list*/
    public void insertAtHead(E obj) {
        Node nPtr = new Node(obj, null, null);
        if (head == null) {
            head = nPtr;
            tail = head;
        } else {
            head.setLinkPrev(nPtr);
            nPtr.setLinkNext(head);
            head = nPtr;
        }
        size++;
    }//end insert at head of linked list


    /*Display the array to the console*/
    public void display() {
        System.out.println("List of Names . . . ");
        if (size == 0) {
            System.out.println("List empty!");
            return;
        }
        if (head.getLinkNext() == null) {
            System.out.println(head.getData());
            return;
        }
        Node ptr = head;
        System.out.println(head.getData());
        ptr = head.getLinkNext();
        while (ptr.getLinkNext() != null) {
            System.out.println(ptr.getData());
            ptr = ptr.getLinkNext();
        }
        System.out.println(ptr.getData() + "\n");
    }//end display

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    /*============================MERGE SORT================================================*/
    public Node mergeSort(Node headOrg) {
        if (headOrg == null || headOrg.next == null)
            return headOrg;
        Node a = headOrg;
        Node b = headOrg.next;
        while ((b != null && b.next != null)) {
            headOrg = headOrg.next;
            b = (b.next).next;
        }//end while
        b = headOrg.next;
        headOrg.next = null;
        return merge(mergeSort(a), mergeSort(b));
    }//end mergeSort


    public Node merge(Node a, Node b) {
        Node temp = new Node(a);
        Node head = temp;
        Node c = head;
        while ((a != null) && (b != null)) {
            if (a.data.compareTo(b.data) < 1) {
                c.next = a;
                c = a;
                a = a.next;
            } else {
                c.next = b;
                c = b;
                b = b.next;
            }//end else
        }//end while
        c.next = (a == null) ? b : a;
        return head.next;
    }//end merge


    /*============================SELECTION SORT==========================================*/
    public void selectionSort(Node head) {
        for (Node index = head; ((index != null) && (index.getLinkNext() != null)); index = index.getLinkNext()) {
            Node min = index;
            for (Node test = min.getLinkNext(); test != null; test = test.getLinkNext()) {
                if (test.getData().compareTo(min.getData()) < 1) {
                    min = test;
                }//end if within for loop
            }//end for
            if(index != min) {
                Node temp = new Node(min);
                temp = index;
                index = min;
                min = temp;
            }//end if
        }//end for loop
    }//end selectionSort

     /*============================BINARY-INSERTION SORT==========================================*/
     public void insertionSort(Node node) {
         //declare first node the start of sorted list
         Node sortedList = node;
         node = node.next;
         sortedList.next = null;

         while(node != null) {
             final Node current = node;
             node = node.next;

             //find current
             if (current.data.compareTo(sortedList.data) < 1) {
                 //current is now the sorted head
                 current.next = sortedList;
                 sortedList = current;
             } else {
                 //search for correct positions
                 Node search = sortedList;
                 while (search.next != null && (current.data.compareTo(search.next.data)) > 0) {
                     search = search.next;
                 }//end while search
                 current.next = search.next;
                 search.next = current;
             }//end else
         }//end while node
     }//end insertionSort

    /*============================BUBBLE SORT==========================================*/
    public void bubbleSort() {
        if (size > 1) {
            for(int i = 0; i < size; i++) {
                Node currentNode = head;
                Node next = head.getLinkNext();
                for(int j = 0; j < size - 1; j++) {
                    if(currentNode.getData().compareTo(next.getData()) > 0) {
                        Node temp = currentNode;
                        currentNode.data = next.data;
                        next.data = temp;
                    }//end if
                    currentNode = next;
                    next = next.getLinkNext();
                }//end 2nd for
            }//end first for
        }//end if
    }//end bubbleSort


}//end class LinkedList