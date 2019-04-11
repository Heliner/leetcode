import java.util.Arrays;

public class Solution869 {
    public boolean reorderedPowerOf2(int N) {
        char[] chn = String.valueOf(N).toCharArray();
        Arrays.sort(chn);
        for (int i = 0; i < 31; i++) {
            char[] chss = String.valueOf((int) Math.pow(2, i)).toCharArray();
            Arrays.sort(chss);
            if (Arrays.equals(chss, chn))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution869 solution670 = new Solution869();
        System.out.println(""+solution670.reorderedPowerOf2(Integer.MAX_VALUE));
    }
}
