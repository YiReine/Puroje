/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.CourseInstructor.CourseInstructorForm;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author NguyenNhi
 */
public class MenuForm extends javax.swing.JFrame {

    /**
     * Creates new form MenuForm
     */
    public MenuForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel1 = new UI.UI_Item.button.Panel();
        panel_teacher = new UI.UI_Item.button.Panel();
        label_teacher = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        myButton1 = new UI.UI_Item.button.MyButton();
        panel3 = new UI.UI_Item.button.Panel();
        panel_student = new UI.UI_Item.button.Panel();
        label_student = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panel5 = new UI.UI_Item.button.Panel();
        panel_Course = new UI.UI_Item.button.Panel();
        label_Course = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panel7 = new UI.UI_Item.button.Panel();
        panel_StudentGrade = new UI.UI_Item.button.Panel();
        label_StudentGrade = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panel9 = new UI.UI_Item.button.Panel();
        panel_CourseIns = new UI.UI_Item.button.Panel();
        label_CourseIns = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 240, 240));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(86, 182, 236));
        jLabel1.setText("COURSE MANAGER");

        panel1.setBackground(new java.awt.Color(86, 182, 236));
        panel1.setRoundBottomLeft(30);
        panel1.setRoundBottomRight(30);
        panel1.setRoundTopLeft(30);
        panel1.setRoundTopRight(30);

        panel_teacher.setBackground(new java.awt.Color(255, 255, 255));
        panel_teacher.setRoundBottomLeft(25);
        panel_teacher.setRoundBottomRight(25);
        panel_teacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_teacherMouseExited(evt);
            }
        });

        label_teacher.setBackground(new java.awt.Color(255, 255, 255));
        label_teacher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_teacher.setForeground(new java.awt.Color(0, 204, 255));
        label_teacher.setText("                  TEACHER");
        label_teacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_teacherMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_teacherMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_teacherLayout = new javax.swing.GroupLayout(panel_teacher);
        panel_teacher.setLayout(panel_teacherLayout);
        panel_teacherLayout.setHorizontalGroup(
            panel_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_teacher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_teacherLayout.setVerticalGroup(
            panel_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_teacher, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panel_teacher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(86, 182, 236));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("WELLCOME");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ADMINISTRATOR");

        myButton1.setText("LOGOUT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel4)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        panel3.setBackground(new java.awt.Color(86, 182, 236));
        panel3.setRoundBottomLeft(30);
        panel3.setRoundBottomRight(30);
        panel3.setRoundTopLeft(30);
        panel3.setRoundTopRight(30);

        panel_student.setBackground(new java.awt.Color(255, 255, 255));
        panel_student.setRoundBottomLeft(25);
        panel_student.setRoundBottomRight(25);

        label_student.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_student.setForeground(new java.awt.Color(0, 204, 255));
        label_student.setText("                   STUDENT");
        label_student.setToolTipText("");
        label_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_studentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_studentMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_studentLayout = new javax.swing.GroupLayout(panel_student);
        panel_student.setLayout(panel_studentLayout);
        panel_studentLayout.setHorizontalGroup(
            panel_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_student, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );
        panel_studentLayout.setVerticalGroup(
            panel_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_student, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_student, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(83, 83, 83))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel5.setBackground(new java.awt.Color(86, 182, 236));
        panel5.setRoundBottomLeft(30);
        panel5.setRoundBottomRight(30);
        panel5.setRoundTopLeft(30);
        panel5.setRoundTopRight(30);

        panel_Course.setBackground(new java.awt.Color(255, 255, 255));
        panel_Course.setRoundBottomLeft(25);
        panel_Course.setRoundBottomRight(25);

        label_Course.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_Course.setForeground(new java.awt.Color(0, 204, 255));
        label_Course.setText("                     COURSE");
        label_Course.setToolTipText("");
        label_Course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_CourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_CourseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_CourseLayout = new javax.swing.GroupLayout(panel_Course);
        panel_Course.setLayout(panel_CourseLayout);
        panel_CourseLayout.setHorizontalGroup(
            panel_CourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_Course, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );
        panel_CourseLayout.setVerticalGroup(
            panel_CourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_Course, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Course, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(83, 83, 83))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_Course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel7.setBackground(new java.awt.Color(86, 182, 236));
        panel7.setRoundBottomLeft(30);
        panel7.setRoundBottomRight(30);
        panel7.setRoundTopLeft(30);
        panel7.setRoundTopRight(30);

        panel_StudentGrade.setBackground(new java.awt.Color(255, 255, 255));
        panel_StudentGrade.setRoundBottomLeft(25);
        panel_StudentGrade.setRoundBottomRight(25);

        label_StudentGrade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_StudentGrade.setForeground(new java.awt.Color(0, 204, 255));
        label_StudentGrade.setText("             STUDENT GRADE");
        label_StudentGrade.setToolTipText("");
        label_StudentGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_StudentGradeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_StudentGradeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_StudentGradeLayout = new javax.swing.GroupLayout(panel_StudentGrade);
        panel_StudentGrade.setLayout(panel_StudentGradeLayout);
        panel_StudentGradeLayout.setHorizontalGroup(
            panel_StudentGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_StudentGradeLayout.createSequentialGroup()
                .addComponent(label_StudentGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_StudentGradeLayout.setVerticalGroup(
            panel_StudentGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_StudentGrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_StudentGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel7Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_StudentGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel9.setBackground(new java.awt.Color(86, 182, 236));
        panel9.setRoundBottomLeft(30);
        panel9.setRoundBottomRight(30);
        panel9.setRoundTopLeft(30);
        panel9.setRoundTopRight(30);
        panel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel9MouseClicked(evt);
            }
        });

        panel_CourseIns.setBackground(new java.awt.Color(255, 255, 255));
        panel_CourseIns.setRoundBottomLeft(25);
        panel_CourseIns.setRoundBottomRight(25);

        label_CourseIns.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_CourseIns.setForeground(new java.awt.Color(0, 204, 255));
        label_CourseIns.setText("       COURSE INSTRUCTOR");
        label_CourseIns.setToolTipText("");
        label_CourseIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_CourseInsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_CourseInsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_CourseInsLayout = new javax.swing.GroupLayout(panel_CourseIns);
        panel_CourseIns.setLayout(panel_CourseInsLayout);
        panel_CourseInsLayout.setHorizontalGroup(
            panel_CourseInsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_CourseIns, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );
        panel_CourseInsLayout.setVerticalGroup(
            panel_CourseInsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_CourseIns, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel9Layout = new javax.swing.GroupLayout(panel9);
        panel9.setLayout(panel9Layout);
        panel9Layout.setHorizontalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_CourseIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(84, 84, 84))
        );
        panel9Layout.setVerticalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_CourseIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, 217, Short.MAX_VALUE))
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(165, 165, 165))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panel_teacherMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_teacherMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_teacherMouseExited

    private void label_teacherMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_teacherMouseEntered
        SetColor(panel_teacher);
        SetColorText(label_teacher);
    }//GEN-LAST:event_label_teacherMouseEntered

    private void label_teacherMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_teacherMouseExited
        reSetColor(panel_teacher);
        reSetColorText(label_teacher);
    }//GEN-LAST:event_label_teacherMouseExited

    private void label_studentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_studentMouseEntered
        SetColor(panel_student);
        SetColorText(label_student);
    }//GEN-LAST:event_label_studentMouseEntered

    private void label_studentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_studentMouseExited
        reSetColor(panel_student);
        reSetColorText(label_student);
    }//GEN-LAST:event_label_studentMouseExited

    private void label_CourseInsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CourseInsMouseEntered
        SetColor(panel_CourseIns);
        SetColorText(label_CourseIns);
    }//GEN-LAST:event_label_CourseInsMouseEntered

    private void label_CourseInsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CourseInsMouseExited
        reSetColor(panel_CourseIns);
        reSetColorText(label_CourseIns);
    }//GEN-LAST:event_label_CourseInsMouseExited

    private void label_StudentGradeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_StudentGradeMouseEntered
        SetColor(panel_StudentGrade);
        SetColorText(label_StudentGrade);
    }//GEN-LAST:event_label_StudentGradeMouseEntered

    private void label_StudentGradeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_StudentGradeMouseExited
        reSetColor(panel_StudentGrade);
        reSetColorText(label_StudentGrade);
    }//GEN-LAST:event_label_StudentGradeMouseExited

    private void label_CourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CourseMouseEntered
        SetColor(panel_Course);
        SetColorText(label_Course);
    }//GEN-LAST:event_label_CourseMouseEntered

    private void label_CourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CourseMouseExited
        reSetColor(panel_Course);
        reSetColorText(label_Course);
    }//GEN-LAST:event_label_CourseMouseExited

    private void panel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel9MouseClicked
        CourseInstructorForm CIUI = new CourseInstructorForm(this, rootPaneCheckingEnabled);
        CIUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_panel9MouseClicked
    public void SetColor(JPanel p1) {
        p1.setBackground(new Color(179, 250, 160));
    }

    public void reSetColor(JPanel p) {
        p.setBackground(new Color(255, 255, 255));
    }

    public void SetColorText(JLabel p) {
        p.setForeground(new Color(255, 255, 255));
    }

    public void reSetColorText(JLabel p1) {
        p1.setForeground(new Color(0, 204, 255));
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuForm().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_Course;
    private javax.swing.JLabel label_CourseIns;
    private javax.swing.JLabel label_StudentGrade;
    private javax.swing.JLabel label_student;
    private javax.swing.JLabel label_teacher;
    private UI.UI_Item.button.MyButton myButton1;
    private UI.UI_Item.button.Panel panel1;
    private UI.UI_Item.button.Panel panel3;
    private UI.UI_Item.button.Panel panel5;
    private UI.UI_Item.button.Panel panel7;
    private UI.UI_Item.button.Panel panel9;
    private UI.UI_Item.button.Panel panel_Course;
    private UI.UI_Item.button.Panel panel_CourseIns;
    private UI.UI_Item.button.Panel panel_StudentGrade;
    private UI.UI_Item.button.Panel panel_student;
    private UI.UI_Item.button.Panel panel_teacher;
    // End of variables declaration//GEN-END:variables
}
