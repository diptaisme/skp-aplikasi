<%-- 
    Document   : cobaIndex
    Created on : Apr 9, 2012, 3:49:45 PM
    Author     : diptaisme
--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <title>SASARAN KINERJA INDIVIDU PEGAWAI NEGERI SIPIL</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="Collapsing Site Navigation with jQuery" />
        <meta name="keywords" content="jquery, navigation, menu, collapsing, accordion, sliding, image, css3"/>
		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<script src="/SKPapplication/js/cufon-yui.js" type="text/javascript"></script>
		<script src="/SKPapplication/js/Liberation_Sans.font.js" type="text/javascript"></script>
		<script type="text/javascript">
			Cufon.replace('span');
			Cufon.replace('li');
			Cufon.replace('h1');
			Cufon.replace('p');
		</script>
        <style>
			body{
				background:#000 url(/SKPapplication/images/stripe.gif) repeat top left;
				margin:0;
				padding:0;
			}
			span.reference{
				font-family:Arial;
				text-transform:uppercase;
				position:fixed;
				right:95px;
				bottom:10px;
				font-size:11px;
				text-shadow:1px 1px 1px #000;
			}
			span.reference a{
				color:#aaa;
				text-decoration:none;
				margin-right:20px;
			}
			span.reference a:hover{
				color:#ddd;
			}
			.title{
				position:absolute;
				right:10px;
				top:10px;
				width:600px;
				height:600px;
				background:transparent url(/SKPapplication/images/label.png) no-repeat top left;
			}
		</style>
    </head>

    <body>

		<div class="title"></div>
		<div id="cc_menu" class="cc_menu">
			<div class="cc_item" style="z-index:5;">
				<img src="/SKPapplication/images/OperatorSKI.jpg" alt="image" />
				<div class="cc_submenu">
					<ul>
						<li class="cc_content_1">Operator SKI</li>
					</ul>
				</div>
			</div>
			<div class="cc_item" style="z-index:4;">
				<img src="/SKPapplication/images/KeluarSKI.jpg" alt="image" />
				<div class="cc_submenu">
					<ul>
						<li class="cc_content_3">Sign Out</li>
					</ul>
				</div>
			</div>
                    	<div id="cc_content" class="cc_content">
                                <span id="cc_back" class="cc_back">&lt;&lt; Go back</span>
                                <div class="cc_content_1">
                                    <a href="RequestServlet?page=insertTupoksi"><p style="font-size:24px;color:whitesmoke">FORM OPERATOR TUPOKSI</p></a>
                                    <p style="font-size:14px;color:whitesmoke">Kewenangan FORM ini hanya untuk USER OPERATOR yang telah ditunjuk secara khusus untuk melakukan entri data Tugas Pokok Dan Fungsi dari Setiap Eselon di Badan Kepegawaian Negara</p>
				</div>
                                <div class="cc_content_3">
					<a href="RequestServlet?page=indexlogin"><p style="font-size:24px;color:whitesmoke">Keluar Aplikasi</p></a>
                                        <p style="font-size:14px;color:whitesmoke">Anda Memilih Akan Keluar dari Aplikasi Sasaran Kinerja Individu PNS. Aplikasi ini merupakan salah satu quick wins dari proses akselerasi reformasi birokrasi di Badan Kepegawaian Negara</p>
				</div>
                       </div>
               </div>
        <!-- The JavaScript -->
        <script type="text/javascript">
            $(function() {
				//all the menu items
				var $items 		= $('#cc_menu .cc_item');
				//number of menu items
				var cnt_items	= $items.length;
				//if menu is expanded then folded is true
				var folded		= false;
				//timeout to trigger the mouseenter event on the menu items
				var menu_time;
				/**
				bind the mouseenter, mouseleave to each item:
				- shows / hides image and submenu
				bind the click event to the list elements (submenu):
				- hides all items except the clicked one, 
				and shows the content for that item
				*/
				$items.unbind('mouseenter')
					  .bind('mouseenter',m_enter)
				      .unbind('mouseleave')
					  .bind('mouseleave',m_leave)
					  .find('.cc_submenu > ul > li')
					  .bind('click',function(){
					var $li_e = $(this);
						  //if the menu is already folded,
						  //just replace the content
					if(folded){
						hideContent();
						showContent($li_e.attr('class'));
					}	
					      else //fold and show the content
						fold($li_e);
				});
				
				/**
				mouseenter function for the items
				the timeout is used to prevent this event 
				to trigger if the user moves the mouse with 
				a considerable speed through the menu items
				*/
				function m_enter(){
					var $this 	= $(this);
					clearTimeout(menu_time);
					menu_time 	= setTimeout(function(){
					//img
					$this.find('img').stop().animate({'top':'0px'},400);
					//cc_submenu ul
					$this.find('.cc_submenu > ul').stop().animate({'height':'200px'},400);
					},200);
				}
				
				//mouseleave function for the items
				function m_leave(){
					var $this = $(this);
					clearTimeout(menu_time);
					//img
					$this.find('img').stop().animate({'top':'-600px'},400);
					//cc_submenu ul
					$this.find('.cc_submenu > ul').stop().animate({'height':'0px'},400);
				}
				
				//back to menu button - unfolds the menu
				$('#cc_back').bind('click',unfold);
				
				/**
				hides all the menu items except the clicked one
				after that, the content is shown
				*/
				function fold($li_e){
					var $item		= $li_e.closest('.cc_item');
					
					var d = 100;
					var step = 0;
					$items.unbind('mouseenter mouseleave');
					$items.not($item).each(function(){
						var $item = $(this);
						$item.stop().animate({
							'marginLeft':'-140px'
						},d += 200,function(){
							++step;
							if(step == cnt_items-1){
								folded = true;
								showContent($li_e.attr('class'));
							}	
						});
					});
				}
				
				/**
				shows all the menu items 
				also hides any item's image / submenu 
				that might be displayed
				*/
				function unfold(){
					$('#cc_content').stop().animate({'left':'-700px'},600,function(){
						var d = 100;
						var step = 0;
					$items.each(function(){
							var $item = $(this);
							
							$item.find('img')
								 .stop()
								 .animate({'top':'-600px'},200)
								 .andSelf()
								 .find('.cc_submenu > ul')
								 .stop()
								 .animate({'height':'0px'},200);
								 
							$item.stop().animate({
							'marginLeft':'0px'
							},d += 200,function(){
								++step;
								if(step == cnt_items-1){
									folded = false;
									$items.unbind('mouseenter')
										  .bind('mouseenter',m_enter)
										  .unbind('mouseleave')
										  .bind('mouseleave',m_leave);
									
									hideContent();
								}		  
							});
						});
					});
				}
				
				//function to show the content
				function showContent(idx){
					$('#cc_content').stop().animate({'left':'140px'},200,function(){
						$(this).find('.'+idx).fadeIn();
					});
				}
				
				//function to hide the content
				function hideContent(){
					$('#cc_content').find('div').hide();
				}
            });
        </script>
    </body>
</html>