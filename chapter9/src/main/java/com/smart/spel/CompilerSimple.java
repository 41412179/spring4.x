package com.smart.spel;

import com.smart.User;
import com.sun.org.apache.xalan.internal.extensions.ExpressionContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParseException;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * SpelCompiler将表达式直接编译成字节码，避免每次调用时
 * 进行语法解析，有效提高执行效率，适用于表达式不经常发生
 * 变动且重复调用频繁的场景
 */
public class CompilerSimple {
    public static void main(String... args) {
        User user = new User();
        //创建解析配置
        SpelParserConfiguration configuration = new SpelParserConfiguration(
                SpelCompilerMode.IMMEDIATE, CompilerSimple.class.getClassLoader());
        //创建解析器
        SpelExpressionParser parser = new SpelExpressionParser(configuration);
        //创建取值上下文
        EvaluationContext context = new StandardEvaluationContext(user);
        //表达式
        String expression = "isVipMember('tom') && isVipMember('jony')";
        //解析表达式
        SpelExpression spelExpression = parser.parseRaw(expression);

        //通过表达式求值
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));




    }
}
