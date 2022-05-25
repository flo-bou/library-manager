package cnam.nfa035.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class BiblioFrame extends JFrame {

    public BiblioFrame(){
        setTitle ("Ma Bibliothèque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize ( 600, 300 );
        setLocation( 200, 200 );
        setVisible( true );
        initInterface();
        pack();
    }

    public void initInterface (){
        Container contentP = this.getContentPane();
//        contentP.setLayout(new GridLayout( 4, 3 ));
        contentP.setLayout(new BorderLayout(10, 10));
        contentP.add(createHeaderPanel(), BorderLayout.NORTH);
        contentP.add(createBodyPanel(), BorderLayout.CENTER);
        contentP.add(createFooterPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel(){
        JPanel headerPanel = new JPanel();
        URL iconUrl = this.getClass().getResource("book-shelf-96x96.gif");
        ImageIcon libIcon = new ImageIcon(iconUrl, "Book shelf.");
        headerPanel.add(new JLabel (libIcon));
        headerPanel.add(new JLabel ("Rechecher dans la Bibliothèque."));
        return headerPanel;
    }

    private JPanel createBodyPanel(){
        JPanel bodyPanel = new JPanel();

        JPanel buttonContainer = new JPanel();
        ButtonGroup bGroup = new ButtonGroup();
        JRadioButton isbnButton = new JRadioButton("Par isbn", true);
        JRadioButton titleButton = new JRadioButton("Par titre");
        JRadioButton categoryButton = new JRadioButton("Par catégorie");
        bGroup.add(isbnButton);
        bGroup.add(titleButton);
        bGroup.add(categoryButton);
        buttonContainer.add(isbnButton);
        buttonContainer.add(titleButton);
        buttonContainer.add(categoryButton);
        buttonContainer.setLayout(new GridLayout(3, 1));

        bodyPanel.add(new JLabel ("Rechercher :"));
        bodyPanel.add(new JTextField("", 12));
        bodyPanel.add(buttonContainer);
        bodyPanel.add(new JButton ("Valider"));

        return bodyPanel;
    }

    private JPanel createFooterPanel() {
        JPanel resultPanel = new JPanel();
        resultPanel.add(new JLabel ("Résultat :"));
        resultPanel.add(new JTextArea("", 3, 18));
//        resultPanel.setLayout(new GridLayout(1, 2, 10, 10));
        return resultPanel;
    }

    public abstract class BiblioAdapteur implements ActionListener {
        public BiblioAdapteur(ActionEvent evt){
            getContentPane().setBackground(Color.CYAN);
//            bGroup.getSelection();
//
        }
    }
}
