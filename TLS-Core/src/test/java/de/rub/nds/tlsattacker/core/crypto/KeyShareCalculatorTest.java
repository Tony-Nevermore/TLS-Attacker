/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.crypto;

import de.rub.nds.tlsattacker.core.constants.NamedGroup;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Merget <robert.merget@rub.de>
 */
public class KeyShareCalculatorTest {

    public KeyShareCalculatorTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of createClassicEcPublicKey method, of class KeyShareCalculator.
     */
    @Test
    public void testCreateClassicEcPublicKey() {
    }

    /**
     * Test of createX25519KeyShare method, of class KeyShareCalculator.
     */
    @Test
    public void testCreateX25519KeyShare() {
    }

    @Test
    public void crashTest() {
        List<BigInteger> somePrivateKeyList = new LinkedList<>();
        somePrivateKeyList.add(BigInteger.ZERO);
        somePrivateKeyList.add(BigInteger.ONE);
        somePrivateKeyList.add(new BigInteger(8, new Random(0)));
        somePrivateKeyList.add(new BigInteger(32, new Random(0)));
        somePrivateKeyList.add(new BigInteger(128, new Random(0)));
        somePrivateKeyList.add(new BigInteger(256, new Random(0)));
        for (BigInteger bigInt : somePrivateKeyList) {
            for (NamedGroup group : NamedGroup.getImplemented()) {
                System.out.println("Testing: " + group + " - privKey: " + bigInt.toString());
                if (group.isStandardCurve()) {
                    KeyShareCalculator.createClassicEcPublicKey(group, bigInt);
                } else {
                    KeyShareCalculator.createX25519KeyShare(group, bigInt);
                }
                // Note this test has to be extended once we support more groups
            }
        }
    }
}
