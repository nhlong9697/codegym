<%--
  Created by IntelliJ IDEA.
  User: longnguyen
  Date: 6/18/20
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.util.Map"%>
<%@ page import ="java.util.HashMap"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
<%--declaretion tag can declare function as well as variable--%>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%--scriptlet tag can only decleare variable not method--%>
<%
    dic.put("hello","Xin chao");
    dic.put("how", "The nao");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");

    String wordToTranslate = request.getParameter("word");

    String translatedWord = dic.get(wordToTranslate);

    if (translatedWord != null) {
      out.println("Word: " + wordToTranslate);
      out.println("Result: " + translatedWord);
    } else {
      out.println("Word is not found");
    }
%>
</body>
</html>
