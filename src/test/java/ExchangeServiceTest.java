import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

@QuarkusTest
//@QuarkusTestResource(WireMockExtensionsResource.class)
public class ExchangeServiceTest {
    @Test
    public void testExtensionIdAsyncEndpoint() {
        given()
                .when().get("/exchange/05-15-2015")
                .then()
                .statusCode(200);
    }
}
