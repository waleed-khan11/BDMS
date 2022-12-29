/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Waleed
 */
import java.util.ArrayList;
import model.dto.DonorDTO;
import dal.DAL_Manager;
import model.dto.Response;
import model.BDMS_Validator.CommonValidator;
public class BDMS_Controller {
    
    DAL_Manager objDAL = BDMS_Creator.getInstanceOF_DAL_Manager();
      public ArrayList<DonorDTO> searchDonorList(String searchKey) {
        return objDAL.getDonorsList(searchKey);
    }
        public Response addDonor(DonorDTO objDon) {
        Response objResponse = BDMS_Creator.getInstanceOF_Response();
        CommonValidator.validateDonor(objDon,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveDonors(objDon,objResponse);
        }
        return objResponse;
    }
        
        
}
