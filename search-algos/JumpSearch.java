public class JumpSearch {

    private static int jumpSearch(int[] elements, int elementToSearch){
        int noOfElements = elements.length;
        int step = (int) Math.floor(Math.sqrt(noOfElements));
        int previousStep = 0;

        while(elements[Math.min(step, noOfElements)-1] < elementToSearch){
            previousStep = step;
            step += (int) Math.floor(Math.sqrt(noOfElements));

            if(previousStep == noOfElements){
                return -1;
            }
        }

        while(elements[previousStep] < elementToSearch){
            previousStep++;

            if(previousStep == Math.min(step, noOfElements)){
                return -1;
            }
        }

        if(elements[previousStep] == elementToSearch)
            return previousStep+1;

        return -1;
    }

    public static void main(String[] args){
        int[] elements = {5,18,24,36,47,51,54,62,79,83,90,101};
        int elementToSearch = Integer.parseInt(args[0]);
        int elementPosition = jumpSearch(elements, elementToSearch);
        System.out.println("Element found at position: " + elementPosition);
    }
}
