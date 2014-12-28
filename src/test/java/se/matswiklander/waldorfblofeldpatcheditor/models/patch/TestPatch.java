package test.java.se.matswiklander.waldorfblofeldpatcheditor.models.patch;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import main.java.se.matswiklander.waldorfblofeldpatcheditor.models.enums.ZeroToPlus127;
import main.java.se.matswiklander.waldorfblofeldpatcheditor.models.patch.Banks;
import main.java.se.matswiklander.waldorfblofeldpatcheditor.models.patch.Categories;
import main.java.se.matswiklander.waldorfblofeldpatcheditor.models.patch.Patch;

import org.junit.Test;

public class TestPatch {
        private final byte[] initPatchData = new byte[] { 0x01, 0x40, 0x40,
                        0x40, 0x42, 0x60, 0x00, 0x00, 0x02, 0x7F, 0x01, 0x40,
                        0x00, 0x00, 0x00, 0x00, 0x00, 0x40, 0x40, 0x40, 0x42,
                        0x60, 0x00, 0x00, 0x00, 0x7F, 0x03, 0x40, 0x00, 0x00,
                        0x00, 0x00, 0x00, 0x34, 0x40, 0x40, 0x42, 0x60, 0x00,
                        0x00, 0x00, 0x7F, 0x05, 0x40, 0x00, 0x00, 0x00, 0x00,
                        0x00, 0x00, 0x02, 0x40, 0x00, 0x00, 0x00, 0x00, 0x00,
                        0x14, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x7F, 0x00, 0x7F,
                        0x00, 0x00, 0x00, 0x40, 0x00, 0x00, 0x00, 0x00, 0x01,
                        0x00, 0x00, 0x01, 0x7F, 0x40, 0x00, 0x00, 0x00, 0x00,
                        0x00, 0x00, 0x40, 0x40, 0x40, 0x01, 0x40, 0x00, 0x00,
                        0x40, 0x01, 0x40, 0x00, 0x00, 0x7F, 0x40, 0x00, 0x00,
                        0x00, 0x00, 0x00, 0x00, 0x40, 0x40, 0x40, 0x00, 0x40,
                        0x00, 0x00, 0x40, 0x03, 0x40, 0x00, 0x00, 0x03, 0x00,
                        0x00, 0x7F, 0x72, 0x05, 0x40, 0x00, 0x00, 0x00, 0x01,
                        0x00, 0x14, 0x40, 0x40, 0x00, 0x7F, 0x7F, 0x7F, 0x7F,
                        0x7F, 0x7F, 0x7F, 0x7F, 0x7F, 0x7F, 0x08, 0x00, 0x35,
                        0x40, 0x64, 0x00, 0x40, 0x64, 0x00, 0x64, 0x6E, 0x00,
                        0x0F, 0x40, 0x7F, 0x7F, 0x00, 0x32, 0x40, 0x00, 0x00,
                        0x00, 0x00, 0x40, 0x00, 0x00, 0x40, 0x00, 0x00, 0x28,
                        0x40, 0x00, 0x00, 0x00, 0x00, 0x40, 0x00, 0x00, 0x40,
                        0x00, 0x00, 0x1E, 0x40, 0x00, 0x00, 0x00, 0x00, 0x40,
                        0x00, 0x00, 0x40, 0x01, 0x00, 0x40, 0x00, 0x00, 0x7F,
                        0x32, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x00, 0x00, 0x40,
                        0x00, 0x00, 0x7F, 0x34, 0x7F, 0x00, 0x7F, 0x00, 0x00,
                        0x00, 0x00, 0x40, 0x00, 0x00, 0x40, 0x40, 0x40, 0x40,
                        0x40, 0x40, 0x00, 0x00, 0x00, 0x40, 0x00, 0x00, 0x40,
                        0x40, 0x40, 0x40, 0x40, 0x40, 0x00, 0x00, 0x01, 0x00,
                        0x00, 0x00, 0x40, 0x00, 0x00, 0x00, 0x40, 0x00, 0x00,
                        0x00, 0x40, 0x00, 0x00, 0x00, 0x40, 0x01, 0x01, 0x40,
                        0x00, 0x00, 0x40, 0x00, 0x00, 0x40, 0x00, 0x00, 0x40,
                        0x00, 0x00, 0x40, 0x00, 0x00, 0x40, 0x00, 0x00, 0x40,
                        0x00, 0x00, 0x40, 0x00, 0x00, 0x40, 0x00, 0x00, 0x40,
                        0x00, 0x00, 0x40, 0x00, 0x00, 0x40, 0x00, 0x00, 0x40,
                        0x00, 0x00, 0x40, 0x00, 0x00, 0x40, 0x00, 0x00, 0x40,
                        0x10, 0x64, 0x00, 0x00, 0x0F, 0x08, 0x05, 0x00, 0x00,
                        0x00, 0x01, 0x0C, 0x00, 0x00, 0x0F, 0x00, 0x00, 0x37,
                        0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04,
                        0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x44, 0x44,
                        0x44, 0x44, 0x44, 0x44, 0x44, 0x44, 0x44, 0x44, 0x44,
                        0x44, 0x44, 0x44, 0x44, 0x44, 0x44, 0x00, 0x00, 0x00,
                        0x49, 0x6E, 0x69, 0x74, 0x20, 0x20, 0x20, 0x20, 0x20,
                        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x00, 0x00,
                        0x00, 0x00 };

        @Test
        public final void testBankAndNumber() {
                Patch patch = new Patch();

                patch.setBank(Banks.C);
                assertEquals(Banks.C, patch.getBank());

                patch.setNumber(ZeroToPlus127.PLUS93);
                assertEquals(ZeroToPlus127.PLUS93, patch.getNumber());
        }

        @Test
        public final void testInitPatch() {
                Patch patch = new Patch();

                assertNotNull(patch.getOscillators());
                assertNotNull(patch.getMixers());
                assertNotNull(patch.getFilters());
                assertNotNull(patch.getAmplifier());
                assertNotNull(patch.getArpeggiator());
                assertNotNull(patch.getEffect1());
                assertNotNull(patch.getEffect2());
                assertNotNull(patch.getEnvelopes());
                assertNotNull(patch.getMixers());
                assertNotNull(patch.getModifiers());
                assertNotNull(patch.getModulations());
                assertNotNull(patch.getLfos());

                assertArrayEquals(initPatchData, patch.getPatchData()
                                .getPayload());

                assertEquals(0x3b, patch.getChecksum());
        }

        @Test
        public final void testPatchCategory() {
                Patch patch = new Patch();

                assertEquals(Categories.INIT.value, patch.getPatchData()
                                .getPayload()[379]);

                patch.setCategory(Categories.LEAD);

                assertEquals(Categories.LEAD.value, patch.getPatchData()
                                .getPayload()[379]);

                assertEquals(Categories.LEAD, patch.getCategory());
        }

        @Test
        public final void testPatchName() {
                Patch patch = new Patch();

                patch.setName("TestPatch");

                assertEquals('T', patch.getPatchData().getPayload()[363]);
                assertEquals('e', patch.getPatchData().getPayload()[364]);
                assertEquals('s', patch.getPatchData().getPayload()[365]);
                assertEquals('t', patch.getPatchData().getPayload()[366]);
                assertEquals('P', patch.getPatchData().getPayload()[367]);
                assertEquals('a', patch.getPatchData().getPayload()[368]);
                assertEquals('t', patch.getPatchData().getPayload()[369]);
                assertEquals('c', patch.getPatchData().getPayload()[370]);
                assertEquals('h', patch.getPatchData().getPayload()[371]);
                assertEquals(' ', patch.getPatchData().getPayload()[372]);
                assertEquals(' ', patch.getPatchData().getPayload()[373]);
                assertEquals(' ', patch.getPatchData().getPayload()[374]);
                assertEquals(' ', patch.getPatchData().getPayload()[375]);
                assertEquals(' ', patch.getPatchData().getPayload()[376]);
                assertEquals(' ', patch.getPatchData().getPayload()[377]);
                assertEquals(' ', patch.getPatchData().getPayload()[378]);

                assertEquals("TestPatch", patch.getName());
        }
}