package model;

import dao.Dao;
import dao.DaoImplJDBC;
import main.Logable;

public class Employee extends Person implements Logable {

    private Dao employeeDao = new DaoImplJDBC();

    public Employee(int employeeId, String password) {
        super();
    }

    @Override
    public boolean login(int userId, String password) {
        
    	boolean isAuthenticated = false;
        
    	try {
            employeeDao.connect();
            Employee employee = employeeDao.getEmployee(userId, password);
            if (employee != null) {
                isAuthenticated = true;
            }
            employeeDao.disconnect();
        
    	} catch (Exception e) {
            e.printStackTrace();
        }
        
    	return isAuthenticated;
    }
}
