package com.nycjv321.testng.annotationtransformers;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by fedora on 11/4/15.
 */
public class InvocationCountTransformer implements IAnnotationTransformer {

    private static int count;

    public static InvocationCountTransformer get(int count) {
        InvocationCountTransformer invocationCountTransformer = new InvocationCountTransformer();
        InvocationCountTransformer.count = count;
        return invocationCountTransformer;
    }

    public InvocationCountTransformer(){}

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
     annotation.setInvocationCount(count);
    }
}
