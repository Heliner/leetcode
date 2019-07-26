public class Solution567 {
   static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            //s2 contains s1 s1.length() <= s2.length();
            //1->0 change require 0->-1 no change >0 || 1->2 change 0>1 change -1>0 no change
            if(s1.length() > s2.length())
                return false;
            //窗口大小固定
            int sw,res,require,l;
            char[] chs2 = s2.toCharArray();
            require =0;l=0;
            sw = s1.length();

            int[] dict = new int[26];
            boolean[] exist = new boolean[26];
            for(char c : s1.toCharArray()){
                dict[c-'a']++;
                exist[c-'a']=true;
                require++;
            }

            for(int i =0 ; i < sw ; i++){
                if(dict[chs2[i]-'a']-- > 0 &&exist[chs2[i]-'a'])
                    require--;
            }
            if(require == 0)
                return true;



            for(int i = sw ; i < s2.length() ; i++){
                char c = chs2[i];
                if(dict[c-'a']-- > 0&& exist[c-'a'])
                    require--;
                if(dict[chs2[i-sw]-'a']++ >= 0&&exist[chs2[i-sw]-'a'])
                    require++;
                System.out.println(require);
                if(require == 0)
                    return true;
            }
            return false;

        }
    }

    public static void main(String[] args) {
       Solution solution = new Solution567.Solution();
       solution.checkInclusion("bbc","bbacba");
    }
}
