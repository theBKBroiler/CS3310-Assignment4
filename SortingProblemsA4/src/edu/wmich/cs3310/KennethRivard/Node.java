package edu.wmich.cs3310.KennethRivard;

import sun.awt.AWTAccessor;

/**
 * Created by Kenneth Rivard on 11/2/16.
 */

public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {

    protected E data;
    protected Node next;
    protected Node prev;

    /*Initialize Node*/
    public Node(E obj) {
        this.data = obj;
        next = null;
    }//end Node()

    /*Assign data and next variables*/
    public Node(E d, Node n, Node p) {
        data = d;
        next = n;
        prev = p;
    }//end Node(d, n)

    /*increment along the linked list*/
    public Node<E> getLinkNext() {
        return next;
    }//end getLinkNext

    public void setLinkNext(Node n) {
        next = n;
    }

    public Node getLinkPrev() {
        return prev;
    }

    public void setLinkPrev(Node p) {
        prev = p;
    }

    /*fetched elements from the linked list*/
    public E getData() {
        return data;
    }//end getData()

    public void setData(E d) {
        data = d;
    }

    @Override
    public int compareTo(Node<E> eNode) {
        return 0;
    }

}//end class Node
