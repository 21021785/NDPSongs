package sg.edu.rp.c346.id21021785.ndpsongs;

import java.io.Serializable;

public class  Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int years, int stars  ) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = years;
        this.stars = stars;
    }

    public int getId() {
        return id;
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

    public void setSongContent(int id, String newTitle, String newSinger, int newYear, int newStars) {
        this.id = id;
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

