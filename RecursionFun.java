/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Benjamin Millerd
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (n > k) {

		}
		if (n == k || k == 0) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	private int count = 0;

	public String intWithCommas(int n) {
		if (count == 3) {
			count = 0;
			return intWithCommas(n) + ",";
		}
		if (n > 9) {
			count++;
			return "" + intWithCommas(n / 10) + n % 10;
		} else {
			return "" + n;
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index == len || index > len) {
			return;
		} else {
			int temp = x[index];
			x[index] = x[len - 1];
			x[len - 1] = temp;
			reverseArray(x, index + 1, len - 1);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int index = 0;
		int max = a[index];
		int min = a[index];
		return rangeget(a, index, max, min);
	}

	private int rangeget(int[] a, int index, int max, int min) {
		if (index == a.length) {
			return max - min;
		} else {
			if (a[index] < min) {
				min = a[index];
			}
			if (a[index] > max) {
				max = a[index];
			}
			return rangeget(a, index + 1, max, min);
		}
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length <= 1) {
			return true;
		} else {
			int start = nums[0];
			int index = 1;
			return nextnum(nums, start, index);
		}
	}

	private boolean nextnum(int[] nums, int prev, int i) {
		if (nums.length - 1 == i) {
			return nums[i] >= prev;
		} else {
			return nums[i] >= prev && nextnum(nums, nums[i], i + 1);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		int i = 0;
		return lookup(search, strs, i);
	}

	private boolean lookup(String s, String[] strs, int i) {
		if (strs.length - 1 == i) {
			return s.equals(strs[i]);
		} else {
			return s.equals(strs[i]) || lookup(s, strs, i + 1);
		}
	}
}
