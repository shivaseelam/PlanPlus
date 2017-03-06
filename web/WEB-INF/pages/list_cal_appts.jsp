<%--
  Created by IntelliJ IDEA.
  User: siva
  Date: 1/2/2017
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
    <title>All Calendar Appointments</title>
    <%--<link href="https://cdnjs.cloudflare.com/ajax/libs/extjs/6.0.0/classic/theme-classic/resources/theme-classic-all.css" rel="stylesheet" />
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/extjs/6.0.0/ext-all.js"></script>
    <script type="text/javascript" src="CalendarPanel.js "></script>
    <script type="text/javascript">
       /* Ext.onReady(function() {
            Ext.create('Ext.Panel', {
                renderTo: 'helloWorldPanel',
                height: 100,
                width: 200,
                title: 'Hello world',
                html: 'First Ext JS Hello World Program'
            });
        });*/

       Ext.Loader.setConfig({
           enabled: true,
           disableCaching: false,
           paths: {
               "Extensible": "extjs/src/extensible/src",
               "Extensible.example": "extjs/src/extensible/examples"
           }
       });
        Ext.require([
            'Extensible.calendar.data.MemoryEventStore',
            'Extensible.calendar.CalendarPanel',
            'Extensible.example.calendar.data.Events'
        ]);

        Ext.onReady(function(){
            var eventStore = Ext.create('Extensible.calendar.data.MemoryEventStore', {
                // defined in ../data/Events.js
                data: Extensible.example.calendar.data.Events.getData()
            });

            //
            // example 1: simplest possible stand-alone configuration
            //
            Ext.create('Extensible.calendar.CalendarPanel', {
                eventStore: eventStore,
                renderTo: 'simple',
                title: 'Basic Calendar',
                width: 700,
                height: 500
            });

            //
            // example 2: shows off some common Ext.Panel configs as well as a
            // few extra CalendarPanel-specific configs + a calendar store
            //
            Ext.create('Extensible.calendar.CalendarPanel', {
                id: 'cal-example2',
                eventStore: eventStore,
                renderTo: 'panel',
                title: 'Calendar with Panel Configs',
                activeItem: 1, // default to week view
                width: 700,
                height: 500,

                // Standard Ext.Panel configs:
                frame: true,
                collapsible: true,
                bbar: [{text: 'A Button', handler: function(){
                    Ext.Msg.alert('Button', 'I work!');
                }}],

                listeners: {
                    // A simple example showing how to handle a custom calendar event to
                    // override default behavior. See the docs for all available events.
                    'eventclick': {
                        fn: function(panel, rec, el){
                            // override the default edit handling
                            //Ext.Msg.alert('App Click', 'Editing: ' + rec.data.Title);

                            // return false to tell the CalendarPanel that we've handled the click and it
                            // should ignore it (e.g., do not show the default edit window)
                            //return false;
                        },
                        scope: this
                    }
                }
            });
        });
    </script>--%>

</head>
<body>
<%--<div id='simple'></div>--%>
<h1><center>Student Details  <a href="list_cal_appts.htm"> refresh</a></center> </h1>
<c:choose>
    <c:when test="${lstCalAppts ne null }">
        <table style="height:200px;width:100px;">
            <tr>
                <th  style="width:25%">ApptId</th>
                <th style="width:25%">ApptName</th>
                <%--<th style="width:25%">ApptDesc</th>--%>
                <th style="width:25%">ApptLocation</th>
            </tr>
            <c:forEach var="calAppt" items="${lstCalAppts}">
                <tr>
                    <td><c:out value="${calAppt._apptId }"/></td>
                    <td><c:out value="${calAppt._apptName }"/></td>
                    <%--<td><c:out value="${calAppt._apptDesc }"/></td>--%>
                    <td><c:out value="${calAppt._location }"/></td>
                    <td>
                        <a href="edit.htm?no=<c:out value="${st.sno}"/>">edit</a>
                        <a href="delete.htm?no=<c:out value="${st.sno}"/>">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1><center>Records not found </center></h1>
    </c:otherwise>
</c:choose>
<center><br><br> <a href="insert.htm">Create New Appointment</a> </center>
<br><br><br>
<c:if test="${result ne null}">
    <p style="color:red"><c:out value="${result}"/> </p>
</c:if>
</body>
</html>
