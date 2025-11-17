package com.java.employ.bal;

import com.java.employ.dao.EmployDao;
import com.java.employ.dao.EmployDaoImp;
import com.java.employ.exceptions.EmployException;
import com.java.employ.model.Employ;

import java.util.List;

public class EmployBal {
    static StringBuilder sb;
    static EmployDao employDao;

    static {
        sb= new StringBuilder();
        employDao = new EmployDaoImp();
    }

    public List<Employ> showEmployBal(){
        return employDao.showEmployDao();
    }

    public String addEmployBal(Employ employ) throws EmployException {
        if(validateEmploy(employ) == true){
            return employDao.addEmployDao(employ);
        }
        throw new EmployException(sb.toString());
    }
    public Employ searchEmployBal(int empno){
        return employDao.searchEmployDao(empno);
    }
    public String deleteEmployBal(int empno){
        return employDao.deleteEmployDao(empno);
    }
    public String updateEmployBal(Employ employ) throws EmployException {
        if (validateEmploy(employ)==true) {
            return employDao.updateEmployDao(employ);
        }
        throw new EmployException(sb.toString());
    }

    public boolean validateEmploy(Employ employ){
        boolean isValid = true;

        if (employ.getEmpno() <= 0){
            sb.append("Employ cannot be zero or negative number...\n");
            isValid = false;
        }
        if (employ.getName().length() < 5){
            sb.append("Employ Name must be 5 char min... \n");
            isValid = false;
        }
        if (employ.getDept().length() < 3) {
            sb.append("Department Contains Min 3 Chars...\n");
            isValid = false;
        }

        if (employ.getBasic() < 10000 || employ.getBasic() > 80000) {
            sb.append("Basic Must be Between 10000 and 80000...\n");
            isValid = false;
        }
        return isValid;
    }
}
