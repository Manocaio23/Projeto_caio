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

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class EnterInsurantData_Page {
	private WebDriver driver;
	private WebDriver element;
	
	public EnterInsurantData_Page(WebDriver driver) {
		this.driver= driver;
	}
	
	public void InseriroNome(String primeiroNome) {
		driver.findElement(By.id("firstname")).sendKeys(primeiroNome);
		
	}
	
	public void InserirSobrenome(String string) {
		driver.findElement(By.id("lastname")).sendKeys(string);
	}
	
	public void DataNiver(String string) {
		driver.findElement(By.id("birthdate")).sendKeys(string);
	}
	
	public void Sexo(String string) {
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]/span")).click();
	}
	
	public void Pais(String string) {
		WebElement element= driver.findElement(By.id("country"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	
	public void ZipCode(String string) {
		driver.findElement(By.id("zipcode")).sendKeys(string);
		
	}
	
	public void Oucpation(String string) {
		WebElement element= driver.findElement(By.id("occupation"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	
	public void Hobbie(String string) {
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[5]/span")).click();
	}
	
	public void tiraPrint() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshot/EnterIsurantData.png"));
		
	}
	
	public void PrintY() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z");
		Date hj=new Date();
		String dataH = sdf.format(hj);
		String data =dataH.toString().replace(" ","-" ).replace(":", "-");
		Screenshot print= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(print.getImage(), "PNG", new File("./Screenshot/EnterInsuranteData"+data+".png"));
	}
	
	public EnterInsurantData_Page BtnNext() {
		driver.findElement(By.id("nextenterproductdata")).click();
		return this;
	}
	
	
	
	
	
	
	
	
	
	
}
