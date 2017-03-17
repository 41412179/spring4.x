package com.smart.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELHello {
    public static void main(String[] args) {
        //创建一个SpEL表达式解析器
        ExpressionParser parser = new SpelExpressionParser();
        //调用ExpressionParser#parseExpression()对表达式进行解析
        Expression exp = parser.parseExpression("'Hello' + ' World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}
