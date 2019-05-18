/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file NodeBS.java
 * @description Bu classi search treenin node yapisi olacak sekilde tasarladim
 * @assignment 2
 * @date 10:06:24 PM Apr 15, 2019
 * @author baris
 */
public class NodeBS<T extends Comparable<T>> {

    T data;
    InnerLinkedList<T> ls;
    NodeBS<T> left;
    NodeBS<T> right;

    public NodeBS(T data) {
        this.data = data;
    }

}
