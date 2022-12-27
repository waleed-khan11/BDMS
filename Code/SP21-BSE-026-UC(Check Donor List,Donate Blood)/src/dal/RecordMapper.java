/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.BDMS_Creator;
import model.dto.DonorDTO;
/**
 *
 * @author Waleed
 */
public class RecordMapper {
    ArrayList<DonorDTO> getDonors(ResultSet rs) {
        ArrayList<DonorDTO> donlist = new ArrayList<>();
        try{
        while (rs.next())
            {
             DonorDTO objDon=BDMS_Creator.getInstanceOF_DonorDTO();
                objDon.id=rs.getString(1);
                objDon.Firstname= rs.getString(2);
                objDon.Lastname =rs.getString(3);
                objDon.bloodtype=rs.getString(4);
                objDon.age=rs.getString(5);
                objDon.City=rs.getString(6);
                
               //objEmp.BirthDate = rs.getString(6);
                donlist.add(objDon);   
            }
        }catch (Exception e){
        }
        return donlist;
    }
}
