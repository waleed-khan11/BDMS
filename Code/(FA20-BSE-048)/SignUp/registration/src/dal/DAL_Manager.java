/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author muhammad ali raza
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.BDMS_Creator;
import model.dto.RegisterDTO;
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
  public ArrayList<RegisterDTO> getRegistersList(String searchKey) {
                
        Connection  dbConnection = objConnection.getConnection();
        Response objResponse = BDMS_Creator.getInstanceOF_Response();
        String viewregistersQuery = "Select * from register";
        
//        if(searchKey == null || searchKey.length() > 0)
//        {    
//            objVal.validateSearch(objResponse);
//            viewregistersQuery += " where fullName LIKE '%"+searchKey+"%' OR Email LIKE '%"+searchKey+"%' OR Password LIKE '%"+searchKey+"%'OR ConfirmAPssword LIKE '%"+searchKey+ "%';";
//        }
        ResultSet rs = objReader.getRecords(viewregistersQuery, dbConnection);
        return objMapper.getRegisters(rs);        
    }
   public void saveRegister(RegisterDTO objDon, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveRegisters(objDon,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message("Ooops! Failed to Donate Blood, Please contact support that there an issue while Donating Blood.", MessageType.Error));//
        objResponse.messagesList.add(BDMS_Creator.getInstanceOF_Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));//
        }
    }

    public void saveRegisters(RegisterDTO objReg, Response objResponse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
