package com.fengqiliu.test.jackson;

import java.io.Serializable;
import java.util.List;

/**
 * 前端API操作返回结果类
 *
 * @athor liufengqi
 * @date 2016/3/23
 * @since 2.0
 */
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 登录信息.该属性是为了兼容前端angular-shiro插件,而增加的. 建议仅在返回登录信息时使用.
     */
    private T info;
    private T data;
    private PageResultSet<T> pagingData;
    private List<T> datas;
    private boolean success;
    private int errorCode;
    private String errorMsg;
    private String resolvedMsg;

    public ResponseResult() {
    }

    /**
     * 构造操作响应结果
     *
     * @param success     操作结果
     * @param errorCode   错误码
     * @param errorMsg    错误信息
     * @param resolvedMsg 解决方法
     */
    public ResponseResult(boolean success, int errorCode, String errorMsg, String resolvedMsg) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.resolvedMsg = resolvedMsg;
    }

    /**
     * 构造单条数据查询响应结果
     *
     * @param data        单条数据
     * @param success     操作结果
     * @param errorCode   错误码
     * @param errorMsg    错误信息
     * @param resolvedMsg 解决方法
     */
    public ResponseResult(T data, boolean success, int errorCode, String errorMsg, String resolvedMsg) {
        this.data = data;
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.resolvedMsg = resolvedMsg;
    }

    /**
     * 构造分页数据查询响应结果
     *
     * @param pagingData  单页数据
     * @param success     操作结果
     * @param errorCode   错误码
     * @param errorMsg    错误信息
     * @param resolvedMsg 解决方法
     */
    public ResponseResult(PageResultSet<T> pagingData, boolean success, int errorCode, String errorMsg, String resolvedMsg) {
        this.pagingData = pagingData;
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.resolvedMsg = resolvedMsg;
    }

    /**
     * 构造不分页数据查询响应结果
     *
     * @param datas       所有数据
     * @param success     操作结果
     * @param errorCode   错误码
     * @param errorMsg    错误信息
     * @param resolvedMsg 解决方法
     */
    public ResponseResult(List<T> datas, boolean success, int errorCode, String errorMsg, String resolvedMsg) {
        this.datas = datas;
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.resolvedMsg = resolvedMsg;
    }

    /**
     * 获取查询单条数据时的返回结果.
     *
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * 设置查询单条数据时的返回结果.
     *
     * @param data 查询单条数据时的返回结果
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 获取查询分页数据时的返回结果.
     *
     * @return
     */
    public PageResultSet<T> getPagingData() {
        return pagingData;
    }

    /**
     * 设置查询分页数据时的返回结果.
     *
     * @param pagingData 分页查询返回的单页数据
     */
    public void setPagingData(PageResultSet<T> pagingData) {
        this.pagingData = pagingData;
    }

    /**
     * 获取不使用分页查询数据时的返回结果.
     *
     * @return
     */
    public List<T> getDatas() {
        return datas;
    }

    /**
     * 设置不使用分页查询数据时的返回结果.
     *
     * @param datas 不使用分页查询数据时的返回结果.
     */
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    /**
     * 获取操作结果
     *
     * @return true : 操作成功; false : 操作失败
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * 设置操作结果
     *
     * @param success 操作结果
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 获取错误码
     *
     * @return
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误码
     *
     * @param errorCode 错误码
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 获取错误信息
     *
     * @return
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设置错误信息
     *
     * @param errorMsg 错误信息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 获取错误解决方法信息
     *
     * @return
     */
    public String getResolvedMsg() {
        return resolvedMsg;
    }

    /**
     * 设置错误解决方法信息
     *
     * @param resolvedMsg 错误解决方法信息
     */
    public void setResolvedMsg(String resolvedMsg) {
        this.resolvedMsg = resolvedMsg;
    }

    /**
     * 获取登录信息. 建议仅在返回登录信息时使用.
     *
     * @return
     */
    public T getInfo() {
        return info;
    }

    /**
     * 设置登录信息. 建议仅在设置登录信息时使用.
     *
     * @param info
     */
    public void setInfo(T info) {
        this.info = info;
    }
}
