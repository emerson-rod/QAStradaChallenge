package steps.post;
import io.cucumber.java.pt.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class Post {

    private RequestSpecification request;
    private Response response;

    @Dado("que a URL base é {string}")
    public void definir_url_base(String urlBase) {
        RestAssured.baseURI = urlBase;
        request = RestAssured.given();
    }

    @Quando("fazemos uma solicitação POST para {string} com o corpo:")
    public void solicita_post_com_corpo( String endpoint,String requestBody) {
        request.body(requestBody);
        response = request.post(endpoint);
    }

    @Então("o código de resposta do POST deve ser {int}")
    public void codigo_resposta_post(int statusCode) {
        int responseCode = response.getStatusCode();
        Assert.assertEquals(statusCode, responseCode);
    }

    @E("o cabeçalho de resposta do POST deve conter {string}")
    public void cabecalho_resposta_post(String expectedHeader) {
        String actualHeader = response.header("Content-Type");
        Assert.assertTrue(actualHeader.contains(expectedHeader));
    }
}