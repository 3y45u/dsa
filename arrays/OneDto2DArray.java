package arrays;

// Example solution to convert a 1D array into a 2D array
public class OneDto2DArray {

    public static void main(String[] args) {

        System.out.println('z'-'a');

        StringBuilder sb = new StringBuilder();
        sb.length();

        int arr[] = {1, 2, 3, 4};
        int res[][] = construct2DArray(arr, 2, 2);

        // Print the result 2D array
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {

        int[][] res = new int[m][n];
        int noOfElements = original.length;

        // Check if the total number of elements matches
        if (m * n != noOfElements) {
            return new int[0][0]; // Return an empty array if conversion is not possible
        }

        int idx = 0;

        // Correctly fill the 2D array from the 1D array
        for (int i = 0; i < m; i++) {     // Loop through rows
            for (int j = 0; j < n; j++) { // Loop through columns
                res[i][j] = original[idx];
                idx++;
            }
        }

        return res;
    }
}
