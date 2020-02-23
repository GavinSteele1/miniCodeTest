package miniCodeTest2;

public class Word {
	private String word;
	
	public Word(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMatchWord() {
		return this.word.replace(" ", "");
	}

	public String toString() {
		return word;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.toString().equals(obj.toString())) {
			return true;
		}else {
			return false;
		}
	}
	
}
