
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
public class Producer implements Runnable
{

    BlockingQueue S1;
    BlockingQueue S2;

    public Producer(BlockingQueue S2, BlockingQueue S1)
    {
        this.S1 = S1;
        this.S2 = S2;

    }

    public void run()
    {
        while(!S1.isEmpty())
        {
           int fib1 = (int) S1.poll();
            System.out.println("Tal der skal fibbes: "+fib1);
            long fibTal = (long) fib1;
            long john = fib(fibTal);
            //System.out.println(fib1+"  .long john." + john);
            try
            {
                S2.put(john);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private long fib(long n)
    {
        if ((n == 0) || (n == 1))
        {
            return n;
        }
        else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
