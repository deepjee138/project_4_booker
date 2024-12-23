package booker.userinfo;

import booker.model.AuthPojo;
import booker.model.BookingPojo;
import booker.testbase.TestBase;
import booker.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    static String id;

    @Test
    public void verifyBookingCreatedSuccessfully() {

            String firstName = "jenny" + TestUtils.getRandomValue();
            String lastName = "patel" + TestUtils.getRandomValue();
            int totalPrice = 111;
            boolean depositPaid = true;
            HashMap<String, String> bookingDates = new HashMap<>();
            String checkIn = "2020-05-03";
            String checkOut = "2020-05-10";
            bookingDates.put("checkin", checkIn);
            bookingDates.put("checkout", checkOut);
            String additionalNeeds = "Lunch";

            BookingPojo bookingPojo = new BookingPojo();
            bookingPojo.setFirstname(firstName);
            bookingPojo.setLastname(lastName);
            bookingPojo.setTotalprice(totalPrice);
            bookingPojo.setDepositpaid(depositPaid);
            bookingPojo.setBookingdates(bookingDates);
            bookingPojo.setAdditionalneeds(additionalNeeds);

            Response response = given().log().ifValidationFails()
                    .header("Content-Type", "application/json")
                    .when()
                    .body(bookingPojo)
                    .post("/booking");

            id = response.jsonPath().getString("bookingid");

            response.prettyPrint();
            response.then().log().ifValidationFails().statusCode(200);
        }
        @Test
        public void createToken(){


            AuthPojo authPojo=new AuthPojo();
                authPojo.setUsername("admin");
                authPojo.setPassword("password123");
                Response response = given().log().ifValidationFails()
                        .header("Content-Type", "application/json")
                        .when()
                        .body(authPojo)
                        .post("/auth");


                response.prettyPrint();
                response.then().log().ifValidationFails().statusCode(200);

        }
    }

