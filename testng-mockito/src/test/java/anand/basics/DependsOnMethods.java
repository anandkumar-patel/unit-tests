package anand.basics;

import org.testng.Assert;
import org.testng.annotations.Test;

// Dependency Test Using DependsOnMethods
public class DependsOnMethods {
	String message = "Anand";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = "Anand";
		Assert.assertEquals(message, messageUtil.printMessage());
	}

	@Test(dependsOnMethods = { "initEnvironmentTest" })
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Anand";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}

	@Test
	public void initEnvironmentTest() {
		System.out.println("This is initEnvironmentTest");
	}
}