public class BinarySearch {

	// Given a sorted array and a target value, return the index if the target is found
	//  If not, return the index where it would be if it were inserted in order.
	public  static int searchInsert(int[] nums, int target) {
		int i = 0, j = nums.length - 1 ;
		
		while (i < j) {
			
			int m = (j + i) / 2 ;

			if (nums[m] < target ) {
				i = m + 1 ;
			} else {
				j = m;
			}
		}
		return (nums[i] < target) ? i + 1 : i;
	}

	public static void main(String [] args) {
		assert searchInsert(new int [] {1, 3, 5, 7}, 5) == 2;
		assert searchInsert(new int [] {1, 3, 5, 7}, 6) == 3;
		assert searchInsert(new int [] {1, 1, 1, 3, 3, 3, 3, 3, 3, 5}, 6) == 10;
	}
}