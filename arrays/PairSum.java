package arrays;

public class PairSum {

    public static int pairsum(int[] arr) {
        // code here

        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > largest) {
                second_largest = largest;
                largest = i;
            } else if (i > second_largest && i < largest) {
                second_largest = i;
            }
        }

        return largest + second_largest;
    }

    public static void main(String[] args) {
        int[] ar = {9, 1, 2, 3, 4, 5, 6, 7, 8};

        int sum = pairsum(ar);

        System.out.println(sum);
    }
}
