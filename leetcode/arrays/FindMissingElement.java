package arrays;

public class FindMissingElement{
    private int[] numbers;
    private int n;

    public FindMissingElement(int[] numbers, int n) {
        this.numbers = numbers;
        this.n = n;
    }

    public int missingElement(){
        int sum = (n*(n+1))/2;
        for(int num:numbers)
            sum-=num;
        return sum;
    }

    public static void main(String[] args) {
        FindMissingElement findMissingElement = new FindMissingElement(new int[]{1,2,4,5},5);
        System.out.println(findMissingElement.missingElement());
    }
}