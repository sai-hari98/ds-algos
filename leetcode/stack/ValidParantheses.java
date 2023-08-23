package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Link:
 */
public class ValidParantheses {

    private String s;

    public ValidParantheses(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        ValidParantheses validParantheses = new ValidParantheses("()[]{}");
        System.out.println(validParantheses.isValid());
    }

    /*
        Classic stack problem. The number of opening and closing brackets should be same.
        The order of the brackets also matter. Closing bracket immediately after opening bracket.
        Pop from stack if the bracket is a closing bracket.
        Push it in otherwise
     */
    public boolean isValid() {
        Stack bracketStack = new Stack();
        Map<Character,Character> bracketMap = new HashMap<>();
        //Using map to keep the track of closing bracket and the expected bracket in top of stack as value.
        bracketMap.put(')','(');
        bracketMap.put('}','{');
        bracketMap.put(']','[');
        for(int i = 0; i < s.length() ; i++){
            char chr = s.charAt(i);
            //check for closing bracket and top of the stack.
            if(bracketMap.containsKey(chr)
                    && !bracketStack.isEmpty()
                    && bracketStack.peek() == bracketMap.get(chr)){
                bracketStack.pop();
                continue;
            }
            //else push it.
            bracketStack.push(chr);
        }
        //if stack is empty then the brackets are balancing or else its not.
        return bracketStack.isEmpty();
    }
}
