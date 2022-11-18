import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Screen screen;
    Hero hero = new Hero(10, 10);
    public Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException{
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    private void processKey(com.googlecode.lanterna.input.KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowDown:
                hero.moveDOWN();
                break;
            case ArrowUp:
                hero.moveUP();
                break;
            case ArrowLeft:
                hero.moveLEFT();
                break;
            case ArrowRight:
                hero.moveRIGHT();
                break;
        }
    }
    public void run() throws IOException{
        while(true){
            draw();
            KeyStroke key = screen.readInput();
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }
            else if (key.getKeyType() == KeyType.EOF) {
                break;
            }
            else{
                processKey(key);
            }
        }
    }
}
