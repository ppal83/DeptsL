package com.pp.validation.dept;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.model.Dept;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class DeptValidator {

    private static final Logger logger = Logger.getLogger(DeptValidator.class);

    private DeptErrorsBean deptErrBean = new DeptErrorsBean();
    private DeptInputedBean deptInputedBean = null;

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final DeptDAO deptDAO = daoFactory.getDeptDAO();

    public boolean validate(HttpServletRequest req) {

        //creating dept bean with string fields for validation
        createDeptInpBean(req);

        logger.debug("Validating dept " + deptInputedBean);

        rejectIfEmptyOrWhitespace("Name", deptInputedBean.getName());
        rejectIfNameExists();


        return deptErrBean.isValid();
    }

    public DeptErrorsBean getDeptErrBean() {
        return deptErrBean;
    }

    public void setDeptErrBean(DeptErrorsBean deptErrBean) {
        this.deptErrBean = deptErrBean;
    }

    public DeptInputedBean getDeptInputedBean() {
        return deptInputedBean;
    }

    public void setDeptInputedBean(DeptInputedBean deptInputedBean) {
        this.deptInputedBean = deptInputedBean;
    }

    private void createDeptInpBean(HttpServletRequest req) {
        String id = req.getParameter("id") != null ? req.getParameter("id") : "0";
        String name = req.getParameter("name");

        deptInputedBean = new DeptInputedBean(id, name);
    }

    private void rejectIfEmptyOrWhitespace(String inputFieldName, String inputFieldValue) {
        if ( inputFieldValue.isEmpty() || inputFieldValue.trim().isEmpty() ) {
            setErrBeanProperty(inputFieldName, "Dept " + inputFieldName + " is required");
            deptErrBean.setValid(false);
        }
    }

    private void rejectIfNameExists() {

        int deptId = Integer.parseInt(deptInputedBean.getId());
        List<Dept> deptsList = deptDAO.getAllDepts();

        //new employee
        if (deptId == 0) {
            for (Dept dept : deptsList) {
                if ( deptInputedBean.getName().equals(dept.getName()) ) {
                    deptErrBean.setName("Dept with this name already exists");
                    deptErrBean.setValid(false);
                }
            }
        }

        //existing employee
        if (deptId != 0) {
            Dept deptDb = deptDAO.getDeptById(deptId);
            for (Dept dept : deptsList) {
                if ( deptInputedBean.getName().equals(dept.getName())
                        && !deptInputedBean.getName().equals(deptDb.getName()) ) {
                    deptErrBean.setName("Dept with this name already exists");
                    deptErrBean.setValid(false);
                }
            }
        }
    }

    private void setErrBeanProperty(String errFieldName, String errFieldValue) {
        try {
            Method setter = deptErrBean.getClass().getMethod("set" + errFieldName, String.class);
            setter.invoke(deptErrBean, errFieldValue);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}