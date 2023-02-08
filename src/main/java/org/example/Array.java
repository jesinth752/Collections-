package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Center {
    int size;
    int rec[];
    private static final Logger log = Logger.getLogger("InfoLogging");

    StringBuilder show= new StringBuilder("");
    void increase(){
        int[] temp = new int[size+1];
        for(int i=0; i<size; i++){
            temp[i] = rec[i];
        }
        rec = temp;
        size++;
    }
    class Arr {
        Arr(int val) {
            rec[size-1]=val;
            int run()
            {
             return size;
            }


        }


    }
    Center()
    {
       size=0;
    }
    void insert(int val)
    {
        increase();
        Arr a1=new Arr(val);
        a1.run();
    }
    void display()
    {
        if(rec.length!=0) {
            for (int i = 0; i < rec.length; i++) {

                show.append(" " + rec[i] + " ");


            }
            String sp=show.toString();
            log.info(sp);
            show.delete(0, sp.length());
        }
        else
        {
            log.info("Array is Empty");
        }
    }
    void remove()
    {
        if(rec.length!=0) {
            int[] rem = new int[size - 1];
            for (int i = 0; i < size - 1; i++) {
                rem[i] = rec[i];
            }
            rec = rem;
            size--;
        }
        else
        {
            log.info("Array is Empty - Pop operation fails");
        }
    }
    void insertAtPos(int pos ,int val)
    {
        increase();
        for(int i= rec.length-1;i>=pos;i--)
        {
          rec[i]=rec[i-1];
        }
        rec[pos]=val;
    }
     void rotation(int k)
     {
         int dum;
         int j;
         for(int i=0;i<k;i++)
         {
             dum=rec[0];
             for(j=0;j< rec.length-1;j++)
             {
                 rec[j]=rec[j+1];
             }
             rec[j]=dum;
         }
     }

}
public class Array {
    private static final Logger log = Logger.getLogger("InfoLogging");
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int opt;
        int value;
        int pos;
        int k;
        Center c=new Center();

        do {
            log.info("\n1.Insert\n2.Display\n3.Pop\n4.Insert At Position\n5.Rotate the Array\n6.Exit");
            log.info("Enter option:");
            opt=input.nextInt();
            if(opt!=6) {
                switch (opt) {


                    case 1:
                        log.info("Enter value to Insert:");
                        value = input.nextInt();
                        c.insert(value);
                        break;

                    case 2:
                        c.display();
                        break;
                    case 3:
                        c.remove();
                        break;
                    case 4:
                        log.info("Enter Position:");
                        pos = input.nextInt();
                        log.info("Enter value to Insert:");
                        value = input.nextInt();
                        c.insertAtPos(pos, value);
                        break;
                    case 5:
                        log.info("Enter Number of Times:");
                        k = input.nextInt();
                        c.rotation(k);
                        break;
                    default:
                        log.info("invalid choice");
                }
            }
        }while (opt!=6);
    }

}
