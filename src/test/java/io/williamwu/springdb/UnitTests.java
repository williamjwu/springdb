package io.williamwu.springdb;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class UnitTests {

    @Test
    public void testStudent() {
        Student student = new Student("william", 19, Enums.Gender.MALE);
        student.addClass("calculus");
        student.addClass("english");
        student.addClass("psychology");
        Iterator a = student.getClasses();
        while (a.hasNext()) {
            System.out.println(a.next());
        }
        Assert.assertEquals(Enums.Gender.MALE, student.getGender());
    }

    @Test
    public void testClass() {

    }
}
