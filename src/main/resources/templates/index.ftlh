<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <title>Dress Up</title>
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-2 px-md-3 mb-2 bg-white border-bottom shadow-sm">
  <img src="/images/hanger.png" class="img-fluid" alt="hanger">
  <h2 class="my-0 mr-md-auto font-weight-normal" href="/home">Dress Up</h2>
  <nav class="my-2 my-md-0 mr-md-3">

   <#-- <#if current_user??>
    <a class="text-primary" href="/profile">Hello, ${current_user.getNickname()}</a>
    <a class="p-2 text-dark" href="/logout">Log out</a>
    </#if>

    -->
    <a class="btn btn-outline-success m-1" href="/login">Sign in</a>
    <a class="btn btn-outline-primary" href="/signup">Sign up</a>

  </nav>
  <form class="form-inline ">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
</div>

<div id="slides" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#slides" data-slide-to="0" class="active"></li>
    <li data-target="#slides" data-slide-to="1"></li>
    <li data-target="#slides" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/images/blogger1.jpg" class="img-fluid" alt="blogger1">
      <div class="carousel-caption display-1">
        <h1>Make your own fashion</h1>
        <p>Take photos of your looks and share it with your followers</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/images/carousel2.jpg" class="img-fluid" alt="blogger2">
      <div class="carousel-caption display-1">
        <h1>Follow your favourite blogger</h1>
        <p>Dive in fashion world!</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/images/carousel3.jpg" class="img-fluid" alt="Share your looks with your friends and become a superstar">
      <div class="carousel-caption display-1">
        <h1>Just shine</h1>
        <p>Share your looks with your friends and become a superstar</p>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#slides" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#slides" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div class="container-fluid">
  <h1>
  </h1>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>