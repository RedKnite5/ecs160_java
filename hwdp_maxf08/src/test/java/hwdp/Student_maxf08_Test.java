package hwdp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Student_maxf08_Test {
    @Test
    void myStudentTest() {
        /* Test toString methods */
        LibraryBook book = new LibraryBook("The Emperor of the Bands");
        assertEquals(book.toString(), "The Emperor of the Bands");

        SourceObserver srcObserver = new SourceObserver("Eye");
        assertEquals(srcObserver.toString(), "Eye");

        DestObserver destObserver = new DestObserver("Target");
        assertEquals(destObserver.toString(), "Target");

        LBState onshelf = OnShelf.getInstance();
        assertEquals(onshelf.toString(), "OnShelf");

        LBState borrowed = Borrowed.getInstance();
        assertEquals(borrowed.toString(), "Borrowed");

        LBState gotback = GotBack.getInstance();
        assertEquals(gotback.toString(), "GotBack");
        
        LibraryLogger.getInstance().clearWriteLog();

        book.attach(srcObserver);
        book.attach(srcObserver);

        assertArrayEquals(
			new String [] {
                "Eye is now watching The Emperor of the Bands",
                "Eye is already attached to The Emperor of the Bands",
			}, 
			LibraryLogger.getInstance().getWrittenLines()
		);
    }
}
