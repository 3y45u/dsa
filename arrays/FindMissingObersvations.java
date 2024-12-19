package arrays;

public class FindMissingObersvations {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int[] res = missingRolls(arr, 6, 4);

        for (int i : res) {
            System.out.println(i);
        }

    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        // n diya hua hai
        // or kyunki rolls me utne obersvations hai jitne hume pata hai. to ye m observations hai

        int m = rolls.length;

        // n or m dono mil gaye to total obs n + m 
        // inka mean bhi diya hua hai: mean = totalSum / (n+m);
        int totalSum = mean * (n + m);

        // ab hum m observations ka sum nikal lete hai
        int mSum = 0;

        for (int i : rolls) {
            mSum += i;
        }

        // total bhi hai or mSum bhi hai to nSum ya missing sum nikal jayega
        int nSum = totalSum - mSum; // missing sum

        // ab ye sum humko pehle check krna hai ki hum n observations me distribute kr skte hai ya nhi
        // kyuki dice ka sabse chota number 1 hai, or agar 1 n times aya hoga to distribute ho jayega
        // n se kam hota to nhi distribute kr skte
        // similarly agar 6 number dice ka n times aa jata to 6 * n hona hai, isse jada hoga fir bhi/
        // distribute ni krskte
        if (nSum < n || nSum > 6 * n) {
            return new int[0]; // empty array bhej do kyunki distribute ni kr skte
        }

        // agar distribute kr ske
        // to pehle to nSum ko 6 parts me divide krna hai
        int parts = nSum / n;

        // agr number bach rahe hai. to remaining part bhi equally distribute kr denge 1 1 krke
        int rem = nSum % n;

        // ab inhe distribute krte hai n times
        int res[] = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = parts + (i < rem ? 1 : 0);
        }

        return res;
    }
}
