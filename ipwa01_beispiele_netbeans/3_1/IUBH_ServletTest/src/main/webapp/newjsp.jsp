<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
      <h1>Hello <% 
	  String name = request.getParameter("name");
	  if(name != null && name.length() > 0)
	    out.print(name);
	  else
	    out.print("World");
	%> from JSP!</h1>
    </body>
</html>
