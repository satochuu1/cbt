/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.login.bb;

import java.util.Arrays;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import jp.co.cody.cbt.util.qualifier.LogQualifier;

/**
 *
 * @author satochuu
 */
@Named
@RequestScoped
public class LoginBb {

    private String userCd;
    private String password;
    
    @Inject @LogQualifier(value=0)//@LogQualifier(value=1)
    transient Logger log;

    /**
     * Creates a new instance of LoginBb
     */
    public LoginBb() {
        
        
    }
    public String login(){
        HttpServletRequest request = getRequest();
        try {
            log.info("■" + userCd + " / " + password);
            request.login(userCd, password);
        } catch (ServletException ex) {
            facesErrorMsg("ログインできません");
            facesErrorMsg(ex.getMessage());
            facesErrorMsg(Arrays.toString(ex.getStackTrace()));
            return null;
        }
        return "/cbt/top.xhtml?faces-redirect=true";
    }
    
    public String logout() {
        try {
            getServlet().invalidateSession();
            HttpServletRequest request = getRequest();
            request.logout();
        } catch (ServletException ex) {
        }
        return "/login.xhtml?faces-redirect=true ";
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCd() {
        return userCd;
    }

    public void setUserCd(String userCd) {
        this.userCd = userCd;
    }
    

    /* *****（サーブレット環境を取得する）**************/
    
    public ExternalContext getServlet() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }
    /* *****（リクエストオブジェクトを取得する）**************/
    
    public HttpServletRequest getRequest() {
        return (HttpServletRequest) getServlet().getRequest();
    }
    /* *****（エラーメッセージを作成しキューに入れる）**************/
    
    public void facesErrorMsg(String s) {
        FacesMessage msg = new FacesMessage(s);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
