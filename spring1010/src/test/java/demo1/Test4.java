package demo1;

import com.bean.Grade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ApplicationContext app=
                new ClassPathXmlApplicationContext("spring.xml");
        Grade g=(Grade) app.getBean("g2");
        System.out.println(g.getGname());
    }
}
