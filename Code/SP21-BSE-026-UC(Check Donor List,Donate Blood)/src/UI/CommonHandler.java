/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import model.dto.Response;

/**
 *
 * @author Waleed
 */
public class CommonHandler {
     static void handleResponse(Response objResponse,JComponent uiComponent) {
        if(objResponse.hasError()){
            if(uiComponent instanceof JLabel){
                ((JLabel)uiComponent).setText(objResponse.getErrorMessages());
                ((JLabel)uiComponent).setForeground(Color.red);
                //((JLabel)uiComponent).setBounds(0, 40, 0, 0);
            }
        }
        if(objResponse.isSuccessfull()){
            if(uiComponent instanceof JLabel){
                ((JLabel)uiComponent).setText("Blood sucessfully donated");
                ((JLabel)uiComponent).setForeground(Color.green);
                //((JLabel)uiComponent).setBounds(0, 40, 0, 0);
            }
        }
    }
}
