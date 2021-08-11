import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PriceCalculator {
    public static void main(String[] args) {
        try {
            BigInteger totalCartPrice = new BigInteger("0");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(args[1]));

            Gson gson = new Gson();
            ArrayList<BasePrices> basePrices = gson.fromJson(bufferedReader, new TypeToken<ArrayList<BasePrices>>() {
            }.getType());
            ArrayList<Cart> carts = gson.fromJson(bufferedReader1, new TypeToken<ArrayList<Cart>>() {
            }.getType());
            for (Cart cart : carts) {
                BasePrices basePrice = basePrices.stream().filter(base -> isBaseObjectMatching(cart, base)).findAny()
                        .orElse(null);
                totalCartPrice = totalCartPrice.add(BigInteger.valueOf(calcCartItemPrice(cart, basePrice)));
            }
            System.out.println(String.format("Total Cart Value is -> %s", totalCartPrice));
        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public static boolean isBaseObjectMatching(Cart cart, BasePrices base) {
        boolean isMatching = base.getProductType().equals(cart.getProductType());
        if (isMatching && cart.getOptions() != null && cart.getOptions().getSize() != null) {
            isMatching = base.getOptions().getSize().contains(cart.getOptions().getSize());
        }
        if (isMatching && cart.getOptions() != null && cart.getOptions().getColour() != null) {
            isMatching = base.getOptions().getColour().contains(cart.getOptions().getColour());
        }
        return isMatching;
    }

    public static int calcCartItemPrice(Cart cart, BasePrices basePrice) {
         System.out.println(basePrice);
        System.out.println(cart);
        int tempCartItemPrice = Math
                .round(basePrice.getBasePrice() + ((basePrice.getBasePrice() * cart.getArtistMarkup()) / 100))
                * cart.getQuantity();
         System.out.println(String.format("printing cart item price -> %s",
         tempCartItemPrice));
        return tempCartItemPrice;
    }
}