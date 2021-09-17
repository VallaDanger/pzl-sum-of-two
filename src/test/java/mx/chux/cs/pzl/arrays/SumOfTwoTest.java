package mx.chux.cs.pzl.arrays;

import org.junit.Test;

import mx.chux.cs.pzl.PuzzleSolution;

import static org.assertj.core.api.Assertions.*;

public class SumOfTwoTest {
    
    @Test
    public void rightBestCaseTest() {
    	final int[] testCase = new int[] { 1, 3, 7, 4, 9, 2 };
    	final PuzzleSolution<int[]> puzzle = SumOfTwo.inArray(testCase, 11, false);
        assertThat(puzzle.optimalSolution()).containsOnly(4, 5);
    }
    
    @Test
    public void leftBestCaseTest() {
    	final int[] testCase = new int[] { 7, 4, 9, 2, 1 };
    	final PuzzleSolution<int[]> puzzle = SumOfTwo.inArray(testCase, 11, false);
        assertThat(puzzle.optimalSolution()).containsOnly(0, 1);
    }
    
    @Test
    public void emptyArrayTest() {
    	final int[] testCase = new int[0];
    	final PuzzleSolution<int[]> puzzle = SumOfTwo.inArray(testCase, 11, false);
        assertThat(puzzle.optimalSolution()).isEmpty();
    }
    
    @Test
    public void singletonArrayTest() {
    	final int[] testCase = new int[] { 11 };
    	final PuzzleSolution<int[]> puzzle = SumOfTwo.inArray(testCase, 11, false);
        assertThat(puzzle.optimalSolution()).isEmpty();
    }
    
}
