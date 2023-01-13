package visitor;

import CompositeAndDecorator.*;
import CompositeAndDecorator.Character;
import Interpreter.ContentExpression;
import Interpreter.UpperCaseEp;
import builder.Builder;

import utils.parseArgs;

import java.util.Stack;

public class WrapLabelVisitor implements Visitor{
    private Stack<parseArgs> parseStack = new Stack<>();
    private Builder formatting;
    ContentExpression UpperCaseExpression = new UpperCaseEp();
    public WrapLabelVisitor(Builder formatting){
        this.formatting = formatting;
    }
    @Override public void visit(Body body) {pushCompositeToStack(body);}
    @Override public void visit(CompositeAndDecorator.Paragraph paragraph) {pushCompositeToStack(paragraph);}
    @Override public void visit(Span span) {pushCompositeToStack(span);}
    @Override public void visit(Character character) {pushLeafToStack(character);}
    @Override public void visit(CompositeAndDecorator.Bold bold) {pushCompositeToStack(bold);}
    @Override public void visit(CompositeAndDecorator.Italic italic) {pushCompositeToStack(italic);}
    @Override public void visit(CompositeAndDecorator.Underline underline) {pushCompositeToStack(underline);}
    @Override public void visit(CompositeAndDecorator.Font font) {pushCompositeToStack(font);}
    @Override public void visit(HTML html) {pushCompositeToStack(html);}

    public void pushCompositeToStack(HTML html){
        parseArgs HaveLabelTag = formatting.parse(html);
        if(html.getChildSize()>0 && parseStack.size() >= html.getChildSize()){
            String leafParseStrings = "";
            //Can see the number of composite class child
            //System.out.printf("%s:%d \n",g.getTagname(),g.getChildSize());
            for(int i = html.getChildSize(); i>0; i--){
                leafParseStrings = parseStack.pop().getFullTag() + leafParseStrings;
            }
            leafParseStrings = UpperCaseExpression.Interpret(leafParseStrings);
            leafParseStrings =
                    HaveLabelTag.getStartingTag() +
                    leafParseStrings +
                    HaveLabelTag.getClosingTag();
            parseArgs pushBackParseArgs = new parseArgs();
            pushBackParseArgs.setFullTag(leafParseStrings);
            parseStack.push(pushBackParseArgs);
        } else {
            pushLeafToStack(html);
        }
    }
    public void pushLeafToStack(HTML html){
        parseArgs HaveLabelTag = formatting.parse(html);
        parseStack.push(HaveLabelTag);
    }
    public String getWholeLebelString(){
        return parseStack.peek().getFullTag();
    }
}
