import com.google.gson.annotations.SerializedName;

public class Cart {
    @SerializedName("product-type")
    private String productType;
    @SerializedName("artist-markup")
    private int artistMarkup;
    private int quantity;
    private CartOptions options;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getArtistMarkup() {
        return artistMarkup;
    }

    public void setArtistMarkup(Integer artistMarkup) {
        this.artistMarkup = artistMarkup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CartOptions getOptions() {
        return options;
    }

    public void setOptions(CartOptions options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Cart [artistMarkup=" + artistMarkup + ", options=" + options + ", productType=" + productType
                + ", quantity=" + quantity + "]";
    }

}
