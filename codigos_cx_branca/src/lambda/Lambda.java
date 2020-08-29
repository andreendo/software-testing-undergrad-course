package lambda;

import java.util.List;

public class Lambda {
	
	public int[] countWordsStartingWithAandZ(List<String> strings) {
		int[] ret = {0, 0};
		
		strings.stream().forEach(s -> {
			if(s.startsWith("a"))
				ret[0]++;
			
			if(s.startsWith("z"))
				ret[1]++;
		});
		
		return ret;
	}
}
