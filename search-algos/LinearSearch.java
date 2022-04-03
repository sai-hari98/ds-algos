
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

    public static void main(String[] args){
        int[] elements = {10,58,45,30,36,85,74,143,100,111};
        //fetching input element from program arguments
        int elementToSearch = Integer.parseInt(args[0]);
        int elementPosition = linearSearch(elements, elementToSearch);
        System.out.println("Element present at position: "+elementPosition);
    }
}