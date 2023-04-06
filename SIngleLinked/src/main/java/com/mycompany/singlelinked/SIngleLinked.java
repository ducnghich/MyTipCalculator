/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.singlelinked;

/**
 *
 * @author Duc
 */
public class SIngleLinked {

    public static void main(String[] args) {
        
        
        int n = 120;
        SinglyLinkedList numList = new SinglyLinkedList();
        SinglyLinkedList primesWith3 = new SinglyLinkedList();
        for (int i = 0; i <= n; i++) {
            if (isPrime(i)) {
                numList.append(i);
                if (String.valueOf(i).contains("3")) {
                    primesWith3.append(i);
                }
            }
        }
        System.out.println(primesWith3.sum());
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
        
        /*SinglyLinkedList numList = new SinglyLinkedList();
        Node nodeA = new Node(14);
        Node nodeB = new Node(2);
        Node nodeC = new Node(20);
        Node nodeD = new Node(31);
        Node nodeE = new Node(16);
        Node nodeF = new Node(55);
        
        
        
        numList.append(nodeA);   // Add 14
        numList.append(nodeB);   // Add 2, make the tail
        numList.append(nodeC);   // Add 20
        
        
        
        
        System.out.print("List after adding nodes: ");
        numList.printList();
}

}
*/