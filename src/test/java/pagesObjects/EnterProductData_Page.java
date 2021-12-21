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

public class EnterProductData_Page {
	private WebDriver driver;
	private WebDriver element;
	
	public EnterProductData_Page(WebDriver driver) {
		this.driver= driver;
	}
	
	public void DataInicio(String string) {
		driver.findElement(By.id("startdate")).sendKeys(string);
	}
	
	public void SomaSeguro(String string) {
		WebElement element= driver.findElement(By.id("insurancesum"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	
	public void Classificacao(String string) {
		WebElement element= driver.findElement(By.id("meritrating"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	
	public void SeguroDanos(String string) {
		WebElement element= driver.findElement(By.id("damageinsurance"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	
	public void Produto(String string) {
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span")).click();
	}
	
	public void Carro(String string) {
		WebElement element= driver.findElement(By.id("courtesycar"));
		Select select= new Select(element);
		select.selectByValue(string);
		
	}
	
	public void tiraPrint() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshot/EnterProducData.png"));
		
	}
	public void PrintY() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z");
		Date hj=new Date();
		String dataH = sdf.format(hj);
		String data =dataH.toString().replace(" ","-" ).replace(":", "-");
		Screenshot print= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(print.getImage(), "PNG", new File("./Screenshot/EnterProductData"+data+".png"));
	}
	
	public EnterProductData_Page BtnNext () {
		driver.findElement(By.id("nextselectpriceoption")).click();
		
		return this;
	}
	
	
	
}
