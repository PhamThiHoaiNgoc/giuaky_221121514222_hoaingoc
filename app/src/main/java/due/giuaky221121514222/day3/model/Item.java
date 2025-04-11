package due.giuaky221121514222.day3.model;

public class Item {
    private String id;
    private String releaseDate;
    private String primaryTitle;
    private String description;
    private String primaryImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return releaseDate;
    }

    public void setDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return primaryTitle;
    }

    public void setTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getContent() {
        return description;
    }

    public void setContent(String description) {
        this.description = description;
    }

    public String getImage() {
        return primaryImage;
    }

    public void setImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }
}