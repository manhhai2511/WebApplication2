/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface AccountDAO {
    List<Account> getAll() throws Exception;
}
