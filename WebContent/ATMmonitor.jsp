
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<!-- Connect to database -->
<%
	Connection connection = null;
	try {
		//Loading the JDBC driver for MySql

		Class.forName("com.mysql.jdbc.Driver");

		//Getting a connection to the database. Change the URL parameters
		connection = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/ATMDatabase", "root",
				"19911116");
		//Creating a statement object
		Statement stmt = connection.createStatement();

		//Executing the query and getting the result set
		ResultSet rs = stmt
				.executeQuery("select * from atmdatabase.atmstatus");

		//Iterating the resultset and printing the data into table format
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>SMU tBank ATM Admin</title>
<meta name="keywords" content="Admin,SMU tBank" />
<!-- We need to emulate IE7 only when we are to use excanvas -->
<!--[if IE]>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<![endif]-->
<!-- Favicons -->
<link rel="shortcut icon" type="image/png"
	HREF="img/favicons/favicon.png" />
<link rel="icon" type="image/png" HREF="img/favicons/favicon.png" />
<link rel="apple-touch-icon" HREF="img/favicons/apple.png" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<!-- Colour Schemes
		Default colour scheme is blue. Uncomment prefered stylesheet to use it.
		<link rel="stylesheet" href="css/brown.css" type="text/css" media="screen" />  
		<link rel="stylesheet" href="css/gray.css" type="text/css" media="screen" />  
		<link rel="stylesheet" href="css/green.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/pink.css" type="text/css" media="screen" />  
		<link rel="stylesheet" href="css/red.css" type="text/css" media="screen" />
		-->
<!-- Your Custom Stylesheet -->
<link rel="stylesheet" href="css/custom.css" type="text/css" />
<!--swfobject - needed only if you require <video> tag support for older browsers -->
<script type="text/javascript" SRC="js/swfobject.js"></script>
<!-- jQuery with plugins -->
<script type="text/javascript" SRC="js/jquery-1.4.2.min.js"></script>
<!-- Could be loaded remotely from Google CDN : <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
<script type="text/javascript" SRC="js/jquery.ui.core.min.js"></script>
<script type="text/javascript" SRC="js/jquery.ui.widget.min.js"></script>
<script type="text/javascript" SRC="js/jquery.ui.tabs.min.js"></script>
<!-- jQuery tooltips -->
<script type="text/javascript" SRC="js/jquery.tipTip.min.js"></script>
<!-- Superfish navigation -->
<script type="text/javascript" SRC="js/jquery.superfish.min.js"></script>
<script type="text/javascript" SRC="js/jquery.supersubs.min.js"></script>
<!-- jQuery form validation -->
<script type="text/javascript" SRC="js/jquery.validate_pack.js"></script>
<!-- jQuery popup box -->
<script type="text/javascript" SRC="js/jquery.nyroModal.pack.js"></script>
<!-- jQuery graph plugins -->
<!--[if IE]><script type="text/javascript" src="js/flot/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" SRC="js/flot/jquery.flot.min.js"></script>
<!-- Internet Explorer Fixes -->
<!--[if IE]>
		<link rel="stylesheet" type="text/css" media="all" href="css/ie.css"/>
		<script src="js/html5.js"></script>
		<![endif]-->
<!--Upgrade MSIE5.5-7 to be compatible with MSIE8: http://ie7-js.googlecode.com/svn/version/2.1(beta3)/IE8.js -->
<!--[if lt IE 8]>
		<script src="js/IE8.js"></script>
		<![endif]-->
<body>
	<!-- Header -->
	<header id="top">
		<div class="wrapper">
			<!-- Title/Logo -->
			<div id="title">
				<img SRC="img/tBank.png" alt="SMU tBank" />
				<!--<span>Administry</span>-->
			</div>
			<!-- Top navigation -->
			<div id="topnav">
				Logged in as <b>Admin</b> <span>|</span> <a href="login.html">Logout</a><br />
			</div>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<nav id="menu">
				<ul class="sf-menu">
					<li class="current"><a HREF="ATMmonitor.jsp">ATM Dashboard</a></li>
					<li><a HREF="mapLocator.jsp">Map Locator</a></li>
					<li><a HREF="#">tBank backup 1</a></li>
					<li><a HREF="#">tBank backup 2</a></li>
					<li><a HREF="#">tBank backup 3</a></li>
				</ul>
			</nav>
			<!-- End of Main navigation -->
			<!-- Aside links -->
			<!-- Aside links (Do not use here):  <aside><b>English</b> &middot; <a href="#">Spanish</a> &middot; <a href="#">German</a></aside>   -->
			<!-- End of Aside links -->
		</div>
	</header>
	<!-- End of Header -->
	<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>Dashboard</h1>
		</div>
	</div>
	<!-- End of Page title -->

	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper">
			<!-- Left column/section -->
			<section class="column width6 first">

				<div class="colgroup leading">
					<div class="column width3 first"></div>
				</div>

				<script type="text/javascript">
$(document).ready(function(){
	
	/* setup navigation, content boxes, etc... */
	Administry.setup();
	
	<%HashMap map = new HashMap();

				while (rs.next()) {

					String id = rs.getString(1);
					String location = rs.getString(2);
					String num_of_10s = rs.getString(3);
					String num_of_50s = rs.getString(4);
					String serverStatus = rs.getString(5);
					String locationUrl = rs.getString(6);
					String location_lat = rs.getString(7);
					String location_lon = rs.getString(8);%>
			Administry.progress("#progress<%=id%>1", <%=num_of_10s%>, 500);
			Administry.progress("#progress<%=id%>2", <%=num_of_50s%>, 250);
		<%
				//create array list to store each row's information
					ArrayList<String> array = new ArrayList<String>();
					array.add(location);
					array.add(num_of_10s);
					array.add(num_of_50s);
					array.add(serverStatus);
					array.add(locationUrl);
					array.add(location_lat);
					array.add(location_lon);
					//store ArrayList into hashmap with id as key
					map.put(id, array);
					}%>
				
	});
	</script>


				<%
					Set<String> idSet = map.keySet();
						Iterator<String> iterator = idSet.iterator();

						while (iterator.hasNext()) {

							String id = iterator.next();
							ArrayList<String> atmArray = (ArrayList<String>) map
									.get(id);
							String location = atmArray.get(0);
							String num_of_10s = atmArray.get(1);
							String num_of_50s = atmArray.get(2);
							String serverStatus = atmArray.get(3);

							/* progress bar animations - setting initial values */
				%>
				<div class="colgroup leading">
					<div class="column width3">
						<h4>
							ATM
							<%=id%>
							<a href="#">(View Details)</a>
						</h4>
						<hr />
						<table class="no-style full">
							<tbody>
								<tr>
									<td><strong>ATM ID:</strong></td>
									<td class="ta-right"></td>
									<td class="ta-right"><%=id%></td>
								</tr>
								<tr>
									<td><strong>Location:</strong></td>
									<td class="ta-right"></td>
									<td class="ta-right"><%=location%></td>
								</tr>
								<tr>
									<td><strong>Server Status:</strong></td>
									<td class="ta-right"></td>
									<td class="ta-right">
										<%
											if (serverStatus.equals("online")) {
										%> <img SRC="img/valid.gif"
										alt="online" />ONLINE <%
 	} else {
 %> <img SRC="img/cancel.png"
										alt="offline" />OFFLINE <%
 	}
 %>
									</td>
								</tr>
								<tr>
									<td><strong>Num of $10<br>&nbsp;&nbsp;(<%=num_of_10s%>/500)
									</strong></td>

									<td class="ta-right"></td>
									<td><div id="progress<%=id%>1"
											class="progress full progress-green">
											<span><b></b></span>
										</div></td>
								</tr>
								<tr>
									<td><strong>Num of $50<br>&nbsp;&nbsp;(<%=num_of_50s%>/250)
									</strong></td>
									<td class="ta-right"></td>
									<td><div id="progress<%=id%>2"
											class="progress full progress-red">
											<span><b></b></span>
										</div></td>
								</tr>
							</tbody>
						</table>
					</div>
					<%
						} // end of while loop
					%>

					<!-- here to delete -->

				</div>

				<div class="clear">&nbsp;</div>

			</section>
			<!-- End of Left column/section -->

			<!-- Right column/section -->
			<aside class="column width2">
				<div id="rightmenu">
					<header>
						<h3>Your Account</h3>
					</header>
					<dl class="first">
						<dt>
							<img width="16" height="16" alt="" SRC="img/key.png">
						</dt>
						<dd>
							<a href="#">Administry</a>
						</dd>
						<dd class="last">SMU tBank Admin Account</dd>

						<dt>
							<img width="16" height="16" alt="" SRC="img/help.png">
						</dt>
						<dd>
							<a href="mailto:zhuoran.li.2011@sis.smu.edu.sg">Support</a>
						</dd>
						<dd class="last">Documentation and FAQ</dd>
					</dl>
				</div>
				<div class="content-box">
					<header>
						<h3>Latest in the tBank Team</h3>
					</header>
					<section>
						<dl>
							<dt>tBank ironMEN Project Outline</dt>
							<dd>
								<a
									href="https://wiki.smu.edu.sg/is480/IS480_Team_wiki:_2013T1_ironMEN_Documentation_Project_Design">Read
									more</a>
							</dd>
						</dl>
					</section>
				</div>
			</aside>
			<!-- End of Right column/section -->

		</div>
		<!-- End of Wrapper -->
	</div>
	<!-- End of Page content -->


	<%
		session.setAttribute("atm_details", map);
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String message = request.getParameter("msg");
		if (message != null) {
	%>
	<p>
		<font color="green">Update/ Delete successfully!</font>
	</p>
	<%
		}
	%>

	<!-- Page footer -->
	<footer id="bottom">
		<div class="wrapper">
			<p>Copyright &copy; 2013 SMU tBank ironMEN</p>
		</div>
	</footer>
	<!-- End of Page footer -->
	<!-- Scroll to top link -->
	<a href="#" id="totop">^ scroll to top</a>

	<!-- Admin template javascript load -->
	<script type="text/javascript" SRC="js/administry.js"></script>
</body>
</html>