import java.util.*;

public class TwoSum {

	// find two numbers that they add up to a specific target
	// O(n^2) sucks
	// Yes we can better
	// this takes O(n) runtime, O(n) space	
	public static int[] twoSum (int [] arr, int target) {
		System.out.println("Working with : " + Arrays.toString(arr));
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++ ) {
			int x = arr[i];
			if (map.containsKey(target - x)) {
				return new int[] {map.get(target - x) + 1 , i + 1};
			}
			map.put(x,i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] {1, 2, 3, 4, 5}, 6)));
	}
}

