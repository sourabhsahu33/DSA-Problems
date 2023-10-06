//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
   public static void rearrange(Node odd)
    {
        if(odd.next == null){
            return;
        }
        // add your code here
        Node alt = null;
        Node current = odd;
        Node prev = null;
        while(current!= null&& current.next!=null){
            //maintain a previous so that we can attach alt list to it later
            prev=current;
            Node future = current.next;
            //Always take current to odd nodes and use current.next in alt list
            current.next = future.next;
            //Keep reversing alt list
            future.next = alt;
            alt=future;
            current =current.next;
           }
        if(prev != null && prev.next != null){
            prev.next.next=alt;
        }
        else{
              prev.next= alt;
        }
        
    }
}
