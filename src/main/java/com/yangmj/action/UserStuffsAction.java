package com.yangmj.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yangmj.bean.UserBean;
import com.yangmj.service.impl.UserServiceImpl;
import java.util.List;
import java.util.Map;


//public class UserStuffsAction extends ActionSupport implements ModelDriven<UserBean> {
public class UserStuffsAction extends ActionSupport {
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    private UserBean userBean;
    private UserBean userBeanChanged;
    private List<UserBean> userBeanList;
    private String error_message;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserBean getUserBeanChanged() {
        return userBeanChanged;
    }

    public void setUserBeanChanged(UserBean userBeanChanged) {
        this.userBeanChanged = userBeanChanged;
    }

    public List<UserBean> getUserBeanList() {
        return userBeanList;
    }

    public void setUserBeanList(List<UserBean> userBeanList) {
        this.userBeanList = userBeanList;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    //    private UserBean userBean;

//    @Override
//    public UserBean getModel() {
//        return userBean;
//    }



    public String login() {
        boolean checkResult = checkIfLoginSuccess(userBean.getUserName(),userBean.getUserPwd());
        if (checkResult) {
            ActionContext.getContext().getSession().put("current_user", userBean.getUserName());
            return "success";
        } else {
            error_message = "Bad name or password!";
            return "error";
        }
    }

    public String logout(){
        System.out.println("you are now off line!");
        ActionContext.getContext().getSession().remove("current_user");
        return "success";
    }

    public String register(){
        boolean isUserAlreadyExist = findUsernameIsExist(userBean.getUserName());
        if (isUserAlreadyExist){
            error_message = "This name has been used!";
            return "error";
        }
        else {
            if (doSaveUser(userBean.getUserName(),userBean.getUserPwd()))
                return "success";
            else {
                error_message = "May try it later";
                return "error";
            }
        }
    }

    public String update(){
        if(updateUserInformation(userBeanChanged.getUserName(),userBeanChanged.getUserPwd(),
                ActionContext.getContext().getSession().get("current_user").toString())){
            return "success";
        }
        else {
            error_message = "Something wrong with your input!";
            return "error";
        }
    }

    public String showAllUsers(){
        userBeanList = userService.getAllUsers();
        return "success";
    }

    public String getUserBeanByUsername(){
        userBean = userService.getUserBeanByUsername(
                ActionContext.getContext().getSession().get("current_user").toString());
        return "success";
    }

    public boolean checkIfLoginSuccess(String name,String pwd){
        boolean checkResult = userService.checkUserInputValue(name,pwd);
        return checkResult;
    }

    public boolean updateUserInformation(String name,String pwd,String old_name){
        boolean isUpdated = userService.updateUserInfo(name,pwd,old_name);

        return isUpdated;
    }

    private boolean findUsernameIsExist(String name){
        boolean isUserExist = userService.findUserByUsername(name);
        return isUserExist;
    }

    private boolean doSaveUser(String name,String pwd){
        boolean isSaved = userService.saveUser(name,pwd);
        return isSaved;
    }


    private UserBean getUserBeanByUsername(String username){
        return new UserBean();
    }


    public String testSave(){
        String name = "111";
        String pwd = "123";
        String old_name = "123";
//        userService.saveUser(name,pwd);
//        userService.updateUserInfo(name,pwd,old_name);
//        List<UserBean> userBeanList = new ArrayList<>();
//        userBeanList = userService.getAllUsers();
//        System.out.println(userBeanList);
//        boolean checkResult = userService.checkUserInputValue(name,pwd);
//        System.out.println(checkResult);
//        boolean isUserExist = userService.findUserByUsername(name);
//        System.out.println(isUserExist);
//        boolean saved = userService.saveUser(name,pwd);
//        System.out.println("save status:"+saved);
        ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> request = (Map) actionContext.get("request");
        Map<String,Object> session = (Map) actionContext.get("session");

        System.out.println(request.get("request"));
        System.out.println(session.get("session"));
        request.put("results","results in request");
        System.out.println(request.get("results"));
//        System.out.println(ActionContext.getContext());
        return "success";
    }

}
