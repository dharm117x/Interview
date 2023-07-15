<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="idKey" required="true" type="java.lang.String" %>
<%@ attribute name="labelKey" required="false" type="java.lang.String" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
  <form action="home">
    <div class="row">
      <div class="col-25">
        <label for="${idKey}">${name}</label>
      </div>
      <div class="col-75">
        <input type="text" id="${idKey}" name="${name}" placeholder="Your name..">
      </div>
    </div>
</form>
</div>    
