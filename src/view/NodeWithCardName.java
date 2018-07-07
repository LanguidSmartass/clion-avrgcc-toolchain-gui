package view;

import model.NamedTreeNode;
import javax.swing.JPanel;

public class NodeWithCardName extends NamedTreeNode {
    private final String cardName;

    public NodeWithCardName(String name) {
        super(name);
        this.cardName = "";
    }

    public NodeWithCardName(String nodeName, String cardName) {
        super(nodeName);
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }
}
