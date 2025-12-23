<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>View Water Bill</title>
        <style>
            body {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }

            body::before {
                content: "";
                background-image: linear-gradient(to right, rgb(15, 100, 34), rgb(12, 72, 90));
                opacity: 0.8;
                position: absolute;
                z-index: -1;
                top: 0;
                left: 0;
                height: 100vh;
                width: 100vw;
            }

            h1 {
                font-family: Verdana, Geneva, Tahoma, sans-serif;
                color: #ffffff;
            }

            .input-container {
                margin: 20px auto;
            }

            .input-container input {
                outline: none;
                font-family: Verdana, Geneva, Tahoma, sans-serif;
                border: 2px solid rgb(255, 255, 255);
                padding: 5px;
                border-radius: 20px;
                font-size: 1.3rem;
            }

            .input-container select {
                font-family: Verdana, Geneva, Tahoma, sans-serif;
                font-size: 1.3rem;
                outline: none;
                border: 2px solid rgb(255, 255, 255);
                padding: 5px;
                border-radius: 20px;
                cursor: pointer;
            }

            .input-label {
                display: inline-block;
                width: 250px;
            }

            .input-label label {
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-size: 1.5rem;
            }

            .search-container {
                text-align: center;
            }

            .search-container input {
                font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                font-size: 2rem;
                padding: 4px 8px;
                outline: none;
                border: 1px solid rgb(31, 30, 30);
                border-radius: 30px;
                background: #bb7204;
                color: white;
                transition: all 0.2s 0s ease-in-out;
            }

            .search-container input:hover {
                transform: scale(1.05);
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <h1>Enter bill details:</h1>

        <form class="viewBill" action="MainServlet" method="post">
            <input type="hidden" name="operation" value="view">


            <div class="input-container">
                <div class="input-label">
                    <label for="consumerNum">Consumer Number</label>
                </div>
                <input type="text" name="consumerNum" id="consumerNum" required>
            </div>

            <div class="input-container">
                <div class="input-label">
                    <label for="billMonth">Month</label>
                </div>
                <select name="billMonth" id="billMonth" required>
                    <option value="SelectMonth">--Select Month--</option>
                    <option value="Jan">Jan</option>
                    <option value="Feb">Feb</option>
                    <option value="Mar">Mar</option>
                    <option value="Apr">Apr</option>
                    <option value="May">May</option>
                    <option value="Jun">Jun</option>
                    <option value="Jul">Jul</option>
                    <option value="Aug">Aug</option>
                    <option value="Sep">Sep</option>
                    <option value="Oct">Oct</option>
                    <option value="Nov">Nov</option>
                    <option value="Dec">Dec</option>
                </select>
            </div>

            <div class="input-container">
                <div class="input-label">
                    <label for="billYear">Year</label>
                </div>
                <input type="text" name="billYear" id="billYear" required>
            </div>

            <div class="search-container">
                <input type="submit" value="Search">
            </div>
        </form>

    </body>

    </html>