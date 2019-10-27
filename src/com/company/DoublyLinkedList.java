package com.company;

public class DoublyLinkedList {
    static class DlinkedNode {
        String name;
        int id;
        DlinkedNode next;
        DlinkedNode prev;
    }
    DlinkedNode head;
    DlinkedNode tail;
    DoublyLinkedList() {
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    public void addNode(DlinkedNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

    }
    public void removeNode(DlinkedNode node) {
        DlinkedNode next = node.next;
        DlinkedNode prev = node.prev;

        next.prev = prev;
        prev.next = next;
    }
    public void setHead(DlinkedNode node) {
        removeNode(node);
        head.next = node;
        head = node;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        DlinkedNode n1 = new DlinkedNode();
        n1.name = "Nupur";
        n1.id = 1;
        DlinkedNode n2 = new DlinkedNode();
        n2.name = "Hitesh";
        n2.id = 2;
        DlinkedNode n3 = new DlinkedNode();
        n3.name = "John";
        n3.id = 3;
        dll.addNode(n1);
        dll.addNode(n2);
        dll.addNode(n3);

    }
}
