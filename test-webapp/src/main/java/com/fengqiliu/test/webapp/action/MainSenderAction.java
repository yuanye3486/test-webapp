package com.fengqiliu.test.webapp.action;

public class MainSenderAction extends BaseAction {
    private static final long serialVersionUID = 2136250826273535074L;

    private String tos;
    private String content;
    private String subject;

    public void sender() {
        System.out.println("##########################");
        System.out.println("tos = " + tos);
        System.out.println("content = " + content);
        System.out.println("subject = " + subject);
    }


    public String getTos() {
        return tos;
    }

    public void setTos(String tos) {
        this.tos = tos;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
