
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jakob
 */
public class Initializer
{

    public static void main(String[] args) throws InterruptedException
    {

        BlockingQueue S1 = new ArrayBlockingQueue(11);
        BlockingQueue S2 = new ArrayBlockingQueue(11);
        try
        {
            S1.put(4);
            S1.put(5);
            S1.put(8);
            S1.put(12);
            S1.put(21);
            S1.put(22);
            S1.put(34);
            S1.put(35);
            S1.put(36);
            S1.put(37);
            S1.put(42);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("How many threads would you like to use mayt?");
        int nrOfThreads = scn.nextInt();
        ArrayList<Thread> threads = new ArrayList();

        for (int i = 0; i < nrOfThreads; i++)
        {
            Thread t = new Thread(new Producer(S2, S1));
            threads.add(t);
            threads.get(i).start();

        }
        boolean driven = false;
        
        while (!driven)
        {
            while (!S2.isEmpty())
            {
                //System.out.println(""+S2.size());
                if (S2.size() >= 11)
                {

                    Thread c = new Thread(new Consumer(S2));
                    c.start();
                    c.join();
                    driven = true;
                }

            }
        }

    }

}
