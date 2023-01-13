package Interpreter;

public class NullDeleteEp implements ContentExpression {

    @Override
    public String Interpret(String content) {
        System.out.println(content);
            content = content.replaceFirst("null","");
            return content;
    }
}
