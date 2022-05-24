package meena51TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomepageTestCases {

	WebDriver driver;
	Actions act;
	
	@BeforeTest
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in");
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 
	@Test (priority=1)
	public void checkHomePageHasThreeSliders() {

		/*
		 * 1) Open the browser 
		 * 2) Enter the URL “http://practice.automationtesting.in/”
		 * 3) Click on Shop Menu 
		 * 4) Now click on Home menu button 
		 * 5) Test whether the Home page has Three Sliders only 
		 * 6) The Home page must contains only three sliders
		 */

		// shop button
		driver.findElement(By.id("menu-item-40")).click();
		// Home button
		driver.findElement(By.xpath("//*[@class='list-post']/nav/a")).click();

		// Homepage slider
		List<WebElement> threeSlides = driver.findElements(By.xpath("//*[@class='n2-ss-slider-3']/div"));

		int slides = threeSlides.size();
		System.out.println(slides);

		assert (slides == 3);
		System.out.println("The Home page contains only three sliders!");
	}
	
	
	@Test (priority=2)
	public void homepageContainsThreeArrival() {

		/*
		 * 1) Open the browser 
		 * 2) Enter the URL “http://practice.automationtesting.in/”
		 * 3) Click on Shop Menu 
		 * 4) Now click on Home menu button 
		 * 5) Test whether the Home page has Three Arrivals only 
		 * 6) The Home page must contains only three Arrivals
		 */
		
		// shop button
		driver.findElement(By.id("menu-item-40")).click();
		// Home button
		driver.findElement(By.xpath("//*[@class='list-post']/nav/a")).click();

		// new arrival
		List<WebElement> threeSlides = driver.findElements(By.xpath("//*[@class='row_inner_wrapper']/div"));

		int slides = threeSlides.size();
		System.out.println(slides);

		assert (slides == 3);
		System.out.println("The Home page contains only three Arrivals");
	}
	 
	@Test (priority=3)
	public void clickingImagesAndNavigateToNextPage() {

		/*
		 * 1) Open the browser 
		 * 2) Enter the URL “http://practice.automationtesting.in/”
		 * 3) Click on Shop Menu 
		 * 4) Now click on Home menu button 
		 * 5) Test whether the Home page has Three Arrivals only 
		 * 6) The Home page must contains only three Arrivals 
		 * 7) Now click the image in the Arrivals 
		 * 8) Test whether it is navigating to next page where the user can add that book into his basket. 
		 * 9) Image should be clickable and should navigate to next page where user can add that book to his basket
		 */

		// shop button
		driver.findElement(By.id("menu-item-40")).click();
		// Home button
		driver.findElement(By.xpath("//*[@class='list-post']/nav/a")).click();

		// new arrival
		List<WebElement> threeSlides = driver.findElements(By.xpath("//*[@class='row_inner_wrapper']/div"));

		int slides = threeSlides.size();
		System.out.println(slides);

		assert (slides == 3);
		System.out.println("The Home page contains only three Arrivals");

		// * 7) Now click the image in the Arrivals 
		// * 8) Test whether it is navigating to next page where the user can add that book into his basket. 
		//* 9) Image should be clickable and should navigate to next page where user can add that book to his basket

		 
		// first picture
		WebElement firstPicture = driver.findElement(By.xpath("//*[@class='module module-text text-22-sub_row_1-0-2-0-0   ']"));
		firstPicture.click();
		
		//check if it is navigating and clickable
		String isClickable = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
		Assert.assertTrue(isClickable.contains("Selenium Ruby"));
		
		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@class='woocommerce-breadcrumb']/a[1]")).click();


		// second picture
		WebElement secondPicture = driver.findElement(By.xpath("//*[@class='module module-text text-22-sub_row_1-0-2-1-0   ']"));
		secondPicture.click();

		//check if it is navigating and clickable
		String checkSecondBook = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

		Assert.assertTrue(checkSecondBook.contains("Thinking in HTML"));
		
		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@class='woocommerce-breadcrumb']/a[1]")).click();

		// Third picture
		WebElement thirdPicture = driver.findElement(By.xpath("//*[@class='module module-text text-22-sub_row_1-0-2-2-0   ']"));
		thirdPicture.click();
		
		//check if it is navigating and clickable
		String checkThirdBook = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

		Assert.assertTrue(checkThirdBook.contains("Mastering JavaScript"));
			
	}
					
	 
	@Test (priority=4)
	public void clickDescriptionTap() {
		/* 	1) Open the browser
		   	2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Now click on Home menu button
			5) Test whether the Home page has Three Arrivals only
			6) The Home page must contains only three Arrivals
			7) Now click the image in the Arrivals
			8) Test whether it is navigating to next page where the user can add that book into his basket.
			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
			10) Click on Description tab for the book you clicked on.
			11) There should be a description regarding that book the user clicked on
		*/
		
		// shop button
		driver.findElement(By.id("menu-item-40")).click();
		// Home button
		driver.findElement(By.xpath("//*[@class='list-post']/nav/a")).click();

		// new arrival
		List<WebElement> threeSlides = driver.findElements(By.xpath("//*[@class='row_inner_wrapper']/div"));

		int slides = threeSlides.size();
		System.out.println(slides);

		assert (slides == 3);
		System.out.println("The Home page contains only three Arrivals");
		

		//  7) Now click the image in the Arrivals 
		//  8) Test whether it is navigating to next page where the user can add that book into his basket. 
		//  9) Image should be clickable and should navigate to next page where user can add that book to his basket
		//  10) Click on Description tab for the book you clicked on.
		//  11) There should be a description regarding that book the user clicked on
		
		// first picture
		
		WebElement firstPicture = driver.findElement(By.xpath("//*[@class='module module-text text-22-sub_row_1-0-2-0-0   ']"));
		firstPicture.click();
		
		//check if it is navigating and clickable
		String isClickable = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
		Assert.assertTrue(isClickable.contains("Selenium Ruby"));
		
//		//description tab
//		driver.findElement(By.xpath("//*[@class='description_tab active']")).click();
//		
		String firstDescription = driver.findElement(By.xpath("//*[@id='tab-description']/h2")).getText();
		Assert.assertTrue(firstDescription.contains("Product Description"));
		
		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@class='list-post']/nav/a")).click();

		// second picture
		WebElement secondPicture = driver.findElement(By.xpath("//*[@class='module module-text text-22-sub_row_1-0-2-1-0   ']"));
		secondPicture.click();

		//check if it is navigating and clickable
		String checkSecondBook = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

		Assert.assertTrue(checkSecondBook.contains("Thinking in HTML"));
		
//		//2nd description tab
//		driver.findElement(By.xpath("//*[@class='description_tab active']")).click();
		
		String secondDescription = driver.findElement(By.xpath("//*[@id='tab-description']/h2")).getText();
		Assert.assertTrue(secondDescription.contains("Product Description"));
		
		System.out.println("It is clickable");
		
		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@id='content']/nav/a[1]")).click();

		// Third picture
		WebElement thirdPicture = driver.findElement(By.xpath("//*[@class='module module-text text-22-sub_row_1-0-2-2-0   ']"));
		thirdPicture.click();
		
		//check if it is navigating and clickable
		String checkThirdBook = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

		Assert.assertTrue(checkThirdBook.contains("Mastering JavaScript"));
					
//		//3rd description tab
//		driver.findElement(By.xpath("//*[@class='description_tab active']")).click();
						
		String thirdDescription = driver.findElement(By.xpath("//*[@id=\"tab-description\"]/h2")).getText();
		Assert.assertTrue(thirdDescription.contains("Product Description"));
		System.out.println("It is clickable");

	
	}
	
	@Test (priority=5)
	public void reviewsTab() {
		
		/*
		 	1) Open the browser
		   	2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Now click on Home menu button
			5) Test whether the Home page has Three Arrivals only
			6) The Home page must contains only three Arrivals
			7) Now click the image in the Arrivals
			8) Test whether it is navigating to next page where the user can add that book into his basket.
			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
			10) Now clock on Reviews tab for the book you clicked on.
			11) There should be a Reviews regarding that book the user clicked on
		 */
		

		// shop button
		driver.findElement(By.id("menu-item-40")).click();
		// Home button
		driver.findElement(By.xpath("//*[@class='list-post']/nav/a")).click();

		// new arrival
		List<WebElement> threeSlides = driver.findElements(By.xpath("//*[@class='row_inner_wrapper']/div"));

		int slides = threeSlides.size();
		System.out.println(slides);

		assert (slides == 3);
		System.out.println("The Home page contains only three Arrivals");

		
// 	 	8) Test whether it is navigating to next page where the user can add that book into his basket. 
//		9) Image should be clickable and should navigate to next page where user can add that book to his basket
//		10) Now click on Reviews tab for the book you clicked on 
//		11) There should be a Reviews regarding that book that user clicked on 

		 
		// first picture
		WebElement firstPicture = driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]"));
		firstPicture.click();
		
		//check if it is navigating and clickable
		String isClickable = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
		Assert.assertTrue(isClickable.contains("Selenium Ruby"));
		
		
		String reviewBox1 = driver.findElement(By.xpath("//*[@id='comment']")).getAttribute("name");
		Boolean name =  reviewBox1.equals("comment");
		Assert.assertTrue(name);
		
//		String firstReview = driver.findElement(By.xpath("//*[@id='comment']")).getAttribute("comment");
//		Assert.assertTrue(firstReview.contains("Your Review"));

		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@class='woocommerce-breadcrumb']/a[1]")).click();
		
		// second picture
		WebElement secondPicture = driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]"));
		secondPicture.click();

		//check if it is navigating and clickable
		String checkSecondBook = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

		Assert.assertTrue(checkSecondBook.contains("Thinking in HTML"));
		
		String reviewBox2 = driver.findElement(By.xpath("//*[@id='comment']")).getAttribute("name");
		Boolean name2 =  reviewBox2.equals("comment");
		Assert.assertTrue(name);
		
//		String secondReview = driver.findElement(By.xpath("//*[@id='product-160']/div[3]/ul/li[2]/a")).getText();
//		Assert.assertTrue(secondReview.contains("Your Review"));
		
		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@id='content']/nav/a[1]")).click();

		// Third picture
		WebElement thirdPicture = driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']"));
		thirdPicture.click();
		
		//check if it is navigating and clickable
		String checkThirdBook = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

		Assert.assertTrue(checkThirdBook.contains("Mastering JavaScript"));

		String reviewBox3 = driver.findElement(By.xpath("//*[@id='comment']")).getAttribute("name");
		Boolean name3 =  reviewBox3.equals("comment");
		Assert.assertTrue(name3);
		
		
//		String thirdReview = driver.findElement(By.xpath("//*[@id='product-160']/div[3]/ul/li[2]/a")).getText();
//		Assert.assertTrue(thirdReview.contains("Your Review"));		

		
		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@id='content']/nav/a[1]")).click();
		
	}
	
	@Ignore
	@Test (priority=6)
	public void addToBasket() {
		
		/*
	 	1) Open the browser
		2) Enter the URL “http://practice.automationtesting.in/”
		3) Click on Shop Menu
		4) Now click on Home menu button
		5) Test whether the Home page has Three Arrivals only
		6) The Home page must contains only three Arrivals
		7) Now click the image in the Arrivals
		8) Test whether it is navigating to next page where the user can add that book into his basket.
		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
		10) Click on the Add To Basket button which adds that book to your basket
		11) User can view that Book in the Menu item with price.
		12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
		 */
		

		// shop button
		driver.findElement(By.id("menu-item-40")).click();
		// Home button
		driver.findElement(By.xpath("//*[@class='list-post']/nav/a")).click();

		// new arrival
		List<WebElement> threeSlides = driver.findElements(By.xpath("//*[@class='row_inner_wrapper']/div"));

		int slides = threeSlides.size();
		System.out.println(slides);

		assert (slides == 3);
		System.out.println("The Home page contains only three Arrivals");

		
//		8) Test whether it is navigating to next page where the user can add that book into his basket. 
//		9) Image should be clickable and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
//		11) User can view that Book in the Menu item with price.
//		12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
	
		 
		// first picture
		WebElement firstPicture = driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]"));
		firstPicture.click();
		
		//check if it is navigating and clickable
		String isClickable = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
		Assert.assertTrue(isClickable.contains("Selenium Ruby"));
		
		//CAN NOT ADD DUE TO OUT OF STOCK 
		
		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@class='woocommerce-breadcrumb']/a[1]")).click();


		// second picture
		WebElement secondPicture = driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]"));
		secondPicture.click();

		//check if it is navigating and clickable
		String checkSecondBook = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

		Assert.assertTrue(checkSecondBook.contains("Thinking in HTML"));
		
		//click relate picture due to out of stock
		driver.findElement(By.xpath("//img[@title=\"HTML5 Web Application Development Beginner's guide\"]")).click();
		
		//click add to basket
	
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//button[@type='submit']"));
		act.click().build().perform();
		//can view Book in the Menu item with price.
		
		String getText = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
		
		Assert.assertTrue(getText.contains("has been added to your basket."));
		
		
		//Back to home to test the next book
		driver.findElement(By.xpath("//*[@class='woocommerce-breadcrumb']/a[1]")).click();

		// Third picture
		WebElement thirdPicture = driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']"));
		thirdPicture.click();
		
		//check if it is navigating and clickable
		String checkThirdBook = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

		Assert.assertTrue(checkThirdBook.contains("Mastering JavaScript"));
		
		//click relate picture due to out of stock
		driver.findElement(By.xpath("//img[@title='Functional Programming in JS']")).click();
		
		//click add to basket
		driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/button")).click();
		
		//can view Book in the Menu item with price.
		
		String getText2 = driver.findElement(By.xpath("//*[@class='woocommerce-message']")).getText();
		
		Assert.assertTrue(getText2.contains("has been added to your basket."));
	}
	
	
	@AfterTest
    public void tearDown() {
        driver.quit();
    }
	
	
}
