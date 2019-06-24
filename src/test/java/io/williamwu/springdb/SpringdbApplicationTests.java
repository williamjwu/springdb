package io.williamwu.springdb;

import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringdbApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void testStudent() {
        Student a = new Student("william", 19, Enums.Gender.MALE);
        System.out.println(a.getId());
    }

}
