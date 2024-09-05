package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

import java.util.Arrays;
import java.util.List;

public class FreeRangeSteps {
    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @And("^(?:I|The user|The client) selects? Introducción al Testing$")
    public void navigateToIntro() {
        cursosPage.clickFundamentosTestingLink();
        fundamentosPage.clickIntroduccionTestingLink();
    }

    @When("^(?:I|The user|The client) selects? Elegir Plan$")
    public void selectElegirPlan() {
        landingPage.clickOnElegirPlanButton();
    }

    @Then("^(?:I|The user|The client) can validate the options in the checkout page$")
    public void validateCheckoutPlans(){
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 12 productos", "Academia: $176 / año • 12 productos", "Free: Gratis • 3 productos");
        Assert.assertEquals(listaEsperada, lista);

    }
}
