package Listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ISuiteListener, ITestListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("suit Start");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("suit Finish");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getDescription());
         }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }
}
