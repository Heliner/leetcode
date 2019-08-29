import today.TreeNode;

public class Solution1078 {
    static class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            String[] ts = text.trim().replaceAll(" +", " ").split(" ");
            String res = "";
            for(int i =0 ; i <= ts.length-3; i++){
                if(ts[i].equals(first)&&ts[i+1].equals(second))
                    res+=ts[i+2]+" ";
            }
            if("".equals(res))
                return new String[0];

            return res.split(" ");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1078.Solution();
        System.out.println();
    }
}