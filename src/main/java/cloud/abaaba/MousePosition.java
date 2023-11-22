package cloud.abaaba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * MousePosition 确定鼠标像位置
 *
 * @author Pig-Gua
 * @date 2023-11-22
 */
public class MousePosition {

    /**
     * 使用方法：
     * 1、开始运行，手动切换到目标页面。
     * 2、手动点开JFrame，将鼠标移动到页面的目标位置，按下任意按键。
     * 3、目标位置的像素坐标将打印到控制台。
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Keyboard Listener Example");
        JPanel panel = new JPanel();

        JTextField textField = new JTextField(20);
        panel.add(textField);

        // 添加键盘事件监听器
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // 按下并释放某个键时调用
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 按下某个键时调用
                int keyCode = e.getKeyCode();
                String keyText = KeyEvent.getKeyText(keyCode);
                System.out.println("Key pressed: " + keyText);
                printMousePosition();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 释放某个键时调用
            }
        });

        frame.add(panel);
        frame.setSize(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * 打印鼠标位置
     */
    private static void printMousePosition() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        System.out.println("point.getX() = " + point.getX() + ", point.getY() = " + point.getY());
    }

}
