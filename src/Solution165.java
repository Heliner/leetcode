import java.util.Arrays;

/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * <p>
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 * . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * <p>
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 * <p>
 * 1、使用递归 Recursive
 * 2、消除前导0
 */
public class Solution165 {

    public int compareVersion(String version1, String version2) {

        return cv(version1.split("\\."), 0, version2.split("\\."), 0, version1.split("\\.").length, version2.split("\\.").length);
    }

    int cv(String[] ver1, int v1, String[] ver2, int v2, int len1, int len2) {
        if (v1 >= len1 && v2 >= len2)
            return 0;
        else if (v1 >= len1 && allZero(ver2, v2))
            return 0;
        else if (v1 >= len1 && !allZero(ver2, v2))
            return -1;
        else if (v2 >= len2 && allZero(ver1, v1))
            return 0;
        else if (v2 >= len2 && !allZero(ver1, v1))
            return 1;

        int cm = Integer.valueOf(ver1[v1]) - Integer.valueOf(ver2[v2]);
        if (cm == 0)
            return cv(ver1, v1 + 1, ver2, v2 + 1, len1, len2);
        return cm > 0 ? 1 : -1;
    }

    boolean allZero(String[] ver, int v) {
        for (int i = v; i < ver.length; i++) {
            if (Integer.valueOf(ver[i]) != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution165 solution165 = new Solution165();
        System.out.println(solution165.compareVersion("1.0.1", "1"));
    }
}
