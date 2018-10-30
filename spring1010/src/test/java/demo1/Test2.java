package demo1;

import com.bean.Users;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Test2 {
    public static void main(String[] args) {

        //测试2-springel表达式测试对象类型
       //<bean id="u" class="com.bean.Users" p:username='测试名字' >
        Users u=new Users();
        u.setUsername("测试名字");
        //解析表达式
        ExpressionParser  ep=new SpelExpressionParser();
        //指定被解析的对象
        EvaluationContext  ec=new StandardEvaluationContext(u);
        //得到username
       String name=(String) ep.parseExpression("username").getValue(ec);

       System.out.println(name);

    }
}
