/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.BDMS_Creator;
import model.dto.RegisterDTO;
/**
 *
 * @author muhammad ali raza
 */
public class RecordMapper {
    ArrayList<RegisterDTO> getRegisters(ResultSet rs) {
        ArrayList<RegisterDTO> reglist = new ArrayList<>();
        try{
        while (rs.next())
            {
             RegisterDTO objReg=BDMS_Creator.getInstanceOF_RegisterDTO();
                objReg.id=rs.getString(1);
                objReg.Fullname= rs.getString(2);
                objReg.Email =rs.getString(3);
                objReg.Password=rs.getString(4);
                objReg.ConfirmPassword=rs.getString(5);
                
               //objEmp.BirthDate = rs.getString(6);
                reglist.add(objReg);   
            }
        }catch (Exception e){
        }
        return reglist;
    }

}
