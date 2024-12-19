package arrays;

public class FindTwoElements {

    public static void main(String[] args) {
        int[] res = findTwoElement(new int[]{1, 3, 3, 4, 5});
        System.out.println("Repeating element: " + res[0]);
        System.out.println("Missing element: " + res[1]);
    }

    public static int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int xor = 0;

        // XOR all elements of the array
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }

        // XOR all elements from 1 to n
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        // Now xor contains A ^ B, where A is the repeating and B is the missing element.
        // Find the rightmost set bit (where A and B differ)
        int setBit = xor & ~(xor - 1);

        // Initialize variables to hold two distinct sets
        int x = 0; // One of A or B
        int y = 0; // The other one of A or B

        // Split the elements in arr and numbers from 1 to n into two sets
        for (int i = 0; i < n; i++) {
            if ((arr[i] & setBit) != 0) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        // Now we have two candidates x and y, but we don't know which is the repeating and which is the missing
        int[] res = new int[2];
        // Check which one is missing and which is repeating by scanning the array
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                res[0] = x; // x is the repeating element
                res[1] = y; // y is the missing element
                break;
            } else if (arr[i] == y) {
                res[0] = y; // y is the repeating element
                res[1] = x; // x is the missing element
                break;
            }
        }

        return res;
    }
}
