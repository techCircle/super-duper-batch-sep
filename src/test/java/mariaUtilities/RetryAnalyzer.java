package mariaUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
///// please copy the code from git hum ms maria/////
public class RetryAnalyzer implements IRetryAnalyzer {

	// this class is used to retry the failed methods and re run them and if they are retried for the given time 
	//it retries and in the end it gives that it failed
	int counter = 0;
	int retryLimit = 50;

	@Override
	public boolean retry(ITestResult result) {

		if (counter < retryLimit) {

			
			counter++;
			return true;
			
		}

		return false;
	}


}
