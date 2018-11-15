/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao;

import java.util.List;
import lk.ijse.ijsebillinsystem.dto.SuperDTO;

/**
 *
 * @author user
 */
public interface SuperDAO <T extends SuperDTO,ID>{
    public boolean save(T t)throws Exception;
    public boolean delete(T t)throws Exception;
    public boolean update(T t)throws Exception;
    public T find(ID id)throws Exception;
    public List<T> getAll()throws Exception;
    
    
    
}
