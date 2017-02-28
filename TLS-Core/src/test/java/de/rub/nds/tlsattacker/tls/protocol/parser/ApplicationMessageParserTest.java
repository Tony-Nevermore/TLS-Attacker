/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0 http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.parser;

import de.rub.nds.tlsattacker.tls.protocol.message.ApplicationMessage;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
@RunWith(Parameterized.class)
public class ApplicationMessageParserTest {
    
    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays
                .asList(new Object[][] {
                        {
                            new byte[]{0,1,2,3,4,5,6},0,new byte[]{0,1,2,3,4,5,6},new byte[]{0,1,2,3,4,5,6}
                        },
                        {
                            new byte[]{0,1,2,3,4,5,6},2,new byte[]{2,3,4,5,6},new byte[]{2,3,4,5,6}
                        }});
    }
    
    private byte[] message;
    private int start;
    private byte[] expectedPart;
    private byte[] data;

    public ApplicationMessageParserTest(byte[] message, int start, byte[] expectedPart, byte[] data) {
        this.message = message;
        this.start = start;
        this.expectedPart = expectedPart;
        this.data = data;
    }

    /**
     * Test of parse method, of class ApplicationMessageParser.
     */
    @Test
    public void testParse() {
        ApplicationMessageParser parser = new ApplicationMessageParser(start, message);
        ApplicationMessage applcationMessage = parser.parse();
        assertArrayEquals(applcationMessage.getCompleteResultingMessage().getValue(), expectedPart);
        assertArrayEquals(applcationMessage.getData().getValue(),data);
    }
    
}