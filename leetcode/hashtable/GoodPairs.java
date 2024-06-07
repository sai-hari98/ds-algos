package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem description: https://leetcode.com/problems/number-of-good-pairs/
 */
public class GoodPairs {

    /**
     * The below method computes the number of pairs that can be formed with duplicates that are present in the array.
     * Same number duplicates are joined as a pair.
     * For eg: [1,2,3,1,1,3] can be formed as (1,1) - 0th and 3rd index (1,1) - 0th and 4th index (1,1) - 3rd and 4th index and (3,3)
     * @param nums - the list of numbers to find good pairs for
     * @return - number of good pairs that can be formed
     */
    public static int numIdenticalPairs(int[] nums) {
        //We use a hashmap to keep track of number of occurrences for each number
        Map<Integer, Integer> countMap = new HashMap<>();
        int goodPairs = 0;
        for(int num : nums){
            Integer numOccurrences = countMap.get(num);
            //if numOccurrences is not null, it means there are previous occurrences of the element.
            if(numOccurrences != null){
                // the current number can form a pair with all the previous occurrences. therefore number of good pairs will increase by number of occurrences of the number before this.
                goodPairs+=numOccurrences;
                //increasing the occurrences by 1
                countMap.put(num, numOccurrences+1);
            }else{
                countMap.put(num, 1);
            }
        }
        return goodPairs;
    }
}
