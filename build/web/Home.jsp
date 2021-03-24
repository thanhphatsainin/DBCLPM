<%-- 
    Document   : Home
    Created on : Mar 14, 2021, 10:06:33 PM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/bootsrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/css/main.css"/>
        <title>QLDT PTIT</title>
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
                <div class="row mt-4">
                    <div class="col-lg-3">
                        <form action="listClassic" method="POST" class = "form-subject">
                            <div class="form-group">
                                <label>${sessionScope.nameUser}</label>
                                <label>Chọn môn giảng dạy</label>
                                <label style="display:none;">${sessionScope.idUser}</label>

                                <select class="form-control" autofocus>
                                    <c:forEach items="${listSubject}" var="a" >
                                        <option>${a.name}</option>

                                    </c:forEach>

                                </select>

                            </div>
                            <button class="btn btn-primary" type="submit" >Chọn</button>
                        </form>
                    </div>

                    <div class="col-lg-3">
                        <form class = "form-class">
                            <div class="form-group">
                                <label>Chọn lớp học phần</label>
                                <select class="form-control">
                                    <c:forEach items="${listClassics}" var="a" >
                                        <option>${a.time}</option>

                                    </c:forEach>
                                </select>
                            </div>
                            <button class="btn btn-primary" type="submit" >Chọn</button>
                        </form>
                    </div>
                </div>

                <div class="row">
                    <table class="table mt-4">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Họ tên</th>
                                <th scope="col">MSV</th>
                                <th scope="col">Điểm CC</th>
                                <th scope="col">Điểm TP1</th>
                                <th scope="col">Điểm TP2</th>
                                <th scope="col">ĐIểm thi</th>
                                <th scope="col">Điểm TB</th>
                                <th>ĐKDT</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${listBangDiems}" var="bd" >
                                <tr>
                                    <td>${bd.id}</td>
                                    <td>${bd.student.getName()}</td>
                                    <td>${bd.student.getMaSV()}</td>
                                    <td>${bd.point.getCC()}</td>
                                    <td>${bd.point.getTP1()}</td>
                                    <td>${bd.point.getTP2()}</td>
                                    <td>${bd.point.getDT()}</td>
                                    <td>${bd.point.getDiemTB()}</td>
                                    <td>${bd.point.getDKDT()}</td>
                                    <td>
                                        <a href="EditPoint?studentId=${bd.id}">Sửa điểm</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="row mt-5 other-form">
                    <div class="col-lg-4">
                        <h5>Phần trăm điểm thành phần:</h5>
                        <p class = "desc-percent"> (bạn có muốn thay đổi phần trăm các đầu điểm không? 
                            Nếu không hệ thống sẽ tính điểm với tương ứng với các giá trị bên dưới!)</p>
                        <form class="add-form" id = "form-1" method="POST" action="editPhanTram">
                            <input type="text" name="id" value = "${phanTramDiem.id}" readonly="true" style="display:none;">
                            <div class="form-group">
                                <label>% điểm CC</label>
                                <input type="text" class="form-control" name ="cc" id = "percent-cc" value="${phanTramDiem.phantramCC}">
                                <span class="form-message"></span>
                            </div>
                            <div class="form-group">
                                <label>% điểm TP1</label>
                                <input type="text" class="form-control" name ="tp1" id = "percent-tp1" value="${phanTramDiem.phantramTP1}">
                                <span class="form-message"></span>
                            </div>

                            <div class="form-group">
                                <label>% điểm TP2</label>
                                <input type="text" class="form-control" name ="tp2" id = "percent-tp2" value="${phanTramDiem.phantramTP2}">
                                <span class="form-message"></span>
                            </div>

                            <div class="form-group">
                                <label>% điểm thi</label>
                                <input type="text" class="form-control" name ="thi" id = "percent-thi" value="${phanTramDiem.phantramDT}">
                                <span class="form-message"></span>
                            </div>

                            <button type="submit" class="btn btn-primary"> Xác Nhận</button>
                        </form>
                    </div>
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4">
                        <div class="d-flex">
                            <p>Số SV đủ điều kiện dự thi: </p> &nbsp; <p>${sessionScope.duDK}</p>
                        </div>
                        <div class="d-flex">
                            <p>Số SV không đủ điều kiện dự thi: </p> &nbsp; <p>${sessionScope.kduDK}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>


</html>


