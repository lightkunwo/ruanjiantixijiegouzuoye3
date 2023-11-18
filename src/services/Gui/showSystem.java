package services.Gui;
import javax.swing.*;
import javax.xml.rpc.ServiceException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;

import services.WeatherForecastService;

public class showSystem extends JFrame {
    JTextArea out=new JTextArea();
    JLabel label = new JLabel("姓名");
    private JTextField numberTextField;
    JTextField textField = new JTextField(11);
    JButton submitButton;
    public static void main(String[] args) {
        showSystem GUI = new showSystem();
        GUI.showFrame();

    }
    //事件处理
    public   void onButtonOk()  {

        String str = textField.getText();//获取输入内容
        //判断是否输入了
        if (str.equals("")) {
            Object[] options = {"OK ", "CANCEL "};
            JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        } else {
            String result[] = new String[0];
            try {
                result = WeatherForecastService.QueryWeatherForecastInfo(str);
                System.out.println(result[0]);
                String s = "";
                for (String r : result)
                    s += r;
                textField.setVisible(false);
                out.setVisible(true);
                out.setLocation(200,250);
                out.setSize(200,200);
                out.setText(s);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (ServiceException e) {
                e.printStackTrace();
            }

        }
    }

    public void showFrame() {
        this.setVisible(true);
        this.setTitle("天气预测软件");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1000, 1000);
        textField.setSize(100,150);
        textField.setLocation(0,0);
        out.setText("1");
        // 创建按钮并添加到窗口中
        submitButton = new JButton("Submit");
        submitButton.setSize(100,100);
        submitButton.setLocation(100,150);
        // 设置按钮点击事件的监听器
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在按钮点击时调用获取文本
                onButtonOk();

            }
        });

        addFunction(this);
    }

    public static void addFunction(showSystem showSystem) {
        // 将构件添加到主面板
        showSystem.getContentPane().setSize(600,600);
        showSystem.getContentPane().add(showSystem.textField);
        showSystem.getContentPane().add(showSystem.submitButton);
        showSystem.getContentPane().add(showSystem.out);


    }



}
