package controller;

import view.ViewFactory;
/*
 * This abstract class is used as a base controller for all other controllers.
 * These controllers are generated from Scenebuilder code, then added onto as needed for logic code
 * using UI element. 
 * 
 * Because it is abstract, it cannot be initialized in another files but can be implmented
 * Example: controller/MainWindowController.java 
 * public class MainWindowController extends BaseController
 */
public abstract class BaseController {

    protected ViewFactory viewFactory;
    private String fxmlName;

    // Base contstructor
    public BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
