/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file Node.java
 * @description Bu class ise ignore listi tuttugum linked listin node yapisi
 * @assignment 2
 * @date 10:08:56 PM Apr 15, 2019
 * @author baris
 */
public class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

}
