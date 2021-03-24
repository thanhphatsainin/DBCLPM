<%-- 
    Document   : EditPoint
    Created on : Mar 23, 2021, 8:25:10 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/bootsrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <title>Sửa và nhập điểm sinh viên</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="mar-30 d-flex">
          <a class="navbar-brand" href="/">
            <img src="assets/image/Logo_PTIT.jpg" alt="" class="navbar-logo">
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="index.html">Thông tin lớp giảng dạy</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div class="app">
        <div class="mar-30">
          <div class="mt-4">
            <div class="d-flex">
              <h5 class="sv-name"> Họ tên SV: </h5> &nbsp; <h5 name ="name">${student.name}</h5>
            </div>
            <div class="d-flex">
              <h5 class="sv-code"> Mã SV: </h5> &nbsp; <h5>${student.maSV}</h5>
            </div>
<!--            <p id="id-sv" value = "${pointUpdate.id}" name= "id" style="display:none;">id</p>-->
          </div>
          <div class="row mt-4">
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
              <form class="add-form" id = "form-1" method="POST" action="EditPointStudent">
                <div class="form-group">
                   <label name="id" style="display:none;"> ${sessionScope.nameUser}</label>
<!--                   <p id="id-sv" value = "${pointUpdate.id}" name= "id" style="display:none;">id</p>-->
                   <input type="text" class="form-control" value = "${pointUpdate.id}" name ="id" id = "diem-cc" autofocus style="display:none;" >
                  <label>Điểm CC</label>
                  <input type="text" class="form-control" value = "${pointUpdate.CC}" name ="cc" id = "diem-cc" autofocus>
                  <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label>Điểm TP1</label>
                    <input type="text" class="form-control" value = "${pointUpdate.TP1}" name ="tp1" id = "diem-tp1">
                    <span class="form-message"></span>
                  </div>

                  <div class="form-group">
                    <label>Điểm TP2</label>
                    <input type="text" class="form-control" value = "${pointUpdate.TP2}" name ="tp2" id = "diem-tp2">
                    <span class="form-message"></span>
                  </div>

                  <div class="form-group">
                    <label>Điểm thi</label>
                    <input type="text" class="form-control" value = "${pointUpdate.DT}" name ="thi" id = "diem-thi">
                    <span class="form-message"></span>
                  </div>

                <button type="submit" class="btn btn-primary">Lưu Lại</button>
              </form>
            </div>
          </div>
      </div>
      </div>
      <script src="assets/JS/login.js"></script>

        <script>

            // Mong muốn nhận được
            Validator({
                form: '#form-1',
                rules: [
                    Validator.isRequired('#diem-cc'),
                    Validator.isRequired('#diem-tp1'),
                    Validator.isRequired('#diem-tp2'),
                    Validator.isRequired('#diem-thi'),
                ],
                // onSubmit: function(data){

                //   console.log(data);
                //   // nếu submit với JS thì ông lấy data ở đây

                //   // Nếu submit = form như bình thường thì cmt hàm này
                // }
            });

        </script>
</body>
</html>
