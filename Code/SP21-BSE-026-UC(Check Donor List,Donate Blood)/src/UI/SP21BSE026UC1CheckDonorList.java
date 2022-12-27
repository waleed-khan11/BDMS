/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UI;

/**
 *
 * @author Waleed
 */
import model.BDMS_Creator;
public class SP21BSE026UC1CheckDonorList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Dashboard objDashboard=BDMS_Creator.getInstanceOF_Dashboard();
       objDashboard.setVisible(true);
       objDashboard.setTitle("Blood Donation Management System");
    }
    
}
