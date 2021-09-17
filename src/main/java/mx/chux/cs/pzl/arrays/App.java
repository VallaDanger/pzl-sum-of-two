package mx.chux.cs.pzl.arrays;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    
    public static void main( String[] args ) {
    	
    	final int[] array = new int[] { 1, 2, 3, 4, 7, 9 };
	    
	    final Instant start = Instant.now();
	    final int[] answer = SumOfTwo.inArray(array, 11, true).optimalSolution();
    	final Instant finish = Instant.now();
    	long timeElapsed = Duration.between(start, finish).toMillis();
		
    	LOGGER.log(Level.INFO, "SumOfTwo [ time: {0} ]: {1}", new Object[] { timeElapsed, Arrays.toString(answer) });
	    
    }
    
}
