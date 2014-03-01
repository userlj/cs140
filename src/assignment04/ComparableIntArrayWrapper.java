package assignment04;

public class ComparableIntArrayWrapper implements Comparable<ComparableIntArrayWrapper> {
    private int[ ] content;


public ComparableIntArrayWrapper(int[] content) {
		super();
		this.content = content;
	}


public int[] getContent() {
	return content;
}


public int compareTo(ComparableIntArrayWrapper arg) {
    return content.length - arg.content.length;
}
}