/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.protocol.serializer;

import de.rub.nds.tlsattacker.core.constants.ProtocolVersion;
import de.rub.nds.tlsattacker.core.protocol.message.EncryptedExtensionsMessage;

/**
 * @author Nurullah Erinola <nurullah.erinola@rub.de>
 */
public class EncryptedExtensionsSerializer extends HandshakeMessageSerializer<EncryptedExtensionsMessage> {

    private final EncryptedExtensionsMessage msg;

    public EncryptedExtensionsSerializer(EncryptedExtensionsMessage message, ProtocolVersion version) {
        super(message, version);
        this.msg = message;
    }

    @Override
    public byte[] serializeHandshakeMessageContent() {
        LOGGER.debug("Serializing EncryptedExtensionsMessage");
        if (hasExtensionLengthField()) {
            writeExtensionLength();
            if (hasExtensions()) {
                writeExtensionBytes();
            }
        }
        return getAlreadySerialized();
    }

}