package test.java.models.enums;

import static org.junit.Assert.assertEquals;
import main.java.models.enums.CtrlSendModes;

import org.junit.Test;

public class TestCtrlSendModes {
        @Test
        public final void testOrdinal() {
                assertEquals(0, CtrlSendModes.OFF.ordinal());
                assertEquals(1, CtrlSendModes.CTRL.ordinal());
                assertEquals(2, CtrlSendModes.SYSEX.ordinal());
                assertEquals(3, CtrlSendModes.CTRL_SYSEX.ordinal());
        }
}
