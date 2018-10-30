package demo1;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test1 {
    public static void main(String[] args) {

        //测试1springel表达式
        //解析表达式
        ExpressionParser  ep=new SpelExpressionParser();
       // ep.parseExpression("表达式")
       Expression expression= ep.parseExpression("'a'+'b'");
       //得到结果
       String str=(String)expression.getValue();
       System.out.println(str);

    }
}
