//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class Zeroes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            Node curr=null;
            while(n-->0){
                int a=sc.nextInt();
                if(head==null){
                    head=new Node(a);
                    curr=head;
                }
                else{
                    Node temp=new Node(a);
                    temp.next=null;
                    curr.next=temp;
                    curr=temp;
                }
            }
            GfG g=new GfG();
            head = g.moveZeroes(head);
            while(head!=null){
                System.out.print(head.data+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

class GfG{
    public Node moveZeroes(Node head){
      Node zerodummy = new Node(0);
      Node nonzerodummy = new Node(0);
      Node zerotail = zerodummy;
      Node nonzerotail = nonzerodummy;
      
      Node curr = head;
      while(curr != null){
          Node next = curr.next;
          if(curr.data == 0){
              zerotail.next = curr;
              zerotail = curr;
              zerotail.next = null;  
          }else{
              nonzerotail.next = curr;
              nonzerotail = curr;
              nonzerotail.next = null;
          }
          curr = next;
      }
      zerotail.next = nonzerodummy.next;
      return zerodummy.next;
    }
}



