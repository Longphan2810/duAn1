/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author Thinkpad E440
 */
public interface EntityDAO<Entity> {
    
    public void insert(Entity E);
    public void update(Entity E);
    public int delete(String ID);
    public List<Entity> selectAll(); 
    public Entity findById(String ID);
    
    
}
