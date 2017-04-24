



<!DOCTYPE html>
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
    <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
    <style>
        #sortable { list-style-type: none; margin: 0;
            padding: 0; width: 40%; }
        .sortable.ui-sortable-dragging { background: red; }
        .default {

            /*border: 1px solid #DDDDDD;*/
            color: #7a7a7a;
            FONT-FAMILY: Arial, Helvetica, sans-serif;
            font-size: 9pt;
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
            /*font-size: 1.2em;*/
            height: 18px;
            display: -webkit-box;
        }
        #colss li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; /*font-size: 1.2em;*/ height: 18px; display: -webkit-box; }

        .bu {
            border: none;
            font-family: inherit;
            font-size: inherit;
            color: inherit;
            background: none;
            cursor: pointer;
            padding: 11px 1px;
            display: inline-block;
            margin: -29px -3px;
            text-transform: uppercase;
            letter-spacing: 1px;
            font-weight: 700;
            outline: none;
            position: relative;
            -webkit-transition: all 0.3s;
            -moz-transition: all 0.3s;
            transition: all 0.3s;
        }

        .bu:after {
            content: '';
            position: absolute;
            z-index: -1;
            -webkit-transition: all 0.3s;
            -moz-transition: all 0.3s;
            transition: all 0.3s;
        }

        .bu:before,
        .icon-heart:after,
        .icon-star:after,
        .icon-plus:after,
        .icon-file:before {
            font-family: 'icomoon';
            speak: none;
            font-style: normal;
            font-weight: normal;
            font-variant: normal;
            text-transform: none;
            line-height: 1;
            position: relative;
            -webkit-font-smoothing: antialiased;
        }

        .bu-5 {
            background: #f5f5f5;
            color: black;
            height: 5px;
            min-width: 81px;
            line-height: 6px;
            font-size: 9px;
            font-family: sans-serif;
            font-size: 11px;
            font-weight: bold;
            overflow: hidden;
            -webkit-backface-visibility: hidden;
            -moz-backface-visibility: hidden;
            backface-visibility: hidden;
            transform: translate(1376%, -79%);

        }

        .bu-5:active {
            background: #9053a9;
            top: 2px;
        }

        .bu-5 span {
            display: inline-block;
            width: 100%;
            height: 100%;
            left: 50%;
            top: 50%;
            -webkit-transition: all 0.3s;
            -webkit-backface-visibility: hidden;
            -moz-transition: all 0.3s;
            -moz-backface-visibility: hidden;
            transition: all 0.3s;
            backface-visibility: hidden;
            transform: translate(25%, 25%);
            line-height: 104%;
           /* content: 'Delete';
            position: absolute;
            left: 50%;
            top: 50%;
            transition: all 0.3s;
           */
        }

        .bu-5:before {
            position: absolute;
            height: 100%;
            width: 100%;
            line-height: 1.5;
            font-size: 180%;
            -webkit-transition: all 0.3s;
            -moz-transition: all 0.3s;
            transition: all 0.3s;



        }

        .bu-5:active:before {
            color: #703b87;
        }




        .bu-5a:hover span {
            -webkit-transform: translateY(300%);
            -moz-transform: translateY(300%);
            -ms-transform: translateY(300%);
            transform: translateY(300%);
        }

        .bu-5a:before {
            left: 10%;
            top: -100%;
        }

        .bu-5a:hover:before {
            top: 10%;
        }
        .icon-remove:before {
            font-family: 'Ionicons';
            content: '\f4c5';
            top: 190%;
            transform: translate(30%, -17%);
        }
        .icon-back:before {
            font-family: 'Ionicons';
            content: '\f106';
            top: 190%;
            transform: translate(30%, -17%);
        }
        /*.btn-ppol {
            background-color: #f5f5f5;
            background-image: -moz-linear-gradient(center top , #f5f5f5, #f1f1f1) repeat scroll 0 0;
            border: 1px solid rgba(0,0,0,0.1);
            border-radius: 2px;
            color: #444;
            cursor: pointer;
            display: inline-block;
            font-family: Arial;
            font-weight: bold;
            font-size: 11px;
            height: 24px;
            line-height: 24px;
            outline: none;
            padding: 0 8px;
            text-align: center;
            text-decoration: none;
            transition: all 200ms ease;
        }*/
        .btn-ppol.orange {
            background-color: #f5f5f5;
            border: 1px solid #f5f5f5;
            color: black;
        }

        .button12 {
            width: 81px;
            height: 25px;
            background-color: #fb8404;
            position: absolute;
            left: 16%;
            top: 54%;
            transform: translate(34%, -1308%);
            border-radius: 3px;
            overflow: hidden;
            cursor: pointer;
            color: black;
            font-family: Arial;
            font-size: 11px;
            font-weight: bold;

        }
        .button12:after, .button12:before {
            content: 'Delete';
            position: absolute;
            left: 50%;
            top: 50%;
            transition: all 0.3s;
            transform: translate(-50%, -50%);
        }
        .button12:hover:after {
            top: -50%;
        }
        .button12:before {
            font-family: 'Ionicons';
            content: '\f4c5';
            font-size: 20px;
            top: 190%;
        }
        .button12:hover:before {
            top: 50%;
        }
    </style>
    <script>
        function deleteFun() {
            var result = confirm("Do You Want to Delete?");
            var editID ='http://localhost:8080/delete_customer/${id}';

            $.ajax({
                url:editID,
                data:'json',
                method:"GET",
                success:function (data) {
                    console.log("success");
                    window.location.href ="http://localhost:8080/list_customers";
                    },
                error:function (data) {
                    console.log("failed");
                }
            });

            }


        /*$(document).click(function(){
       /!* $("#example").on('click', '.editor_delete', function() {*!/


            var delCustomer = confirm("do u Want to delete[Y/N]?");
            var table = $('#example').DataTable();



            if(delCustomer)
            {
                /!*alert("delete functionality");*!/
                //  window.location.href = $(this).attr('href');

                /!*$(this).attr('href').submit();*!/
                /!*var target_row = $(this).closest("tr").get(0);*!/


                console.log("delete function");



                $.ajax({
                    url:$(this).attr('href'),
                    data:'json',
                    method:"GET",
                    success:function (data) {
                        console.log("ajax call"+$(this).attr('href'));
                        $("#deleteCustomerMsg").html("<p style=\"text-align: center;color: red;font-size: medium;background-color: beige;\">Record Deleted Successfully.</p>").fadeToggle(3000);

                    }
                });
                //$(this).closest('tr').remove();
                //$(this).closest('tr').slideToggle("slow");
                $(this).closest('tr').fadeToggle(3000);
            }
            return false;

        });*/
    </script>
</head>

<body>


<hr>
<a align="left" class="bu bu-5 bu-5a icon-back"  href="http://localhost:8080/list_customers"><span>Back</span></a>&nbsp;
<a class="bu bu-5 bu-5a icon-remove"  onclick="deleteFun();"><span>Delete</span></a><hr>
<h2 style=" background-color: #f5f5f5;border: 1px solid rgba(0,0,0,0.1);font-family: sans-serif;font-weight: normal;"><center>Edit Contact Details  </center> </h2>
<form:form id="target" action="/update_customer" method="post">
    <div id="Container"  >
        <div id="rows" class="pull-left">
            <div id="cols" class="paddingleft">
                <table>
                    <tr>
                        <li class="default"> <label>First Name:</label>
                           &nbsp; <form:input path="firstName" />
                        </li>
                    </tr>
                    <tr>
                        <li class="default">  <label>Last Name:</label>
                            &nbsp; <form:input path="lastName" /></li>
                    </tr>
                    <tr>
                        <li class="default"><label> MiddleName:</label>
                            &nbsp;  <form:input path="middleName" />
                        </li>
                    </tr>
                    <%--<tr>
                        <li class="default"><label> Contact Number:</label>
                            &nbsp;  <form:input path="middleName" />
                        </li>
                    </tr>
                    <tr>
                        <li class="default"><label> Email:</label>
                            &nbsp;  <form:input path="middleName" />
                        </li>
                    </tr>
                    <tr>
                        <li class="default"><label> Birthday:</label>
                            &nbsp;  <form:input path="middleName" />
                        </li>
                    </tr>
                    <tr>
                        <li class="default"><label> Url:</label>
                            &nbsp;  <form:input path="middleName" />
                        </li>
                    </tr>--%>

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
                            &nbsp; <form:input path="customerId" /></li>
                    </tr>
                    <tr>
                        <li class="default"><label>Customer Number:</label>
                            &nbsp; <form:input path="customerNumber"/></li>
                    </tr>

                    <tr>
                        <li class="default"> <label>Job Title:</label>
                            &nbsp; <form:input path="displayName"/>
                        </li>
                    </tr>
                    <%--<tr>
                        <li class="default"> <label>Url:</label>
                            &nbsp; <form:input path="displayName"/>
                        </li>
                    </tr>
                    <tr>
                        <li class="default"> <label>Phone Number</label>
                            &nbsp; <form:input path="displayName"/>
                        </li>
                    </tr>
                    <tr>
                        <li class="default"> <label>Department</label>
                            &nbsp; <form:input path="displayName"/>
                        </li>
                    </tr>
                    <tr>
                        <li class="default"> <label>Sex</label>
                            &nbsp; <form:input path="displayName"/>
                        </li>
                    </tr>--%>
                </table>

            </div>
            <div id="colss2"></div>


            <%--<a class="bu bu-5 bu-5a icon-remove" >Update 2</a>--%>
            <input class="btn-ppol orange " id="submitId" type="submit" value="Update">
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
