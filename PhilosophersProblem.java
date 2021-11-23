
/**
 * main class:
 *
 * @author (Herbert Wenisch)
 * @version (23.11.21)
 */

public class PhilosophersProblem {
    private final int N = 5;
    private final Table table = new Table(N);
    private final Philosopher[] philosophers = new Philosopher[N];
    
    public PhilosophersProblem(){
        for(int i = 0; i < N; i++){
            philosophers[i] = new Philosopher(i, table);
        }
    }
    
    public void test(){
        for(int i = 0; i < N; i++){
            philosophers[i].start();
        }
    }
    
}