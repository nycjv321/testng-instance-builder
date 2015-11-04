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

    public ClassBuilder whiteList(String methodName) {
        List<XmlInclude> includedMethods = clazz.getIncludedMethods();
        includedMethods.add(new XmlInclude(methodName));
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
