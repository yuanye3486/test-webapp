<%--
  Created by IntelliJ IDEA.
  User: LiuFengqi
  Date: 2015/3/25
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% 	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
  <head>
  	<script type="text/javascript" src="js/jquery/jquery-2.1.3.min.js"></script>
    <title>参数传递测试</title>
    <script type="text/javascript">
    	function ajaxCommit(){
    		$.ajax({
    			  url: "parametertest/StrutsParameter/testStringPara.action",
    			  data: {
    				  stringPara:$("#stringPara").val()
    			  },
    			  success: function( data ) {
    			    $("#json_container").html("<strong>" + data + "</strong>");
    			  }
    			});
    	}
    	
    	function getAjaxJsonResult(){
    		$.ajax({
  			  url: "parametertest/StrutsParameter/testJsonReturn.action",
  			  success: function( data ) {
  			    $("#json_container").html("<strong>" + data + "</strong>");
  			  }
  			});
    	}
    </script>
  </head>
  <body>
  	<h3>测试Spring MVC 参数传递</h3>
    <form action="springmvcPara/arrayPara.do">
        	参数为数组：<input name="arrayPara" />
        	<br/>
            <input type="submit" value="提交">
    </form>
	<hr/>

	<h3>测试Strust2 String 参数传递</h3>
	<div id="json_container"></div>
    <form action="parametertest/StrutsParameter/testStringPara.action">
        	参数为字符串：<input id="stringPara" name="stringPara" />
        	<br/>
            <input type="submit" value="提交"/><br/>
            <input type="button" onclick="ajaxCommit()" value="异步提交"/>
            <input type="button" onclick="getAjaxJsonResult()" value="异步获取字符串列表"/>
    </form>

  </body>
</html>
