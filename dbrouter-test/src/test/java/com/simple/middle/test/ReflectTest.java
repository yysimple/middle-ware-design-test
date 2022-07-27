package com.simple.middle.test;

import com.simple.middle.test.dbrouter.test.ParamTest;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 项目: middle-ware-design-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-07-27 22:06
 **/
public class ReflectTest {

    public String testParam(@ParamTest("111") String name, Integer age) {
        return "2222";
    }

    @Test
    public void paramTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Method method = reflectTestClass.getDeclaredMethod("testParam", String.class, Integer.class);
        System.out.println(method.getName());
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] parameterAnnotation = parameterAnnotations[i];
            for (int i1 = 0; i1 < parameterAnnotation.length; i1++) {
                Annotation annotation = parameterAnnotation[i];
                System.out.println(annotation instanceof ParamTest);
            }
        }
    }

    @Test
    public void paramNameTest() throws Exception {
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Method method = reflectTestClass.getDeclaredMethod("testParam", String.class, Integer.class);
        System.out.println(method.getName());
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter.getName());
        }
    }


}
