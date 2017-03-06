
<%--
  Created by IntelliJ IDEA.
  User: shiva9
  Date: 2/7/2017
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
    <title>List_Customers</title>
    <jsp:include page="/WEB-INF/pages/header.jsp"/>
   <style>
       .btnE{

           background-image: url('/resources/images/edit.gif');
           background-repeat: no-repeat;
       }
       .btnD{

           background-image: url('/resources/images/delete.gif');
           background-repeat: no-repeat;
       }
   </style>
<body>

<table id="example" class="display" cellspacing="0" width="100%" style="overflow-x:auto">

<thead>
    <tr>
        <td><a href="/displayForm">Create_Customer</a> </td>
    </tr>
    <tr>
        <th style=" background-color: darkorange;">CustomerId</th>
        <th style=" background-color: darkorange;">FirstName</th>
        <th style=" background-color: darkorange;">LastName</th>
        <th style=" background-color: darkorange;">LastName</th>
        <th style=" background-color: darkorange;">Edit/Delete</th>

    </tr>

    </thead>

</table>
<script type="text/javascript">
    $(document).ready(function(){

       /* $("#load").on("click", function () {
            loader();
        });*/


        var data = ${lstCustomers};
        console.log("data="+data);

        /*for ( var i=0 ; i<data.length ; i++ ) {
            data.push( [  { "mData":"_customerId"},
                        { "mData": "_firstName"},
                        { "mData": "_lastName"},
                        {
                            "mData": "_customerId",
                            className: "center",
                            "render": function(mData, type, full, meta) {
                                return '<a href="edit_customers/' + mData + '">Edit</a>/<a href="update_customer/' + mData + '">Delete</a>';
                            }
                        }
                    ] );
        }*/
        var table = $('#example').DataTable( {

            "aaData": data,
            "aoColumns": [
                { "mData":"customerId"},
                { "mData": "firstName"},
                { "mData": "lastName"},
                { "mData": "lastName"},

                {
                    "mData": "customerId",
                    /*className: "btnE btnD",*/

                    //defaultContent: '<a href="edit_customers/{_customerId"}" class="editor_edit">Edit</a> / <a href="" class="editor_remove">Delete</a>'
                    //defaultContent: '<a href="edit_customers/{_customerId"}" class="editor_edit">Edit</a> / <a href="" class="editor_remove">Delete</a>'
                    //defaultContent: '<a href="edit_customers/'+"{data._customerId}"+'">Edit</a>'
                    "render": function(mData, type, full, meta) {
                        return '<a href="edit_customers/' + mData + '" class="editor_edit"><img src="resources/images/edit.gif"></a> <a  href="delete_customer/' + mData + '"class="editor_delete"><img src="resources/images/delete.gif"></a>';
                        //return '<img src="resources/images/edit.gif"> <img src="resources/images/delete.gif">';
                    }
                }


            ],

            "paging":true,
            "pageLength":10,
            "ordering":true,
            "order":[0,"asc"]
        });

        /*$('#example').DataTable( {
            data:           data,
            deferRender:    true,
            scrollY:        200,
            scrollCollapse: true,
            scroller:       true
        } );*/
    });

    /*$('#example').on( 'click', '.editor_edit', function () {
        var id = table.row( this ).id();

        alert( 'Clicked row id '+id );
    } );*/

   $("#example").on('click', '.editor_delete', function() {


       var delCustomer = confirm("do u Want to delete[Y/N]?");
       var table = $('#example').DataTable();

       if(delCustomer)
       {
           /*alert("delete functionality");*/
         //  window.location.href = $(this).attr('href');

           /*$(this).attr('href').submit();*/
           /*var target_row = $(this).closest("tr").get(0);*/


               console.log("delete function");

           $.ajax({
                url:$(this).attr('href'),
                data:'json',
                method:"POST",
                success:function (data) {
                    console.log("ajax call");
                    $("#deleteCustomerMsg").html("<p style=\"text-align: center;color: red;font-size: medium;background-color: beige;\">Record Deleted Successfully.</p>").fadeToggle(3000);

                }
           });
           //$(this).closest('tr').remove();
           //$(this).closest('tr').slideToggle("slow");
           $(this).closest('tr').fadeToggle(3000);
       }
       return false;

    });


   /* $('#example').on('click', 'a.editor_edit', function (e) {
        e.preventDefault();

        editor.edit( $(this).closest('tr'), {
            title: 'Edit record',
            buttons: 'Update'
        } );
    } );*/
</script>
<div id="deleteCustomerMsg"></div>
</body>
</html>
