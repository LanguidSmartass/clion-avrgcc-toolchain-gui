package view;

import model.NamedTreeNode;
import javax.swing.JPanel;

public class TreeNodeWithJPanel extends NamedTreeNode {
    private final String cardName;

    public TreeNodeWithJPanel(String name) {
        super(name);
        this.cardName = "";
    }

    public TreeNodeWithJPanel(String nodeName, String cardName) {
        super(nodeName);
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }
}
