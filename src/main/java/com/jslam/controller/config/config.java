package com.jslam.controller.config;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Config {

    private Boolean logErrors = false;
    private Boolean startEnabled = false;
    private Boolean minSystemTray = false;
    private Boolean startMini = false;
    private Boolean folderOverride = false;
    private String steamFolderPath = ""; // TODO
    private String userDateFolderPath = ""; // TODO
    private String path = "src\\main\\java\\com\\jslam\\controller\\config\\config.xml";

    // Default Constructor
    public Config() {

    }

    // Getter - Setter for path variable 
    public String getPath(){
        return this.path;
    }

    public void setPath(String path){
        this.path = path;
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

    @XmlElement
    public Boolean getFolderOverride() {
        return folderOverride;
    }

    public void setFolderOverride(Boolean folderOverride) {
        this.folderOverride = folderOverride;
    }

    // Used to print the info of this class
    @Override
    public String toString() {
        return "Config [logErrors=" + logErrors + ", startEnabled=" + startEnabled + ", minSystemTray=" + minSystemTray + ", startMini=" + startMini +  ", folderOverride=" + folderOverride + "]" ;
    }

    public void saveXMLToFile(){
        try{
            JAXBContext context = JAXBContext.newInstance(Config.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Save the config to an XML file
            marshaller.marshal(this, new File(this.path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void loadXMLFromFile() {
        try{ 
            JAXBContext context = JAXBContext.newInstance(Config.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            // Reads XML config file
            File file = new File("src\\main\\java\\com\\jslam\\controller\\config\\config.xml");

            if(file.exists()) {
                this.copy((Config) unmarshaller.unmarshal(file));
            } 

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void copy(Config config) {
        this.logErrors = config.logErrors;
        this.minSystemTray = config.minSystemTray;
        this.startEnabled = config.startEnabled;
        this.startMini = config.startMini;
        this.folderOverride = config.folderOverride;
    }
}
