package iferden.geronimo.geronimo.Model;

/**
 * Created by abdelaliiferden on 21/01/2018.
 */

public class Personnage {
    private String name;
    private String serie;
    private int image;

    public Personnage(String name, String serie, int image) {
        this.name = name;
        this.serie = serie;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getSerie() {
        return serie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
