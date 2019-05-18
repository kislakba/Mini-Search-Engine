/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file InnerLinkedList.java
 * @description BST'nin Nodelarinin ic linkedListinin yapisidir burada amac 
 * ayni dosyadan geliyorsa counteri arttir gelmiyorsa sonuna ekleme yapmaktir.
 * @assignment 2
 * @date 12:18:59 AM Apr 16, 2019
 * @author baris
 */
public class InnerLinkedList<T> {

    InnerNode<T> head;

    public InnerLinkedList(T fileName) {
        this.head = new InnerNode<>(fileName);
    }

    void addLast(T fileName) {
        InnerNode<T> newNode = new InnerNode<>(fileName);

        if (isHere(fileName)) {
                //isHere metodu True donerse zaten icerisinde deger arttirma 
            //islemi yaptigindan ekstra isleme gerek duymuyorum false dondugu
            //taktirde kendisi listenin sonuna yeni dosyadan gelen sonucu ekleyecek
        } else {
            if (head == null) {
                head = newNode;
            } else {
                InnerNode<T> temp = head;

                while (temp.next != null) {
                    temp = temp.next;
                }

                temp.next = newNode;
            }
        }
    }

    boolean isHere(T fileName) {
        if (head == null) {
            System.out.println("empty list !");
        } else {
            if (head.fileName.equals(fileName)) {
                head.counter++;
                return true;
            } else {
                InnerNode<T> temp = head.next;
                InnerNode<T> prev = head;

                while (temp != null && !temp.fileName.equals(fileName)) {
                    prev = temp;
                    temp = temp.next;
                }

                if (temp != null) {
                    temp.counter++;
                    return true;
                }
            }
        }
        return false;
    }

    String print() {
        InnerNode<T> temp = head;
        String s;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.fileName + "(" + temp.counter + ") -> ");
            temp = temp.next;
        }
        sb.append(" null");
        s = sb.toString();
        return s;
    }
}
