import java.util.List;

public class BaseOptions {
    private List<String> colour;
    private List<String> size;

    public List<String> getColour() {
        return colour;
    }

    public void setColour(List<String> colour) {
        this.colour = colour;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "BaseOptions [colour=" + colour + ", size=" + size + "]";
    }

}
