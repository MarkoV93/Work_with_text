
package project2;
public class Word {
	private String wordText;
	public Word(String wordText) {
		
		this.wordText=wordText.toLowerCase();
	}

    public String getWordText() {
        return wordText;
    }

    public void setWordText(String wordText) {
        this.wordText = wordText;
    }

	public String toString(){
	return wordText;
	}
}

