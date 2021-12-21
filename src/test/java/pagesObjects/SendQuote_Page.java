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

import junit.framework.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SendQuote_Page {
	private WebDriver driver;
	private WebElement icone;
	private WebElement texto;
	
	public SendQuote_Page(WebDriver driver) {
		this.driver= driver;
	}
	
	public void Email(String string) {
		driver.findElement(By.id("email")).sendKeys(string);
		
	}
	
	public void User(String string) {
		driver.findElement(By.id("username")).sendKeys(string);
	}
	
	public void Senha(String string) {
		driver.findElement(By.id("password")).sendKeys(string);
	}
	public void ConfSenha(String string) {
		driver.findElement(By.id("confirmpassword")).sendKeys(string);
	}
	
	public SendQuote_Page BtnSend() {
		driver.findElement(By.id("sendemail")).click();
		return this;
	}
	public void tiraPrint() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshot/SendQuote.png"));
		
	}
	
	public void PrintY() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z");
		Date hj=new Date();
		String dataH = sdf.format(hj);
		String data =dataH.toString().replace(" ","-" ).replace(":", "-");
		Screenshot print= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(print.getImage(), "PNG", new File("./Screenshot/SendQuote"+data+".png"));
	}
	
	public SendQuote_Page Sucesso() {
		
		driver.findElement(By.className("confirm")).click();
		return this;
	}
	
	
}
