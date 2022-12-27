/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author Waleed
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.BDMS_Creator;
import model.dto.DonorDTO;
import model.dto.MessageType;
import model.dto.Response;
import model.BDMS_Validator.CommonValidator;
public class DAL_Manager {
     DB_Reader objReader;
    RecordMapper objMapper;
    RecordAdder objAdder;
   SQLConnection objConnection;
   CommonValidator objVal;
   
    public DAL_Manager(RecordMapper mapper){
    objConnection =  BDMS_Creator.getInstanceOF_SQLConnection("localhost","master", "sa","root123");
    objReader = BDMS_Creator.getInstanceOF_DB_Reader();
    objAdder = BDMS_Creator.getInstanceOF_RecordAdder();
    objVal=BDMS_Creator.getInstanceOf_Validator();
    this.objMapper=mapper;
    
    }
  public ArrayList<DonorDTO> getDonorsList(String searchKey) {
                
        Connection  dbConnection = objConnection.getConnection();
        Response objResponse = BDMS_Creator.getInstanceOF_Response();
        String viewDonorsQuery = "Select * from donor";
        
        if(searchKey == null || searchKey.length() > 0)
        {    
            objVal.validateSearch(objResponse);
            viewDonorsQuery += " where firstName LIKE '%"+searchKey+"%' OR lastName LIKE '%"+searchKey+"%' OR bloodtype LIKE '%"+searchKey+"%'OR age LIKE '%"+searchKey+ "%'OR city LIKE '%"+searchKey+"%';";
        }
        ResultSet rs = objReader.getRecords(viewDonorsQuery, dbConnection);
        return objMapper.getDonors(rs);        
    }
   public void saveDonors(DonorDTO objDon, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveDonors(objDon,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Ooops! Failed to Donate Blood, Please contact support that there an issue while Donating Blood.", MessageType.Error));//
        objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));//
        }
    }
}
