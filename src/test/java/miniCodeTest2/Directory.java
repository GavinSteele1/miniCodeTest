package miniCodeTest2;

import java.util.HashMap;

public class Directory {
	private Word[] words;
	private HashMap<String, Word> abbreviationMap;

	
	public Word[] getWords() {
		return words;
	}

	public void setWords(Word[] words) {
		this.words = words;
	}

	public HashMap<String, Word> getAbbreviationMap() {
		HashMap<String, Word> hs = new HashMap<String, Word>();
		for (Word word : words) {
			hs.putAll(getAbbreviation(word));
		}
		return hs;
	}

	public void setAbbreviationMap(HashMap<String, Word> abbreviationMap) {
		this.abbreviationMap = abbreviationMap;
	}

	private HashMap<String, Word> getAbbreviation(Word source) {
		HashMap<String, Word> hs = new HashMap<String, Word>();
		for (Word word : words) {
			if (source.toString().startsWith(word.toString())) {
				for (Word word2 : words) {
					if (!word.equals(word2) && source.equals(word.toString() + word2.toString())) {
						hs.put(word.toString() + " " + word2.toString(), source);
						break;
					}
				}
			}
		}
		return hs;
	}
}
