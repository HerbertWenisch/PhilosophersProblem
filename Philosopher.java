

/**
 * @author (Herbert Wenisch)
 * @version (23.11.21)
 */

import java.util.Random;

public class Philosopher extends Thread {
    private final int nr;
    private final Table table;
    private final Random random = new Random();

    public Philosopher(int nr, Table table) {
        this.nr = nr;
        this.table = table;
    }
    
    
    private void thinking(){
        long time = (long)random.nextInt(400);
        System.out.println("Philosoph " + nr + ": denkt nach ...");
        nap(time);
    }
    
    private void eating(){
        long time = (long)random.nextInt(100);
        System.out.println("Philosoph " + nr + ": isst ...");
        nap(time);
        System.out.println("Philosoph " + nr + ": hat fertig gegessen");
    }
    
    @Override
    public void run(){
        for(int i = 8; i>0; i--){
            thinking();
            table.takeForks(nr);  // sleeping, if impossible
            eating();
            table.putForks(nr);   // sleeping philosophers are woken up
        }
    }
    
    
    private void nap(long ms){
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException e) {}
    }
}
