package demo1;

import com.bean.Grade;
import com.bean.Users;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test3 {

    public static void main(String[] args) {
       //1.springel解析普通类型值
        ExpressionParser ep=new SpelExpressionParser();
        double num1=(Double)ep.parseExpression("3.123").getValue();
        System.out.println(num1);
        String str=(String)ep.parseExpression("\"abc\"").getValue();
        System.out.println(str);
        //2.解析方法
        String str2=(String)ep.parseExpression("'abc'.concat('bcd')").getValue();
        System.out.println(str2);
        boolean bl=(Boolean)ep.parseExpression("'abc'.equals('abc')").getValue();
        System.out.println("bl="+bl);
        //3.数组
       String[] strs=(String[])ep.parseExpression("new String[]{'aaa','bbb','cccc'}").getValue();
        System.out.println(Arrays.toString(strs));
       //4.list
       List list=(List)ep.parseExpression("{1,2,3,4,5}").getValue();
        for (Object o : list) {
            System.out.println(o+",");
        }
       //5.Map  {'key':value}
       Map m=(Map)ep.parseExpression("{'username':'张三','age':18}").getValue();
        System.out.println(m.get("username"));
        System.out.println(m.get("age"));
      //6.对象类型
        Users u=new Users();
        u.setUsername("刘能");
        Grade g=new Grade();
        g.setGname("高年级");
        u.setGrade(g);

        EvaluationContext ec=new StandardEvaluationContext(u);
        String username= (String)ep.parseExpression("username").getValue(ec);
       String gname=(String)ep.parseExpression("grade.gname").getValue(ec);
        System.out.println(username+"...."+gname);
      //7.修改对象值
        ep.parseExpression("username").setValue(ec,"刘二能");
        username= (String)ep.parseExpression("username").getValue(ec);
        System.out.println("修改后的值:"+username);
     //8.运算符解析:
        boolean br= (Boolean) ep.parseExpression("2==3").getValue();
        System.out.println("br="+br);
        boolean br2= (Boolean) ep.parseExpression("2>3||3<4").getValue();
        System.out.println("br2="+br2);
        String br3= (String) ep.parseExpression("2>3?'a':'b'").getValue();
        System.out.println("br3="+br3);
        //9.调取构造
        Users user=(Users)ep.parseExpression("new com.bean.Users()").getValue();
        System.out.println("users="+user);
        //10.调取类中的方法
         ep.parseExpression("abc(20)").getValue(ec);
       //11.静态的有返回值方法
         String string=(String) ep.parseExpression("bcd('aaa')").getValue(ec);
        System.out.println("bcd的返回值："+string);
    }
}
