package com.nycjv321.testng.builders;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


/**
 * Created by fedora on 11/4/15.
 */
public class InstanceBuilderTest {
    private static final Logger logger = LogManager.getLogger(InstanceBuilderTest.class);

    @Test
    public void runMe(Method method) {
        logger.debug(method.getName() + " running...");
    }

}

