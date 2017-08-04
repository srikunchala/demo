<!DOCTYPE html>
<html>
<head>
<title>Spring Security Tutorial</title>
<link rel="stylesheet" type="text/css" th:href="@{/css/social.css}" />
<link rel="stylesheet" type="text/css" th:href="@{/css/login.css}" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.container-fluid {
	color: white;
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}

.navbar-brand {
	color: white;
	float: left;
	height: 50px;
	padding: 15px 15px;
	font-size: 16px;
	line-height: 13px;
}
<!-- menu background-->
.navbar-default {
	color: white;
	background-color:#337ab7; 
	border-color:#337ab7;
}

.navbar-default .navbar-nav>li>a {
	color: white
}

.navbar-default .navbar-nav>li>a:hover {
	color: white
}
.navbar-default .navbar-nav > .open > a, .navbar-default .navbar-nav > .open > a:focus, .navbar-default .navbar-nav > .open > a:hover {
    color: #555;
    background-color: #337ab7;
}
</style>

</head>

<body>
	<!-- 	
	
 -->


	<div class="container-fluid">

<div>
<br>
<br>
<br>
<br>

</div>

		<nav class="navbar navbar-default" style="background-color: #337ab7;color: #337ab7">

			<div class="col-sm-8">


				<!-- <div class="col-sm-4">
					<a class="navbar-brand" href="#" style="color: #0e8084;">SPARTANS
						ACADEMY</a>
				</div> -->
				<div>
					<ul class="nav navbar-nav" style=" color: white">
						<li><a href="#">Home</a></li>
						<li><a href="#">ADMINISTRATION</a></li>
						<!-- <li><a href="#">ADMISSIONS</a></li> -->
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">EXAMINATIONS <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">NEET</a></li>
								<li><a href="#">IIT/JEE</a></li>
								<li><a href="#">EAMCET</a></li>
							</ul></li>
							<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">PREVIOUS PAPERS<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">NEET</a></li>
								<li><a href="#">IIT/JEE</a></li>
								<li><a href="#">EAMCET</a></li>
							</ul></li>
						<li><a href="#">RESULTS</a></li>
						<li><a href="#">ABOUT US</a></li>
						<li><a href="#">CONTACT US</a></li>

					</ul>

				</div>


			</div>
			<!-- 	<div class="col-sm-2">
			
			</div> -->

			<div class="col-sm-4">

				<form th:action="@{/login}" method="POST" class="form-signin">



					<div class="col-sm-1 text-right">
						<a href="#" class="fa fa-facebook-square" style="font-size: 38px;color:white"></a>


					</div>



					<div class="col-sm-1 ">
						<a class="fa fa-google-plus-square"
							style="font-size: 38px;color:white;" ></a>

					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon" style="width: 12px;"><i
								class="fa fa-user"></i></span> <input type="text" id="email"
								name="email" th:placeholder="Email"
								class="form-control input-sm " />
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon" style="width: 12px;"><i
								class="fa fa-lock"></i></span> <input type="password"
								th:placeholder="Password" id="password" name="password"
								class="form-control input-sm " />
						</div>
					</div>


					<div class="col-sm-2">
						<button class=" fa fa-lock" name="Submit" value="Login"
							type="Submit" th:text="Login"
							style="color: #0e8084; background-color: #293a48; height: 31px; width: 62px;"></button>

					</div>


				</form>

			</div>
		 
		</nav>
	</div>


	<div class="container">
		<h2></h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" style="width: 100%; height: 600px;">
				<div class="item active">
					<img src="resources/images/1.jpg" alt="Los Angeles" style="width: 100%;">
				</div>

				<div class="item">
					<img src="resources/images/2.jpg" alt="Chicago" style="width: 100%;">
				</div>

				<div class="item">
					<img src="resources/images/8.jpg" alt="New york" style="width: 100%;">
				</div>
				<!--    <div class="item">
        <img src="/images/4.jpg" alt="New york" style="width:100%;">
      </div> -->
				<div class="item">
					<img src="resources/images/6.jpg" alt="New york" style="width: 100%;">
				</div>
				<div class="item">
					<img src="resources/images/7.jpg" alt="New york" style="width: 100%;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<div class="container">
		<h2>Spartans Academy provides coaching for Neet, IIT/JEE and olympiad exams through offline and online. </h2>

	</div>
	
	<!-- <div id="footer-wrapper"> -->
    	<div class="container" style="background: #42a5f6;">
        	
        	  
<!--              <div class="cols-3 widget-column-1">            	
               <h5>About SPARTANS</h5>
               <p>Detailed description of our institute comes here</p>                 <div class="clear"></div>    
              </div>       -->            
			           
            
           
             
                     
                      
               <div class="cols-3 widget-column-3">                
            	<h5>Spartans Academy</h5>
               	
                <p>Banjara Hills</p>
                <p>Hyderabad</p>
                <div class="phone-no">
                	                		<p><span>Phone:</span>9908645511</p>
                                                            <p><span>E-mail:</span><a href="mailto:info@yourmail.com">info@yourmail.com</a></p>
                                                            	<p><span>Website:</span><a target="_blank" href="http://spartans.ac.in">http://spartans.ac.in</a></p>
                                    <div class="copyright-wrapper">
        	<div class="container">
            	<div class="copyright-txt">&copy; 2016 <a href="#">Spartans Academy </a> All Rights Reserved</div>
                <div class="design-by">Design by <a rel="nofollow" href="http://www.spoorthiemg.com/" target="_blank">Spoorthi EMG</a></div>
            </div>
            <div class="clear"></div>
        </div>
                                    </div>
               </div>
                        
            <div class="clear"></div>
        </div><!--end .container-->
        
       
    <!-- </div> -->
<script type='text/javascript' src='http://www.spartans.ac.in/wp-includes/js/wp-embed.min.js?ver=4.6.6'></script>
</body>
</html>