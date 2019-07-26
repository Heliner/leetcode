import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution17 {
    static
    class Solution {
        Map<Integer,String> map = new HashMap();
        public List<String> letterCombinations(String digits) {
            List<String> res = new LinkedList<>();
            if(digits.length() == 0)
                return res;
            map.put(2,"abc");map.put(3,"def");map.put(4,"ghi");map.put(5,"jkl");map.put(6,"mno");map.put(7,"pqrs");map.put(8,"tuv");
            map.put(9,"wxyz");

            dfs(digits,0,res,"");
            return res;
        }
        //有序的
        private void dfs(String digits, int index , List<String> res, String temp ){
            if(index >= digits.length()){
                res.add(temp);
                return;
            }
            for(char ch : map.get(Integer.valueOf(digits.charAt(index)-'0')).toCharArray()){
                dfs(digits,index+1,res,temp+String.valueOf(ch));
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution17.Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}
