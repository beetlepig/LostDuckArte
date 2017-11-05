import processing.core.PApplet;
import processing.serial.Serial;

class Logica {
    private PApplet sketchRef;
    private boolean[] keysOne;
    private boolean[] keysTwo;
    private Serial puertoArduino;
    private String infoString;
    private Thread sendString;
    private boolean threadVivo;

    Logica (PApplet sketch) {
        this.sketchRef = sketch;
        threadVivo = true;
        keysOne = new boolean [4];
        keysTwo = new boolean [4];
     //   puertoArduino = new Serial(sketch, Serial.list()[0], 9600);
        sendString = new Thread(sendInfo());
        sendString.start();
    }

    private Runnable sendInfo () {
        return () -> {

            while (threadVivo) {
                try {
                    infoString = "playerOneUp:"+keysOne[0]+",playerOneDown:"+keysOne[1]+",playerOneLeft:"+keysOne[2]+",playerOneRight:"+keysOne[3];
                    // puertoArduino.write(infoString);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                     e.printStackTrace();
                }
            }

        };
    }

     void display () {
      showPlayerOne();
      showPlayerTwo();
    }

    private void showPlayerOne () {
        sketchRef.fill(0);
        if(keysOne[0]) {
            sketchRef.fill(255);
        }
        sketchRef.rect((sketchRef.width/3)*2, (sketchRef.height/2)-50, 50, 50);

        sketchRef.fill(0);
        if(keysOne[1]) {
            sketchRef.fill(255);
        }

        sketchRef.rect((sketchRef.width/3) * 2, (sketchRef.height/2) + 50, 50, 50);

        sketchRef.fill(0);
        if(keysOne[2]) {
            sketchRef.fill(255);
        }

        sketchRef.rect(((sketchRef.width/3) * 2) - 50, sketchRef.height/2, 50, 50);

        sketchRef.fill(0);
        if(keysOne[3]) {
            sketchRef.fill(255);
        }

        sketchRef.rect(((sketchRef.width/3) * 2) + 50, sketchRef.height/2, 50, 50);
    }

    private void showPlayerTwo () {
        sketchRef.fill(0);
        if(keysTwo[0]) {
            sketchRef.fill(255);
        }
        sketchRef.rect((sketchRef.width/3), (sketchRef.height/2)-50, 50, 50);

        sketchRef.fill(0);
        if(keysTwo[1]) {
            sketchRef.fill(255);
        }

        sketchRef.rect(sketchRef.width/3, (sketchRef.height/2) + 50, 50, 50);

        sketchRef.fill(0);
        if(keysTwo[2]) {
            sketchRef.fill(255);
        }

        sketchRef.rect((sketchRef.width/3) - 50, sketchRef.height/2, 50, 50);

        sketchRef.fill(0);
        if(keysTwo[3]) {
            sketchRef.fill(255);
        }

        sketchRef.rect((sketchRef.width/3) + 50, sketchRef.height/2, 50, 50);
    }

    void keyDown (int key) {

     if (key == sketchRef.UP){
         keysOne[0] = true;

     }

     if (key == sketchRef.DOWN) {
         keysOne[1] = true;
     }

     if (key == sketchRef.LEFT) {
            keysOne[2] = true;
     }

     if (key == sketchRef.RIGHT) {
            keysOne[3] = true;
     }

     if(key == 119) {
         keysTwo[0] = true;
     }

     if(key == 115) {
            keysTwo[1] = true;
     }

     if(key == 97) {
            keysTwo[2] = true;
     }

     if(key == 100) {
            keysTwo[3] = true;
     }

     System.out.println(key);
     System.out.println(infoString);

    }

    void keyUp (int key) {
        if (key == sketchRef.UP){
            keysOne[0] = false;
        }

        if (key == sketchRef.DOWN) {
            keysOne[1] = false;
        }

        if (key == sketchRef.LEFT) {
            keysOne[2] = false;
        }

        if (key == sketchRef.RIGHT) {
            keysOne[3] = false;
        }

        if(key == 119) {
            keysTwo[0] = false;
        }

        if(key == 115) {
            keysTwo[1] = false;
        }

        if(key == 97) {
            keysTwo[2] = false;
        }

        if(key == 100) {
            keysTwo[3] = false;
        }
    }
}
