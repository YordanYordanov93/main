package positive.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POSTLastName {

    private static RequestSpecification spec;



      @Test
        public void lastNameRequest() {

            RestAssured.baseURI = "https://login.yahoo.com/account/module/create?validateField=lastName";
            RequestSpecification request = RestAssured.given();
            given().urlEncodingEnabled(true)
                    .spec((io.restassured.specification.RequestSpecification) spec)
                    .param("lastName", "Yordan")
                    .header("Accept", ContentType.JSON.getAcceptHeader())
                    .header("Content-Length", equalTo("179"))
                    .post("/login")
                    .then().assertThat().statusCode(200);
        }
    }


