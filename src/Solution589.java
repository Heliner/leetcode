import sun.reflect.Reflection;
import sun.reflect.misc.ReflectUtil;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class Solution589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        List<Integer> res = new LinkedList<Integer>();

        public List<Integer> preorder(Node root) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);
            while (!stack.empty()) {
                Node tNode = stack.pop();
                res.add(tNode.val);
                if (tNode.children != null) {
                    for (int i = tNode.children.size() - 1; i >= 0; i--)
                        stack.push(tNode.children.get(i));
                }
            }
            return res;
        }
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        /*不支持自动装箱 int -> Integer*/
        BinaryOperator<Integer> bo = (Integer a, Integer b) -> {
            return a + b;
        };
        Integer c = null;
        System.out.println(c);
        Solution589.class.newInstance();
        Solution589 solution589 = (Solution589) ReflectUtil.newInstance(Solution589.class);
        System.out.println(solution589);
    }
}
