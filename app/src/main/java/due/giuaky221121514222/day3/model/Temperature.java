package due.giuaky221121514222.day3.model;
import com.google.gson.annotations.SerializedName;

public class Temperature {
    @SerializedName("Value")
    private Double value;

    @SerializedName("Unit")
    private String unit;

    public Double getValue() { return value; }
    public String getUnit() { return unit; }
}
