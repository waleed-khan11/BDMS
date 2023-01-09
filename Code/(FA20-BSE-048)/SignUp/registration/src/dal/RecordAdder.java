/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import model.dto.Response;
import model.dto.RegisterDTO;
import model.BDMS_Creator;
import model.dto.MessageType;
/**
 *
 * @author muhammad ali raza
 */
public class RecordAdder {
    public void saveRegisters(RegisterDTO objReg, Response objResponse, Connection dbConnection) {
        try{
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO donor (Reg#,firstName,lastName,bloodtype,age,city) VALUES (?,?,?,?,?);");
            p.setString(1, objReg.id);
            p.setString(2, objReg.Fullname);
            p.setString(3, objReg.Email);
            p.setString(4, objReg.Password);
            p.setString(5, objReg.ConfirmPassword);
            
            int rowsInserted = p.executeUpdate();
            if(rowsInserted > 0){
                objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Registraion Successfully.", MessageType.Information));
            }
        }catch(SQLException e){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Ooops! Failed to Donate Blood, Please contact support that there an issue while saving Donating Blood.", MessageType.Error));
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message(e.getMessage() + "\n Stack Track:\n"+Arrays.toString(e.getStackTrace()), MessageType.Exception));
        }
    }
}
