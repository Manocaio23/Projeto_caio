package Steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesObjects.EnterInsurantData_Page;
import pagesObjects.EnterProductData_Page;
import pagesObjects.EnterVehicleData_Page;
import pagesObjects.SelectPriceOption_Page;
import pagesObjects.SendQuote_Page;

public class CadastroDefinitionStep {
	private EnterVehicleData_Page mc;
	private EnterInsurantData_Page mc1;
	private EnterProductData_Page mc2;
	private SelectPriceOption_Page mc3;
	private SendQuote_Page mc4;
	
	private  WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		mc= new EnterVehicleData_Page(driver);
		mc1=new EnterInsurantData_Page (driver);
		mc2=new EnterProductData_Page(driver);
		mc3=new SelectPriceOption_Page (driver);
		mc4=new SendQuote_Page (driver);
	}
	
	@Given("que estou no site da tricentis")
	public void que_estou_no_site_da_tricentis() {
	    mc.acessarPagina();
	}
	
	@When("preencher {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} do formulario da aba enteer Vehicle Data e clicar em Next")
	public void preencher_do_formulario_da_aba_enteer_vehicle_data_e_clicar_em_next(String marca, String modelo, String cilindrada, String desempenho, String dataFabricacao, String assentos, String assentos2, String tipocom, String playload, String totalWheit, String pesoT, String precoTabela, String km) throws InterruptedException, IOException {
		mc.inserirMake(marca);
		mc.Modelo(modelo);
		mc.Cinlindradas(cilindrada);
		mc.Desempenho(desempenho);
		mc.DataDeFabricacao(dataFabricacao);
		mc.Assentos1(assentos);
		mc.RightHandDrive();
		mc.Assentos2(assentos2);
		mc.TipoCom(tipocom);
		mc.PlayLoad(playload);
		mc.totalPeso(totalWheit);
		mc.precoTabela(precoTabela);
		mc.KM(km);
		//mc.tiraPrint();
		mc.PrintY();
		mc.BnNext();
		Thread.sleep(1500);
		
		
	}

	@And("preencher {string} {string} {string} {string} {string} {string}  {string} {string} os dados do formulario da aba enter Insurante Data e clicar em Next")
	public void preencher_os_dados_do_formulario_da_aba_enter_insurante_data_e_clicar_em_next(String primeiroNome, String UltimoNome, String Nascimento, String Genero, String Cep, String Pais, String Ocupacao, String Hobbies) throws InterruptedException, IOException {
	    mc1.InseriroNome(primeiroNome);
	    mc1.InserirSobrenome(UltimoNome);
	    mc1.DataNiver(Nascimento);
	    mc1.Sexo(Genero);
	    mc1.Pais(Pais);
	    mc1.ZipCode(Cep);
	    mc1.Oucpation(Ocupacao);
	    mc1.Hobbie(Hobbies);
	    //mc1.tiraPrint();
	    mc1.PrintY();
	    mc1.BtnNext();
	    
	    Thread.sleep(1500);
	}

	@When("{string} {string} {string} {string} {string} {string} preencher os dados do formulario da aba enter Product Data e clicar em Next")
	public void preencher_os_dados_do_formulario_da_aba_enter_product_data_e_clicar_em_next(String DataInicio, String SomaSeguro, String Classificacao, String SeguroDanos, String Produtos, String Carro) throws InterruptedException, IOException {
	    mc2.DataInicio(DataInicio);
	    mc2.SomaSeguro(SomaSeguro);
	    mc2.Classificacao(Classificacao);
	    mc2.SeguroDanos(SeguroDanos);
	    mc2.Produto(Produtos);
	    mc2.Carro(Carro);
	    //mc2.tiraPrint();
	    mc2.PrintY();
	    mc2.BtnNext();
	    
	    
	}

	@When("selecionar {string} do formulario da aba Select Prince Option e clicar em Next")
	public void selecionar_do_formulario_da_aba_select_prince_option_e_clicar_em_next(String Silver) throws InterruptedException, IOException {
		Thread.sleep(1500);
		mc3.EscolherSilver(Silver);
	    Thread.sleep(1500);
	    //mc3.BaixarPDF();
	   // Thread.sleep(2500);
	   // mc3.tiraPrint();
	    mc3.PrintY();
	    mc3.BtnNext();
	}

	@When("preencher {string} {string} {string} {string}  dados do formulario da aba Send Quote")
	public void preencher_dados_do_formulario_da_aba_send_quote(String Email, String User, String Senha, String ConfirmarSenha) {
	    mc4.Email(Email);
	    mc4.User(User);
	    mc4.Senha(Senha);
	    mc4.ConfSenha(ConfirmarSenha);
	    
	}

	@When("clico em Send")
	public void clico_em_send() throws InterruptedException {
		Thread.sleep(15000);
		mc4.BtnSend();
		
		
	}

	@Then("O cadastro deve ser criado com sucesso e clicar em ok")
	public void o_cadastro_deve_ser_criado_com_sucesso_e_clicar_em_ok() throws InterruptedException, IOException {
		Thread.sleep(15000);
		//mc4.tiraPrint();
		mc4.PrintY();
		mc4.Sucesso();
	}
}
