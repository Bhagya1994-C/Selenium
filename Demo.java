package Test;

public class Demo {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    
	WebDriver driver= new ChromeDriver();


	//add implicit wait		
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//maximaze the web browser using this method
	 driver.manage().window().maximize();
	
	
	// Launch the browser by using get or navigate method
	driver.get("https://www.flipkart.com/");
	//driver.navigate().to("https://www.flipkart.com/");
	
	//driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	
	//get title of page
	String title=driver.getTitle();
	System.out.println("Title of Page: "+title);
			
	//get url of page
	String url=driver.getCurrentUrl();
	System.out.println("Page Url: "+url);
			
	//get page source of page
	//String pagesource= driver.getPageSource();
	//System.out.println("Page Source: "+pagesource);
	
	//refresh the page
	driver.navigate().refresh();
		
			
	//find hyperliks on webpage
	List<WebElement> linkElements=driver.findElements(By.tagName("a"));
	
	System.out.println("Total Links on Webpage): "+linkElements.size());
			
	//print hyperlinks on webpage
	for(WebElement e1:linkElements)
	{
		System.out.println(e1.getText());
	}
	
	driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	
	//Find product
	driver.findElement(By.name("q")).sendKeys("Redmi note 12 5g");
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
	
	//navigate to back
	driver.navigate().back();
	
	//navigate to forword
	driver.navigate().forward();
	
	//select dropdown option
	WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[1]/select"));
			
	Select dropdown=new Select(element);
	//dropdown.selectByVisibleText("₹15000");
	//dropdown.selectByValue("15000");
	dropdown.selectByIndex(3);
			
	//to check dropdown is multiple or not multiple
	if(dropdown.isMultiple()==true)
	{
		System.out.println("Dropdown is Multiple");
	}
	else
	{
		System.out.println("Dropdown is Not Multiple");
	}
			
	//total number of all dropdown option and print
	List<WebElement> alldropdownlist=dropdown.getOptions();
	System.out.println("Total Options: "+alldropdownlist.size());
			
	for(WebElement e2:alldropdownlist)
	{
		System.out.println(e2.getText());
	}
	
	WebElement element1=driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
	Select dropdown1=new Select(element1);
	//dropdown1.selectByVisibleText("₹30000");
	//dropdown1.selectByValue("30000");
	dropdown1.selectByIndex(2);
	
	//click on product
	driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();
	
	//get handle of all windows
	String mainwindowhandle=driver.getWindowHandle();
	Set<String> allwindowhandles=driver.getWindowHandles();
	Iterator<String> iterator=allwindowhandles.iterator();
	String parentwindow=iterator.next();
	String childwindow=iterator.next();
	
	//go to child window
	driver.switchTo().window(childwindow);
	
	
	//add to cart
	driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
	
	
	//go to parent window
    driver.switchTo().window(parentwindow);
    

	//To quit website page
	driver.quit();

}
