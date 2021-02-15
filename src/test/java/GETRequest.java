import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GETRequest {

    @Test
    public void responseHeaderData_ShouldBeCorrect() {

        Response statusCode = given().
                queryParam("firstName", "Yordan").
                when().
                get("https://login.yahoo.com/account/module/create/suggestions?crumb=5ppC0ViIwCT&acrumb=vQeDJ4Gp&firstName=Yordan&lastName=Yordanov&yid=").
                then().
                assertThat().
                statusCode(200).
                and().
                header("Content-Length",equalTo("221")).
                and().
                contentType(ContentType.JSON).extract().response();
    }



    }




