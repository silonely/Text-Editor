package visitor;

import CompositeAndDecorator.*;
import CompositeAndDecorator.Character;
import Interpreter.ContentExpression;
import Interpreter.NullDeleteEp;
import Interpreter.SplitToWordsEp;

public class ContentVisitor implements Visitor{
    String[] List = new String[10000];
    static String[] stringArray;
    ContentExpression nullDeleteExpression = new NullDeleteEp();
    ContentExpression splitToWordsEp = new SplitToWordsEp();
    private int paragraphCount = 0;

    @Override public void visit(Body body) {

    }

    @Override public void visit(Paragraph paragraph) {
        if(paragraph.getChildSize()!=0)
            paragraphCount++;
    }
    @Override public void visit(Span span) {}
    @Override public void visit(Character character) {
        int p = paragraphCount;
        if(!character.getContent().equals("")){
            List[p] = List[p] + character.getContent();
            //System.out.println(List[p]);
            List[p] = nullDeleteExpression.Interpret(List[p]);
            SaveStringToAry(splitToWordsEp.Interpret(character.getContent()));
        }
    }
    @Override public void visit(Bold bold) {

    }
    @Override public void visit(Italic italic) {

    }
    @Override public void visit(Underline underline) {

    }
    @Override public void visit(Font font) {

    }
    @Override public void visit(HTML html) {

    }

    public void SaveStringToAry(String s) {
        stringArray= s.split(",");
    }
    public String[] getAry() {
        return stringArray;
    }
}




//  List[p]: nullHi&nbsp;how&nbsp;are&nbsp;you.
//  NullDeleteEp
//  List[p]: Hi&nbsp;how&nbsp;are&nbsp;you.

