package main.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.JavmosGUI;
import main.components.JavmosPanel;
import main.components.functions.Cosine;
import main.components.functions.Function;
import main.components.functions.Logarithmic;
import main.components.functions.Polynomial;
import main.components.functions.Sine;
import main.components.functions.Tangent;
import main.exceptions.PolynomialException;

public class DrawListener implements ActionListener {

    private final JavmosGUI gui;
    private final JavmosPanel panel;

    public DrawListener(JavmosGUI gui, JavmosPanel panel) {
        this.gui = gui;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String f = gui.getEquationField();
            Function function;
            if (f.contains("sin")) {
                function = new Sine(gui, f);
            } else if (f.contains("cos")) {
                function = new Cosine(gui, f);
            } else if (f.contains("tan")) {
                function = new Tangent(gui, f);
            } else if (f.contains("ln") || f.contains("log")) {
                function = new Logarithmic(gui, f);
            } else {
                function = new Polynomial(gui, f);
            }
            panel.components.clear();
            panel.setFunction(function);
            panel.repaint();
            gui.setFirstDerivativeLabel(panel.getFunction().getFirstDerivative());
            gui.setSecondDerivativeLabel(panel.getFunction().getSecondDerivative());
        } catch (PolynomialException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Function Error", JOptionPane.ERROR_MESSAGE);
        }
        panel.repaint();
    }
}