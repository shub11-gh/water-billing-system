<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.reva.water.bean.WaterBillBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Water Bill Details</title>
<style>
        h2 {
            font-family: Georgia, 'Times New Roman', Times, serif;
        }

        table {
            width: 250px;
            border: 1px solid rgb(20, 20, 20);
            background: rgb(20, 20, 20);
        }
        
        .bill-table {
                    display: flex;
                    flex-direction: column;
                    justify-content: center;
                    align-items: center;

        }

        .bill-table tr {
            background: #eff0f1;
        }

        .bill-table td {
            font-size: 1.1rem;
            padding: 6px;
        }
        
        .back-link a {
            text-decoration: none;
            color: rgb(0, 80, 133);
            font-size: 1.2rem;
        }

        .total-charges th {
            background-color: #3fd411;
        }


        .total-charges td {
            background-color: #b4eea3;
        }
        
        .back-link{
            margin-top:30px;
        }
        
        .no-record {
            font-family: Georgia, 'Times New Roman', Times, serif;
            font-size: 1.2rem;
         }
       
    </style>
</head>

<body>
	<div class="bill-table">
    <%
      WaterBillBean bean = (WaterBillBean) request.getAttribute("beanObject");
      boolean notFound = request.getAttribute("notFound") != null;
      if (notFound || bean == null) {
    %>
	    <div class="no-record">
		    No matching records exists! Please try again!
	    </div>
    <%
      } 
      else 
      	{ 
    %>
    	<h2>Water Bill</h2>
        <table>
            <tr>
                <th>
                    Consumer Number
                </th>
                <td>
                   <%= bean.getConsumerNumber()%>
                </td>
            </tr>

            <tr>
                <th>
                    Month
                </th>
                <td>
                   <%= bean.getBillMonth()%>
                </td>
            </tr>

            <tr>
                <th>
                    Year
                </th>
                <td>
                    <%= bean.getYear()%>
                </td>
            </tr>

            <tr>
                <th>
                    Start Reading
                </th>
                <td>
                    <%= bean.getStartReading()%>
                </td>
            </tr>

            <tr>
                <th>
                    Current Reading
                </th>
                <td>
                   <%= bean.getCurrentReading()%>
                </td>
            </tr>

            <tr>
                <th>
                    Consumption
                </th>
                <td>
                   <%= bean.getTotalConsumption()%>
                </td>
            </tr>

            <tr>
                <th>
                    Connection Type
                </th>
                <td>
                   <%= bean.getConnectionType()%>
                </td>
            </tr>

            <tr>
                <th>
                    Fixed Charges
                </th>
                <td>
                   <%= bean.getFixedCharges()%>
                </td>
            </tr>

            <tr>
                <th>
                    Variable Charges
                </th>
                <td>
                   <%= bean.getVariableCharges()%>
                </td>
            </tr>

            <tr class="total-charges">
                <th>
                    Total Charges
                </th>
                <td>
					Rs. <%= String.format("%.2f",bean.getTotalCharges()) %>                
                </td>
            </tr>
            
        </table>
    <% 
    	} 
    %>
    
        <div class="back-link">
            <a href="menu.html">Back to Menu</a>
        </div>
    </div>
</body>
</html>