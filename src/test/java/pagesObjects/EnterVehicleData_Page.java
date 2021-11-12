package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EnterVehicleData_Page {
	private static final String URL = "http://sampleapp.tricentis.com/101/app.php";
	private WebDriver driver;
	private WebDriver element;
	//private Select select = new Select((WebElement) driver);
	
	public EnterVehicleData_Page(WebDriver driver) {
		this.driver= driver;
	}
	 //acessando pagina
	public void acessarPagina() {
		driver.get(URL);

	}
	
	public void inserirMake(String make) {
		WebElement element= driver.findElement(By.id("make"));
		Select select= new Select(element);
		select.selectByValue(make);
		
	}
	
	public void DesempenhoMotor(String string) {
		driver.findElement(By.id("engineperformance")).sendKeys(string);
	}
	
	public void Modelo(String string) {
		WebElement element=driver.findElement(By.id("model"));
		Select select= new Select(element);
		select.selectByValue(string);
	}
	
	public void Cinlindradas(String string) {
		driver.findElement(By.id("cylindercapacity")).sendKeys(string);
	}

	public void Desempenho(String string) {
		driver.findElement(By.id("engineperformance")).sendKeys(string);
	}
	
	public void DataDeFabricacao(String string ) {
		driver.findElement(By.id("dateofmanufacture")).sendKeys(string);
	}
	
	public void Assentos1(String string) {
		WebElement element= driver.findElement(By.id("numberofseats"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	
	public EnterVehicleData_Page RightHandDrive() {
		driver.findElement(By.xpath("//span[@class='ideal-radio checked']")).click();
		return this;
	}
	
	public void Assentos2() {
		
	}
	
	
	
	
}
