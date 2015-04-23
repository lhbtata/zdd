<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
 String contextPath = request.getContextPath();
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="找丢丢"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>找丢丢 找到心爱的宝贝</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.SuperSlide.js"></script>
</head>

<body>
<div class="header">
    <div class="header_menu">
		 <ul class="header_nav">
			  <li><a href="#">${session_area }[更换] <span id="area"></span></a></li>
			  <li><a href="${ctx }/index.do">您好，欢迎来到找丢丢!</a></li>
		 </ul>
		 <ul class="header_mid"> 
		 		<c:choose>
		 			<c:when test="${not empty session_user }">
		 			<li>
		 			<a  href="#">欢迎你，<span>${session_user.username }</span></a>　
		 			<!-- <a  href="${ctx}/background/msg/MessageListPage.do?pageNow=1" id="msgCount">站内信(0)</a>　 -->
		 			<a  href="${ctx}/logout.do">退出</a> 
		 			</li>
		 			</c:when>
		 			<c:otherwise>
		 			<li><a href="${ctx}/denglu.do">[登录]</a></li>
		 			</c:otherwise>
		 		</c:choose>
			  <li><a href="${ctx}/zhuce.do">[免费注册]</a></li>
		 </ul>
		 <ul class="header_right">  
			  <li><a href="#">客户服务</a></li>
			  <li><a href="#">网站导航</a></li>
		 </ul>
	</div>
	<div class="top_ad">
		<ul>
			<li class="top_ad1"><a href="#"></a></li>
		</ul>
    </div>
</div>
<div class="logosearch">
	<div class="logo"><img src="img/logo.gif" width="190px"alt="找丢丢 找到心爱的宝贝" /></div>
	<div class="search_con">
		<div>
			<table cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td><span><input type="text" class="search_text"/></span></td>
					<td><input type="submit" class="search_submit1" value=""/></td>
					<td><input type="submit" class="search_submit2" value=""/></td>
				</tr>
			</table>
		</div>
		<div>
			<ul  class="dangqian">
				<li><a href="#"><span>[北京]</span></a></li>
			</ul>
			<ul  class="chengshi">
				<li><a href="#">上海</a></li>
				<li><a href="#"> 广州</a></li>
				<li><a href="#">深圳</a></li>
				<li><a href="#">成都</a></li>
				<li><a href="#">重庆</a></li>
				<li><a href="#">武汉</a></li>
				<li><a href="#">杭州</a></li>
				<li><a href="#">南京</a></li>
				<li><a href="#">苏州</a></li>
				<li><a href="#">东莞</a></li>
				<li><a href="#">沈阳</a></li>
				<li><a href="#">大连</a></li>
				<li><a href="#">济南</a></li>
				<li><a href="#">海南</a></li>
				<li><a href="#">三亚</a></li>
				<li><a href="#">香港</a></li>
				<li><a href="#">[377城市]</a></li>
			</ul>
			<ul>
			    <li><a href="#" class="kouhao">一个人的力量是很难应付生活中无边的苦难的。所以，自己需要别人帮助，自己也要帮助别人。――茨威格。搜索(流动文字)</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="menu">
	<ul>                                      
		        <li><span  class="dangqian"><a href="#">网站首页</a></span></li>
				<li><a href="#"> 找东西</a></li>
				<li><a href="#">好人榜</a></li>
				<li><a href="#">寻人启示</a></li>
				<li><a href="#">丢丢帮</a></li>
				<li><a href="#">积分规则</a></li>
				<li><a href="find.html">寻找他(她)</a></li>
				<li><a href="#">免费放送</a></li>
	</ul>
</div>
<div class="border1">
	<div class="border1_mid">
		<div class="border_mid_lanmu">
			<h3 style="padding-left:3px;background:url(img/lanmu_bg.jpg) repeat-x;line-height:36px;height:36px;color:#ff6000;">最新捡到的东西<a href="#">更多</a></h3>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
						<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
						<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
		</div>
	    <div class="border_mid_lanmu">
			<h3 style="padding-left:3px;background:url(img/lanmu_bg.jpg) repeat-x;line-height:36px;height:36px;color:#ff6000;"><a>最新捡到的东西</a></h3>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
						<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
						<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
			<ul>
			    <li>[山东]</li>
				<li>[沂水]</li>
         		<li><a href="#">丢了一串钥匙，5把，希望捡到的好心人联系他。</a></li>
		    </ul>
		</div>
	</div>
	<div class="border1_right">
		<div class="bd">
			<ul style="position: relative; width: 318px; height: 333px;">
				<li style="position: absolute; width: 318px; left: 0px; top: 0px; display: none;">
				<a href="#"><img src="img/img1.jpg"></a></li>
				<li style="position: absolute; width: 318px; left: 0px; top: 0px; display: none;">
				<a href="#"><img src="img/img2.jpg"></a></li>
				<li style="position: absolute; width: 318px; left: 0px; top: 0px; display: list-item;">
				<a href="#"><img src="img/img3.jpg"></a></li>
			</ul>
		</div>
		<div class="hd">
			<div class="hoverBg" style="margin-top: 5px;">
			</div>
			<ul>
				<li class=" "><a href="#">
				<img src="img/0.1.jpg"></a></li>
				<li class=" "><a href="#">
				<img src="img/0.2.jpg"></a></li>
				<li class=" "><a href="#">
				<img src="img/0.3.jpg"></a></li>
			</ul>
		</div>
		<div class="border1_right_bottom">
		   <ul>
			  <li class="border1_right_bottom_bt" style="font-size:16px"><b><a href="#">寻人启示</a></b></li>
			  <li>    19日晚，尹女士一家在玉楼东星沙店就餐，离席时尹女士将装有两千多元现金、500元购物卡的手提包遗落在了包厢的窗台上......</li>
		   </ul>	
		</div>
    </div>
  	<div class="border1_left">
	    <ul>
			<li class="border1_left_list"><a href="#">电子产品</a></li>
		</ul>	
	</div>
<script type="text/javascript">
jQuery(".border1_right").slide({ mainCell:".bd ul", effect:"fold", autoPlay:true, delayTime:300, triggerTime:50, startFun:function(i){jQuery(".border1_right .hoverBg").animate({"margin-top":116*i},150);}});
</script>
</div>
<div class="border2">
   <div class="border2_top">
     <marquee style="WIDTH: 990px; HEIGHT: 30px" scrollamount="5" behaviour="Alternate" scrolldelay="1"> 
	 <li style="color:#ff6000">
	 喜报：路一起走丢的东西找到了失主，感谢好心人。好人有好报！   路一起走丢的东西找到了失主，感谢好心人。好人有好报！  (流动文字)
	 </li>
	  </marquee>
   </div>
   <div class="border2_bottom">
       <div class="border2_bottom_left">
	        <div class="border2_bottom_left1">
			   <div class="border2_bottom_left_bg"></div>
			   <div class="border2_bottom_left_menu">
			      <ul>
				     <li class="border2_bottom_left_botton" style="background-color:#fbf9b5"><span class="hdm_01" id="hdm0" onmousemove="javascript:hd(0)"></span></li>
					 <li class="border2_bottom_left_botton" style="background-color:#bbb"><span id="hdm1" onmousemove="javascript:hd(1)"></span></li>
					 <li class="border2_bottom_left_botton" style="background-color:#ccc"><span id="hdm2" onmousemove="javascript:hd(2)"></span></li>
				  </ul>			   
			   </div>
			</div>
			<div class="border2_bottom_left2" style="display:block;" id="fr_hd0">
                   <ul>
				      <li><a>被评为感人故事邮费也不用付喔</a></li>
					  <li><a>做三件好事即可免费获得</a></li>
				  </ul>
				  <div class="border2_bottom_left2_1" ></div>
			</div>
		</div>
       <div class="border2_bottom_bg0" style="display:block;" id="tx_hd0">
	   </div>
	    <div class="border2_bottom_bg1" style="display:block;" id="tx_hd1">
	   </div>
	    <div class="border2_bottom_bg2" style="display:block;" id="tx_hd2">
	   </div>
	 </div>
	  <div class="border2_bottom_right">
	       <ul>
		     <li class="border2_bottom_right_bg" style="font-size:16px"><b><a href="#">丢丢帮（论坛）</a></b></li>
			<table>
			      <tr>
			        <td style="width:25%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">捡到了一串钥匙，共5把，失主联系他。</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:25%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">捡到了一串钥匙，共5把，失主联系他。</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:25%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">捡到了一串钥匙，共5把，失主联系他。</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:25%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">捡到了一串钥匙，共5把，失主联系他。</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:25%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">捡到了一串钥匙，共5把，失主联系他。</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:25%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">捡到了一串钥匙，共5把，失主联系他。</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:25%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">捡到了一串钥匙，共5把，失主联系他。</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:25%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">捡到了一串钥匙，共5把，失主联系他。</a>
					</td>
			     </tr>
		   </table>
		   </ul>
	   </div>
</div>
<div class="bottom">
    <div class="bottom_top1">
	    <ul>
		   <li class="find"><a href="#">寻找失去多年的他（她）</a></li>
		   <li class="find" style="text-align:right; font-size:12px;"><a href="#">more..</a></li>
		 </ul>
	</div>
	<div class="bottom_top2">
		 <ul>
		   <li class="goodman"><a href="#">好人榜</a></li>
		   <li class="goodman" style="text-align:right; font-size:12px;"><a href="#">更多》</a></li>
		</ul>
	</div>
	<div class="bottom_left">
	   <div class="bottom_left1">
	       <ul>
		      <li>是否有一个人在心中永远不能忘记，那段美好的记忆挥之不去，是否很久没有相互联系，想要找他（她）却不知道他（她）在哪里？</li>
			  <li>告诉我，你们</li>
			  <li>相识的地点</li>
			  <li>他（她）的名字</li>
              <li>年龄：</li>
			  <li>70年代   80年代  90年代  2000年以来</li>
			  <li>我们共同帮你重拾那时的回忆。</li>
		   </ul>
	   </div>
	   <div class="bottom_left2">
	       <ul>
	           <li style="color:#7f7f7f;">最新消息(你可能认识）</li>
			   <table>
			      <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#" >(给他推荐)</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td>
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				 <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td>
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				 <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td>
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				 <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
				  <tr>
			        <td style="width:19%">
					  <a href="#"><span class="broder_mid_add">[路一起走]</span></a>
					</td>
				    <td>
					   <a href="#">还记得吗？我们一起的时刻，好久没见了。</a>
					</td>
					<td style="width:19%">
					   <a href="#">(给他推荐)</a>
					</td>
			     </tr>
		   </table>
		   </ul>		   
	   </div>
	</div>
	<div class="bottom_right">
		<ul>
			<li class="bottom_right_jp1"></li>
			<li><a href="#"><img src="img/0.3.jpg"  class="bottom_right_tp1"/> </a></li>
			<li>账户：<br />姓名：<br /> 所在地:</li>
		</ul>
		<ul>
			<li class="bottom_right_jp2"></li>
			<li><a href="#"><img src="img/0.2.jpg"  class="bottom_right_tp1"/> </a></li>
			<li>账户：<br />姓名：<br /> 所在地:</li>
		</ul>
		<ul>
			<li class="bottom_right_jp3"></li>
			<li><a href="#"><img src="img/0.1.jpg"  class="bottom_right_tp1"/> </a></li>
			<li>账户：<br />姓名：<br /> 所在地:</li>
		</ul>
	</div>
</div>
<div class="banquan">
   <ul class="banquan_lianjie">
      <li>友情链接：</li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
	  <li><a href="#">沂水团县委</a></li>
   </ul>
   <ul>
       <li>Copyright (C) 找丢丢网 2014-2014, All Rights Reserved</li>
       <li>京ICP证041189号|出版物经营许可证 新出发京批字第直0673号|食品流通许可证：SP1101011010021855(1-1)</li>
	   <li>互联网药品信息服务资格证编号：(京)-非经营性-2012-0016|京公网安备110101000001号</li>
   </ul>
</div>
</body>
</html>
