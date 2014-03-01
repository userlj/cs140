package assignment04;

import java.util.ArrayList;

public class Book2Helper {

	static Book2 bookWithMostPages(ArrayList<Book2> list) {
		Book2 returnVal = null;
		if(list != null && list.size() > 0) {
			int maxIndex = 0;
			while(maxIndex < list.size() 
					&& list.get(maxIndex) == null){
				maxIndex++; 
			}
			if (maxIndex < list.size()) {
				int maxPages = list.get(maxIndex).getPageCount();
				for(int i = maxIndex+1; i < list.size(); i++) {
					if(list.get(i) != null && list.get(i).getPageCount() > maxPages) {
						maxIndex = i;
						maxPages = list.get(i).getPageCount();
					}
				}
				returnVal= list.get(maxIndex);
			}
		}
		return returnVal;
	}
}
