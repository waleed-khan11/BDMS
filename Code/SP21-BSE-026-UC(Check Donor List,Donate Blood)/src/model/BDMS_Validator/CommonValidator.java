/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.BDMS_Validator;

import model.dto.MessageType;
import model.dto.Response;
import model.BDMS_Creator;
import model.dto.DonorDTO;
import UI.ViewDonorsList;
/**
 *
 * @author Waleed
 */
public class CommonValidator {
        public static void validateDonor(DonorDTO objDon, Response objResponse) {
        if(objDon.Firstname.compareTo("") ==0 && objDon.City.compareTo("") == 0  &&objDon.Lastname.compareTo("") == 0&&objDon.age.compareTo("")==0&&objDon.bloodtype.compareTo("Select Blood Type")==0 ){
         objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Please Enter some data in the above boxes.",MessageType.Error));   
        }
        else{
         if(objDon.Firstname == null || objDon.Firstname.length() < 3){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("FIrst Name is not valid, Provide valid first name with at least 3 characters.",MessageType.Error));
        }
         if(objDon.Lastname == null || objDon.Lastname.length() < 3){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Last Name is not valid, Provide valid last name with at least 3 characters.",MessageType.Error));
        }
         if(objDon.City == null || objDon.City.length() < 3){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("City Name is not valid, Provide a valid city name with at least 3 characters.",MessageType.Error));
        }
//        if(objDon.Firstname ==null && objDon.City == null  &&objDon.Lastname == null ){
//         objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Please Enter some data in the above boxes.",MessageType.Error));   
//        }
         if(objDon.bloodtype.compareTo("Select Blood Type")==0){
        objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Please Select a particular blood type.",MessageType.Error));    
        }
        
            try{
            int a=Integer.parseInt(objDon.age);
        }
        catch(Exception e){
            objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Age must be entered a digit",MessageType.Error));
        
        }
        
    }
        }
        public  void validateSearch(Response objResponse){
              ViewDonorsList objdonList = BDMS_Creator.getInstanceOF_CheckDonorList();
              String Search = objdonList.getSearchVal();
              if(Search==null){
                  objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Please first type something in the search box then click on search.",MessageType.Error));
              }
        } 
}
