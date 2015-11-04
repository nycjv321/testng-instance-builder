package com.nycjv321.testng.builders;

import org.testng.ITestNGListener;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fedora on 11/4/15.
 */
class SuiteBuilder extends Builder<XmlSuite, SuiteBuilder> {
    private final List<XmlTest> tests = new ArrayList<>();
    private final XmlSuite suite;

    private SuiteBuilder() {
        this.suite = new XmlSuite();
    }

    public static SuiteBuilder createSuiteBuilder() {
        return new SuiteBuilder();
    }

    public SuiteBuilder add(TestBuilder builder) {
        tests.add(builder.build());
        return getThis();
    }

    public SuiteBuilder name(String name) {
        suite.setName(name);
        return getThis();
    }

    public SuiteBuilder parameters(Map<String, String> parameters) {
        suite.setParameters(parameters);
        return getThis();
    }

    public SuiteBuilder listener(ITestNGListener listener) {
        List<String> listeners = suite.getListeners();
        listeners.add(listener.getClass().getCanonicalName());
        suite.setListeners(listeners);
        return getThis();
    }


    public XmlSuite build() {
        suite.setTests(tests);
        return suite;
    }

    public XmlSuite get() {
        return suite;
    }

    @Override
    public SuiteBuilder getThis() {
        return this;
    }
}
