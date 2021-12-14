package Utilities;

import PageObjects.AppiumPageObjects.MortgageCalcPage;
import PageObjects.AppiumPageObjects.MortgageCalcSavePage;
import PageObjects.DesktopPageObjects.CalculatorRegularPage;
import PageObjects.DesktopPageObjects.CalculatorScientificPage;
import PageObjects.ElectronPageObjects.ToDoListMainPage;
import PageObjects.WebPageObjects.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Base {

    //Api
    public static RequestSpecification req;
    public static Response res;

    //Web
    protected static WebDriver driver;
    protected static Actions actions;
    protected static WebDriverWait wait;

    //Sikuli
    protected static Screen screen;
    protected static String impPath;

    //Database
    protected static String dbUrl;
    protected static ResultSet rs;
    protected static Connection con;
    protected static Statement stmt;
    protected static String usernameDB;
    protected static String passwordDB;
    protected static List<String> listOfUsersFromDB;
    protected static List<String> listOfPasswordFromDB;
    protected static List<String> listOfNamesFromDB;

    //Electron
    protected static ChromeOptions opt;

    //Appium
    protected static AndroidDriver<AndroidElement> driverAndroid;
    protected static Dimension dims;
    protected static PointOption pointOptionStart, pointOptionEnd;
    protected static TouchAction touchAction;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static String baseURL;
    protected static String saveLastId;

    //Desktop
    protected static WindowsDriver driverDesktop;
    protected static DesiredCapabilities capabilities;
    protected static String calcApp;
    protected static String[] CalcNumber;
    protected static CalculatorRegularPage calculatorRegularPage;
    protected static CalculatorScientificPage calculatorScientificPage;


    //general
    protected static SoftAssert softAssert;

    //PageObjects
    protected static GrafanaLoginPage grafanaLoginPage;
    protected static GrafanaMainPage grafanaMainPage;
    protected static GrafanaLeftBarPage grafanaLeftBarPage;
    protected static GrafanaCreateUserPage grafanaCreateUserPage;
    protected static GrafanaDeleteUserPage grafanaDeleteUserPage;
    protected static ToDoListMainPage toDoListMainPage;
    protected static MortgageCalcPage mortgageCalcPage;
    protected static MortgageCalcSavePage mortgageCalcSavePage;

}
