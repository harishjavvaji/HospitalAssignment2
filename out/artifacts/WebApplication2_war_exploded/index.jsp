<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  <title>Registration page</title>
</head>
<body>
<div class="p-3 mb-2 bg-info text-white">

  <section class="container">
    <div class="header bg-" >

      <div class="text">

        <div class="display-3"> Welcome!</div>

        <p> Enter details below for registration</p>

      </div>

    </div>


  </section>

  <section class="box">
    <div class="container">

      <form action="/Registration" method="post">

        <div class="form-group">
          <label for="firstName">First Name</label>
          <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter First Name">
        </div>

        <div class="form-group">
          <label for="lastName">Last Name</label>
          <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Last Name">
        </div>

        <fieldset class="form-group">
          <label>Gender</label>
          <div class="form-check">
            <label class="form-check-label">
              <input type="radio" class="form-check-input" name="gender" id="male" value="Male">Male
            </label>
          </div>
          <div class="form-check">
            <label class="form-check-label">
              <input type="radio" class="form-check-input" name="gender" id="female" value="Female">Female
            </label>
          </div>

        </fieldset>


        <div class="form-group">
          <label for="eMail">Email address</label>
          <input type="email" class="form-control" id="eMail" name="eMail" aria-describedby="emailHelp" placeholder="Enter email">
          <small id="emailHelp" class="form-text">We'll never share your email with anyone else.</small>
        </div>


        <div class="form-group">
          <label for="userName">User Name</label>
          <input type="text" class="form-control" id="userName" name="userName" placeholder="Choose a User Name">
        </div>


        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Choose a password">
        </div>

        <div>
          <button type="submit" class="btn btn-primary">Sign UP</button> Already have an account?
          <a href="Login.html" class="btn btn-primary"> Sign In</a>
        </div>


      </form>

    </div>

  </section>
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</div>

</body>
</html>