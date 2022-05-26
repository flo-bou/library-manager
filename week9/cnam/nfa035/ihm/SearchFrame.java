package cnam.nfa035.ihm;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;
import cnam.nfa035.bookDao.BookDaoInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

public class SearchFrame extends JFrame {
    JRadioButton isbnButton;
    JRadioButton titleButton;
    JRadioButton categoryButton;
    JTextField textField;
    JTextArea textArea;
    protected BookDaoInterface bookDao;

    public void setBookDao(BookDaoInterface dao){
        this.bookDao = dao;
    }

    public SearchFrame(){
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
        this.isbnButton = new JRadioButton("Par isbn", true);
        this.titleButton = new JRadioButton("Par titre");
        this.categoryButton = new JRadioButton("Par catégorie");
        bGroup.add(this.isbnButton);
        bGroup.add(this.titleButton);
        bGroup.add(this.categoryButton);
        buttonContainer.add(this.isbnButton);
        buttonContainer.add(this.titleButton);
        buttonContainer.add(this.categoryButton);
        buttonContainer.setLayout(new GridLayout(3, 1));

        bodyPanel.add(new JLabel ("Rechercher :"));
        this.textField = new JTextField("", 12);
        bodyPanel.add(this.textField);
        bodyPanel.add(buttonContainer);
        JButton validateButton = new JButton ("Valider");
        validateButton.addActionListener(new SearchAdapter());
        bodyPanel.add(validateButton);

        return bodyPanel;
    }

    private JPanel createFooterPanel() {
        JPanel resultPanel = new JPanel();
        resultPanel.add(new JLabel ("Résultat :"));
        this.textArea = new JTextArea("", 3, 28);
        this.textArea.setLineWrap(true);
        resultPanel.add(this.textArea);
//        resultPanel.setLayout(new GridLayout(1, 2, 10, 10));
        return resultPanel;
    }

    class SearchAdapter implements ActionListener {

        private String getIsbnSearchResult(){
            String resultStr;
            String isbn = textField.getText().trim();
            Book searchResult = bookDao.getLivreParIsbn(isbn);
            if(searchResult != null){
                resultStr = searchResult.toString();
            } else{
                resultStr = "Aucun livre avec cet isbn n'a été trouvé";
            }
            return resultStr;
        }

        private String getTitleSearchResult(){
            String resultStr;
            String title = textField.getText().trim();
            List<Book> searchResults = bookDao.getLivreParTitre(title);
            if(searchResults.size() > 0){
                resultStr = searchResults.size() + " livre(s) trouvé(s) : \n";
                for(Book b : searchResults){
                    resultStr = resultStr + b.toString() + "\n";
                }
            } else{
                resultStr = "Aucun livre avec ce titre n'a été trouvé";
            }
            return resultStr;
        }

        private String getCategorySearchResult(){
            String resultStr = "Aucun livre de cette catégorie n'a été trouvé";
            try{
                BookCategory category = BookCategory.toEnum(textField.getText().trim());
                List<Book> searchResults = bookDao.getLivreParCategorie(category);
                if(searchResults.size() > 0){
                    resultStr = searchResults.size() + " livre(s) trouvé(s) : \n";
                    for(Book b : searchResults){
                        resultStr = resultStr + b.toString() + "\n";
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
                resultStr = "Cette catégorie n'existe pas";
            }
            return resultStr;
        }

        @Override
        public void actionPerformed(ActionEvent evt){
            // triggered quand le bouton a été clique
            // obtenir le choix de type de recherche
            // lire le champs d'entrée
            // utiliser la recherche via dao
            // afficher le résultat dans le composant TextArea
            try {
                if (isbnButton.isSelected()) {
                    textArea.setText(getIsbnSearchResult());
                } else if (titleButton.isSelected()) {
                    textArea.setText(getTitleSearchResult());
                } else if (categoryButton.isSelected()) {
                    textArea.setText(getCategorySearchResult());
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
