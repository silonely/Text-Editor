package Interpreter;

import org.apache.commons.lang.WordUtils;

public class UpperCaseEp implements ContentExpression{

    @Override
    public String Interpret(String content) {
        return WordUtils.capitalize(content, new char[]{'.'});
    }
}
