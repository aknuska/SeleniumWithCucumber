package org.selenium;

import org.openqa.selenium.support.PageFactory;

public class Page {

    public Page(boolean waitForConnectionsToClose) {
        if (waitForConnectionsToClose) {
            PageFactory.initElements(BrowserInstance.getDriver(), this);
            waitToLoad();
        } else {
            PageFactory.initElements(BrowserInstance.getDriver(), this);
        }
    }

    public final void waitToLoad() {
        BrowserInstance.waitForAllConnectionsToClose();
    }

}
