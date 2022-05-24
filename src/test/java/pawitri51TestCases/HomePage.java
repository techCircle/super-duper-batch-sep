package pawitri51TestCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HomePage {
	
	WebDriver driver;

    @Before
    public void setUp(){

        //1) Open browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 3) Click on Shop Menu
        WebElement shopMenu =driver.findElement(By.xpath("//*[@id='menu-item-40']/a"));
        shopMenu.click();

        // 4) Now click on Home menu button
        WebElement HomeMenuButton = driver.findElement(By.xpath("//*[@id='content']/nav/a"));
        HomeMenuButton.click();

    }

    @Test
    public void test1WithThreeSlidersOnly() {

        //5) Test whether the Home page has Three Sliders only
        List<WebElement> sliderLists = driver.findElements(By.xpath("//*[@id='n2-ss-6']/div[1]/div/div/div"));

        //6) The Home page must contain only three sliders
        boolean slider3 = (sliderLists.size() == 3);
        Assert.assertTrue(slider3);
    }

    @Test
    public void test2WithThreeArrivalsOnly() {

        //5) Test whether the Home page has Three Arrivals only
        List<WebElement> arrivalLists = driver.findElements(By.xpath("//*[contains(@id,'text-22-sub_row_1-0-2')]"));

        //6) The Home page must contain only three Arrivals
        boolean arrival3 = (arrivalLists.size() == 3);
        Assert.assertTrue(arrival3);

    }


    @Test
    public void test3ImagesInArrivalsShouldNavigate() {

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contain only three Arrivals
        test2WithThreeArrivalsOnly();

        List<WebElement> imageList = driver.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));
        //System.out.println(imageList.size());


        for (int i = 0; i < imageList.size(); i++) {
            imageList = driver.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));
            WebElement image = imageList.get(i);
            //staleElementException
            /* when proceed to another page it makes all the elements in the list stale.
             Those elements are not attached to the page when you come back to the page again.
             You need to find the elements every time you load the page.*/

            //need to get the title of the book before clicking to the image which links to another page
            List<WebElement> bookNameList = driver.findElements(By.xpath("//h3"));
            String exptTitle = bookNameList.get(i).getText();
            //System.out.println(exptTitle);

            //7) Now click the image in the Arrivals
            //9) Image should be clickable and should navigate to next page *** where user can add that book to his basket
            image.click();

            //8) Test whether it is navigating to next page ***where the user can add that book into his basket.
            // System.out.println(driver.getTitle());
            String actualTitle =driver.getTitle();
            Assert.assertTrue(actualTitle.contains(exptTitle));

            //go back to home page
          WebElement home = driver.findElement(By.xpath("//*[@id='content']/nav/a[1]"));
          home.click();
            // driver.navigate().back();
        }
    }

    @Test
    public void test4ArrivalsImagesDescription() {

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contain only three Arrivals
        test2WithThreeArrivalsOnly();

        List<WebElement> imageList = driver.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));
        //System.out.println(imageList.size());


        for (int i = 0; i < imageList.size(); i++) {
            imageList = driver.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));
            WebElement image = imageList.get(i);
            //staleElementException
            /* when proceed to another page it makes all the elements in the list stale.
             Those elements are not attached to the page when you come back to the page again.
             You need to find the elements every time you load the page.*/

            //need to get the title of the book before clicking to the image which links to another page
            List<WebElement> bookNameList = driver.findElements(By.xpath("//h3"));
            String exptTitle = bookNameList.get(i).getText();
            //System.out.println(exptTitle);

            //7) Now click the image in the Arrivals
            //9) Image should be clickable and should navigate to next page *** where user can add that book to his basket
            image.click();

            //8) Test whether it is navigating to next page ***where the user can add that book into his basket.
            // System.out.println(driver.getTitle());
            String actualTitle =driver.getTitle();
            Assert.assertTrue(actualTitle.contains(exptTitle));


            //10.1) Click on Description tab for the book you clicked on.
            WebElement descriptionTab = driver.findElement(By.xpath("//a[@href='#tab-description']"));
            descriptionTab.click();

        //11.1) There should be a description regarding that book the user clicked on
          WebElement description = driver.findElement(By.xpath("//*[@id='tab-description']"));
          String descriptionText = description.getText();
         System.out.println(descriptionText);
         Assert.assertTrue(descriptionText.contains("Product Description"));

            //go back to home page
            driver.navigate().back();
        }
    }


    @Test
    public void test5ArrivalsImagesReviews() {
        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contain only three Arrivals
        test2WithThreeArrivalsOnly();
        List<WebElement> imageList = driver.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));
        //System.out.println(imageList.size());


        for (int i = 0; i < imageList.size(); i++) {
            imageList = driver.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));
            WebElement image = imageList.get(i);
            //staleElementException
            /* when proceed to another page it makes all the elements in the list stale.
             Those elements are not attached to the page when you come back to the page again.
             You need to find the elements every time you load the page.*/

            //need to get the title of the book before clicking to the image which links to another page
            List<WebElement> bookNameList = driver.findElements(By.xpath("//h3"));
            String exptTitle = bookNameList.get(i).getText();
            //System.out.println(exptTitle);

            //7) Now click the image in the Arrivals
            //9) Image should be clickable and should navigate to next page *** where user can add that book to his basket
            image.click();

            //8) Test whether it is navigating to next page ***where the user can add that book into his basket.
            // System.out.println(driver.getTitle());
            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(exptTitle));


            //10.1) Now click on Reviews tab for the book you clicked on.
            WebElement reviewsTab = driver.findElement(By.xpath("//a[@href='#tab-reviews']"));
            reviewsTab.click();

            //11.1) There should be a Reviews regarding that book the user clicked on
            WebElement reviews = driver.findElement(By.xpath("//*[@id='comments']"));
            String reviewsTextImage = reviews.getText();
            //System.out.println(reviewsTextImage);
            Assert.assertTrue(reviewsTextImage.contains("Reviews"));

            //go back to home page
            driver.navigate().back();
        }
    }



    @Test
    public void test6ArrivalsImagesAddToBasket() {
/*       5) Test whether the Home page has Three Arrivals only
        6) The Home page must contain only three Arrivals
        7) Now click the image in the Arrivals
        8) Test whether it is navigating to next page where the user can add that book into his basket.
        9) Image should be clickable and should navigate to next page where user can add that book to his basket*/
        test3ImagesInArrivalsShouldNavigate();

/*      ***10) Click on the Add To Basket button which adds that book to your basket
        ---> the arrivals are all out of stock. Using related book to test instead*/
          WebDriverWait wait = new WebDriverWait(driver,10);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']/div/ul/li/a[1]/h3")));
        WebElement image3 = driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']/div/ul/li/a[1]/h3"));
        image3.click();

//        11) User can view that Book in the Menu item with price.
        //verify text price shown // the related book list is moving every time if changing page, so hae to put it the list
        List<WebElement> relatedBookNameLists = driver.findElements(By.xpath("//*[@id='product-165']/div[5]/ul/li/a/h3"));
        //System.out.println(relatedBookNameLists.size());

        for (int i = 0; i < relatedBookNameLists.size() ; i++) {
            relatedBookNameLists = driver.findElements(By.xpath("//*[@id='product-165']/div[5]/ul/li/a/h3"));
            String bookName= relatedBookNameLists.get(i).getText();
            //System.out.println(bookName);
            if (bookName.equals("Functional Programming in JS")){
                relatedBookNameLists.get(i).click();  // click that book
                break;
            }
        }

        String priceShownText = driver.findElement(By.xpath("//*[@id='product-170']/div[2]/div[1]/p/span")).getText();
        String priceText = priceShownText.substring(1,priceShownText.length()); //250.00
        double priceDouble = Double.parseDouble(priceText);
            //System.out.println(priceText);
        // compare with meta-tag price
        String metaPrice = driver.findElement(By.xpath("//*[@id='product-170']/div[2]/div[1]/meta[1]")).getAttribute("content");
            //System.out.println(metaPrice);
        double metaPriceDouble = Double.parseDouble(metaPrice);
        Assert.assertTrue(priceDouble==metaPriceDouble);

//        12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
        WebElement addToBasket = driver.findElement(By.xpath("//*[@id='product-170']/div[2]/form/button"));
        addToBasket.click();
        //verify
        String addBasketNotification = driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();
        Assert.assertTrue(addBasketNotification.contains("has been added to your basket"));

    }

    @Test
    public void test7ArrivalsAddToBasketWithMoreBooks() {

/*      5) Test whether the Home page has Three Arrivals only
        6) The Home page must contain only three Arrivals
        7) Now click the image in the Arrivals
        8) Test whether it is navigating to next page where the user can add that book into his basket.
        9) Image should be clickable and should navigate to next page where user can add that book to his basket
      ***10) Click on the Add To Basket button which adds that book to your basket
      ---> the arrivals are all out of stock. Using related book to test instead
        11) User can view that Book in the Menu item with price.
        12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket*/
        test6ArrivalsImagesAddToBasket();

//        13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
        WebElement addBookWeb = driver.findElement(By.xpath("//*[@id='product-170']/div[2]/form/div/input"));
        String stockMaxStr = addBookWeb.getAttribute("max");
            //System.out.println(stockStr);
        int overStockNumber = Integer.parseInt(stockMaxStr)+1;
            //System.out.println(overStockNumber);
        String OverStockStr = ""+overStockNumber; // to string
        addBookWeb.clear();  //sendKeys to that box
        addBookWeb.sendKeys(OverStockStr);

//        14) Click the add to basket button
        WebElement addBasketButton = driver.findElement(By.xpath("//*[@id='product-170']/div[2]/form/button"));
        addBasketButton.click();

//        15) Now it throws an error prompt like you must enter a value between 1 and 20

        //verify error message prompt pop up (using javascript)
        //WebElement ele = driver.findElement(By.xpath("//*[@id='product-170']/div[2]/form/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean isNumberValid = (Boolean)js.executeScript("return arguments[0].checkValidity();", addBookWeb);
            //System.out.println(isNumberValid);
        String errorPrompt = (String)js.executeScript("return arguments[0].validationMessage;", addBookWeb);
            System.out.println(errorPrompt);

        Assert.assertFalse(isNumberValid);

        String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(stockMaxStr));

        Assert.assertTrue(errorPrompt.contains(alert));
    }


    @Test
    public void test8ArrivalsAddToBasketItems(){
/*      5) Test whether the Home page has Three Arrivals only
        6) The Home page must contain only three Arrivals
        7) Now click the image in the Arrivals
        8) Test whether it is navigating to next page where the user can add that book into his basket.
        9) Image should be clickable and should navigate to next page where user can add that book to his basket
      ***10) Click on the Add To Basket button which adds that book to your basket
      ---> the arrivals are all out of stock. Using related book to test instead*/
        test6ArrivalsImagesAddToBasket();

        //11) User can view that Book in the Menu item with price.
        //verify
        //1) get the quantity
        String numberOfBookStr = driver.findElement(By.xpath("//*[@id='product-170']/div[2]/form/div/input")).getAttribute("value");
        double numberOfBookDouble = Double.parseDouble(numberOfBookStr);

        //2) get the price of the book by meta-tag price content
        String metaPrice = driver.findElement(By.xpath("//*[@id='product-170']/div[2]/div[1]/meta[1]")).getAttribute("content");
        double metaPriceDouble = Double.parseDouble(metaPrice);

        //subtotal = quantity * price
        double subTotalItemMenu = numberOfBookDouble*metaPriceDouble;

        //check item menu
        WebElement itemMenu = driver.findElement(By.xpath("//*[@id='wpmenucartli']"));
        //verify
        String itemMenuStr = itemMenu.getText(); //pattern: 1 Item₹250.00
            //System.out.println(itemMenuStr);
        String itemMenuQuantity[] = itemMenuStr.split(" ");
        double menuQuantityDouble = Double.parseDouble(itemMenuQuantity[0]);

        String itemMenuPrice[] = itemMenuStr.split("₹");
        double menuPriceDouble = Double.parseDouble(itemMenuPrice[1]);

        //compare the information with the item menu
        Assert.assertTrue(numberOfBookDouble==menuQuantityDouble);
        Assert.assertTrue(metaPriceDouble==menuPriceDouble);

        //12) Now click on Item link which navigates to proceed to check out page.
//      13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
        itemMenu.click();
        String urlStr = driver.getCurrentUrl();
        Assert.assertTrue(urlStr.equals("http://practice.automationtesting.in/basket/"));
    }

    @Test
    public void test9ArrivalsAddToBasketItemsCoupon() throws IOException {
/*      5) Test whether the Home page has Three Arrivals only
        6) The Home page must contain only three Arrivals
        7) Now click the image in the Arrivals
        8) Test whether it is navigating to next page where the user can add that book into his basket.
        9) Image should be clickable and should navigate to next page where user can add that book to his basket
      ***10) Click on the Add To Basket button which adds that book to your basket
      ---> the arrivals are all out of stock. Using related book to test instead
        11) User can view that Book in the Menu item with price.*/
        test6ArrivalsImagesAddToBasket();

        //12) Now click on Item link which navigates to proceed to check out page.
//        13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
         WebElement itemMenu = driver.findElement(By.xpath("//*[@id='wpmenucartli']"));
         itemMenu.click();

//***        14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
//***        15) User can able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
         // ***Not enough information to test ------>Coupon usage limit has been reached.

        //input the coupon
        WebElement couponBox = driver.findElement(By.xpath("//*[@id='coupon_code']"));
        couponBox.sendKeys("krishnasakinala");

        WebElement applyCouponButton = driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"));
        applyCouponButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/ul"));
        File screen = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
        Point p = errorMessage.getLocation();
        int width = errorMessage.getSize().getWidth();
        int height = errorMessage.getSize().getHeight();
        BufferedImage img = ImageIO.read(screen);
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, height);
        ImageIO.write(dest, "png", screen);
        File f = new File("C:\\Users\\pawit\\Desktop\\PicForTestCase\\CouponUsageLimit.png");
        FileUtils.copyFile(screen, f);
    }

    @Test
    public void test10ArrivalsAddToBasketItemsCouponValueLessThan450() throws IOException {

/*      5) Test whether the Home page has Three Arrivals only
        6) The Home page must contain only three Arrivals
        7) Now click the image in the Arrivals
        8) Test whether it is navigating to next page where the user can add that book into his basket.
        9) Image should be clickable and should navigate to next page where user can add that book to his basket
      ***10) Click on the Add To Basket button which adds that book to your basket
      ---> the arrivals are all out of stock. Using related book to test instead
        11) User can view that Book in the Menu item with price.*/

        //12) Now click on Item link which navigates to proceed to check out page.
//        13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
//        14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
//        15) User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
//        because the coupon is applicable for the book price > 450 rps

        //// ***Not enough information to test ------>Coupon usage limit has been reached.
        test9ArrivalsAddToBasketItemsCoupon();

    }

    @Test
    public void test11ArrivalsAddToBasketItemsRemoveBook() {
/*      5) Test whether the Home page has Three Arrivals only
        6) The Home page must contain only three Arrivals
        7) Now click the image in the Arrivals
        8) Test whether it is navigating to next page where the user can add that book into his basket.
        9) Image should be clickable and should navigate to next page where user can add that book to his basket
      ***10) Click on the Add To Basket button which adds that book to your basket
      ---> the arrivals are all out of stock. Using related book to test instead
        11) User can view that Book in the Menu item with price.*/
        test6ArrivalsImagesAddToBasket();

   //     12) Now click on Item link which navigates to proceed to check out page.
        WebElement itemMenu = driver.findElement(By.xpath("//*[@id='wpmenucartli']"));
        itemMenu.click();

//        13) Now click on Remove this icon in Check out page which removes that book from the grid.
//        14) User has the feasibility to remove the book at the time of check out also
        System.out.println("----------Not Yetttttttttttttttttttttttttttttttt-----------");
        List<WebElement> bookInBasketList = driver.findElements(By.xpath("//*[@id=\"page-34\"]/div/div[1]"));
        int sizeBeforeRemove = bookInBasketList.size();
        System.out.println(bookInBasketList.size());
        for (WebElement bookInBasket:bookInBasketList) {
            System.out.println(bookInBasket.getText());
        }

        //click remove on the book that is chosen to remove
        List<WebElement> reMoveButtonRowList = driver.findElements(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr/td[1]/a"));
        List<WebElement> rowOfBookInfoList = driver.findElements(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr"));

        for (int i = 0; i < reMoveButtonRowList.size() ; i++) {
            if(rowOfBookInfoList.get(i).getText().contains("Functional Programming in JS")){
                reMoveButtonRowList.get(i).click();
                break;
            }
        }

        System.out.println("---------------NOT YETTTTTT-----------------");
        bookInBasketList = driver.findElements(By.xpath("//*[@id=\"page-34\"]/div/div[1]"));
        int sizeAfterRemove = bookInBasketList.size();
        System.out.println(bookInBasketList.size());

        for (WebElement bookName:bookInBasketList) {
            System.out.println(bookName.getText());
        }

      // Assert.assertTrue(sizeBeforeRemove>sizeAfterRemove);

        //*[@id="page-34"]/div/div/form/table/tbody/tr/td = row,column
        //*[@id="page-34"]/div/div[1]/form/table/tbody/tr = row
        //*[@id="page-34"]/div/div[1]/form/table/tbody/tr[1]/td = column
        //*[@id="page-34"]/div/div[1]/form/table/tbody/tr/td[1]/a = remove button of each row
    }

    @Test
    public void test12ArrivalsAddToBasketItemsAddBook() {

/*      5) Test whether the Home page has Three Arrivals only
        6) The Home page must contain only three Arrivals
        7) Now click the image in the Arrivals
        8) Test whether it is navigating to next page where the user can add that book into his basket.
        9) Image should be clickable and should navigate to next page where user can add that book to his basket
      ***10) Click on the Add To Basket button which adds that book to your basket
      ---> the arrivals are all out of stock. Using related book to test instead
        11) User can view that Book in the Menu item with price.*/
        test6ArrivalsImagesAddToBasket();


//        12) Now click on Item link which navigates to proceed to check out page.
        WebElement itemMenu = driver.findElement(By.xpath("//*[@id='wpmenucartli']"));
        itemMenu.click();

//        13) Click on textbox value under quantity in Check out page to add or subtract books.

        //check number of book in the box
        WebElement numberOfBook = driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"));
        String numberOfBookStr = numberOfBook.getAttribute("value");
        int numberOfBookBeforeInt = Integer.valueOf(numberOfBookStr);

        List<WebElement> quantityBoxLists = driver.findElements(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr/td[5]/div/input"));
        WebElement quantityBox;

        List<WebElement> rowOfBookInfoList = driver.findElements(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr"));
        WebElement bookName;
        for (int i = 0; i < rowOfBookInfoList.size() ; i++) {
            bookName =rowOfBookInfoList.get(i);
            quantityBox =quantityBoxLists.get(i);
            if(bookName.getText().contains("Functional Programming in JS")){
                quantityBox.clear();
                quantityBox.sendKeys(Keys.ARROW_UP);
                quantityBox.sendKeys(Keys.ARROW_UP);
                break;
            }
        }

//        14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
//        15) Now click on Update Basket to reflect those changes
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[3]/td/input[1]")));
        WebElement updateBasketButton =driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[3]/td/input[1]"));
        updateBasketButton.click();

//        16) User has the feasibility to Update Basket at the time of check out.
        numberOfBook = driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"));
        numberOfBookStr = numberOfBook.getAttribute("value");
        int numberOfBookAfterInt = Integer.valueOf(numberOfBookStr);

        Assert.assertTrue(numberOfBookBeforeInt<numberOfBookAfterInt);

   //*[@id="page-34"]/div/div[1]/form/table/tbody/tr/td[5]/div/input = quantity in row
    }
    
    @After
	    public void destroy(){
	        driver.close();
	        }


}
