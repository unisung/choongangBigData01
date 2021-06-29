<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>mu0</title>
	<link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon" />
	<link rel="icon" href="/resources/img/favicon.png" type="image/x-icon" />
	<link rel="stylesheet" href="/resources/css/common.css" />
	<link rel="stylesheet" href="/resources/css/subpage.css" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
	<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="/resources/js/datepicker.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
	<script type="text/javascript" src="/resources/js/subpage.js"></script>
	<script type="text/javascript" src="/resources/js/postcode.js"></script>
	<script type="text/javascript" src="/resources/smarteditor2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript" src="/resources/js/smarteditor.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.easing.1.3.js"></script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
	
</head>
<body>
	<header>
        <div class="hTop">
            <ul>
                <li><a href="/member/register">JOIN</a>
                <li><a href="/member/login">LOGIN</a>
                <li><a href="/member/mypage">MYPAGE</a>
                <li><a href="/shop/cart">CART</a>
            </ul>
        </div>
        <div class="hSearch">
            <h1 class="logo"><a href="/index"><img src="/resources/img/mo_logo.png" alt=""></a></h1>
            <div class="search">
                  <label for="searchbox">검색입력상자</label>
                    <input type="text" id="searchbox" placeholder="검색어를 입력하세요.">
                    <button type="submit" class="ico"></button>
            </div>
        </div>
      
       <nav class="gnb">
           <ul>
               <li><a href="/shop/new" class="topNav">NEW</a></li>
               <li><a href="/shop/best" class="topNav">BEST</a></li>
               
               <li><a href="/shop/list?c1=1&c2=TOP" class="topNav">MAN</a>
                   <ul class="subNav">
                       <li><a href="/shop/list?c1=1&c2=TOP">상의</a></li>
                       <li><a href="/shop/list?c1=1&c2=BOTTOM">하의</a></li>
                       <li><a href="/shop/list?c1=1&c2=ACC">악세서리</a></li>
                   </ul>
               </li>
               <li><a href="/shop/list?c1=2&c2=TOP" class="topNav">WOMAN</a>
                   <ul class="subNav">
                       <li><a href="/shop/list?c1=2&c2=TOP">상의</a></li>
                       <li><a href="/shop/list?c1=2&c2=BOTTOM">하의</a></li>
                       <li><a href="/shop/list?c1=2&c2=ACC">악세서리</a></li>
                       <li><a href="/shop/list?c1=2&c2=ONEPIECE">원피스</a></li>
                   </ul>
               </li>
               <li><a href="/shop/list?c1=3&c2=HAIR" class="topNav">BEAUTY</a>
                   <ul class="subNav">
                       <li><a href="/shop/list?c1=3&c2=HAIR">헤어케어</a></li>
                       <li><a href="/shop/list?c1=3&c2=BODY">바디케어</a></li>
                       <li><a href="/shop/list?c1=3&c2=PERFUME">향수</a></li>
                   </ul>
               </li>
               <li><a href="/shop/sale" class="topNav">SALE</a></li>
               <li><a href="/magazine/list" class="topNav">MAGAZINE</a></li>
           </ul>
       </nav>
   </header>