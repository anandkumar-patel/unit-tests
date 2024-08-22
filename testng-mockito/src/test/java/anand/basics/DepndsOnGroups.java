package anand.basics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DepndsOnGroups {
	String message = "anand";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test(groups = { "init" })
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = "anand";
		Assert.assertEquals(message, messageUtil.printMessage());
	}

	@Test(dependsOnGroups = { "init" })
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "anand";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}

	@Test(groups = { "init" })
	public void initEnvironmentTest() {
		System.out.println("This is initEnvironmentTest");
	}
	
	@Test(groups = { "init" })
	public void initOther() {
		System.out.println("This is initOther");
	}
}