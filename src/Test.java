
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @file Test.java
 * @description Test Class
 * @assignment 2
 * @date 10:18:41 PM Apr 15, 2019
 * @author baris
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String ignorePath = "belgeler/ignoreList.txt";
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        Scanner sc1 = null;
        Scanner sc2 = null;
        LinkedList<String> ignoreList = new LinkedList<>();
        try {
            sc1 = new Scanner(new File(ignorePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Scanner yardimi ile bosluk bosluk metni okuyorum
        //ve okurken ayni zamanda ignoreListimi LinkedListte olusturuyorum
        while (sc1.hasNextLine()) {
            Scanner s1 = new Scanner(sc1.nextLine());
            while (s1.hasNext()) {
                String s = s1.next();
                ignoreList.addLast(s);

            }
        }
        ignoreList.addLast(",");
        ignoreList.addLast(".");
        //Manuel olarak metinlerde bulunan noktalama isaretlerini kaldiriyorum
        //dosya adlarinin son 3hanesinden yararlanarak belgeler icinde bulunan
        //501-510 dosyalarini sirasiyla donuyorum ve treeme ekliyorum
        for(int counter = 501; counter < 511; counter++){
        try {
            sc2 = new Scanner(new File("belgeler/cse22"+counter+".html"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                if (s.startsWith("<")) {
                    continue;
                }
                if (ignoreList.isHere(s)) {
                    continue;
                }
                bst.insert(s, "belgeler/cse22"+counter+".html");
            }
        }
        }
        //istedigimiz yolu belirtip cikti aliyoruz yolun sonundaki dosya 
        //bulunmuyor bile olsa PrintWriter onu otomatikmen olusturuyor
        //bst.printOut("belgeler/cikti.txt");
        MaxHeap mh =  bst.findString("boundary body basis");
        mh.print();
    }
}
