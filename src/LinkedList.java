/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file LinkedList.java
 * @description Bu linkedList ignore listin tutulmasi icin yapildi
 * @assignment 2
 * @date 12:02:52 AM Apr 16, 2019
 * @author baris
 */
public class LinkedList<T> {

    private Node<T> head;

    void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    boolean isHere(T data) {
        if (head == null) {
            System.out.println("empty list !");
        } else {
            if (head.data.equals(data)) {
                return true;
            } else {
                Node<T> temp = head.next;
                Node<T> prev = head;

                while (temp != null && !temp.data.equals(data)) {
                    prev = temp;
                    temp = temp.next;
                }

                if (temp != null) {
                    return true;
                } 
            }
        }
        return false;
    }

    void print() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
