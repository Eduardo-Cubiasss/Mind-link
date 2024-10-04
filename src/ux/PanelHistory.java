/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import java.util.Stack;

/**
 *
 * @author 50369
 */
public class PanelHistory {
    private Stack<String> panelStack;

    public PanelHistory() {
        panelStack = new Stack<>();
    }

    public void pushPanel(String panelName) {
        panelStack.push(panelName);
    }

    public String popPanel() {
        if (!panelStack.isEmpty()) {
            return panelStack.pop();
        }
        return null;
    }

    public boolean isEmpty() {
        return panelStack.isEmpty();
    }
}
