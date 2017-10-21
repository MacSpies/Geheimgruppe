
public class Project {
	private String[][] s;
	public Project (String[][] string) {
		s = string;
	}
	
	public boolean isWellSorted(String[] sequence) {
		if (sequence.length < 2) {
			return false;
		}
		
		for (int g=0; g<sequence.length-1; g++) {
			for (int h=g+1; h<sequence.length; h++) {
				if (sequence[g].equals(sequence[h])) {
					return false;
				}
			}	
		}
		
		for (int i=0; i<s.length; i++) {
			for (int j=0; j<sequence.length; j++) {
				if (sequence[j].equals(s[i][1])) {
					for (int k=j+1; k<sequence.length; k++) {
						if (sequence[k].equals(s[i][0])) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

}
