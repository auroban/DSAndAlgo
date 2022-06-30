package org.example.auro.leetcode.hard.designATextEditor;

class Node {

    private final Character value;
    private Node prev;
    private Node next;

    Node(final Character c) {
        value = c;
    }

    public Character getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(final Node next) {
        this.next = next;
    }

    public void setPrev(final Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return " [ " + value + " ] ";
    }
}
