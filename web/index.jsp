<%-- 
    Document   : Login
    Created on : Mar 14, 2021, 9:29:29 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/login.css">
    <title>Đăng Nhập</title>
</head>
<body>
    <div class="main">

        <form action="CheckLoginUser" method="POST" class="form" id="form-1">
          <h3 class="heading">Đăng Nhập QLDT PTIT</h3>
            <img src="/assets/image/Logo_PTIT.jpg" alt="" class="image">

<!--            "/assets/image/Logo_PTIT.jpg"-->
      
          <div class="spacer"></div>
      
          <div class="form-group">
            <label for="mgv" class="form-label">Mã giảng viên</label>
            <input id="mgv" name="username" type="text" placeholder="VD: B17DCCN450" class="form-control" autofocus>
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="password" class="form-label">Mật khẩu</label>
            <input id="password" name="password" type="password" placeholder="Nhập mật khẩu" class="form-control">
            <span class="form-message"></span>
          </div>
      
          <button class="form-submit" type="submit">Đăng Nhập</button>
        </form>
        <script src="/assets/JS/login.js"></script>

        <script>

            // Mong muốn nhận được
            Validator({
                form: '#form-1',
                rules: [
                    Validator.isRequired('#mgv'),
                    Validator.isRequired('#password'),
                ],
//                onSubmit: function(data){
//
//                  console.log(data);
                  // nếu submit với JS thì ông lấy data ở đây

                  // Nếu submit = form như bình thường thì cmt hàm này
//                }
            });

        </script>
      </div>
</body>

</html>
