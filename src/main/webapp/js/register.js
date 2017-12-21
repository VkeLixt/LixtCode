$(function() {

	// 导入tools.js
	$.getScript('js/tools.js');

	pwd();
	
	trimemail();
	
	trimEmailNum();


	// 绑定注册事件
	regist();
	
});



function trimemail(){
	$('input[name=loginname]').blur(function(){
	var $name = $('input[name=loginname').val();
	if(!$name.trim()){
		$('.warning:eq(0)').hide();
		$('#email_log').hide();
		$('#email_reg').hide();
		$('#email_trim').show();
	}else{
		email($name);
	}
 });
}


function email(name){
		$.ajax({
			url : 'loginname',
			method: 'post',
			data:{
				loginname:name
			},
			dataType:'json',
				success:function(data){
					if(data.message){
						$('.warning:eq(0)').hide();
						$('#email_reg').hide();
						$('#email_trim').hide();
						$('#email_log').show();
					}else{
						$('.warning:eq(0)').hide();
						$('#email_log').hide();
						$('#email_trim').hide();
						$('#email_reg').show();
					}
				}
		});
   }

function trimEmailNum(){
	$('input[name=cardId]').blur(function(){
	var $name = $('input[name=cardId').val();
	if(!$name.trim()){
		$('.warning:eq(1)').hide();
		$('#email_num').hide();
		$('#email_vnum').hide();
		$('#email_vtrim').show();
	}else{
		emailNum($name);
	}
 });
}

function emailNum(name){
	$.ajax({
		url : 'cardid',
		method: 'post',
		data:{
			cardId:name
		},
		dataType:'json',
			success:function(data){
				if(data.message){
					$('.warning:eq(1)').hide();
					$('#email_num').show();
					$('#email_vtrim').hide();
					$('#email_vnum').hide();
				}else{
					$('.warning:eq(1)').hide();
					$('#email_num').hide();
					$('#email_vtrim').hide();
					$('#email_vnum').show();
				}
			}
	});
}


function pwd(){
	$('input[name=repass]').blur(function(){
	
		var $pass=$('input[name=password]').val();
		var $repass=$('input[name=repass]').val();
		if($pass != $repass){
			$('#regist').addClass('disabled');
			$('.warning:eq(3)').hide();
			$('#pass').show();
		}else{
			
			$('#pass').hide();
		}
	})
	
	
}


function regist() {
	$('#regist').unbind().click(function(e) {
		e.preventDefault();
		var $params = getParams($('form').serializeArray());
		$.ajax({
			url : "regist",
			method : 'post',
			data : $params,
			dataType : 'json',
			success : function(resp) {
				if (resp.message) {
					alert('注册成功！');
				}else{
					alert('注册失败！')
				}
			}
		});
	});
}