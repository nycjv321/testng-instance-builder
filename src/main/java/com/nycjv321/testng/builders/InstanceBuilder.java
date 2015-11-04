package com.nycjv321.testng.builders;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedora on 11/3/15.
 */
public class InstanceBuilder extends Builder<TestNG, InstanceBuilder> {

    private final TestNG testNG = new TestNG();
    private final List<XmlSuite> suites = new ArrayList<>();

    private InstanceBuilder() {
        testNG.setXmlSuites(suites);
    }

    public static InstanceBuilder createInstanceBuilder() {
        return new InstanceBuilder();
    }

    public InstanceBuilder dataProviderThreadCount(int count) {
        testNG.setDataProviderThreadCount(count);
        return getThis();
    }

    public InstanceBuilder add(SuiteBuilder builder) {
        suites.add(builder.build());
        return getThis();
    }

    public TestNG build() {
        return testNG;
    }

    @Override
    public InstanceBuilder getThis() {
        return this;
    }
}
