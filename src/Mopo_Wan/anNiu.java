package Mopo_Wan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class anNiu {
    JButton button;
    public  void  mainFrame(){
        JFrame frame=new JFrame();
        frame.setSize(100,100);//窗口的大小
        frame.setLocation(300,300);//坐标位置
        frame.setTitle("hello CSDN");//设置标题
        JLabel label_name=new JLabel("label标签");//实例化labael标签
        JTextField textfield=new JTextField();//实例化JTextfield
        button=new JButton("按钮");//实例化一个按钮
        JRadioButton jradiobutton=new JRadioButton("单选");//实例化一个单选框
        JCheckBox    checkbox=new JCheckBox();//实例化一个多选框
        //=====================布局==========================================
        FlowLayout layout=new FlowLayout();//实例化流式布局
        frame.setLayout(layout);//设置布局
        //==============将组件添加到窗体上====================================
        frame.add(button);
        //===================================================================
        //创建事件监听器
        ActionListener a=new ActionListener(){
            //监听器的方法
            public void actionPerformed(ActionEvent e){
                //逻辑处理
                System.out.println("Hello CSDN");
            }
        };
        button.addActionListener(a);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        anNiu anNiu = new anNiu();
        anNiu.mainFrame();
    }
}
