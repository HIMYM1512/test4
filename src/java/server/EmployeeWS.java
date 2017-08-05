/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import entitites.Employees;
import entitites.EmployeesFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nth15
 */
@WebService(serviceName = "EmployeeWS")
public class EmployeeWS {

    @EJB
    private EmployeesFacadeLocal employeesFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkLogin")
    public boolean checkLogin(@WebParam(name = "id") String id, @WebParam(name = "password") String password) {
        boolean check = false;
        try {
            if (employeesFacade.checkLogin(id, password) != null) {
                check = true;
            }
        } catch (Exception e) {

        }

        return check;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "create")
    public String create(@WebParam(name = "id") String id, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name = "age") int age) {
        String message = "";
        Employees emp = new Employees();
        emp.setEmployeeID(id);
        emp.setName(name);
        emp.setPassword(password);
        emp.setAge(age);
        if (employeesFacade.find(id)!=null) {
            message = "ID Existed";
        }
        else {
            employeesFacade.create(emp);
            message = "Inserted Successful";
        }
        return message;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showAll")
    public List<Employees> showAll() {
        return employeesFacade.findAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        return "Deleted Successful";
    }
    
    

}
