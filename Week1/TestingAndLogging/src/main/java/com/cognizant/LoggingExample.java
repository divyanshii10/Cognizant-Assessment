package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("This is an INFO message.");
        logger.debug("This is a DEBUG message. (May not show if default level is INFO)");
        
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.warn("This is a WARNING message: Attempted division by zero.");
            logger.error("This is an ERROR message: ", e);
        }
    }
}
