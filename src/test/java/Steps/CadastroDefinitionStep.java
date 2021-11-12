package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesObjects.EnterVehicleData_Page;

public class CadastroDefinitionStep {
	private EnterVehicleData_Page mc;
	private  WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		mc= new EnterVehicleData_Page(driver);
	}
	
	@Given("que estou no site da tricentis")
	public void que_estou_no_site_da_tricentis() {
	    mc.acessarPagina();
	}
	
	@When("preencher {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} do formulario da aba enteer Vehicle Data e clicar em Next")
	public void preencher_do_formulario_da_aba_enteer_vehicle_data_e_clicar_em_next(String marca, String modelo, String cilindrada, String desempenho, String dataFabricacao, String assentos, String assentos2, String tipocom, String playload, String totalWheit, String pesoT, String precoTabela, String km) {
		mc.inserirMake(marca);
		mc.Modelo(modelo);
		mc.Cinlindradas(cilindrada);
		mc.Desempenho(desempenho);
		mc.DataDeFabricacao(dataFabricacao);
		mc.Assentos1(assentos);
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[7]/p/label[1]/span")).click();
		//mc.RightHandDrive();
		
	}

	@And("preencher {string} {string} {string} {string} {string} {string}  {string} {string} os dados do formulario da aba enter Insurante Data e clicar em Next")
	public void preencher_os_dados_do_formulario_da_aba_enter_insurante_data_e_clicar_em_next(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
	    
	}

	@When("{string} {string} {string} {string} {string} {string} preencher os dados do formulario da aba enter Product Data e clicar em Next")
	public void preencher_os_dados_do_formulario_da_aba_enter_product_data_e_clicar_em_next(String string, String string2, String string3, String string4, String string5, String string6) {
	    
	}

	@When("selecionar {string} do formulario da aba Select Prince Option e clicar em Next")
	public void selecionar_do_formulario_da_aba_select_prince_option_e_clicar_em_next(String string) {
	    
	}

	@When("preencher {string} {string} {string} {string}  dados do formulario da aba Send Quote")
	public void preencher_dados_do_formulario_da_aba_send_quote(String string, String string2, String string3, String string4) {
	    
	}

	@When("clico em Send")
	public void clico_em_send() {
	    
	}

	@Then("O cadastro deve ser criado com sucesso e clicar em ok")
	public void o_cadastro_deve_ser_criado_com_sucesso_e_clicar_em_ok() {
	    
	}
}
