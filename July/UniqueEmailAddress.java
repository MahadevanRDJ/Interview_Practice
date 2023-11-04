package July;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();


       System.out.println( uniqueEmailAddress.find(Arrays.asList("test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com")));
    }
    


    private int find(List<String> emails) {
        Set<String> set = new HashSet<>();
        StringBuilder localName = new StringBuilder();
        for(String email : emails) {
           int indexPlus = email.indexOf("+");
           int indexAt = email.indexOf("@");

           
           if(indexPlus >= 0) localName.append(email.substring(0, indexPlus));
           else localName.append(email.substring(0, indexAt));

           String validEmail = localName.toString().replace(".","") + email.substring(indexAt);
           set.add(validEmail);
           localName.delete(0, localName.length());
        }
        return set.size();
    }

}