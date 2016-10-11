import java.util.*;

public class TwoSumSorted {

	// find two numbers that they add up to a specific target
	// arr is sorted
	// O (nlogn) runtime, O(1) space
	// Yes we can better

	// [1, 2, 3, 4, 5]
	// return index of the found element, -1 if element is not found
	public static int binarySearch(int [] arr, int x, int lo, int hi) {

		while (lo < hi) {
			System.out.printf("Working with : low : %d, hi : %d\n", lo, hi);
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] < x ) {
				lo = mid + 1;
			} else {
				hi = mid;
			}

		}
		return -1;
	}

	public static int[] twoSum (int [] arr, int target) {
		// System.out.println("Working with : " + Arrays.toString(arr));

		for (int i = 0; i < arr.length; i++ ) {
			int x = arr[i];

			// binary search
			int j = binarySearch(arr, target - x, 0, arr.length - 1);
			if (j != -1) {
				return new int[] {j , i};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(twoSum(new int[] {1, 2, 3, 4, 5}, 6)));
		int [] arr = new int[] {1, 2, 13, 4, 26};
		System.out.println(binarySearch(arr, 5, 0, arr.length ));
		System.out.println(Arrays.toString(twoSum(arr, 27)));
	}
}

