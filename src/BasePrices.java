import com.google.gson.annotations.SerializedName;

public class BasePrices {
    @SerializedName("product-type")
    private String productType;
    @SerializedName("base-price")
    private int basePrice;
    private BaseOptions options;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public BaseOptions getOptions() {
        return options;
    }

    public void setOptions(BaseOptions options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "BasePrices [basePrice=" + basePrice + ", options=" + options + ", productType=" + productType + "]";
    }

}
