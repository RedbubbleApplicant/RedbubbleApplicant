import com.google.gson.annotations.SerializedName;

public class CartOptions {
    private String colour;
    private String size;
    @SerializedName("print-location")
    private String printLocation;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrintLocation() {
        return printLocation;
    }

    public void setPrintLocation(String printLocation) {
        this.printLocation = printLocation;
    }

    @Override
    public String toString() {
        return "CartOptions [colour=" + colour + ", printLocation=" + printLocation + ", size=" + size + "]";
    }

}
