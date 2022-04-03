
public class LinearSearch{

    private static int linearSearch(int[] elements, int elementToSearch){
        //-1 means element not present
        int elementPosition = -1;
        for(int index = 0; index < elements.length; index++){
            if(elements[index] == elementToSearch){
                elementPosition = index+1;
                break;
            }
        }
        return elementPosition;
    }

    // If element is in last index, it will take O(n). We can reduce this to O(1).
    //Worst case will be O(n/2)
    private static int linearSearchOptimized(int[] elements, int elementToSearch){
        //-1 means element not present
        int elementPosition = -1;
        int left = 0;
        int right = elements.length - 1;
        for(; left <= right; left++, right--){
            if(elements[left] == elementToSearch){
                elementPosition = left+1;
                break;
            }
            if(elements[right] == elementToSearch){
                elementPosition = right+1;
                break;
            }
        }
        return elementPosition;
    }

    public static void main(String[] args){
        int[] elements = {10,58,45,30,36,85,74,143,100,111};
        //fetching input element from program arguments
        int elementToSearch = Integer.parseInt(args[0]);
        int elementPosition = linearSearchOptimized(elements, elementToSearch);
        System.out.println("Element present at position: "+elementPosition);
    }
}