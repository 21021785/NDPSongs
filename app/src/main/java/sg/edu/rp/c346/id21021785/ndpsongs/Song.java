package sg.edu.rp.c346.id21021785.ndpsongs;

import java.io.Serializable;

public class  Song implements Serializable {

    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int years, int stars  ) {
        this.title = title;
        this.singers = singers;
        this.year = years;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStar() {
        return stars;
    }

    public void setSongContent(String newTitle, String newSinger, int newYear, int newStars) {
        this.title = newTitle;
        this.singers = newSinger;
        this.year = newYear;
        this.stars = newStars;
    }

    @Override
    public String toString() {
        String starCount = "";
        for (int i = 0; i < stars; i++) {
            starCount += "*";
        }
        return title + "\n" + singers + " - " + year + "\n" + starCount;
    }
}

