import com.intellij.openapi.Disposable;

import model.persistence.ApplicationSettings;
import view.TreeModel;

import javax.swing.JPanel;

public class MVCPanel extends JPanel implements Disposable {

    private TreeModel model;
    private view.ToolchainPanel view;
    private controller.ToolchainPanel controller;
    private JPanel viewPanel;


    public MVCPanel() {
        model = new TreeModel();
        view = new view.ToolchainPanel(model);
        controller = new controller.ToolchainPanel(model, view);
        viewPanel = view.getPanel();
    }

    public JPanel getViewPanel() {
        return viewPanel;
    }

    public final void autoRecheckWithApplication() {
    }

    @Override
    public void dispose() {

    }
}
