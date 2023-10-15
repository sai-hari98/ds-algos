package strings;

/**
 * Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 */

public class MaximumParanthesesDepth {

    private String expression;

    public MaximumParanthesesDepth(String expression) {
        this.expression = expression;
    }

    /** using the idea of stack for parantheses validation.
     * If we encounter '(' -> means we are going one level deep inside
     * If we encounter ')' -> means we are coming out by one level
     * eg: "(1+(2*3)+((8)/4))+1"
     * @return max depth
     */
    public int maxDepth() {
        int depth = 0, maxDepth = 0;
        for(int i = 0 ; i < expression.length() ; i++){
            char chr = expression.charAt(i);
            // When going inside by a level, we are incrementing to keep track of the depth
            if(chr == '(')
                depth++;
            // Doing the same when we come out, decrement depth by one.
            // Also checking if the depth before decrement is gt than the previous depth recorded.
            // If yes, it'll be the max depth, else we continue.
            if(chr == ')')
                maxDepth = Math.max(depth--, maxDepth);
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        MaximumParanthesesDepth maxParanthesesDepth = new MaximumParanthesesDepth("(1+(2*3)+((8)/4))+1");
        System.out.println(maxParanthesesDepth.maxDepth());
    }
}
