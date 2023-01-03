/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.Response;
import model.dto.DonorDTO;
import model.BDMS_Creator;
import model.dto.MessageType;
import UI.DonateBlood;
/**
 *
 * @author Waleed
 */
public class RecordAdder {
    public void saveDonors(DonorDTO objDon, Response objResponse, Connection dbConnection) {
        try{
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO donor (Reg#,firstName,lastName,bloodtype,age,city) VALUES (?,?,?,?,?,?);");
            p.setString(1, objDon.id);
            p.setString(2, objDon.Firstname);
            p.setString(3, objDon.Lastname);
            p.setString(4, objDon.bloodtype);
            p.setString(5, objDon.age);
            p.setString(6, objDon.City);
            
            int rowsInserted = p.executeUpdate();
            
                DonateBlood db = BDMS_Creator.getInstanceOF_DonateBlood();
                db.jLabel8.setText("Donation Succesfull");
            
        }catch(SQLException e){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Ooops! Failed to Donate Blood, Please contact support that there an issue while saving Donating Blood.", MessageType.Error));
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }
}
