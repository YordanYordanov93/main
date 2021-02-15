import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class POSTFirstName {



       @Test
                public void submitForm(){

           RestAssured.baseURI = "https://login.yahoo.com/account/module/create?validateField=firstName";
            RequestSpecification request = RestAssured.given();
            given().urlEncodingEnabled(true)
                    .param("firstName", "Yordan")
                    .header("Accept", ContentType.JSON.getAcceptHeader())
                    .header("Content-Length",equalTo("112"))
                    .post("/login")
                    .then().assertThat().statusCode(200);
       }
    private String createResource(String path, Object bodyPayload) {
        return given()
                .body(bodyPayload)
                .when()
                .post(path)
                .then()
                .statusCode(201)
                .extract().header("location");
    }


    private <T> T getResource(String locationHeader, Class<T> responseClass) {
        return given()
                .when()
                .get(locationHeader)
                .then()
                .statusCode(200)
                .extract().as(responseClass);
    }
    }

