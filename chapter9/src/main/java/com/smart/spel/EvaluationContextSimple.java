package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class EvaluationContextSimple {
    static class Simple {
        public List<Boolean> booleanList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Simple simple = new Simple();
        simple.booleanList.add(true);
        //创建求值上下文
        EvaluationContext context = new StandardEvaluationContext(simple);
        ExpressionParser parser = new SpelExpressionParser();
        //自动将"false"转化为布尔类型
        parser.parseExpression("booleanList[0]").setValue(context, "false");
        //b将被设置为false
        Boolean b = simple.booleanList.get(0);
        System.out.println(b);
    }
}
