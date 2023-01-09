/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author muhammad ali raza
 */
import java.util.ArrayList;
import model.dto.RegisterDTO;
import dal.DAL_Manager;
import model.dto.Response;
import model.BDMS_Validator.CommonValidator;
public class BDMS_Controller {
    
    DAL_Manager objDAL = BDMS_Creator.getInstanceOF_DAL_Manager();
      public ArrayList<RegisterDTO> CheckDonorList(String searchKey) {
        return objDAL.getRegistersList(searchKey);
    }
          public Response addRegister(RegisterDTO objReg) {
        Response objResponse = BDMS_Creator.getInstanceOF_Response();
        CommonValidator.validateRegister(objReg,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveRegister(objReg,objResponse);
        }
        return objResponse;
    }
        
        
}
