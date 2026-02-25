package exception;

import java.util.HashMap;
import java.util.Map;

public class ViewDay1P8StringDuplicateChars {

	public static void main(String[] args) {
		
		String str="fjsfhjsfkhdfghhjlb,,b";
		
		Map<Character, Integer> m = new HashMap<>();
		
		for(char c :str.toCharArray())
		{
			m.put(c, m.getOrDefault(c, 0)+1);
		}
		
		for(Map.Entry<Character, Integer> entry : m.entrySet())
		{
			if(entry.getValue()>1) {
				System.out.println(entry.getKey()+"->"+entry.getValue());
			}
		}

	}

}
