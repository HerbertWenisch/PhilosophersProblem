
/**
 *
 * @author (Herbert Wenisch)
 * @version (23.11.21)
 */

public class Table {
    private final int N;
    private final boolean[] reserved; // reservierte Gabeln

    public Table(int N) {
        this.N = N;
        reserved = new boolean[N];
    }
    
    public synchronized void takeForks(int i){
        while(reserved[i] || reserved[(i+1) % N]) {
            System.out.println("Philosoph " + i + ": wartet auf Gabeln ...");
            try {wait();}
            catch (InterruptedException e){}
        }
        reserved[i] = true;
        reserved[(i+1) % N] = true;
    }
    
    public synchronized void putForks(int i){
        reserved[i] = false;
        reserved[(i+1) % N] = false;
        notifyAll();
    }
}