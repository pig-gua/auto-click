package cloud.abaaba;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * AutoClick 自动点击鼠标
 *
 * @author Pig-Gua
 * @date 2023-11-22
 */
public class AutoClick {

    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用方法：
     * 1、以管理员身份打开IDE。
     * 2、修改点击时间间隔clickInterval，修改点击位置xy。
     * 3、开始运行，并手动切到目标页面。
     */
    public static void main(String[] args) throws InterruptedException {
        // 点击时间间隔，单位分钟
        long[] clickInterval = new long[]{19, 22, 18, 16, 26, 10, 23, 13, 13, 22, 26, 23};

        // 点击位置，像素点
        int x = 1011;
        int y = 540;

        // sleep 5秒 开始执行。。。
        Thread.sleep(5 * 1000);

        // 循环点击：点击一次，sleep一段时间
        for (long time : clickInterval) {
            clickLeftMouse(x, y);
            Thread.sleep(time * 60 * 1000);
        }
    }

    /**
     * 鼠标左键点击屏幕上某一点
     *
     * @param x x
     * @param y y
     */
    private static void clickLeftMouse(int x, int y) {
        robot.mouseMove(x, y);
        clickLeftMouse();
    }

    /**
     * 点击鼠标左键
     */
    private static void clickLeftMouse() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}
