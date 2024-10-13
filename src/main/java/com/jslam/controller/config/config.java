package com.jslam.controller.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Config {

    private Boolean logErrors = false;
    private Boolean startEnabled = false;
    private Boolean minSystemTray = false;
    private Boolean startMini = false;
    
    // Default Constructor
    public Config(Boolean logErrors, Boolean startEnabled, Boolean minSystemTray, Boolean startMini) {
        this.logErrors = logErrors;
        this.startEnabled = startEnabled;
        this.minSystemTray = minSystemTray;
        this.startMini = startMini;
    }

    // Getter - Setter for log errors with XmlElement annotation
    @XmlElement
    public Boolean getLogErrors() {
        return logErrors;
    }

    public void setLogErrors(Boolean logErrors) {
        this.logErrors = logErrors;
    }

    // Getter - Setter for start enabled with XmlElement annotation
    @XmlElement
    public Boolean getStartEnabled() {
        return startEnabled;
    }

    public void setStartEnabled(Boolean startEnabled) {
        this.startEnabled = startEnabled;
    }

    // Getter - Setter for minimize system tray with XmlElement annotation
    @XmlElement
    public Boolean getMinSystemTray() {
        return minSystemTray;
    }

    public void setMinSystemTray(Boolean minSystemTray) {
        this.minSystemTray = minSystemTray;
    }

    // Getter - Setter for start minimized with XmlElement annotation
    @XmlElement
    public Boolean getStartMini() {
        return startMini;
    }

    public void setStartMini(Boolean startMini) {
        this.startMini = startMini;
    }

    // Used to print the info of this class
    @Override
    public String toString() {
        return "Config [logErrors=" + logErrors + ", startEnabled=" + startEnabled + ", minSystemTray=" + minSystemTray + ", startMini=" + startMini + "]" ;
    }
}
