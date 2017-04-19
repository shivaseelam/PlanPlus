
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

       .btn-ppol.orange {
           background-color: #fb8404;
           border: 1px solid #fb8404;
           color: white;

       }

       .btn-ppol.chubby {
           font-size: 12px;
           height: 36px;
           line-height: 23px;
           padding: 5px 12px;
           text-transform: capitalize;
           font-weight: normal;
           text-decoration: none;
       }
       .createbtn{

          /* padding-left: 925px;
           padding-right: 85px;
           padding-top: 28px;
           padding-bottom: 0px;
           width: 87px;
           height: 0px;*/
           float: right;
           height: 25px;
       }

       #example_wrapper {


           padding-left: 0.047;
           padding-right: 200.047;
           padding-right: 0.047;

       }
       th{
           /*background: #fb8404;*/
           background: #7d7d7d;
       }

       #example table{  overflow-x: auto;
           width: 145%;
       }
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
<div class="createbtn"><a class="btn-ppol orange chubby" title="Create New" href="/displayForm">Create New</a></div>

<table id="example" class="display" cellspacing="0" width="100%" style="overflow-x:auto">

<%--<thead>
    <tr>
        <td><a href="/displayForm">Create_Customer</a> </td>
    </tr>
    <tr id="head">
       &lt;%&ndash; <th style=" background-color: darkorange;">CustomerId</th>
        <th style=" background-color: darkorange;">FirstName</th>
        <th style=" background-color: darkorange;">LastName</th>
        <th style=" background-color: darkorange;">DisplayName</th>
        <th style=" background-color: darkorange;">Edit/Delete</th>
&ndash;%&gt;
    </tr>

    < /thead>--%>
    <tr><thead></thead></tr>
    <tbody></tbody>
</table>
<script type="text/javascript">
    $(document).ready(function(){

       /* $("#load").on("click", function () {
            loader();
        });*/



        var data ='${lstCustomers}' ;

        var dataObject  = eval(data.replace(/\n/g, "<br />"));

        var columns = [];
        $('#example').dataTable({
            "data": dataObject[0].DATA,
            "columns": dataObject[0].COLUMNS,
            "paging":true,
            "pageLength":20,
            "ordering":true,
            "order":[0,"asc"]
        });



       /* var column_names = data.Columns;
        var columns = [];
        for (var i = 0; i < column_names.length; i++) {
            console.log(""+column_names[i])
            columns[i] = {
                'title': column_names[i],

            }
        };
        $('#example').DataTable({
            columns: columns,
            data: data,
        })*/
      /*  var table = $('#example').DataTable( {

            "aaData": data[1],
            "aoColumns": [
                { "mData":"customerId"},
                { "mData": "firstName"},
                { "mData": "lastName"},
                { "mData": "displayName"},

                {
                    "mData": "customerId",
                    /!*className: "btnE btnD",*!/

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
        });*/

        /*$('#example').DataTable( {
            data:           data,
            deferRender:    true,
            scrollY:        200,
            scrollCollapse: true,
            scroller:       true
        } );*/
    });

    $('#example').on( 'click', '.editor_edit', function () {
        var id = table.row( this ).id();

        alert( 'Clicked row id '+id );
    } );
$("#head").click(function(){
    $.get({
        url:"list_customers_headers",
        success:function (data,status) {
            console.log("ajax call"+data);
        }
    });
});
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
