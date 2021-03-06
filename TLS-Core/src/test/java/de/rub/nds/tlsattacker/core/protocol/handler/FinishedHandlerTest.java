/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.protocol.handler;

import de.rub.nds.tlsattacker.core.protocol.message.FinishedMessage;
import de.rub.nds.tlsattacker.core.protocol.parser.FinishedParser;
import de.rub.nds.tlsattacker.core.protocol.preparator.FinishedPreparator;
import de.rub.nds.tlsattacker.core.protocol.serializer.FinishedSerializer;
import de.rub.nds.tlsattacker.core.state.TlsContext;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FinishedHandlerTest {

    private FinishedHandler handler;
    private TlsContext context;

    @Before
    public void setUp() {
        context = new TlsContext();
        handler = new FinishedHandler(context);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getParser method, of class FinishedHandler.
     */
    @Test
    public void testGetParser() {
        assertTrue(handler.getParser(new byte[1], 0) instanceof FinishedParser);
    }

    /**
     * Test of getPreparator method, of class FinishedHandler.
     */
    @Test
    public void testGetPreparator() {
        assertTrue(handler.getPreparator(new FinishedMessage()) instanceof FinishedPreparator);
    }

    /**
     * Test of getSerializer method, of class FinishedHandler.
     */
    @Test
    public void testGetSerializer() {
        assertTrue(handler.getSerializer(new FinishedMessage()) instanceof FinishedSerializer);
    }

    /**
     * Test of adjustTLSContext method, of class FinishedHandler.
     */
    @Test
    public void testAdjustTLSContext() {
        FinishedMessage message = new FinishedMessage();
        message.setVerifyData(new byte[] { 0, 1, 2, 3, 4 });
        handler.adjustTLSContext(message);
        // TODO check that context did not change
    }

}
