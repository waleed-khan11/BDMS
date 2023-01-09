/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import model.BDMS_Creator;

/**
 *
 * @author fa20-bse-048
 */
public class FA20BSE038UC1Resgitration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Registration objDashboard=BDMS_Creator.getInstanceOF_Registration();
       objDashboard.setVisible(true);
       objDashboard.setTitle("Blood Donation Management System");
        // TODO code application logic here
    }
    
}
