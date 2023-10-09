import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Caminho para os arquivos .feature
        glue = {"steps"}, // Pacote onde estão suas classes de steps
        plugin= {"pretty", "html:target/cucumber-reports"}, // Plugins de relatórios
        tags = "@getandpost"// Tags para seleção de cenários

)
public class Runner {
}