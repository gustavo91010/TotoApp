/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TudoApp.view;

import TudoApp.controller.ProjectController;
import TudoApp.controller.TaskController;
import TudoApp.model.Project;
import TudoApp.model.Task;
import TudoApp.util.ButtonColumnCellrenderer;
import TudoApp.util.DeadlineColumnCellRenderer;
import TudoApp.util.TaskTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Gustavo
 */
public class MainScreen extends javax.swing.JFrame {

    private ProjectController projectController;
    private TaskController taskController;
    private TaskTableModel taskTableModel;

    // responsalvel por ser o model do meu conponente grafico
    DefaultListModel projectsModel;

    public MainScreen() {
        initComponents();

        initDataController();
        // esse metodo vai instanciar as classes Controller
        initCompodentesModel();
        // quando minha tela for criada, a lista de projetos sera apresentada
        
        decorateTableTask();
        // o metodo que decora o tableTask
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelToobar = new javax.swing.JPanel();
        jLabelToobarSubTitle = new javax.swing.JLabel();
        jLabelInconettITLE = new javax.swing.JLabel();
        jLabelToobarTitle = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsIcon = new javax.swing.JLabel();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTaskTitle = new javax.swing.JLabel();
        jLabelTasksArts = new javax.swing.JLabel();
        jPanelProjectList = new javax.swing.JPanel();
        jScrollPaneProjects = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPaneTasks = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();
        jPanelEmpytList = new javax.swing.JPanel();
        jLabelEmpytListArts = new javax.swing.JLabel();
        jLabelEmpytListTitle = new javax.swing.JLabel();
        jLabelEmpytListSupTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 800));

        jPanelToobar.setBackground(new java.awt.Color(0, 153, 102));
        jPanelToobar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelToobarSubTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelToobarSubTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToobarSubTitle.setText("Quem nao tem uma boa mem�ria, tem que ter uma boa agenda.");

        jLabelInconettITLE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Incones/check.jpg"))); // NOI18N
        jLabelInconettITLE.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabelInconettITLE.setMinimumSize(new java.awt.Dimension(100, 100));

        jLabelToobarTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelToobarTitle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelToobarTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToobarTitle.setText("Todo App");

        javax.swing.GroupLayout jPanelToobarLayout = new javax.swing.GroupLayout(jPanelToobar);
        jPanelToobar.setLayout(jPanelToobarLayout);
        jPanelToobarLayout.setHorizontalGroup(
            jPanelToobarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToobarLayout.createSequentialGroup()
                .addComponent(jLabelInconettITLE, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanelToobarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelToobarLayout.createSequentialGroup()
                        .addComponent(jLabelToobarTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelToobarSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)))
        );
        jPanelToobarLayout.setVerticalGroup(
            jPanelToobarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToobarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelToobarTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabelToobarSubTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelInconettITLE, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanelProjects.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjects.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelProjectsTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelProjectsTitle.setText("Projetos");

        jLabelProjectsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novos/check 3.png"))); // NOI18N
        jLabelProjectsIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelProjectsIcon)
                .addContainerGap())
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProjectsIcon)))
        );

        jPanelTasks.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTaskTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTaskTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelTaskTitle.setText("Tarefas");

        jLabelTasksArts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novos/check 3.png"))); // NOI18N
        jLabelTasksArts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksArtsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTaskTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTasksArts)
                .addContainerGap())
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTaskTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelTasksLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelTasksArts))))
        );

        jPanelProjectList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListProjects.setBackground(new java.awt.Color(255, 255, 255));
        jListProjects.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setFixedCellHeight(50);
        jListProjects.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
        });
        jScrollPaneProjects.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectListLayout = new javax.swing.GroupLayout(jPanelProjectList);
        jPanelProjectList.setLayout(jPanelProjectListLayout);
        jPanelProjectListLayout.setHorizontalGroup(
            jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelProjectListLayout.setVerticalGroup(
            jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTableTasks.setBackground(new java.awt.Color(255, 255, 255));
        jTableTasks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Descri��o", "Prazo", "Tarefa comcluida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTasks.setGridColor(new java.awt.Color(255, 255, 255));
        jTableTasks.setRowHeight(50);
        jTableTasks.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.setShowVerticalLines(false);
        jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTasksMouseClicked(evt);
            }
        });
        jScrollPaneTasks.setViewportView(jTableTasks);

        jPanel5.add(jScrollPaneTasks, java.awt.BorderLayout.CENTER);

        jPanelEmpytList.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmpytListArts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmpytListArts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novos/Lista.png"))); // NOI18N

        jLabelEmpytListTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpytListTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelEmpytListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmpytListTitle.setText("Nenhuma tarefa por aqui. xD");

        jLabelEmpytListSupTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmpytListSupTitle.setForeground(new java.awt.Color(153, 153, 153));
        jLabelEmpytListSupTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmpytListSupTitle.setText("Clique no botao + para adicionar uma nova tarefa.");

        javax.swing.GroupLayout jPanelEmpytListLayout = new javax.swing.GroupLayout(jPanelEmpytList);
        jPanelEmpytList.setLayout(jPanelEmpytListLayout);
        jPanelEmpytListLayout.setHorizontalGroup(
            jPanelEmpytListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelEmpytListArts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelEmpytListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelEmpytListSupTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelEmpytListLayout.setVerticalGroup(
            jPanelEmpytListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpytListLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabelEmpytListArts)
                .addGap(55, 55, 55)
                .addComponent(jLabelEmpytListTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmpytListSupTitle)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel5.add(jPanelEmpytList, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelToobar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToobar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // metod que salva um novo projeto
    private void jLabelProjectsIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectsIconMouseClicked

        // quando eu clicar na incone la na tela, ele vai abrir uma janela, do objeto ProjectsDialogScreen
        ProjectsDialogScreen projectsDialogScreen = new ProjectsDialogScreen(this, rootPaneCheckingEnabled);
        projectsDialogScreen.setVisible(true);

        // faz essa parada aqui, pra quando eu salvar um projeto, ele atualizar a lista, e apresenta no progama.
        // colocamos um ouvinte para observar o evento de fechar a janela
        projectsDialogScreen.addWindowListener(new WindowAdapter() {
            // quando a janela for fechada
            public void windowClosed(WindowEvent e) {
                // eu chamo novamente meus projetos
                loadProjects();
            }
        });

    }//GEN-LAST:event_jLabelProjectsIconMouseClicked

    private void jLabelTasksArtsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTasksArtsMouseClicked
        TaskDialogScreem taskDialogScreem = new TaskDialogScreem(this, rootPaneCheckingEnabled);

        int projectIndex = jListProjects.getSelectedIndex(); // me mostra o index do item selecionado
        Project project = (Project) projectsModel.get(projectIndex); // solicito o projeto referente a esse index
        taskDialogScreem.setProjeto(project);

        taskDialogScreem.setVisible(true);

        // essa linha de codigo(ouvindte) vai verificar , quando a janela de save for fechada, ele irar chamar novamente a lista de task
taskDialogScreem.addWindowListener( new WindowAdapter() {
     // quando a janela for fechada
    public void windowClosed( WindowEvent e){
       
        // seleciona o index do projeto que foi selecionado
        int projectIndex= jListProjects.getSelectedIndex();
        // seleciona o projeto que foi clicado e esta dentro do projectsModel
        Project project= (Project) projectsModel.get(projectIndex);
        
       // chama as tarefas do projeto que foi clicado
        loadTasks(project.getId());
        
    }
    
});
        
        
    }//GEN-LAST:event_jLabelTasksArtsMouseClicked

    // evento quando clicamos na tela, na parte de tarefas
    private void jTableTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTasksMouseClicked
        // ele me diz qual a linha que recebeu o clic na tabela
        
        int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());

        // ele me diz qual a coluna que recebeu o clic na tabela
        int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());

        // recebe o comando ta tabela taskTableModel, da linha 95
        switch (columnIndex) {

            case 3:
                // eu recebo 1 item da lista tasks que foi alterada no clic, pelo metodo setValueAt da classe taskModelTable
             Task   task = taskTableModel.getTasks().get(rowIndex);

                // ele atualiza a coluna que foi selecionada, no caso, coluna indice 3 que � a "tarefa concluida"
                taskController.update(task);

                break;
            case 4:
                
                break;
            case 5:
                 task= taskTableModel.getTasks().get(rowIndex);
                 // aqui eu removo a tarefa do meu banco de dados
                 taskController.removeById(task.getId());
                 // aqui removo a tarefa do meu model
                 taskTableModel.getTasks().remove(task);
                int projectIndex= jListProjects.getSelectedIndex();
                Project project= (Project) projectsModel.get(projectIndex);
                loadTasks(project.getId());
                break;

        }
 

    }//GEN-LAST:event_jTableTasksMouseClicked

    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseClicked

        // me retorna o indeci do item clicado, no caso, o id do projeto
        int projectIndex = jListProjects.getSelectedIndex();

        // eu uso o id do projeto, para ir na List da classe projectModel  e selecionar o projeto clicado
        Project project = (Project) projectsModel.get(projectIndex);

        // com isso eu carrego as tarefas do projeto selecionado
        loadTasks(project.getId());

    }//GEN-LAST:event_jListProjectsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEmpytListArts;
    private javax.swing.JLabel jLabelEmpytListSupTitle;
    private javax.swing.JLabel jLabelEmpytListTitle;
    private javax.swing.JLabel jLabelInconettITLE;
    private javax.swing.JLabel jLabelProjectsIcon;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTaskTitle;
    private javax.swing.JLabel jLabelTasksArts;
    private javax.swing.JLabel jLabelToobarSubTitle;
    private javax.swing.JLabel jLabelToobarTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelEmpytList;
    private javax.swing.JPanel jPanelProjectList;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelToobar;
    private javax.swing.JScrollPane jScrollPaneProjects;
    private javax.swing.JScrollPane jScrollPaneTasks;
    private javax.swing.JTable jTableTasks;
    // End of variables declaration//GEN-END:variables

    public void decorateTableTask() {

        // customizando o rider (a grade no final) da table de tarefas
        jTableTasks.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTableTasks.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTasks.getTableHeader().setForeground(new Color(255, 255, 255));

        // aqui, estou dizendo que a segunda coluna do meu gride de tarefas, vai ser renderizado segundo a classe DeadlineColumnCellRenderer
        // onde eu havia feito uma customiza��o
       jTableTasks.getColumnModel().getColumn(2).setCellRenderer(new DeadlineColumnCellRenderer());
        
        
        // o comando abaixo seta os incones de editar e excluir
       jTableTasks.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnCellrenderer("edit"));
        // edit= nome do arquivo png que esta na pasta recourse (na pasta que tem os incones)
        
                jTableTasks.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnCellrenderer("delete"));

                
        // criando um organizador automaico(organizando em ordem alfabetica) para as colunas da table
      //  jTableTasks.setAutoCreateRowSorter(true);
    }

    public void initDataController() {

        projectController = new ProjectController();
        taskController = new TaskController();
    }

    // alimenta a lista de tarefas de cada projeto
    public void initCompodentesModel() {
        projectsModel = new DefaultListModel();
        // carregar para dentro dele os projetos que estao no banco de dados
        loadProjects();

        taskTableModel = new TaskTableModel();
        // quando minha tela for criada, estarei usando a tabela que foi criada na classe taskTableModel
        jTableTasks.setModel(taskTableModel);

        // carregar as tarefas para atualizar
        if (!projectsModel.isEmpty()) {
            // quando minha tela � iniciada eu inicializo os componentes models

            jListProjects.setSelectedIndex(0);
            // ela smpre vai iniciar mostrando a lista de tarefa do primeiro projeto
            Project project = (Project) projectsModel.get(0);
            loadTasks(project.getId());
        }
    }

    // metodo que carrega as tarefas
    public void loadTasks(int idProjects) {
        // eu trago as tarefas que estao vinculadas ao projeto
        List<Task> tasks = taskController.getAll(idProjects);

        // aqui, minha tabela de task recebe a lista de tasks que esta no banco de dados arelado ao projeto
        taskTableModel.setTasks(tasks);
        showJTableTasks(!tasks.isEmpty());

    }

    // esse � o metodo que mostra as tarefas quando eu clico em algum projeto
    private void showJTableTasks(boolean hasTasks) {
        if (hasTasks) {
            // existem tarefas?

            if (jPanelEmpytList.isVisible()) {
                jPanelEmpytList.setVisible(false);
                jPanel5.remove(jPanelEmpytList);
            }

            jPanel5.add(jScrollPaneTasks);
            jScrollPaneTasks.setVisible(true);
            jScrollPaneTasks.setSize(jPanel5.getWidth(), jPanel5.getHeight());

        } else {
            if (jScrollPaneTasks.isVisible()) {
                jScrollPaneTasks.setVisible(false);
                jPanel5.remove(jScrollPaneTasks);
            }

            jPanel5.add(jPanelEmpytList);
            jPanelEmpytList.setVisible(true);
            jPanelEmpytList.setSize(jPanel5.getWidth(), jPanel5.getHeight());

        }

    }

    // metodo que carrega os projetos
    public void loadProjects() {

        // vou guardar dentro dele os projetos que seram mostrado na aplica��o
        List<Project> projects = projectController.getAll();
        projectsModel.clear();

        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            projectsModel.addElement(project);

        }
        // para vinvular nossa ista ao jList
        jListProjects.setModel(projectsModel);

    }
}
