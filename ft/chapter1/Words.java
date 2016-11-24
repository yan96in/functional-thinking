/**
 * 
 */
package ft.chapter1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yan96in
 * 
 */
public class Words {

	private Set<String> NOW_WORDS = new HashSet<String>() {
		{
			add("the");
			add("and");
			add("of");
			add("to");
			add("a");
			add("i");
			add("it");
			add("in");
			add("or");
			add("is");
			add("d");
			add("s");
			add("as");
			add("so");
			add("but");
			add("be");
		}
	};

	// 词频统计的java实现
	public Map wordFreq(String words) {
		TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
		Matcher m = Pattern.compile("\\w+").matcher(words);
		while (m.find()) {
			String word = m.group().toLowerCase();
			if (!NOW_WORDS.contains(word)) {
				if (wordMap.get(word) == null) {
					wordMap.put(word, 1);
				} else {
					wordMap.put(word, wordMap.get(word) + 1);
				}
			}
		}
		return wordMap;
	}

	// 词频统计的java8实现
	private List<String> regexToList(String words, String regex) {
		List wordList = new ArrayList<>();
		Matcher m = Pattern.compile(regex).matcher(words);
		while (m.find())
			wordList.add(m.group());
		return wordList;
	}

	public Map wordFreg(String words) {
		TreeMap<String, Integer> wordMap = new TreeMap<>();
		regexToList(words, "\\w+").stream()
			.map(w -> w.toLowerCase())
			.filter(w -> !NOW_WORDS.contains(w))
			.forEach(w -> wordMap
			.put(w, wordMap.getOrDefault(w, 0) + 1));
		return wordMap;
	}
}
