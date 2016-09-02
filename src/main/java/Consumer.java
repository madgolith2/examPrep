
import java.util.concurrent.BlockingQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jakob
 */
public class Consumer implements Runnable
{

    BlockingQueue S2;

    public Consumer(BlockingQueue S2)
    {
        this.S2=S2;
    }

    public void run()
    {
        long john=0;
        while(!S2.isEmpty())
        {
            
            john = (long)S2.poll();
            System.out.println("fibbetTal: "+john);
            
        }
    }
}
