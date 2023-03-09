/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Department;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DepartmentDAO {
       List<Department> getAllDe() throws Exception;
       ArrayList<Department> getUsersList(int start, int end) throws Exception;
       int getTotalPage() throws Exception;
}
