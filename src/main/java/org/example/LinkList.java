package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class LinkedListi {

    Node head;
    int ind=0;
    StringBuilder dis= new StringBuilder("");
    String indx;

    private static final Logger log = Logger.getLogger("InfoLogging");
    class Node {
        int data;
        Node next;
        Node(int val)
        {
            data=val;
            next=null;
        }

    }
    LinkedListi()
    {
        head=null;

    }
    void insertElement(int val)
    {
        Node n1 = new Node(val);
        Node temp=head;

        if(head==null)
        {
            head=n1;
        }
        else
        {

            while (temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=n1;



        }
    }
    void insertElementBegining(int val)
    {
        Node n1 = new Node(val);
        if(head==null)
        {
            head=n1;
        }
        else
        {
            n1.next=head;
            head=n1;
        }
    }
    void insertElementIndex(int pos,int val)
    {
        if(pos==0)
        {
            insertElementBegining(val);
            return;
        }
        Node n1 = new Node(val);
        Node temp=head;
        for(int i=1;i<pos;i++)
        {
            temp=temp.next;
        }
        n1.next=temp.next;
        temp.next=n1;

    }
    int  maximum()
    {
        Node temp=head;
        Node f=temp;
        while (temp!=null)
        {
            if(f.data< temp.data)
            {
                f.data= temp.data;
            }
            temp=temp.next;
        }
        return f.data;
    }
    int  minimum()
    {
        Node temp=head;
        Node f=temp;
        while (temp!=null)
        {
            if(f.data>temp.data)
            {
                f.data= temp.data;
            }
            temp=temp.next;
        }
        return f.data;
    }
    void valueFind(int val)
    {

        Node temp=head;
        ind=0;

        while (temp!=null)
        {
            if(temp.data==val)
            {
                break;
            }
            ind++;
            temp=temp.next;
        }
        indx="Index of "+val+" is "+ind;
        log.info(indx);

    }
    void deleteAtPos(int pos)
    {
        Node temp=head;
        Node previous=temp;
        for(int i=1;i<=pos;i++)
        {
            previous=temp;
            temp=temp.next;

        }
        previous.next=temp.next;

    }
    void remove()
    {
        Node temp=head;
        Node previous=temp;
        while (temp.next!=null)
        {
            previous=temp;
            temp=temp.next;
        }
        previous.next=temp.next;
    }
    void display()
    {

        Node temp=head;
        while (temp!=null)
        {
            dis.append(" "+temp.data+" ");
            temp=temp.next;
        }
        String r=dis.toString();

        log.info(r);
        dis.delete(0,r.length());
    }
}
public class LinkList {
    private static final Logger log = Logger.getLogger("InfoLogging");
    public static void main(String[] args) {
        LinkedListi list1=new LinkedListi();
        Scanner sc=new Scanner(System.in);
        int opt;
        int val;
        int pos;
        do{
            log.info("\n1.insert\n2.insert begining \n3.insert at index \n4.display\n5.Maximum in LL\n6.Minimun in LL \n7.Finding Position of the value\n8.Delete At Position\n9.Pop\n10.Exit");
            log.info("enter option:");
            opt=sc.nextInt();
            if(opt!=10) {
                switch (opt) {
                    case 1:
                        log.info("Enter value to insert");
                        val = sc.nextInt();
                        list1.insertElement(val);
                        break;
                    case 2:
                        log.info("Enter value to insert");
                        val = sc.nextInt();
                        list1.insertElementBegining(val);
                        break;
                    case 3:
                        log.info("enter index :");
                        pos = sc.nextInt();
                        log.info("enter value:");
                        val = sc.nextInt();
                        list1.insertElementIndex(pos, val);break;
                    case 4:
                        list1.display();
                        break;
                    case 5:
                        String max="Maximum element in list:" + list1.maximum();
                        log.info(max);
                        break;
                    case 6:
                        String min="Minimum element in list:" + list1.minimum();
                        log.info(min);
                        break;
                    case 7:
                        log.info("Enter the value:");
                        val = sc.nextInt();
                        list1.valueFind(val);
                        break;
                    case 8:
                        log.info("Enter position to Delete");
                        pos = sc.nextInt();
                        list1.deleteAtPos(pos);
                        break;
                    case 9:
                        list1.remove();
                        break;
                    default:
                        log.info("Invalid option");


                }
            }
        }while (opt!=10);



    }
}