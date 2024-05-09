package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestLoggerListener extends TestListenerAdapter {

    public static final Logger logger = LogManager.getLogger(TestLoggerListener.class);

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info("Test " + tr.getName() + " is finished.");

    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.error("Test " + tr.getName() + " has failed.");

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.warn("Test " + tr.getName() + " was skipped.");
    }
}

