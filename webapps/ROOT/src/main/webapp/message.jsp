<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header-include.jsp">
  <jsp:param name="title" value="john burbridge - send me a message"/>
  <jsp:param name="description" value="Send a message to John using this visitor form"/>
  <jsp:param name="keywords" value="John Burbridge, BBQ, geek, engineer, software, java, development, electronic music, psytrance, cosmology, skepticism, science, psychology, love"/>
</jsp:include>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center">
<h1>john burbridge</h1>
<p>&nbsp;</p>
<table class="menutable">
  <tr>
    <td class="menucells"><a href="http://www.linkedin.com/in/johnburbridge">professional</a></td>
    <td class="menucells"><a href="http://www.facebook.com/johnmburbridge">personal</a></td>
    <td class="menucells"><a href="./">contact</a></td>
  </tr>
</table>
<p>&nbsp;</p>
<form>
<table>
  <tr>
    <td class="formfields">Your name:</td><td><input type=text name="visitorName" maxlength="40" /></td>
  </tr>
  <tr>
    <td class="formfields">Your email:</td><td><input type=text name="visitorEmail" maxlength="40"/></td>
  </tr>
  <tr>
    <td class="formfields">Your message:</td><td><textarea name="visitorMessage" rows="10"></textarea></td>
  </tr>
  <tr>
    <td class="formfields"></td><td><input type=submit value="Send"/></td>
  </tr>
</table>
</form>
</div>
</body>
</html>