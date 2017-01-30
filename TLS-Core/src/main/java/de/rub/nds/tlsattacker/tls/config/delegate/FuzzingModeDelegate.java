/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.config.delegate;

import com.beust.jcommander.Parameter;
import de.rub.nds.tlsattacker.tls.workflow.TlsConfig;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class FuzzingModeDelegate extends Delegate {

    @Parameter(names = "-fuzzing", description = "If sets, supresses Value and generates invalid Data for Cryptographic operations on the FLY. Throws Exceptions otherwise.")
    private boolean fuzzingMode = false;

    public FuzzingModeDelegate() {
    }

    public boolean isFuzzingMode() {
        return fuzzingMode;
    }

    public void setFuzzingMode(boolean fuzzingMode) {
        this.fuzzingMode = fuzzingMode;
    }

    @Override
    public void applyDelegate(TlsConfig config) {
        config.setFuzzingMode(fuzzingMode);
    }

}