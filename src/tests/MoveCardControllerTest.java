package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MoveCardControllerWasteToFoundationsTest.class,
		MoveCardControllerWasteToTableausTest.class,
		MoveCardControllerDeckToWasteTest.class})
public class MoveCardControllerTest {

}
