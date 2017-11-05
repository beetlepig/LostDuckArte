import processing.core.PApplet;

public class MainApp extends PApplet {
    private Logica logiquita;


    public static void main (String[] args) {
        PApplet.main("MainApp", args);
    }

    public void settings () {
      size(1000,500);
    }

    public void setup () {
        this.logiquita = new Logica(this);
        rectMode(CENTER);
        imageMode(CENTER);
        ellipseMode(CENTER);
    }

    public void draw () {
        background(200);
        logiquita.display();
    }

    public void keyPressed() {

            if(key ==  CODED) {
                logiquita.keyDown(keyCode);
            } else {
                logiquita.keyDown(key);
            }
    }

    public void keyReleased() {
        if(key ==  CODED) {
            logiquita.keyUp(keyCode);
        } else {
            logiquita.keyUp(key);
        }
    }
}
