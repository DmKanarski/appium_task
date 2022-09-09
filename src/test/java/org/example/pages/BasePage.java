package org.example.pages;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IElementFactory;
import aquality.selenium.core.elements.interfaces.IElement;

public abstract class BasePage {

    public abstract void waitUntilDisplayed();

    protected IElementFactory getElementFactory() {
        return AqualityServices.getElementFactory();
    }

    protected void waitForClickableAndClick(IElement element) {
        element.state().waitForClickable();
        element.click();
    }

}
