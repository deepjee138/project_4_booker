package booker.testbase;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * Created by Jay Vaghani
 */
public class TestBase {


    @BeforeClass
    public void inIt(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";

       // RestAssured.basePath="/booking";
    }

}