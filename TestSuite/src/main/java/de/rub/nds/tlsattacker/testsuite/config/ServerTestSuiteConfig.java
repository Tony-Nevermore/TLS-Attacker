/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0 http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.testsuite.config;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;
import de.rub.nds.tlsattacker.tls.config.TLSDelegateConfig;
import de.rub.nds.tlsattacker.tls.config.delegate.ClientDelegate;

/**
 *
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class ServerTestSuiteConfig extends TLSDelegateConfig {

    public static final String COMMAND = "testsuite_server";

    @Parameter(names = "-folder", description = "Root folder including the test cases.")
    String folder = "../resources/testsuite";

    @ParametersDelegate
    private ClientDelegate clientDelegate;

    public ServerTestSuiteConfig() {
        clientDelegate = new ClientDelegate();
        addDelegate(clientDelegate);
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
