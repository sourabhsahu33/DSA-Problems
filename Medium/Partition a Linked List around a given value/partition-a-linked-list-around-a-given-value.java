//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node head, int x) {

        /* Let us initialize first and last nodes of
          three linked lists
            1) Linked list of values smaller than x.
            2) Linked list of values equal to x.
            3) Linked list of values greater than x.*/
        Node smallerHead = null, smallerLast = null;
        Node greaterLast = null, greaterHead = null;
        Node equalHead = null, equalLast = null;

        // Now iterate original list and connect nodes
        // of appropriate linked lists.
        while (head != null) {
            // If current node is equal to x, append it
            // to the list of x values
            if (head.data == x) {
                if (equalHead == null)
                    equalHead = equalLast = head;
                else {
                    equalLast.next = head;
                    equalLast = equalLast.next;
                }
            }

            // If current node is less than X, append
            // it to the list of smaller values
            else if (head.data < x) {
                if (smallerHead == null)
                    smallerLast = smallerHead = head;
                else {
                    smallerLast.next = head;
                    smallerLast = head;
                }
            } else // Append to the list of greater values
            {
                if (greaterHead == null)
                    greaterLast = greaterHead = head;
                else {
                    greaterLast.next = head;
                    greaterLast = head;
                }
            }

            head = head.next;
        }

        // Fix end of greater linked list to null if this
        // list has some nodes
        if (greaterLast != null) greaterLast.next = null;

        // Connect three lists

        // If smaller list is empty
        if (smallerHead == null) {
            if (equalHead == null) return greaterHead;
            equalLast.next = greaterHead;
            return equalHead;
        }

        // If smaller list is not empty
        // and equal list is empty
        if (equalHead == null) {
            smallerLast.next = greaterHead;
            return smallerHead;
        }

        // If both smaller and equal list
        // are non-empty
        smallerLast.next = equalHead;
        equalLast.next = greaterHead;
        return smallerHead;
    }
}