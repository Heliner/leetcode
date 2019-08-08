
public class Solution1108 {
    static class Solution {
        public String defangIPaddr(String address) {
            String ad = address;
            ad = ad.replaceAll("\\.", "[.]");
            return ad;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1108.Solution();
        System.out.println(solution.defangIPaddr("1.1.1.1")
        );
    }
}
