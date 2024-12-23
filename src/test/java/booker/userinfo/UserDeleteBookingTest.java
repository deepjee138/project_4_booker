package booker.userinfo;

import booker.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteBookingTest extends TestBase {



    @Test
    public void verifyBookingDeleteSuccessfully() {

        given().log().all()
                .pathParam("id",1)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(404);


    }
    }

