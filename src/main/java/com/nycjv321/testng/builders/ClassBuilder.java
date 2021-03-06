package com.nycjv321.testng.builders;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;

import java.util.List;

/**
 * Created by fedora on 11/4/15.
 */
class ClassBuilder extends Builder<XmlClass, ClassBuilder> {
    private final XmlClass clazz;

    public ClassBuilder(Class<?> clazz) {
        this.clazz = new XmlClass(clazz);
    }

    public ClassBuilder name(String name) {
        clazz.setName(name);
        return getThis();
    }

    public ClassBuilder whiteList(List<String> methodNames) {
        for (String methodName : methodNames) {
            whiteList(methodName);
        }
        return getThis();
    }

    public ClassBuilder whiteList(String methodName) {
        List<XmlInclude> includedMethods = clazz.getIncludedMethods();
        XmlInclude include = new XmlInclude(methodName);
        includedMethods.add(include);
        clazz.setIncludedMethods(includedMethods);
        return getThis();
    }

    public XmlClass build() {
        return clazz;
    }


    @Override
    public ClassBuilder getThis() {
        return this;
    }
}