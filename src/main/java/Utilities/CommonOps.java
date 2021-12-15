package Utilities;

import WorkFlows.WebWorkFlows.GrafanaWeb.DeleteUser;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static WorkFlows.WebWorkFlows.GrafanaWeb.CreateUser.createUser;
import static WorkFlows.WebWorkFlows.GrafanaWeb.CreateUser.createUserBeforeClass;
import static WorkFlows.WebWorkFlows.GrafanaWeb.LogInWF.logInWF;

public class CommonOps extends Base {

    protected static void initSoftAssert() {
        softAssert = new SoftAssert();
    }

    public static void closeDBCon() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error Occurred While Closing JDBC, See Details: " + e);
        }
    }

    // PrintScreen
    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeClass(description = "Init driver ")
    @Parameters({"Platform", "Browser"})
    public void startSession(String platform, @Optional String browser) throws Exception {
        switch (platform.toLowerCase()) {
            case "web":
                initWeb(browser.toLowerCase(), platform.toLowerCase());
                break;
            case "desktop":
                initDesktop(platform);
                break;
            case "api":
                initApi();
                break;
            case "appium":
                initAppium(platform);
                break;
            case "electron":
                initElectron(platform);
                break;
            default:
                throw new Exception("Invalid platform type");
        }
    }

    private void initWeb(String browser, String platform) throws Exception {
        initDriver(browser);
        intiWebUrl();
        intiImplicitlyWait();
        initSoftAssert();
        initDateBase();
        initExplicitWait();
        PageObjectManager.pageObjectManager(platform);
        logInWF();
        initActions();
        createUserBeforeClass();
        initScreenSikuli();
    }

    private void initActions() {
        actions = new Actions(driver);
    }

    public void initScreenSikuli() {
        screen = new Screen();
        impPath = ExternalFilesManager.getData("ImpPath");
    }

    private void initDriver(String browser) throws Exception {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new Exception("Invalid browser type");
        }
        driver.manage().window().maximize();
    }

    private void intiWebUrl() {
        driver.get(ExternalFilesManager.getData("WebUlr"));
    }

    private void intiImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    private void initDateBase() {
        dbUrl = ExternalFilesManager.getData("UrlDataBase");
        usernameDB = ExternalFilesManager.getData("UserNameDataBase");
        passwordDB = ExternalFilesManager.getData("PasswordDataBase");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, usernameDB, passwordDB);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    private void initExplicitWait() {
        wait = new WebDriverWait(driver, 5);
    }

    private void initDesktop(String platform) throws MalformedURLException {
        initDesktopSignature();
        initDesktopCapabilities();
        PageObjectManager.pageObjectManager(platform);
    }

    private void initDesktopSignature() {
        calcApp = ExternalFilesManager.getData("Signature");
    }

    private void initDesktopCapabilities() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", calcApp);
        driverDesktop = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    private void initApi() {
        initAuthentication();
    }

    private void initAuthentication() {
        baseURL = ExternalFilesManager.getData("baseURL");
        RestAssured.baseURI = baseURL;
        req = RestAssured.given().auth().preemptive().basic(ExternalFilesManager.getData("UserApi"),
                ExternalFilesManager.getData("PassApi"));
        req.header("Content-Type", "application/json");
    }

    private void initElectron(String platform) {
        initElectronCapability();
        intiImplicitlyWait();
        initActions();
        initSoftAssert();
        PageObjectManager.pageObjectManager(platform);
    }

    private void initElectronCapability() {
        System.setProperty("webdriver.chrome.driver", "C:/Automation/electrondriver.exe");
        opt = new ChromeOptions();
        opt.setBinary("C:/todolist/Todolist.exe");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", opt);
        capabilities.setBrowserName("chrome");
        opt.merge(capabilities);
        driver = new ChromeDriver(capabilities);
    }

    private void initAppium(String platform) throws MalformedURLException {
        initAppiumCapability();
        initAppiumDriver();
        PageObjectManager.pageObjectManager(platform);
    }

    private void initAppiumCapability() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("reportDirectory", ExternalFilesManager.getData("ReportDirectory"));
        capabilities.setCapability("reportFormat", ExternalFilesManager.getData("ReportFormat"));
        capabilities.setCapability("testName", ExternalFilesManager.getData("TestName"));
        capabilities.setCapability(MobileCapabilityType.UDID, ExternalFilesManager.getData("UDID"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ExternalFilesManager.getData("AppPackage"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ExternalFilesManager.getData("AppActivity"));
    }

    private void initAppiumDriver() throws MalformedURLException {
        driverAndroid = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driverAndroid.setLogLevel(Level.INFO);
        driverAndroid.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dims = driverAndroid.manage().window().getSize();
        touchAction = new TouchAction(driverAndroid);
    }

    @AfterClass
    @Parameters({"Platform"})
    public void closeSession(String platform) {
        if (platform.equalsIgnoreCase("Desktop"))
            driverDesktop.quit();
        else if (platform.equalsIgnoreCase("Appium"))
            driverAndroid.quit();
        else if (platform.equalsIgnoreCase("Web")) {
            if (!DeleteUser.verifyUserDeleted("HenB")) {
                DeleteUser.navigateToDeleteUsrPage();
                DeleteUser.deleteUserByName("HenB");
            }
            closeDBCon();
            driver.quit();
        }
        else if (platform.equalsIgnoreCase("Electron")){
            driver.quit();
        }

    }

}
