<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="com.reva.water.bean.WaterBillBean" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Water Bill Details</title>
            <style>
                body::before {
                    content: "";
                    height: 100%;
                    width: 100%;
                    left: 0;
                    top: 0;
                    opacity: 0.6;
                    z-index: -1;
                    position: absolute;
                    background-image: linear-gradient(to right, rgb(235, 230, 227), rgb(214, 212, 208));
                }

                h1 {
                    font-family: Georgia, 'Times New Roman', Times, serif;
                }

                table {
                    border: 1px solid rgb(20, 20, 20);
                    background: rgb(20, 20, 20);
                    font-family: serif;
                    font-size: 1.5rem;
                    letter-spacing: 2;
                }

                .bill-table {
                    display: flex;
                    flex-direction: column;
                    justify-content: center;
                    align-items: center;

                }

                .bill-table tr {
                    background: #eed4b6;
                }

                .bill-table th {
                    color: rgb(255, 255, 255);
                    background: #e07b06ec;
                }

                .bill-table td {
                    font-size: 1.2rem;
                    padding: 6px;
                }

                .total-charges th {
                    background-color: #207406;
                }


                .total-charges td {
                    background-color: #c1ffae;
                }

                .nav-link {
                    text-decoration: none;
                    font-size: 1.4rem;
                    margin-top: 20px;
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    font-family: Verdana, Geneva, Tahoma, sans-serif;
                }

                .nav-link #back {
                    color: rgb(18, 19, 18);
                    text-decoration: none;
                    margin: 10px 0;
                }

                .nav-link #back:hover {
                    text-decoration: underline;
                }

                .no-record p {
                    font-family: Georgia, 'Times New Roman', Times, serif;
                    font-size: 3rem;
                    font-weight: 500;
                    color: #06098d;
                }
            </style>
        </head>

        <body>
            <div class="bill-table">
                <% WaterBillBean bean=(WaterBillBean) request.getAttribute("beanObject"); boolean
                    notFound=request.getAttribute("notFound") !=null; if (notFound || bean==null) { %>
                    <div class="no-record">
                        <p>No matching records exists! Please try again!</p>
                    </div>
                    <% } else { %>
                        <h1>Water Bill</h1>
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
                        <% } %>

                            <div class="nav-link">
                                <a id="back" href="menu.html">Back to Menu</a>
                            </div>
            </div>
        </body>

        </html>