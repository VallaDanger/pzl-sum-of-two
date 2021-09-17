package mx.chux.cs.pzl.arrays;

import java.util.HashMap;
import java.util.Map;

import mx.chux.cs.pzl.PuzzleSolution;

public class SumOfTwo implements PuzzleSolution<int[]> {

	public static SumOfTwo inArray(final int[] array, int target, boolean isSorted) {
		return new SumOfTwo(array, target, isSorted);
	}

	final int[] array;
	final int target;
	
	final int size;
	
	final boolean isSorted;
	
	private SumOfTwo(final int[] array, final int target, boolean isSorted) {
		this.array = array;
		this.target = target;
		this.size = this.array.length;
		this.isSorted = isSorted;
	}
	
	private int get(int index) {
		return this.array[index];
	}
	
	private int subtract(int index) {
		return this.target - get(index);
	}
	
	@Override
	public int[] bruteForceSolution() {
		// time complexity: O(n^2)
		
		// scan the whole array
		for( int i = 0 ; i < this.size ; i++ ) {
			
			final int valueAtI = get(i);
			
			// starting from i, scan every element to its
			// right until the end of the array
			for( int j = i+1 ; j < this.size ; j++ ) {
				
				// if at some point the sum of current element
				// at j and element at i is equal to target,
				// then the solution has been found.
				if( (valueAtI + get(j)) == this.target ) {
					return new int[] { i, j };
				}
				
			}
			
		}
		
		return new int[0];
	}
	
	@Override
	public int[] optimalSolution() {
		return this.isSorted? sortedOptimalSolution() : nonSortedOptimalSolution();
	}
	
	// Will find if a certain number can be the 
	// result of a sum of 2 elements inside an array.
	public int[] nonSortedOptimalSolution() {
		// time complexity: O(n)
		
		// Keep track of the subtractions at each index,
		// once the algorithm finds another element which is
		// equal to a found difference, then it will yield 0
		final Map<Integer, Integer> history = new HashMap<>(this.size);
		
		// will iterate only size/2 times
		// it will approach on both sides
		for( int i = 0, j = this.size-1 ; i < j ; i++ , j-- ) {
			
			if( history.containsKey(get(i)) ) {
				return new int[] { history.get(get(i)), i };
			}
			
			history.put(subtract(i), i);
			
			if( history.containsKey(get(j)) ) {
				return new int[] { history.get(get(j)), j };
			}
			
			history.put(subtract(j), j);
		}
		
		return new int[0];
	}
	
	private int[] sortedOptimalSolution() {
		
		int left = 0;
		int right = this.size-1;
		
		while( left < right ) {
			
			final int sum = get(left) + get(right);
			
			if( sum > this.target ) {
				right -= 1;
			}
			else if( sum < this.target ) {
				left += 1;
			} else {
				return new int[] { left, right };
			}
			
		}
	
		return new int[0];
		
	}

}
