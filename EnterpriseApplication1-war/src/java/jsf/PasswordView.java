/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Adam
 */
@Named(value = "passwordView")
@Dependent
public class PasswordView {

    /**
     * Creates a new instance of PasswordView
     */
    private String login; 
    private String password2;

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
    @ManagedProperty(value = "#{userController}")
    private UserController userController;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public void submit(){
        this.getUserController().setuName(login);
        this.getUserController().setuPassword(password2);
        System.out.println(this.getUserController().checkUser());
    }
    public PasswordView() {
    }
    
}
