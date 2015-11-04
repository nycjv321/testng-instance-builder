package com.nycjv321.testng.builders;

import com.google.common.collect.ImmutableMap;
import com.nycjv321.testng.annotationtransformers.InvocationCountTransformer;
import com.nycjv321.testng.builders.ClassBuilder;
import com.nycjv321.testng.builders.SuiteBuilder;
import com.nycjv321.testng.builders.TestBuilder;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.nycjv321.testng.builders.InstanceBuilder.createInstanceBuilder;
import static com.nycjv321.testng.builders.TestBuilder.createTestBuilder;

/**
 * // TODO ACTUALLY FINALIZE THIS
 * Created by fedora on 11/4/15.
 */
public class InstanceBuilderTest {
    private static int count = 0;

    @Test
    public void testRunnerBoom() {
        SuiteBuilder suiteBuilder = SuiteBuilder.createSuiteBuilder().listener(InvocationCountTransformer.get(2)).name("test suite");
        TestBuilder testBuilder = createTestBuilder(suiteBuilder);
        ClassBuilder classBuilder = new ClassBuilder(this.getClass());
        classBuilder.whiteList("runMe");
        suiteBuilder.add(
                testBuilder.name("test instance").add(
                        classBuilder
                ).parameters(
                        ImmutableMap.of("key", "value")
                )
        );
        TestNG testng = createInstanceBuilder().add(suiteBuilder).dataProviderThreadCount(25).build();
        testng.run();
    }

    @Test
    public void runMe(){
        System.out.println("#becuasewhynotbecuasenotwhy?");
        ++count;

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("Ran "+ count+ " tests!");
    }

}
