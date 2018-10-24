package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	static final int NO_OF_CHARS = 256;

	@RequestMapping("/words/{word}")
	public Word testWords(@PathVariable String word) {
		String reverse = null;
		Word wordObj = new Word();
		wordObj.setWord(word);
		if (word != null) {
			reverse = new StringBuilder(word).reverse().toString();
			if (word.equals(reverse)) {
				wordObj.setPalindrome(true);
			}
		}
		if (canFormPalindrome(word)) {
			wordObj.setAnagramOfPalindrome(true);
		}
		return wordObj;
	}

	static boolean canFormPalindrome(String str) {
		int[] count = new int[NO_OF_CHARS];
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
		int odd = 0;
		for (int i = 0; i < NO_OF_CHARS; i++) {
			if ((count[i] & 1) != 0)
				odd++;
			if (odd > 1)
				return false;
		}
		return true;
	}
}
