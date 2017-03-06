



<!DOCTYPE html>
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
    <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <style>
        #sortable { list-style-type: none; margin: 0;
            padding: 0; width: 40%; }
        .sortable.ui-sortable-dragging { background: red; }
        .default {

            border: 1px solid #DDDDDD;
            color: #333333;
        }
        .formInput    { FONT-FAMILY: Arial, Helvetica, sans-serif; font-size: 9pt; color: #000000; TEXT-ALIGN: left; padding: 5px 0;}
        .pull-right {
            float: right;
        }
        .pull-left {
            float: left;
        }
        .paddingleft {
            padding-left: 4cm;
        }

        .paddingright {
            padding-right: 4cm;
        }

        #cols li {
            margin: 0 3px 3px 3px;
            padding: 0.4em;
            padding-left: 1.5em;
            font-size: 1.2em;
            height: 18px;
            display: -webkit-box;
        }
        #colss li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.2em; height: 18px; display: -webkit-box; }
    </style>
</head>

<body>




<h1 style=" background-color: darkorange;"><center>Edit Contact Details  </center> </h1>
<form:form id="target" action="/update_customer" method="post">
    <div id="Container"  >
        <div id="rows" class="pull-left">
            <div id="cols" class="paddingleft">
                <table>
                    <tr>
                        <li class="default"> <label>First Name:</label>
                            <form:input path="firstName" />
                        </li>
                    </tr>
                    <tr>
                        <li class="default">  <label>Last Name:</label>
                            <form:input path="lastName" /></li>
                    </tr>
                    <tr>
                        <li class="default"><label> MiddleName:</label>
                            <form:input path="middleName" />
                        </li>
                    </tr>

                </table>

            </div>
            <div id="cols2"></div>
        </div>



        <%--<div id="Containerr" class="pull-right">--%>
        <div id="rowss" class="pull-right">
            <div id="colss" class="paddingright">
                <table>
                    <tr>
                        <li class="default"><label>Customer Id:</label>
                            <form:input path="customerId" /></li>
                    </tr>
                    <tr>
                        <li class="default"><label>Customer Number:</label>
                            <form:input path="customerNumber"/></li>
                    </tr>

                    <tr>
                        <li class="default"> <label>Job Title:</label>
                            <form:input path="jobTitle"/>
                        </li>
                    </tr>

                </table>

            </div>
            <div id="colss2"></div>



            <input id="submitId" type="submit" value="Submit Form">
        </div>


    </div>
</form:form>
<script>
    $(function() {



        $( "#cols,#colss" ).sortable({
            placeholder : "highlight"

        });
    });
</script>
</body>
</html>
