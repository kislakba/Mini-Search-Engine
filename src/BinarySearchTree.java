
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @file BinarySearchTree.java
 * @description Basitce disaridan aldigim kelimeyi data olarak tuttugum ve eger
 * datadan bir tane daha var ise fileName ile hangi klasorden geldigini bulup
 * NodeBs icindeki LinkedListe fileNameyi data olarak ekledigim bir yapi. Ayni
 * fileName geldiginde InnerNodeda tuttugum counteri arttiriyoum fakat bunu
 * InnerLinkedListte yapiyorum.
 * @assignment 2
 * @date 12:17:34 AM Apr 16, 2019
 * @author baris
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private NodeBS<T> root;

    // iterative insert method
    void insert(T newData, T fileName) {
        NodeBS<T> newNode = new NodeBS<>(newData);

        if (root == null) {
            root = newNode;
            root.ls = new InnerLinkedList<>(fileName);
        } else {
            NodeBS<T> temp = root;

            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        temp.right.ls = new InnerLinkedList<>(fileName);
                        return;
                    }

                    temp = temp.right;
                } else if (newData.compareTo(temp.data) < 0) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        temp.left.ls = new InnerLinkedList<>(fileName);
                        return;
                    }
                    temp = temp.left;
                } else if (newData.compareTo(temp.data) == 0) {
                    temp.ls.addLast(fileName);
                    return;
                } else {
                    return;
                }
            }

        }
    }
    public MaxHeap findString(String aranan){  //Heapi disaridan veriyoruz bstnin icine yazmamizin daha mantikli 
       String cumle[]=aranan.toLowerCase().split(" "); // olacagini dusundum buradan daha fazla elemana erisecegimizden
      NodeBS<T> temp = root;
       MaxHeap mh = new MaxHeap(10);
       InnerNode innerTemp;
       for(int i = 0; i<cumle.length; i++){
           if(search((T) cumle[i])){
              innerTemp = findNode((T) cumle[i]).ls.head;   //icerdeki linkedlist halihazirda kac eleman oldugunu tutuyor bunu kullaniyoruz
              while(innerTemp != null){
                  if(mh.search((String) innerTemp.fileName)){ // eger o dosyadan zaten varsa heapde sadece counterini arttiriyoruz 
                      mh.increaseKey((String) innerTemp.fileName, innerTemp.counter);
                  }else{
                      NodeHeap eklenecek = new NodeHeap((String) innerTemp.fileName, innerTemp.counter);
                      mh.insert(eklenecek);
                  }
                  innerTemp = innerTemp.next;
              }
           }
       }
       mh.heapSort();
       return mh;
    }
    // iterative search method
    boolean search(T searchData) {
        if (root == null) {
            System.out.println("empty tree !!");
        } else {
            NodeBS<T> temp = root;

            while (temp != null) {
                if (searchData.compareTo(temp.data) > 0) {
                    temp = temp.right;
                } else if (searchData.compareTo(temp.data) < 0) {
                    temp = temp.left;
                } else {
                    temp.ls.print();
                    return true;
                }
            }

        }
        return false;
    }
    NodeBS findNode(T data){
        if(root == null){
            System.out.println("Tree is empty");
        }else{
            NodeBS<T> temp = root;
            while(temp!=null){
                if(data.compareTo(temp.data)>0){
                    temp = temp.right;
                }else if(data.compareTo(temp.data)<0){
                    temp = temp.left;
                }else return temp;
            }
        }
        return null;
    }
    void preorder(PrintWriter pw) throws IOException {
        preorder(root, pw);
    }

    private void preorder(NodeBS<T> node, PrintWriter pw) throws IOException {
        if (node != null) {
            System.out.println(node.data + " ");
            pw.write(node.data + "\t" + node.ls.print() + "\n");
            preorder(node.left, pw);
            preorder(node.right, pw);

        }
    }

    void printOut(String path) throws IOException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path);
            writer.print("");
        } catch (FileNotFoundException ex) {
            System.out.println("file not exist");
        }
        preorder(writer);
        writer.close();
    }

}
