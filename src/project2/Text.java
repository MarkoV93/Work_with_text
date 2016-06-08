package project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

    List<Sentence> text = new ArrayList<>();

    public void readTheText() {
        String myText = "";
        try {

            File myFile = new File("Mytext.txt");
            FileReader fileReader = new FileReader(myFile);
            String line = null;
            System.out.println("File open");
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                myText += line;
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        while (myText.contains("  ")) {
            String replace = myText.replace("  ", " ");
            myText = replace;
        }
        String sentence = "";
        for (int i = 0; i < myText.length(); i++) {

            sentence += myText.charAt(i);
            if (myText.charAt(i) == '.' || myText.charAt(i) == '!' || myText.charAt(i) == '?') {
                text.add(new Sentence(sentence));
                // System.out.println(new Sentence(sentence));
                sentence = "";
            }
        }
    }

    public String toString() {
        return text.toString();
    }

    public void Task1() {
        try {
            if (text.size() == 0) {
                throw new NullPointerException("text is empty");
            } else {
                String maxOfNum = "";
                List<Word> myWords = new ArrayList<>();
                Iterator i = text.iterator();
                while (i.hasNext()) {
                    Sentence sent = (Sentence) i.next();
                    myWords.addAll(sent.getSentence());
                }
                Iterator it = myWords.iterator();
                int previosNum = 0;
                int num = 0;
                while (it.hasNext()) {
                    Word w = (Word) it.next();
                    num = 0;
                    Object sent[] = text.toArray();
                    for (int s = 0; s < sent.length; s++) {
                        Sentence setence = (Sentence) sent[s];
                        Iterator iter = setence.getSentence().iterator();
                        while (iter.hasNext()) {
                            Word wor = (Word) iter.next();
                            if (w.getWordText().equals(wor.getWordText())) {
                                num++;
                                break;
                            }
                        }
                    }
                    if (num == previosNum) {
                        maxOfNum = w.getWordText();
                    } else if (num > previosNum) {
                        maxOfNum = new String();
                        maxOfNum = w.getWordText();
                        previosNum = num;
                    }
                    //	  System.out.println(w+" "+num);
                }
                System.out.println("TASK 1__________________________");
                System.out.println(maxOfNum + " " + previosNum);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void Task2() {
        try {
            if (text.size() == 0) {
                throw new NullPointerException("text is empty");
            }
            int j = 0;
            Object sente[] = text.toArray();
            System.out.println("TESK2_____________________________");
            for (int i = 0;; i++) {
                for (int s = 0; s < sente.length; s++) {
                    Sentence setence = (Sentence) sente[s];
                    if (setence.getSentence().size() == i) {
                        System.out.println(i + "  ");
                        System.out.println(setence);
                        j++;
                    }
                }
                if (j == sente.length) {
                    break;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
//exeptions
