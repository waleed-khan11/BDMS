/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.BDMS_Validator;

import model.dto.MessageType;
import model.dto.Response;
import model.BDMS_Creator;
import model.dto.RegisterDTO;
//import UI.Registrationt;
/**
 *
 * @author muhammad ali raza
 */
public class CommonValidator {
        public static void validateRegister(RegisterDTO objReg, Response objResponse) {
        if(objReg.Fullname == null || objReg.Fullname.length() < 3){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("FIrst Name is not valid, Provide valid first name with at least 3 characters.",MessageType.Error));
        }
        if(objReg.Email == null || objReg.Email.length() < 3){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Last Name is not valid, Provide valid last name with at least 3 characters.",MessageType.Error));
        }
        try{
            int a=Integer.parseInt(objReg.Password);
            int b=Integer.parseInt(objReg.ConfirmPassword);
        }
        catch(Exception e){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Age must be entered a digit",MessageType.Error));
        }
        
    }

//     public  void validateSearch(Response objResponse){
//              getInstanceOF_Registration objdonList = BDMS_Creator.getInstanceOF_Registration();
//              String Search = objdonList.getSearchVal();
//              if(Search==null){
//                  objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Please first type something in the search box then click on search.",MessageType.Error));
//              }
//        } 
}
