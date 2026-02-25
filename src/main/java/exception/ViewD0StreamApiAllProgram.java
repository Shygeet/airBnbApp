package exception;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class ViewD0StreamApiAllProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strList= {"asa","sdDd","adafd"};
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		int result = numbers
		  .stream()
		  .reduce(2, (e, e1) -> e + e1);
		   System.out.println("Using Reduce "+result);
		   
		   
//Why mapToInt is needed sum() exists only on primitive streams, not on object streams.
		   //count return long 
		   long result2 = numbers
					  .stream()
					  .filter(n->n>2).mapToInt(Integer::intValue)
	                    .sum();
					   System.out.println("Using Filter "+result2);
			
					   /////////////////////////////////////////////
					   /////////////////////////////////////////////
	    Map<String, List<Integer>> result3 =
						        numbers.stream()
						               .collect(Collectors.groupingBy(
						                   n -> n % 2 == 0 ? "EVEN" : "ODD"));				   
	    System.out.println("Using group by "+result3);
	    
	    /////////////////////////////////////////////////////
	    ////////////////////////////////////////////////////
	    
	    String[] resultS = Arrays.stream(strList)
                .filter(s -> s.startsWith("a"))
                .toArray(String[]::new);

        System.out.println(Arrays.toString(resultS));

         ////////////////////////////////////////////
        ///////////////////////////////////////////
        Map<String, Integer> map = new HashMap<>();
        map.put("banana", 2);
        map.put("apple", 5);
        map.put("cherry", 5);
        map.put("date", 3);
        
        map.entrySet()
        .stream()
        .sorted(
            Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                     .thenComparing(Map.Entry.comparingByKey())
        )
        .forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));
        
        
        ///////////////////////////////////////////////
        List<String> sentences = List.of("java core", "spring boot");

        List<String> wordsFlatMAp = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .toList();
        
        List<String[]> resultFmap = sentences.stream()
                .map(s -> s.split(" "))
                .toList();
        
        System.out.println(wordsFlatMAp);
        System.out.println(resultFmap);
        resultFmap.forEach(arr -> System.out.println(Arrays.toString(arr)));
        
        
        //////////////////////////////////////////
        //////////////////////////////////////////
        int[] numbers2 = {5, 2, 9, 1, 7, 3};

        // Filter: keep numbers > 3, Sort: ascending
        int[] filteredSorted = Arrays.stream(numbers2)
                                     .filter(n -> n > 3)
                                     .sorted()
                                     .toArray();
        int[] filteredSortedInt = numbers.stream()
                .filter(n -> n > 3)
                .sorted().mapToInt(Integer::intValue)
                .toArray();
        
       // \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        
       
            String[] fruits = {"apple", "banana", "apricot", "orange"};

            // Filter: strings starting with 'a', Sort ascending
            String[] filteredSorted2 = Arrays.stream(fruits)
                                            .filter(s -> s.startsWith("a"))
                                            .sorted()
                                            .toArray(String[]::new);

            System.out.println(Arrays.toString(filteredSorted2)); // [apple, apricot]

            // Sort descending
            String[] sortedDesc = Arrays.stream(fruits)
                                        .sorted(Comparator.reverseOrder())
                                        .toArray(String[]::new);

            System.out.println(Arrays.toString(sortedDesc)); 
            
            
            
            //1............Separate Odd And Even Numbers
            
            Collection<Integer> listOfIntegers=Arrays.asList(1,2,3,4);
			Map<Boolean, List<Integer>> oddEven =
            		listOfIntegers.stream()
            		              .collect(Collectors.partitioningBy(i -> i % 2 == 0));
			
			System.out.println("Using group by "+oddEven);
			

			//2...........Remove Duplicate Elements From List
			List<String> listOfStrings = Arrays.asList("apple", "banana", "apricot", "apple");
			List<String> remDuplicate =
					listOfStrings.stream()
					             .distinct()
					             .collect(Collectors.toList());
			System.out.println(remDuplicate); 
			
			
			/////////////////////////////////////////
			//////////Frequency Of Each Character In String
			String inputString= "dafkha ak";
			Map<Character, Long> charFreqMapStr =
					inputString.chars()
					           .mapToObj(c -> (char) c)
					           .collect(Collectors.groupingBy(Function.identity(),
					                                          Collectors.counting()));
			System.out.println(charFreqMapStr); 
			
			/////////////////////////////////////////
			///////////////////Frequency Of Each Element In An Array
			List<Integer> anyList=Arrays.asList(1,4,3,23,4,2);
			Map<Integer, Long> charFreqMapElmenet =
					anyList.stream()
					       .collect(Collectors.groupingBy(Function.identity(),
					                                      Collectors.counting()));
			
			System.out.println(charFreqMapElmenet); 
			
			//\\\\\\\\\\\\\\\
			Integer max = anyList.stream()
            .max(Comparator.naturalOrder())
            .get();
			System.out.println(max); 
			
			
			///////
			List<Integer> anyList1=Arrays.asList(1,4,3,23,4,2);
			List<Integer> anyList2=Arrays.asList(1,4,3,23,4,2);
			
			/*
			 * int[] result = IntStream.concat(anyList1.stream(), anyList2.stream())
			 * .sorted() .toArray();
			 */
			 
			int[] mergeOSrtedArr =
			        Stream.concat(anyList1.stream(), anyList2.stream())
			              .mapToInt(Integer::intValue)
			              .sorted()
			              .toArray();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}

}
