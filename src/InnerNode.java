/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file InnerNode.java
 * @description BST'ye ekledigim nodeda bulunan LinkedListin Nodeu olarak bu 
 * yapiyi tercih ettim file name data olarak saklanıyor ve ayni kelime ayni 
 * filedan gelirse counter arttiriliyor.
 * @assignment 2
 * @date 12:18:30 AM Apr 16, 2019
 * @author baris
 */
public class InnerNode<T> {

    T fileName;
    int counter = 1;
    InnerNode<T> next;

    public InnerNode(T data) {
        this.fileName = data;
        this.counter = 1;
        this.next = null;
    }
}
