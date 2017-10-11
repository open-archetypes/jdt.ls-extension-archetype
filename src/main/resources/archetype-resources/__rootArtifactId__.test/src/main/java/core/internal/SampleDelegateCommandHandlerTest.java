package ${package}.core.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
* Sample integration test. In Eclipse, right-click > Run As > JUnit-Plugin. <br/>
* In Maven CLI, run "mvn integration-test".
*/
public class SampleDelegateCommandHandlerTest {

	private SampleDelegateCommandHandler commandHandler;

	@Before
	public void setUp() {
		commandHandler = new SampleDelegateCommandHandler();
	}

	@Test
	public void veryStupidTest() throws Exception {
		assertEquals("Hello World", commandHandler.executeCommand(SampleDelegateCommandHandler.COMMAND_ID, null, null));
	}
}