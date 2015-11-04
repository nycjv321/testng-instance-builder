package com.nycjv321.testng.builders;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* Created by fedora on 11/4/15.
*/
class TestBuilder extends Builder<XmlTest, TestBuilder> {
    private final List<XmlClass> classes = new ArrayList<>();
    private final XmlTest test;

    private TestBuilder(SuiteBuilder suite) {
        test = new XmlTest(suite.get());
    }

    public static TestBuilder createTestBuilder(SuiteBuilder suite) {
        return new TestBuilder(suite);
    }


    public TestBuilder add(ClassBuilder classBuilder) {
        classes.add(classBuilder.build());
        return getThis();
    }

    public TestBuilder parameters(Map<String, String> parameters) {
        test.setParameters(parameters);
        return getThis();
    }

    public TestBuilder name(String name) {
        test.setName(name);
        return getThis();
    }

    public XmlTest build() {
        test.setXmlClasses(classes);
        return test;
    }

    @Override
    public TestBuilder getThis() {
        return this;
    }
}
