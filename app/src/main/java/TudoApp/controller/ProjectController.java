/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TudoApp.controller;

import TudoApp.model.Project;
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
public class ProjectController {

    public void save(Project project) {
        String sql = "INSERT INTO projects ("
                + " name,"
                + " description,"
                + " createdAt,"
                + " updatedAt"
                + ") VALUES "
                + "(?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionFactory.getConnectin();
            stmt = conexao.prepareStatement(sql);
//= new java.sql.Date(new Date().getTime())
            //  stmt.setInt(1, project.getId());
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDescription());
            // Date dateCreatedAt=new Date(project.getCreatedAt().getTime());
            Date dateCreatedAt = new Date(new java.util.Date().getTime());
           // Date dateUpdatedAt = new Date(project.getUpdatedAt().getTime());
            Date dateUpdatedAt = new Date(new java.util.Date().getTime());
            //stmt.setDate(3, project.getCreatedAt());
            stmt.setDate(3, dateCreatedAt);
            stmt.setDate(4, dateUpdatedAt);
            stmt.execute();
        } catch (SQLException e) {

            // throw new RuntimeException("erro ao salvar projeto "+e.getmensage, e);
            throw new RuntimeException("erro ao salvar projeto ", e);
        } finally {
            ConnectionFactory.closeConnection(conexao);
        }

    }

    public void update(Project project) {

        String sql = "UPDATE projects SET "
                + " name=?,"
                + " description=?,"
               // + " createdAt=?,"
                + " updatedAt=?"
                + " WHERE id=?";

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = ConnectionFactory.getConnectin();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDescription());
            //stmt.setDate(3, project.getCreatedAt());
          //  stmt.setDate(3, new Date(project.getCreatedAt().getTime()));
            stmt.setDate(3, new Date(new java.util.Date().getTime()));
            stmt.setInt(4, project.getId());

            stmt.execute();

        } catch (SQLException e) {

            // throw new RuntimeException("erro ao salvar projeto "+e.getmensage, e);
            throw new RuntimeException("erro ao salvar projeto ", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

    }

    public void remuveById(int projectId) {
        String sql = "DELETE FROM projects where id= ? ";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = ConnectionFactory.getConnectin();
            stmt = connection.prepareStatement(sql);

            //stmt.setInt(1, project.setId(id));
            stmt.setInt(1, projectId);
            stmt.execute();

        } catch (SQLException e) {

            throw new RuntimeException("Erro au atualizar projeto", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public List<Project> getAll() {

        String sql = "SELECT * FROM projects ";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Project> projects = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnectin();
            stmt = connection.prepareStatement(sql);
            result = stmt.executeQuery();

            while (result.next()) {

                Project project = new Project();

                project.setId(result.getInt("id"));
                project.setName(result.getString("name"));
                project.setDescription(result.getString("description"));
                project.setCreatedAt(result.getDate("createdAt"));
                project.setUpdatedAt(result.getDate("updatedAt"));
                projects.add(project);

            }

        } catch (SQLException e) {
            throw new RuntimeException("erro ao chamar projeto", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, result);
        }
        return projects;
    }
}
