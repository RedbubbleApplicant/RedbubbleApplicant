import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.awt.List;
import java.util.ArrayList;


public class PriceCalcTest {
   @Test
	
   public void calcCartItemPrice() {
      
	   //String str = "Junit is working fine";
      //assertEquals("Junit is working fine",str);
      
      Cart testCart = new Cart();
      CartOptions testCartOptions = new CartOptions();
      BasePrices testBasePrices = new BasePrices();
      BaseOptions testBaseOptions = new BaseOptions();
      

      ArrayList<String> baseColorOpt = new ArrayList<String>();
      baseColorOpt.add("dark");
      baseColorOpt.add("white");
      
      ArrayList<String> baseSizeOpt = new ArrayList<String>();
      baseColorOpt.add("small");
      baseColorOpt.add("medium");
      
      
      
      testCartOptions.setColour("dark");
      testCartOptions.setSize("small");
      testCartOptions.setPrintLocation("front");
      
      testCart.setProductType("TestHoodie");
      
      testCart.setOptions(testCartOptions);
      
      
      testBaseOptions.setColour(baseColorOpt);
      testBaseOptions.setSize(baseSizeOpt);

      
      
      testBasePrices.setProductType("TestHoodie");
      testBasePrices.setOptions(testBaseOptions);
      
      PriceCalculator pc = new PriceCalculator();
      
      pc.calcCartItemPrice(testCart, testBasePrices);
      
      
      for (int qty = 1; qty <= 10; qty++) {
    	  for (int price=0; price <= 1000; price++){
    		  for (int markup = -10; markup <=10; markup++){
    			  testCart.setQuantity(qty);
    			  testCart.setArtistMarkup(markup);
    			  testBasePrices.setBasePrice(price);
    			  
    			  assertEquals(pc.calcCartItemPrice(testCart, testBasePrices),Math.round(price + ((price * markup) / 100))*qty);
    			  
    		  }
    	  }
    	  
      }
    
      
   }
   
   
}