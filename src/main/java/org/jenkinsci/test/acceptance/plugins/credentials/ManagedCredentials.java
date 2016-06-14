package org.jenkinsci.test.acceptance.plugins.credentials;

import java.util.List;
import java.util.concurrent.Callable;

import org.jenkinsci.test.acceptance.junit.WithPlugins;
import org.jenkinsci.test.acceptance.po.ContainerPageObject;
import org.jenkinsci.test.acceptance.po.Control;
import org.jenkinsci.test.acceptance.po.Jenkins;
import org.openqa.selenium.WebElement;

/**
 * "Manage Credentials" page.
 *
 * @author Vivek Pandey
 * @author Kohsuke Kawaguchi
 */
public class ManagedCredentials extends ContainerPageObject {
    public final Control addButton = control("/domainCredentials/hetero-list-add[credentials]");
    public final Control addDomainButton = control("/repeatable-add");

    public static final String DEFAULT_DOMAIN = "_";

    public ManagedCredentials(Jenkins j) {
        super(j, j.url("credentials/store/system/"));
    }

    public ManagedCredentials(Jenkins j, String domain) {
        super(j, j.url("credentials/store/system/domain/"+domain+"/"));
    }

    /**
     * Find if the given control exists on the main credentials page.
     * @param name
     * @return Control
     */
    public Control checkSystemPage(String name) {
        return control(by.link(name));
    }

    /**
     * Check if the given credential is part of the domain.
     * @param name
     * @return
     */
    public Control checkIfCredentialsExist(String name) {
        return control(by.xpath("//a[@title='"+name+"']"));
    }

    /**
     * Find the href of the associted
     * @param name
     * @return
     */
    public String credentialById(String name) {
        //String href = checkIfCredentialsExist(name).resolve().getAttribute("href");
        //return href.substring(href.lastIndexOf('/'));
        return checkIfCredentialsExist(name).resolve().getAttribute("href");
    }
}
