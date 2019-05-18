/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file MaxHeap.java
 * @description Programınızın açıklaması ne yaptığına dair.
 * @assignment Kaçıncı ödev olduğu
 * @date 11:38:59 PM May 14, 2019
 * @author baris
 */
public class MaxHeap {
    private NodeHeap[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new NodeHeap[capacity];
        size = 0;
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private void swap(int i, int j){
        NodeHeap temp = heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    void insert(NodeHeap data){
        if(size<heap.length){
            heap[size]=data;
            int current = size++;
            
            while(heap[current].counter<heap[parent(current)].counter){
                swap(current,parent(current));
                current=parent(current);
            }
        }else{
            System.out.println("Array Is Full");
        }
    }
    boolean search(String docName){
        for (int i = 0; i < size; i++) {
            if(heap[i].docName.equals(docName)){
                return true;
            }
        }
        return false;
    }
    NodeHeap find(String docName){
        for (int i = 0; i < size; i++) {
            if(heap[i].docName.equals(docName)){
                return heap[i];
            }
        }
        return null;
    }
    void heapify(){
        int lastIndex = size-1;
        for(int i=parent(lastIndex); i>=0;i--){
            minHeap(i);
        }
    }
    private void minHeap(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int min =i;
        if(left<size && heap[min].counter>heap[left].counter){
            min=left;
        }
        if(right<size&&heap[min].counter>heap[right].counter){
            min=right;
        }
        if(min!=i){
            swap(min,i);
            minHeap(min);
        }
        
    }
    void print(){
        for (int i=0;i<heap.length;i++) {
            if(heap[i]==null){
                break;
            }
            System.out.print(heap[i].docName+ "(" + heap[i].counter +") -> ");
        }
        System.out.println("");
    }
    void heapSort(){
        heapify();
        int lastIndex = size -1;
        for(int i= lastIndex; i>0;i--){
            swap(0,i);
            size--;
            minHeap(0);
        }
    }
    void increaseKey(String docName, int artis) {
        for (int i = 0; i < size; i++) {
            if (((NodeHeap)heap[i]).docName.equals(docName)) {
               ((NodeHeap) heap[i]).counter+=artis;
                minHeap(i);
                return;
            }
        }
    }
    

}
