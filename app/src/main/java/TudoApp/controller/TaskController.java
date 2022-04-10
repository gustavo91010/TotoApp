/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TudoApp.controller;

import TudoApp.model.Task;
import TudoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class TaskController {
    
    public void save(Task task){
        String sql= "INSERT INTO tasks (" 
                + "idProject, "
                + "name, "
                + "description, "
                + "isCompleted, "
                + "notes, "
                + "deadline, "
                + "createdAT, "
                + "updatedAt ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try{
            
            conn= ConnectionFactory.getConnectin();
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, task.getIdPreoject());
            stmt.setString(2, task.getName());
            stmt.setString(3, task.getDescription());
            //stmt.setBoolean(4, task.getIsCompleted());
            stmt.setBoolean(4, false);
            stmt.setString(5, task.getNotes());
            stmt.setDate(6, new Date(task.getDeadline().getTime()));
            stmt.setDate(7, new Date(new java.util.Date().getTime()));
            //stmt.setDate(8, new Date(task.getUpdatedAt().getTime()));
            stmt.setDate(8, new Date(new java.util.Date().getTime()));
            // getTime ajuda a transformar Date no pacote sql aceitavel a Date no pacote java.util
            stmt.execute();
            
        }catch (SQLException es){ 
             throw new RuntimeException("erro ao salvar tarefa... :( "+ es.getMessage(), es);
            
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
            
        }
        
    }
    
    public void update( Task task){        
        String sql= "UPDATE tasks SET "
                 + "idProject= ?, "
                + "name= ?, "
                + "description= ?, "
                + "completed= ?, "
                + "notes= ?, "
                + "deadline= ?, "
                //+ "createdAT= ?, "
                + "updatedAt= ? "
                + "WHERE id= ?";
         Connection conn= null;
        PreparedStatement stmt= null;        
        try{            
            conn= ConnectionFactory.getConnectin();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, task.getIdPreoject());
            stmt.setString(2, task.getName());
            stmt.setString(3, task.getDescription());
          //  stmt.setBoolean(4, task.getIsCompleted());
            stmt.setBoolean(4, false);
            stmt.setString(5, task.getNotes());
            stmt.setDate(6, new Date(task.getDeadline().getTime()));
           // stmt.setDate(7, new Date(task.getCreatedAt().getTime()));
          //  stmt.setDate(7, new Date(new java.util.Date().getTime()));
            
           // stmt.setDate(8, new Date(task.getUpdatedAt().getTime()));
            stmt.setDate(7, new Date(new java.util.Date().getTime()));
            
            stmt.setInt(8, task.getId());
            // getTime ajuda a transformar Date no pacote sql aceitavel a Date no pacote java.util
            stmt.execute();            
        }catch (SQLException es){ 
             throw new RuntimeException("erro ao atualizar uma tarefa... :( "+ es.getMessage(), es);
                    }finally{
            ConnectionFactory.closeConnection(conn, stmt);            
        }                    
    }
    
    public void removeById(int taskId) {
        String sql= "DELETE From Tasks where id= ?";        
        Connection conn= null;
        PreparedStatement stmt= null;        
        try{            
            conn= ConnectionFactory.getConnectin();
            stmt= conn.prepareStatement(sql);
            
            stmt.setInt(1, taskId);
            stmt.execute();            
        }catch (SQLException e){ // o do proferro esta so com Exception
            throw new RuntimeException("Erro ao deletar a tarefa");            
        } finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }        
    }
    
    public List<Task> getAll(int idProject ){
        String sql= "SELECT * FROM tasks WHERE idProject = ?";
        Connection conn= null;
        PreparedStatement stmt= null;
        ResultSet resultSet= null;        
        List<Task> tasks= new ArrayList<Task>();        
        try {
            conn= ConnectionFactory.getConnectin();
            stmt= conn.prepareStatement(sql);
            stmt.setInt(1, idProject);
            resultSet= stmt.executeQuery();            
            while (resultSet.next()) {
               Task task = new Task();
               task.setId(resultSet.getInt("id"));
               task.setIdPreoject(resultSet.getInt("idProject"));
               task.setName(resultSet.getString("name"));
               task.setDescription(resultSet.getString("description"));
               task.setNotes(resultSet.getString("notes"));
               task.setIsCompleted(resultSet.getBoolean("isCompleted"));
               task.setDeadline(resultSet.getDate("deadline"));
               task.setCreatedAt(resultSet.getDate("createdAt"));
               task.setUpdatedAt(resultSet.getDate("UpdatedAt"));               
               tasks.add(task);
            }            
        } catch (SQLException e) {           
            throw new RuntimeException("erro ao chamar os dados da tarefa "  +e.getMessage(), e );
        }finally{                
        ConnectionFactory.closeConnection(conn, stmt, resultSet);               
        }
        return tasks;
        
    }
}
