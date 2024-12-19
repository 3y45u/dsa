package strings;

public class AreSentencesSimilar {

    public static boolean areSentencesSimilar(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if(n == m && s1.equals(s2)){
            return true;
        }


        int end_index = n < m ? n : m;

        //checking for prefix
        for(int i = 0; i < end_index; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if((c1 == ' ' && c2 != ' ') || (c1 != ' ' && c2 == ' ')){
                return false;
            }

            if((c1 != c2) && i > 0 && s1.charAt(i-1) == ' '){
                break;
            }

            if(c1 != c2 && i > 0){
                char p1 = s1.charAt(i - 1);
                char p2 = s2.charAt(i - 1);

                if(p1 != p2){
                    return false;
                }
            }

            if(c1 != c2){
                return false;
            }

        }


        // check for suffix
        int i = n - 1;
        int j = m - 1;

        while(i > end_index && j > end_index){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);

            if((c1 == ' ' && c2 != ' ') || (c1 != ' ' && c2 == ' ')){
                return false;
            }

            if(c1 != c2 && i < n && j < m && s1.charAt(i+1) != ' '){
                return false;
            }
            i--;
            j--;
        }

        return true;

        
    }

    public static void main(String[] args) {
        System.out.println(areSentencesSimilar("Are You Okay","are you okay"));
    }
    
}
