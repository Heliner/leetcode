import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.List;

/**
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 */
public class Solution5018 {


    /**
     * 类型：双指针
     * 1、query中一个指针，pattern一个指针
     * 2、判断是否含有多余的大写字母
     *
     * @param queries
     * @param pattern
     * @return
     */
    LinkedList<Boolean> res
            = new LinkedList<>();

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] pchs = pattern.toCharArray();
        for (String query : queries) {
            char[] qs = query.toCharArray();
            int l = 0, r = 0;
            /*1、移动指针让qchs指向大写字母*/
            /*2、是否相等，如果相等就继续*/
            /*3、否则比较剩余的*/
            boolean equals = true;
            while (l < qs.length && r < pchs.length) {
                while (l<qs.length&&!(qs[l] <= 'Z' && qs[l] >= 'A'))
                    l++;
                if (l < qs.length && qs[l] != pchs[r]) {
                    equals = false;
                    break;
                }
                l++;
                r++;
            }
            if (equals == false || r < pchs.length || hasMoreBig(qs, l))
                res.add(false);
           else res.add(true);
        }
        return res;
    }

    private boolean hasMoreBig(char[] qs, int l) {
        for (int i = l; l < qs.length; i++)
            if (qs[i] >= 'A' && qs[i] <= 'Z')
                return true;
        return false;
    }

    public static void main(String[] args) {
    }
}
