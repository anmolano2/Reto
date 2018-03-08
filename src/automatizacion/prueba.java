package automatizacion;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class prueba { 
	

	public static void main(String[] args) throws Exception {
		String baseUrl;
		DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver", "D:/Documentos Andrea Molano/2018 Nequi/Selenium/chromedriver.exe");
        
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
        Thread.sleep(1000);
               
        JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		Thread.sleep(100);
		
		baseUrl = "https://www.grupobancolombia.com/";
        driver.get(baseUrl + "/wps/portal/personas");
        jse.executeScript("window.scrollBy(0,1000)", "");
        driver.findElement(By.cssSelector("img[title=\"Visitanos\"]")).click();
        jse.executeScript("window.scrollBy(0,4000)", "");
        driver.findElement(By.id("srch-term")).clear();
        driver.findElement(By.id("srch-term")).sendKeys("ciudad del rio");
        driver.findElement(By.cssSelector("button.btn.search-sucursal")).click();
        Thread.sleep(20000);
        jse.executeScript("window.scrollBy(0,50)", "");
        driver.findElement(By.cssSelector("button.icono-sucursal.icono-resultado")).click();
       
 
        Thread.sleep(20000);
        takeScreenShotTest(driver,"button.icono-sucursal.icono-resultado");
        Thread.sleep(20000);
        driver.quit();
	}
        public static void takeScreenShotTest(WebDriver driver, String imageName) {
            //Directorio donde quedaran las imagenes guardadas
            //File directory = new File("C:/Users/anmolano/workspace/automatizacion/Fotos");
        	File directory = new File("./Fotos/");
            try {
              if (directory.isDirectory()) {
                  //Toma la captura de imagen
                  File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                  //Mueve el archivo a la carga especificada con el respectivo nombre
                  FileUtils.copyFile(imagen, new File(directory.getAbsolutePath()   + "\\" + imageName + ".png"));
               } else {
                  //Se lanza la excepcion cuando no encuentre el directorio
                  throw new IOException("ERROR : La ruta especificada no es un directorio!");
               }
            } catch (IOException e) {
               //Impresion de Excepciones
               e.printStackTrace();
            }
         }
  }
		
	


