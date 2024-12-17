import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends  JFrame {
    //  value to check if its a player`s turn or not
private  boolean playerTurn;
// Button matrix
private JButton[][] buttons;
private  JPanel panel;
    public Board(){
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));

       buttons = new JButton[3][3];
        playerTurn = true;
         this.addButtons();

         setSize(300,300);
         setLocationRelativeTo(null);
         setVisible(true);

    }
    public void addButtons(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].addActionListener(new ButtonClickListener(i,j));
                add(buttons[i][j]);
            }
        }
    }



    private  class ButtonClickListener implements ActionListener{
        private int row, col;
        public ButtonClickListener(int row, int col){
            this.row = row;
            this.col = col;

        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(buttons[row][col].getText().isEmpty()){
                if(playerTurn){
                    buttons[row][col].setText("X");
                }
                else{
                    buttons[row][col].setText("O");
                }
                playerTurn = !playerTurn;
                checkWin();
            }
        }
    }
    private void checkWin() {
        String winner = checkRows();
        if (winner == null) {
            winner = checkColumns();
        }
        if (winner == null) {
            winner = checkDiagonals();
        }
        if (winner != null) {
            JOptionPane.showMessageDialog(this, winner + " wins!");
        }
    }


    private String checkRows() {
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getText().isEmpty() &&
                    buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText())) {
                return buttons[i][0].getText();
            }
        }
        return null;
    }
    private String checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (!buttons[0][i].getText().isEmpty() &&
                    buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText())) {
                return buttons[0][i].getText();
            }
        }
        return null;
    }
    private String checkDiagonals() {
        if (!buttons[0][0].getText().isEmpty() &&
                buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText())) {
            return buttons[0][0].getText();
        }
        if (!buttons[0][2].getText().isEmpty() &&
                buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText())) {
            return buttons[0][2].getText();
        }
        return null;
    }

    public static void main(String[] args){
        new Board();
    }
}
