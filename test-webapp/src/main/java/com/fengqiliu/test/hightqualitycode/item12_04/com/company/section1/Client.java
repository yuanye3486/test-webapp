package com.fengqiliu.test.hightqualitycode.item12_04.com.company.section1;

//通讯协议
interface Connection {
    // 拨通电话
    public void dial(String phoneNumber);

    // 通话完毕，挂电话
    public void hangup();

}

//数据传输
interface Transfer {
    // 通话
    public void chat(Object o);
}

public class Client {

}

//class Phone implements Connection,Transfer{
//	
//}