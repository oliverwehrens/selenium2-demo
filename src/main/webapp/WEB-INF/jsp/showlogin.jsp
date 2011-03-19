<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
Welcome

<form:form action="dologin.html" method="post" commandName="login">

  <p>
    <form:label for="username" path="username" cssErrorClass="error">Login</form:label><br/>
    <form:input id="username" path="username"/> <form:errors path="username"/>
  </p>

  <p>
    <form:label for="password" path="password" cssErrorClass="error">Password</form:label><br/>
    <form:password id="password" path="password"/> <form:errors path="password"/>
  </p>

  <input id="logmein" type="submit"/>

</form:form>