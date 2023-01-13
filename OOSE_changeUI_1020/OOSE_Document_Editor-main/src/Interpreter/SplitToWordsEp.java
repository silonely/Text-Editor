package Interpreter;

import java.util.ArrayList;
import java.util.List;

public class SplitToWordsEp implements ContentExpression{
    List<String> wordsList = new ArrayList<>();
    String s = "";

    public String Interpret(String content) {
        //System.out.println(content);
        if(content.equals("&nbsp;")){
            //System.out.println("加入"+s);
            wordsList.add(s);
            s = "";
            //System.out.println(wordsList.toString());
        }else{
            s = s + content;
        }
        return wordsList.toString();
    }
}
