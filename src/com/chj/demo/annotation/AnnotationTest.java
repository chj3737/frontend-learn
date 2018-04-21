package com.chj.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ccb on 2016/12/15.
 */
@DomainObject(name="annotationTest")
public class AnnotationTest {

    @ExportMethod(name="mapToList")
    public List mapToList(Map map) {
        List l = new ArrayList(map.size());
        l.add("123");
        return l;
    }

    public void unannotatedMethod() {

    }

    public static void main(String[] args) throws ClassNotFoundException {
//        Class clazz = Class.forName("com.chj.demo.annotation.AnnotationTest");
        Class clazz = new AnnotationTest().getClass();
        final Annotation[] annotations = clazz.getAnnotations();
        for (Annotation ant: annotations ) {
            System.out.println(((DomainObject)ant).name());
        }

        final Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
            if (m.isAnnotationPresent(ExportMethod.class)) {
                System.out.println("=======" + m.getAnnotation(ExportMethod.class).name());
            }
        }
    }
}
