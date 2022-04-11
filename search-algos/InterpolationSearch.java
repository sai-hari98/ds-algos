public class InterpolationSearch {

    private static int interpolationSearch(int[] elements, int elementToSearch){
        int noOfElements = elements.length;
        int high = noOfElements - 1;
        int low = 0;
        while(high-low > 0){
            int positionToSearch = low + (elementToSearch - elements[low]) * ((high-low)/(elements[high] - elements[low]));
            if(elements[positionToSearch] == elementToSearch){
                return positionToSearch+1;
            }

            if(elements[positionToSearch] > elementToSearch)
                high = positionToSearch - 1;

            if(elements[positionToSearch] < elementToSearch)
                low = positionToSearch + 1;
        }

        if(elements[high] == elementToSearch)
            return high+1;

        return -1;
    }

    public static void main(String[] args){
        int[] elements = {5,18,24,36,47,51,54,62,79,83,90,101};
        int elementToSearch = Integer.parseInt(args[0]);
        int elementPosition = interpolationSearch(elements, elementToSearch);
        System.out.println("Element found at position: " + elementPosition);
    }
}
