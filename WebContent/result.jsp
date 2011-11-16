<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The result of the calculation</title>
</head>
<body>
<table  border="0">
<caption>The result of the Exchange :</caption>
<tr>
<td><b><%=request.getAttribute("amount")%>  <%=request.getAttribute("from_currency")%> </b></td>
<td><b>  =  </b></td>
<td><b> <%=request.getAttribute("convertedAmount")%>  <%=request.getAttribute("to_currency")%> </b></td>
</tr>
<tr>
<td colspan="3" align="center"><INPUT type="button" value="New Conversion" onclick="history.back()"></td>
</tr>
</table>
</body>
</html>