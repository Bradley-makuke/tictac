import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class App  implements  ActionListener{

        public App(){
            JFrame frame = new JFrame();

            JButton single = new JButton("Single player");
            single.addActionListener(this);
            JButton dub = new JButton("Double Player");
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
            panel.setLayout(new GridLayout(0,1));
            frame.add(panel, BorderLayout.CENTER);
            panel.add(single);
            panel.add(dub);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Tic Tac toe game");
            frame.pack();
            frame.setVisible(true);



        }
        @Override
        public void actionPerformed(ActionEvent e){
            new Board();

        }



    public static void main(String[] args) throws Exception {
        new App();
    }
}
