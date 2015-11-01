package com.fengqiliu.test.webapp.action;

import java.util.ArrayList;
import java.util.List;

public class StrutsParameterAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private String stringPara;
    private String stringPara2;
    private List<String> stringList;

    public String testStringPara() {
        System.out.println("stringPara = " + stringPara);
        stringPara2 = "stringPara2";

        return SUCCESS;
    }

    public String testJsonReturn() {
        stringList = new ArrayList<String>();
        stringList.add("String1");
        stringList.add("String2");
        stringList.add("String3");
        return SUCCESS;
    }


    public String getStringPara() {
        return stringPara;
    }

    public void setStringPara(String stringPara) {
        this.stringPara = stringPara;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public String getStringPara2() {
        return stringPara2;
    }

    public void setStringPara2(String stringPara2) {
        this.stringPara2 = stringPara2;
    }
}
