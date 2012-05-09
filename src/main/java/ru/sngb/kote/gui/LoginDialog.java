/*
 * Created by JFormDesigner on Thu May 10 02:02:25 MSK 2012
 */

package ru.sngb.kote.gui;

import ru.sngb.kote.service.Impl.UserServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Tsykin
 */
public class LoginDialog extends JFrame {
    UserServiceImpl userService = null;

    public LoginDialog() {
        initComponents();
        userService = new UserServiceImpl();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        String login = txtLogin.getText();
        String password = txtPassword.getText();
        lblStatus.setText(String.valueOf(userService.autorization(login, password)));
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        lblLogin = new JLabel();
        lblPassword = new JLabel();
        txtLogin = new JTextField();
        txtPassword = new JPasswordField();
        lblStatus = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u041a\u041e\u0422\u042d:\u0410\u0432\u0442\u043e\u0440\u0438\u0437\u0430\u0446\u0438\u044f");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- lblLogin ----
                lblLogin.setText("\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c:");

                //---- lblPassword ----
                lblPassword.setText("\u041f\u0430\u0440\u043e\u043b\u044c:");

                //---- lblStatus ----
                lblStatus.setText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0438\u043c\u044f \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f \u0438 \u043f\u0430\u0440\u043e\u043b\u044c.");
                lblStatus.setForeground(Color.red);

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addComponent(lblLogin)
                                                                .addComponent(lblPassword))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addComponent(txtLogin, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                                                .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addComponent(lblStatus)
                                                        .addGap(0, 158, Short.MAX_VALUE)))
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(lblLogin)
                                                .addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblPassword)
                                                .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblStatus)
                                        .addContainerGap(1, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        okButtonActionPerformed(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cancelButtonActionPerformed(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel lblLogin;
    private JLabel lblPassword;
    private JTextField txtLogin;
    private JPasswordField txtPassword;
    private JLabel lblStatus;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
