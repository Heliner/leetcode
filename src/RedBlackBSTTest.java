import com.sun.org.apache.regexp.internal.RE;

public class RedBlackBSTTest {


    public static void main(String[] args) {
        RedBlackBST<Character, Character> redBlackBST = new RedBlackBST<Character, Character>();
        redBlackBST.put('S','S');
        redBlackBST.put('E','E');
        redBlackBST.put('A','A');
        redBlackBST.put('R','R');
        redBlackBST.put('C','C');
        redBlackBST.put('H','H');
        redBlackBST.put('X','X');
        redBlackBST.put('M','M');
        redBlackBST.put('P','P');
        redBlackBST.put('L','L');
        System.out.println(redBlackBST);
    }

}
