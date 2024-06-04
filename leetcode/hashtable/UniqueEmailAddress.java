package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/unique-email-addresses/description/">Problem Description</a>
 */
public class UniqueEmailAddress {

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

    /**
     * This method computes the number of unique email IDs given as input based on the below rules
     * 1. Character '.' is not considered. It will be neglected. For example: John.Doe@abc.com will be considered as JohnDoe@abc.com
     * 2. Anything after a '+' in the local name of email will be disregarded.
     * Eg: John.Doe+Facebook@abc.com will be formatted to JohnDoe@abc.com
     * @param emails an array of email IDs to check for.
     * @return number of unique email IDs in the list provided as input.
     */
    public static int numUniqueEmails(String[] emails) {
        // Used hash set to store the unique email IDs
        Set<String> uniqueEmails = new HashSet<>();
        for(String email : emails){
            StringBuilder strBuilder = new StringBuilder();
            boolean isPlus = false, hasLocalNameEnded = false;
            for(char emailChar : email.toCharArray()){
                //check for if the pointer has crossed local name of email
                hasLocalNameEnded = hasLocalNameEnded || (emailChar == '@');
                //check for if the email has a plus character
                isPlus = isPlus || (emailChar == '+');
                /*
                 * append the character if either
                 * 1. the pointer either crossed the local name of the email
                 * 2. The character is not a '.' or '+' is not encountered in the local name of email
                  */
                if(hasLocalNameEnded || !(emailChar == '.' || isPlus)){
                    strBuilder.append(emailChar);
                }
            }
            String emailNew = strBuilder.toString();
            uniqueEmails.add(emailNew);
        }
        return uniqueEmails.size();
    }
}
