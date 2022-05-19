package cnam.nfa035.ihm;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BiblioFrame extends JFrame {

    public BiblioFrame(){
        setTitle ("Ma Bibliothèque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize ( 600, 300 );
        setLocation ( 200, 200 );
        setVisible ( true );
        initInterface();
        pack();
    }
    public void initInterface (){
        Container contentP = this.getContentPane();
        contentP.setLayout(new GridLayout( 4, 3 ));

//         ligne 1
        URL iconUrl = this.getClass().getResource("book-shelf-96x96.gif");
        ImageIcon libIcon = new ImageIcon(iconUrl, "Book shelf.");
        contentP.add(new JLabel (libIcon));
        contentP.add(new JLabel ("Rechecher dans la Bibliothèque."));
        contentP.add(new JLabel (libIcon));

//        ligne 2
        ButtonGroup searchSelection = new ButtonGroup();
        JRadioButton isbnButton = new JRadioButton("Par isbn");
        JRadioButton titleButton = new JRadioButton("Par titre");
        JRadioButton categoryButton = new JRadioButton("Par catégorie");
        searchSelection.add(isbnButton);
        searchSelection.add(titleButton);
        searchSelection.add(categoryButton);
        contentP.add(isbnButton);
        contentP.add(titleButton);
        contentP.add(categoryButton);

//        ligne 3
        contentP.add(new JLabel ("Rechercher :"));
        contentP.add(new JTextField ());
        contentP.add(new JButton ("Valider")) ;

//        ligne 4
        contentP.add(new JLabel ("Résultat :"));
        contentP.add(new JTextArea ());
        contentP.add(new JLabel ());
    }
}
