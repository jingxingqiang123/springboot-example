package com.jxq.tank;

import java.awt.*;

/**
 * tank类
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private static final int SPEED = 5;
    private TankFrame tankFrame = null;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    // 画出tank的方向
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        move();

    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case LTFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    /**
     * tank 发射子弹
     */
    public void fire() {
        tankFrame.bulletList.add(new Bullet(this.x, this.y, this.dir,this.tankFrame));
    }
}
