package arrays;

public class LC2940 {

    public static void main(String[] args) {

        int[][] queries = {{0,1},{0,3},{2,4},{3,4},{2,2}};

        int[] he = {6,4,8,5,2,7};

        int[] res = leftmostBuildingQueries(he, queries);

        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }

        
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        int k = heights.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int[] query = queries[i];

            int x = query[0];
            int y = query[1];

            if(x == y){
                res[i] = x;
                continue;
            }

            if(heights[y] > heights[x]){
                int nextGreater = -1;
                for(int j = y + 1; j < k - 1; j++){
                    if(heights[j] > heights[y]){
                        nextGreater = j;
                        break;
                    }
                }
                res[i] = nextGreater;
                continue;
            }

            if(heights[x] > heights[y]){
                int nextGreater = -1;
                for(int j = y + 1; j < k - 1; j++){
                    if(heights[j] > heights[x]){
                        nextGreater = j;
                        break;
                    }
                }
                res[i] = nextGreater;
                continue;
            }
        }

        return res;
        
    }
    
}
