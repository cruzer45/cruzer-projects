<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Home</title>
  </head>
  <body>
    <div class="newactions">
      <span class="newmessage">
        <g:link controller="message" action="create">
          Post Message
        </g:link>
      </span>
      <span>
        <g:link controller="file" action="create">Post File</g:link>
      </span>

    </div>

    <div class="panel">
      <h2>Messages</h2>
      <g:if test="${flash.toUser}">
        <div id="userMessage" class="info">
          <g:message code="posting.new" args="${[flash.toUser]}" encodeAs="HTML"/>
        </div>
      </g:if>
      <g:each in="${messages}" var="message">
        <div class="amessage">
          <div class="messagetitle">
            <g:message code="message.title" args="${[message.title]}" encodeAs="HTML"/>
          </div>
          <div class="messagetitlesupplimentary">
            <g:message code="message.user" args="${[message.user.firstName, message.user.lastName]}"/>
          </div>
          <div class="messagebody">
            <g:message code="message.detail" args="${[message.detail]}" encodeAs="HTML"/>
          </div>
        </div>
      </g:each>
    </div>


    <div class="panel">
      <h2>Files</h2>
      <g:each in="${files}" var="file">
        <div class="afile">
          <div class="filename">
            <a href="${g.createLink(controller: 'file', action:'download', id: file.id)}">
              <g:message code="${file.name}" encodeAs="HTML"/>
            </a> -
            <g:message code="file.size" args="${[file.size]}"/>
            <div class="filenamesupplimentary">
              <g:message code="message.user" args="${[file.user.firstName, file.user.lastName]}"/>
            </div>
          </div>
          <div class="filebody">
            <g:message code="${file.description}" encodeAs="HTML"/>
          </div>
        </div>
      </g:each>
    </div>
  </body>
</html>
