//package com.example.fastclientdemo.RSA;
//
//import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionSupport;
//
//
//public class UserAction extends ActionSupport{
//
//    private static final long serialVersionUID = 3859457733764601693L;
//
//    private String password;
//    private Object json;
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Object getJson() {
//        return json;
//    }
//
//    public void setJson(Object json) {
//        this.json = json;
//    }
//
//    /**
//     * 获取系数和指数
//     * @return
//     * @throws Exception
//     */
//    public String keyPair() throws Exception{
//        PublicKeyMap publicKeyMap = RSAUtils.getPublicKeyMap();
//        System.out.println(publicKeyMap);
//        setJson(publicKeyMap);
//        return SUCCESS;
//    }
//
//    /**
//     * 登录
//     * @return
//     * @throws Exception
//     */
//    public String login() throws Exception{
//        String pwd  = RSAUtils.decryptStringByJs(getPassword());
//        System.out.println(pwd);
//        ActionContext.getContext().put("pwd", pwd);
//        return SUCCESS;
//    }
//}
