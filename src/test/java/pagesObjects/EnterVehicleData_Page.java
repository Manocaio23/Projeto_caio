package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

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
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[7]/p/label[1]/span")).click();
		return this;
	}
	
	public void Assentos2(String string) {
		WebElement element= driver.findElement(By.id("numberofseatsmotorcycle"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	public void TipoCom(String string) {
		WebElement element= driver.findElement(By.id("fuel"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	
	public void PlayLoad(String string ) {
		driver.findElement(By.id("payload")).sendKeys(string);
	}
	
	
	
	
	public void totalPeso(String string ) {
		driver.findElement(By.id("totalweight")).sendKeys(string);
	}
	
	public void precoTabela(String string ) {
		driver.findElement(By.id("listprice")).sendKeys(string);
	}
	
	
	public void KM(String string) {
		driver.findElement(By.id("annualmileage")).sendKeys(string);
	}
	
	public EnterVehicleData_Page BnNext() {
		driver.findElement(By.id("nextenterinsurantdata")).click();
		return this;
	}
	
	public void tiraPrint() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshot/EnterVehicleData.png"));
		
	}
	
	public void PrintY() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z");
		Date hj=new Date();
		String dataH = sdf.format(hj);
		String data =dataH.toString().replace(" ","-" ).replace(":", "-");
		Screenshot print= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(print.getImage(), "PNG", new File("./Screenshot/EnterVehicleData"+data+".png"));
	}
	
	public EnterVehicleData_Page Validacao() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Bem vindo, mano caio1!", texto);
		return this;
	}
}
