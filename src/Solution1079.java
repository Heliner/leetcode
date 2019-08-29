public class Solution1079 {
    static class Solution {
        int A = 'A';

        int res = 0;
        int[] count;

        public int numTilePossibilities(String tiles) {
            count = new int[255];
            for (int i = 0; i < tiles.length(); i++) {
                count[tiles.charAt(i)]++;
            }
            for (int i = 1; i <= tiles.length(); i++)
                res+=hp(i, "");
            return res;
        }

        private int hp(int left, String s) {
            int tr = 0;
            if (left == 0) {
                System.out.println(s);
                return 1;
            }
            for(int k =A ; k < A+26 ; k++){
                if(count[k] > 0){
                    count[k]--;
                    tr+=hp(left-1,s+""+((char)k));
                    count[k]++;
                }
            }
            return tr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1079.Solution();
        System.out.println(solution.numTilePossibilities("AAABBC"));
    }
}