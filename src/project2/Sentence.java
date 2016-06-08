
package project2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
private List<Word> sentence=new ArrayList<>();
public Sentence(String mySentence) {
	Pattern p1=Pattern.compile("[ ]([[а-яА-Я]*[a-zA-Z]*]+)");
	Matcher m1=p1.matcher(mySentence);
	while(m1.find()) {
		Word word=new Word(m1.group());
		sentence.add(word);
	}
}

    public List<Word> getSentence() {
        return sentence;
    }

    public void setSentence(List<Word> sentence) {
        this.sentence = sentence;
    }

public String toString() {
	return sentence.toString();
}}