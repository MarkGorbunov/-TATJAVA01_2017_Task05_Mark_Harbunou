package uz.Gorbunov.epam.bean;

/**
 * Created by Mark_Harbunou on 2/16/2017.
 */
public class Food {

    private int id;
    private String photo;
    private String title;
    private String description;
    private String portion;
    private String price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", portion='" + portion + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (id != food.id) return false;
        if (!photo.equals(food.photo)) return false;
        if (!title.equals(food.title)) return false;
        if (!description.equals(food.description)) return false;
        if (!portion.equals(food.portion)) return false;
        return price.equals(food.price);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + photo.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + portion.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
