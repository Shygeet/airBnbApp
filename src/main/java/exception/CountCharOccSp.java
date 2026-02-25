package exception;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountCharOccSp {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner (System.in);
	    System.out.println("Enter String:"); // ab abc
	    String a= s.nextLine();
	    s.close();
	    
	    Map<Character, Integer> freqMap = new HashMap<>();
	    Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : a.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            /*
             * V getOrDefault(Object key, V defaultValue)
key: The key to look up in the map.

defaultValue: The value to return if the key does not exist in the map.
             * 
             */
            
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                // Otherwise add to map with count 1
                charCountMap.put(c, 1);
            }
            //freqMap.getOrDefault(c, 0)
            //Tries to get the current count of character c from the map.

            //If c is not present, it returns 0 by default.
            //Adds 1 to the existing count (or to 0 if it's the first time).
        }

        System.out.println(freqMap);
        System.out.println(charCountMap);
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        System.out.println("Key based map sorting is as follows:");
        charCountMap.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .forEach(entry ->
                System.out.println(entry.getKey() + " -> " + entry.getValue())
        );
        
        Map<Character, Integer> sortedMap =
                charCountMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                        .collect(
                                LinkedHashMap::new,
                                (m, e) -> m.put(e.getKey(), e.getValue()),
                                LinkedHashMap::putAll
                        );

        System.out.println(sortedMap);
        
        System.out.println("grouping based on value");
        Map<Integer, List<Character>> groupedByFrequency =
                charCountMap.entrySet()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Map.Entry::getValue,              // group by frequency
                                        Collectors.mapping(
                                                Map.Entry::getKey,        // collect characters
                                                Collectors.toList()
                                        )
                                )
                        );
        System.out.println(groupedByFrequency);
        
        
        
        
        
     // freq array index = ASCII value of character
        int[] freq = new int[256];   // covers all ASCII characters (0–255)

        // convert string to char array and iterate
        for (char c : a.toCharArray()) {
            freq[c]++;              // c is auto-converted to its ASCII value
        }

        // iterate over frequency array
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + " -> " + freq[i]);
            }
        }
	
	}	

}
