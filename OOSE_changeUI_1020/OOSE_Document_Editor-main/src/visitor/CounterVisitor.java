package visitor;

import CompositeAndDecorator.Body;
import CompositeAndDecorator.Character;
import CompositeAndDecorator.HTML;
import CompositeAndDecorator.Span;

import java.util.ArrayList;

public class CounterVisitor implements Visitor{
    private int characterCount = 0;
    private int paragraphCount = 0;

    @Override public void visit(Body body) {}
    @Override public void visit(CompositeAndDecorator.Paragraph paragraph) {
        if(paragraph.getChildSize()!=0){
            paragraphCount++;
        }

    }
    @Override public void visit(Span span) {}
    @Override public void visit(Character character) {
        if(!character.getContent().equals(""))
            characterCount++;
    }
    @Override public void visit(CompositeAndDecorator.Bold bold) {}
    @Override public void visit(CompositeAndDecorator.Italic italic) {}
    @Override public void visit(CompositeAndDecorator.Underline underline) {}
    @Override public void visit(CompositeAndDecorator.Font font) {}
    @Override public void visit(HTML html) {}
    public int getCharacter(){
        return characterCount;
    }
    public int getParagraph() {return paragraphCount; }
}
