import java.util.*;

public class Solution20 {
    static
    class Solution {
        public boolean isValid(String s) {
            if (s.equals(""))return true;
            Stack<Character> st=new Stack<Character>();
            HashMap<Character,Character> hp=new HashMap<Character,Character>(){{//初始化括号对应值
                put(']','[');
                put(')','(');
                put('}','{');
            }};
            char [] chars=s.toCharArray();
            //程序主体
            for (char z:chars) {
                if(hp.containsValue(z))
                    st.push(z);
                else if (st.isEmpty()||st.pop()!=hp.get(z) )//匹配右括号
                    return false;
            }

            //栈必须为空否则为不正确匹配
            if(st.isEmpty())
                return true;
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello ");
    }
}
