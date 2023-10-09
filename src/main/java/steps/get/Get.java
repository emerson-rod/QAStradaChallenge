package steps.get;


import io.cucumber.java.pt.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class Get {

    private RequestSpecification request;
    private Response response;

    @Dado("que a API JsonPlaceHolder está disponível")
    public void api_disponivel() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        request = RestAssured.given();
    }

    @Quando("eu faço uma solicitação GET para {string}")
    public void solicita_get(String endpoint) {
        response = request.get(endpoint);
    }

    @Entao("o código de resposta do GET deve ser {int}")
    public void codigo_resposta_get(int statusCode) {
        int responseCode = response.getStatusCode();
        Assert.assertEquals(statusCode, responseCode);
    }

    @E("o cabeçalho de resposta do GET deve conter {string}")
    public void cabecalho_resposta_get(String expectedHeader) {
        String actualHeader = response.header("Content-Type");
        Assert.assertTrue(actualHeader.contains(expectedHeader));
    }

    @E("o corpo da resposta deve conter pelo menos {int} post")
    public void corpo_resposta(int minPosts) {
        int postCount = response.jsonPath().getList("$").size();
        Assert.assertTrue(postCount >= minPosts);
    }
}
