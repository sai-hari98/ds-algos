package strings;

public class MaximumParanthesesDepth {

    private String expression;

    public MaximumParanthesesDepth(String expression) {
        this.expression = expression;
    }

    public int maxDepth() {
        int depth = 0, maxDepth = 0;
        for(int i = 0 ; i < expression.length() ; i++){
            char chr = expression.charAt(i);
            if(chr == '(')
                depth++;
            if(chr == ')'){
                maxDepth = Math.max(depth, maxDepth);
                depth--;
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        MaximumParanthesesDepth maxParanthesesDepth = new MaximumParanthesesDepth("(1+(2*3)+((8)/4))+1");
        System.out.println(maxParanthesesDepth.maxDepth());
    }
}
