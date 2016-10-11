public class UniquePaths {

	// backtracking using a dynamic programming (DP) technique called memoization
	private int backtrack(int r, int c, int m, int n, int[][]mat) {
		if (r == m - 1 && c == n - 1)
			return 1;
		if (r >= m || c >= n)
			return 0;
		if (mat[r + 1][c] == -1 )
			mat[r + 1][c] = backtrack(r + 1, c, m, n, mat);

		if (mat[r][c + 1] == -1 )
			mat[r][c + 1] = backtrack(r, c + 1, m, n, mat);

		return mat[r + 1][c] + mat[r][c + 1];
	}

	public int uniquePaths(int m, int n) {
		int mat[][] = new int [m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0 ; j < n + 1 ; j++ ) {
				mat[i][j] = -1;
			}
		}

		return backtrack(0, 0, m, n, mat);
	}

	public int uniquePathsBottomUp(int m, int n) {
		int mat[][] = new int [m + 1][n + 1];
		mat[m - 1][n] = 1;
		mat[m][n - 1] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1 ; j >= 0 ; j-- ) {
				mat[i][j] = mat[i + 1][j] + mat[i][j + 1];
			}
		}
		print (mat, m , n);
		return mat[0][0];
	}

	public void print (int mat[][], int m, int n) {
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0 ; j < n + 1 ; j++ ) {
				System.out.printf("%5d", mat[i][j]);
			}
			System.out.println("");
		}
	}


	public static void main(String[] args) {
		// assert new UniquePaths().uniquePaths(2, 2) == 2;
		// assert new UniquePaths().uniquePaths(2, 3) == 3;
		// assert new UniquePaths().uniquePaths(3, 7) == 28;
		// assert new UniquePaths().uniquePathsBottomUp(2, 2) == 2;
		// assert new UniquePaths().uniquePathsBottomUp(2, 3) == 3;
		assert new UniquePaths().uniquePathsBottomUp(3, 7) == 28;
	}

}

