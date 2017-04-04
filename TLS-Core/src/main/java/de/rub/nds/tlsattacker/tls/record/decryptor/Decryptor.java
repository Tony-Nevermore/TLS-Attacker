/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.record.decryptor;

import de.rub.nds.tlsattacker.tls.record.AbstractRecord;
import de.rub.nds.tlsattacker.tls.record.cipher.RecordCipher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Robert Merget <robert.merget@rub.de>
 * @param <T>
 */
public abstract class Decryptor<T extends AbstractRecord> extends RecordCryptoUnit {

    private static final Logger LOGGER = LogManager.getLogger("DECRYPTOR");

    public Decryptor(RecordCipher cipher) {
        super(cipher);
    }

    public abstract void decrypt(T object);
}
