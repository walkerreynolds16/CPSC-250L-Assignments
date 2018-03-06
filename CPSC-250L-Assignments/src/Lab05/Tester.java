package Lab05;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import edu.cnu.cs.gooey.Gooey;
import edu.cnu.cs.gooey.GooeyDialog;

public class Tester {

	public static void main(String[] args) {
		
		testResetNaive_ClosingDialogDoesNotChangeCombination();
	}
	
	public static void testResetNaive_ClosingDialogDoesNotChangeCombination() {
		Combination         now  = new Combination( 1, 2, 3 );
		final LockWithReset lock = new LockWithReset( 5, now );
		// dialog with empty input
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetNaive();
			}					
			@Override
			public void test(JDialog dialog) {
				Gooey.getLabel ( dialog, "Type a new combination" );
				Gooey.getButton( dialog, "Cancel" ).doClick();
			}
		});
		// combination shouldn't change
		lock.close();
		lock.open ( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}

}
