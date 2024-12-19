import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveMethod {
    // sieve method use hota hai prime numbers find karne ke liye
    // TC : O(n(log(log(n))))

    // n is the given number, upto which we need to find all the prime numbers
    public static List getAllPrimes(int n) {

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // initially all numbers are marked as prime, going futher we'll sieve the prime numbers

        isPrime[0] = false;
        isPrime[1] = false;

        // i <= sqrt(n) , because all the contributing factors are present before the sqrt of n
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {// agar i prime hai to iske sare factos non prime mark krne hai, this is sieving the numbers
                for (int j = 2; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> primes = getAllPrimes(170);
        System.out.println(primes.toString());
        System.out.println(Long.MAX_VALUE);
        int[][] pair = {{0,1}};
        System.out.println(pair[0]);
    }
}
