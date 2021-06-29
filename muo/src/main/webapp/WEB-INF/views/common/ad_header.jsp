<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>mu0</title>
	<link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon"/> 
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon" />
    <link rel="stylesheet" href="/resources/ad_css/common.css">
    <link rel="stylesheet" href="/resources/ad_css/subpage.css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="/resources/ad_js/subpage.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 
</head>
<body>
	<header>
        <div id="ad_header">
            <h1 id="logo">
                <a href="/admin/index">
                    <img src="/resources/img/ad_logo.png" alt="">
                </a>
            </h1>  
            <ul id="head_r" class="clear_fix">
                <li>관리자페이지</li>
                <li><a href="#logout">LOGOUT</a></li>
                <li><a href="../index"><img alt="home" src="/resources/img/home.png"></a></li>
            </ul>
            <nav id="ad_gnb">
            <ul class="clear_fix">
                <li><a href="/member/list">회원관리</a></li>
                <li><a href="/admin/product/list">상품관리</a></li>
                <li><a href="/admin/order/list">주문관리</a></li>
                <li><a href="/admin/coupon">쿠폰관리</a></li>
            </ul>
        </nav>
        </div>
    </header>