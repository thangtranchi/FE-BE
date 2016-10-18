<html>
    <head>
        <title>Employee Management</title>
        <meta name="heading" content="Employee Management">        
    </head>
    <body>      
      <div id="tab-pane-container">
        <section class="tab-pane fade in active bs-example" id="employee-section">
          <%@include file="employee.jsp" %>
        </section>
        <section class="tab-pane fade in active bs-example hide" id="courier-history-section">
          <%@include file="site.jsp" %>
        </section>
        <section class="tab-pane fade in active bs-example hide" id="courier-history-section">
          <%@include file="department.jsp" %>
        </section>
      </div>
    </body>
</html>