<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<html>
    <head>
        <title>My Site - <decorator:title default="Welcome!" /></title>
        <decorator:head/>
    </head>
    <body>
      <decorator:body/>
    </body>
</html>