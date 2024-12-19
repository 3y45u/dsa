package arrays;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] arr = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 30;

        System.out.println(binarySearch(arr, target));

        System.out.println(binarySearchOptimised(arr, target));
    }

    // O(log(m+n))
    public static boolean binarySearchOptimised(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            }

            if (current > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;

    }

    // O(log(m * n))
    public static boolean binarySearch(int[][] matrix, int target) {
        // Matrix dimensions
        int row = matrix.length;
        int col = matrix[0].length;

        // Left and right pointers for binary search
        int l = 0;
        int r = row * col - 1;

        // Perform binary search
        while (l <= r) {
            // Calculate mid-point index in a flattened perspective
            int mid = l + (r - l) / 2;

            // Map 1D index to 2D row and column
            int curRow = mid / col;
            int curCol = mid % col;
            int element = matrix[curRow][curCol]; // Current element at mid-point

            // Check if mid element is the target
            if (element == target) {
                return true; // Target found
            }

            // Move search to right half if element < target
            if (element < target) {
                l = mid + 1;
            } // Move search to left half if element > target
            else {
                r = mid - 1;
            }
        }
        return false;

    }
}
