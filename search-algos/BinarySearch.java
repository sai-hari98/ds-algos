public class BinarySearch {

    //Binary search applies only for sorted list/array
    public static int binarySearch(int[] elements, int elementToSearch, int start, int end){
        //int middlePosition = (start+end)/2;
        //above will fail when sum of start and end is > than possible int value 2^32-1.
        //Hence going with below logic -> decrease and conquer (algo paradigm)
        int middlePosition = start + (end-start)/2;
        if(start > end)
            return -1;

        if(elements[middlePosition] == elementToSearch){
            return middlePosition+1;
        }else if(elements[middlePosition] > elementToSearch){
            return binarySearch(elements, elementToSearch, 0, middlePosition-1);
        }else{
            return binarySearch(elements, elementToSearch, middlePosition+1, end);
        }
    }

    //iterative approach to eliminate recursion
    public static int binarySearchIterative(int[] elements, int elementToSearch){
        int start = 0;
        int end = elements.length - 1;

        while(start<=end){
            int middle = start + (end-start)/2;
            if(elements[middle] == elementToSearch)
                return middle+1;

            if(elements[middle] > elementToSearch)
                end = middle - 1;
            else
                start = middle+1;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] elements = {5,18,24,36,47,51,54,62,79,83,90,101};
        int elementToSearch = Integer.parseInt(args[0]);
        int elementPosition = binarySearchIterative(elements, elementToSearch);
        System.out.println("Element found at position: " + elementPosition);
    }
}
