import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    int x;
    int y;

    public Hero(int posx, int posy){
        x = posx;
        y = posy;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void moveUP(){
        y -= 1;
    }
    public void moveDOWN(){
        y += 1;
    }
    public void moveLEFT(){
        x -= 1;
    }
    public void moveRIGHT(){
        x += 1;
    }

    public void draw(Screen screen){
        screen.setCharacter(this.getX(), this.getY(), TextCharacter.fromCharacter('H')[0]);
    }
}
