package bitmanipulation;

public class ReverseBits {

    private int number;

    public ReverseBits(int number) {
        this.number = number;
    }

    public int reverseBits(){
        int reversedNumber = 0;
        for(int i = 0 ; i < 32 ; i++){
            int bit = number & (1 << i);
            System.out.println(bit);
            reversedNumber = reversedNumber | (bit << (31-i));
            System.out.println(reversedNumber);
        }
        return reversedNumber;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits(4);
        System.out.println(reverseBits.reverseBits());
    }
}
