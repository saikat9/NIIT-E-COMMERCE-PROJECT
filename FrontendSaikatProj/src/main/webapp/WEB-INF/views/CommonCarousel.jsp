<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width,height=device-height,initial-scale=1"/>
<title>NIIT ECOMMERCE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<style type="text/css">
.navbar.navbar-inverse
{
 margin-bottom: auto;
}
.row {
  display: flex;
}

/* Create three equal columns that sits next to each other */
.column {
  flex: 33.33%;
  padding: 10px;
}
body {
    background-color: silver;
}
</style>
</head>
<body>
    <h1 align="center" style="background-color: teal; color: white;">Welcome to NIIT E-Commerce portal</h1>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="/resources/images/carousel10.jpg" alt="carousel1" >
        </div>

        <div class="item">
          <img src="/resources/images/carousel11.jpg" alt="carousel2">
        </div>

        <div class="item">
          <img src="/resources/images/carousel13.jpg" alt="carousel3">
        </div>
        
        <div class="item">
          <img src="/resources/images/carousel14.jpg" alt="carousel4">
        </div>
                
      </div>

      <!-- Left and right controls -->
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
    <div class="container">
    <!-- Static images -->
    <br><br>
    <div class="row">
      <div class="column">
        <img id="carousel1" class="img-responsive" src="/resources/images/carousel15.jpg" alt="" />
      </div>
      <div class="column">
        <img id="carousel2" class="img-responsive" src="/resources/images/carousel16.jpg" alt="" align="middle"/>
      </div>
	</div>	
    <div class="row">
      <div class="column">
        <img id="carousel3" class="img-responsive" src="/resources/images/carousel17.jpg" alt="" />
      </div>
      <div class="column">
        <img id="carousel4" class="img-responsive" src="/resources/images/carousel18.jpg" alt="" />
      </div>
	</div>
	</div>      
</body>
</html>