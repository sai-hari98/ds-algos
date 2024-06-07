package hashtable;

import java.util.*;

/**
 * Problem Description: https://leetcode.com/problems/group-anagrams/submissions/1279984857/
 */
public class GroupAnagrams {


    /**
     * This approach is based on having a hash key as the occurance count of each of 26 alphabets.
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for(String str : strs){
            String hashString = getHashStringForAnagram(str);
            if(groupedAnagrams.containsKey(hashString)){
                List<String> group = groupedAnagrams.get(hashString);
                group.add(str);
                groupedAnagrams.put(hashString, group);
            }else{
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groupedAnagrams.put(hashString, newGroup);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : groupedAnagrams.entrySet())
            result.add(entry.getValue());
        return result;
    }

    public static String getHashStringForAnagram(String str){
        int[] arr = new int[26];
        for(char c : str.toCharArray()){
            int pos = c - 97;
            arr[pos]++;
        }

        StringBuilder strBuilder = new StringBuilder();
        for(int num : arr){
            strBuilder.append("#");
            strBuilder.append(num);
        }
        return strBuilder.toString();
    }

    public static List<List<String>> groupAnagramsSortedHashStr(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(groupedAnagrams.containsKey(sortedStr)){
                List<String> group = groupedAnagrams.get(sortedStr);
                group.add(str);
                groupedAnagrams.put(sortedStr, group);
            }else{
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groupedAnagrams.put(sortedStr, newGroup);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : groupedAnagrams.entrySet())
            result.add(entry.getValue());
        return result;
    }

    /**
     * My own inefficient approach - time limit exceeded
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsMyApproach(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        List<Map<Character, Integer>> groupsCountMap = new ArrayList<>();
        for(int i = 0 ; i < strs.length; i++){
            String str = strs[i];
            Map<Character, Integer> countMap = getCountMap(strs[i]);
            boolean belongsToAGroup = false;
            for(int j = 0; j < groupsCountMap.size(); j++){
                if(isAnagram(groupsCountMap.get(j), countMap)){
                    groupedAnagrams.get(j).add(str);
                    belongsToAGroup = true;
                    break;
                }
            }
            if(!belongsToAGroup || groupsCountMap.size() == 0){
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groupedAnagrams.add(newGroup);
                groupsCountMap.add(countMap);
            }
        }
        return groupedAnagrams;
    }

    public static Map<Character, Integer> getCountMap(String str){
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : str.toCharArray()){
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c)+1);
            }else{
                countMap.put(c, 1);
            }
        }
        return countMap;
    }

    public static boolean isAnagram(Map<Character, Integer> groupCountMap, Map<Character, Integer> countMap){
        for(Map.Entry<Character, Integer> entry : groupCountMap.entrySet()){
            Integer count = countMap.get(entry.getKey());
            if(count == null || count != entry.getValue()){
                return false;
            }
        }
        return groupCountMap.size() == countMap.size();
    }
}
