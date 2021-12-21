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

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SelectPriceOption_Page {
	private WebDriver driver;
	
	public SelectPriceOption_Page(WebDriver driver) {
		this.driver= driver;
}
	
	public void EscolherSilver(String string) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[1]/span")).click();
		//Thread.sleep(1500);
		//driver.findElement(By.xpath("//*[@id='downloadquote']/span")).click();
		
	}
	
	public void BaixarPDF() {
		driver.findElement(By.xpath("//*[@id='downloadquote']/span")).click();
	}
	
	public void tiraPrint() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshot/SelectPriceOption.png"));
		
	}
	public void PrintY() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z");
		Date hj=new Date();
		String dataH = sdf.format(hj);
		String data =dataH.toString().replace(" ","-" ).replace(":", "-");
		Screenshot print= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(print.getImage(), "PNG", new File("./Screenshot/SelectPriceOption"+data+".png"));
	}
	
	public SelectPriceOption_Page BtnNext() {
		driver.findElement(By.id("nextsendquote")).click();
		return this;
	}
}
