package org.selenium;

import cucumber.api.java.en.Given;

public class StepsDefinitions {

    private static final String URL = "https://subaru-maps.com/#/auth/sign-in";

    @Given("^User opens page$")
    public void user_opens_page() {
        BrowserInstance.openURL(URL);
    }


}
