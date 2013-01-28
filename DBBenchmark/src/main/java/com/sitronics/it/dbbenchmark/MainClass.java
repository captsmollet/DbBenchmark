package com.sitronics.it.dbbenchmark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * place description here
 */
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");


        TestTableDao dao = context.getBean("testTableDao", TestTableDao.class);
        TestObject obj = new TestObject();
        obj.setSome_str("%ручкой%");
//        obj.setId(5046197);
        List<TestObject> list = dao.findTestObject(obj);
        System.out.println("Executed query: " + dao.getQueryText());
        System.out.println("Found results:");
        for (TestObject o : list) {
            System.out.println(o.toString());
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTimeInMillis(dao.getElapsedNanos() / 1000000);
        System.out.printf("Elapsed time %1$tM:%1$tS,%1$tL\n", cal);

    }
}
