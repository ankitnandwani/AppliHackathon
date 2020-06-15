package com.ankitnandwani.cucumber;


import com.ankitnandwani.cucumber.Repo.AppliFashion.FashionHome;
import com.applitools.eyes.TestResultsSummary;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by mac on 25/08/17.
 */
public class Browser {

    private WebDriver driver;
    private Properties prop;
    private FashionHome fashionHome;


    @Before
    public void setUp(){
        FileInputStream f = null;
        try{
            f = new FileInputStream(new File("src/test/Resources/com/ankitnandwani/cucumber/Config.properties"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        prop = new Properties();
        try{
            prop.load(f);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public WebDriver getDriver(String browserInstance, String _width, String _height){
        int width = Integer.parseInt(_width);
        int height = Integer.parseInt(_height);

        switch (browserInstance){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver",prop.getProperty("driverExecutable") + "/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().setSize(new Dimension(width, height));
                break;

            case "firefox" :
                System.setProperty("webdriver.gecko.driver",prop.getProperty("driverExecutable") + "/geckodriver");
                File pathToBinary = new File("C:\\Users\\ankit.nandwani\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
                FirefoxBinary firefoxBinary = new FirefoxBinary(pathToBinary);
                DesiredCapabilities desired = DesiredCapabilities.firefox();
                FirefoxOptions options = new FirefoxOptions();
                desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                driver = new FirefoxDriver(options);
                driver.manage().window().setSize(new Dimension(width, height));
                break;

            case "edge" :
                System.setProperty("webdriver.edge.driver",prop.getProperty("driverExecutable") + "/msedgedriver");
                driver = new EdgeDriver();
                driver.manage().window().setSize(new Dimension(width, height));
                break;

        }

        return driver;
    }


    @After
    public void tearDown(){
        driver.quit();
    }


}
