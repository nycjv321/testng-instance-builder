package com.nycjv321.testng.builders;

import com.google.common.collect.ImmutableMap;
import com.nycjv321.testng.annotationtransformers.InvocationCountTransformer;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static com.nycjv321.testng.builders.InstanceBuilder.createInstanceBuilder;
import static com.nycjv321.testng.builders.TestBuilder.createTestBuilder;
import static java.util.stream.Collectors.toList;

/**
 * Created by jvelasquez on 11/4/15.
 */
public class TestNGRunnerExample {

    public static void main(String[] args) {
        SuiteBuilder suiteBuilder = SuiteBuilder
                .createSuiteBuilder()
                .listener(
                        InvocationCountTransformer.count(1)
                )
                .name("test suite")
                .parameters(
                        ImmutableMap.of(
                                "parentKey", "value", "anotherKey", "anotherValue"
                        )
                );

        ClassBuilder classBuilder = new ClassBuilder(InstanceBuilderTest.class);
        classBuilder.whiteList(Stream.of(InstanceBuilderTest.class.getDeclaredMethods()).map(Method::getName).collect(toList()));
        suiteBuilder.add(
                createTestBuilder(suiteBuilder).name("test instance").add(
                        classBuilder
                ).parameters(
                        ImmutableMap.of("key", "value", "anotherKey", "what!")
                )
        );
        createInstanceBuilder().add(suiteBuilder).dataProviderThreadCount(1).build().run();
    }
}
