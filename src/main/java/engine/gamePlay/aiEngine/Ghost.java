package engine.gamePlay.aiEngine;

import engine.model.physicalEngine.shape.Rectangle;


public class Ghost {
    public static void movePinkEntity(Rectangle pinkEntity, Rectangle yellowEntity, double pinkSpeed) {
        double pinkX = pinkEntity.getX();
        double pinkY = pinkEntity.getY();

        double yellowX = yellowEntity.getX();
        double yellowY = yellowEntity.getY();

        double dx = yellowX - pinkX;
        double dy = yellowY - pinkY;


        if (Math.abs(dx) > Math.abs(dy)) {

            if (dx > 0) {
                pinkX += pinkSpeed;
            } else {
                pinkX -= pinkSpeed;
            }
        } else {

            if (dy > 0) {
                pinkY += pinkSpeed;
            } else {
                pinkY -= pinkSpeed;
            }
        }

        pinkEntity.setPosition(pinkX, pinkY);
    }


}
