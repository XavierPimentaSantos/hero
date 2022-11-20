public class Arena {
    int height;
    int width;

    Hero hero;

    public Arena(int h, int w){
        height = h;
        width = w;
        hero = new Hero(10, 10);
    }

    public void processKey(com.googlecode.lanterna.input.KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
    }

    private void moveHero(Position pos){
        if(canHeroMove(pos)){
            hero.setPosition(pos);
        }
    }

    private boolean canHeroMove(Position position){
        return(position.getX() < width && position.getX() >= 0 && position.getY() < height && position.getY() >= 0);
    }

    public Hero getHero(){
        return hero;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

}
