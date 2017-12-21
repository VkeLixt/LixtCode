$(function() {

	// 导入tools.js
	$.getScript('js/tools.js');
	
	
	// 获得首页通知
	getPrimayNotice();
	// 绑定招聘计划选择事件
	chooseRecruitPlan();
	// 绑定登录事件
	//login();
	
	loginname();
	
	loginValidate();
	
	getCodeFromSession();
	
	$('input[name=loginname]').focus(function(){
		$('#vlogin').hide();
		$('#vpass').hide();
	})
	
});

/**
 * bootstrap表单验证
 */
function loginValidate() {
	
	$('form')
			.bootstrapValidator(
					{
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
							loginname : {
								validators : {
									notEmpty : {
										message : '邮箱不能为空'
									},
//									emailAddress : {
//										message : '邮箱地址格式有误'
//									}
								}
							},
							password : {
								validators : {
									notEmpty : {
										message : '密码不能为空'
									},
										stringLength : {
										min : 1,
										max : 18,
										message : '密码长度必须在1到18位之间'
									},
									regexp : {
										regexp : /^[a-zA-Z0-9_]+$/,
										message : '密码只能包含大写、小写、数字和下划线'
									}
								}
							},
							code : {
								validators : {
									callback : {
										message : '验证码不正确',
										callback : function(value, validator) {
											var $inputCode = $(
													'input[name=code]').val();
											return $code && $inputCode
													&& $code.toLocaleUpperCase() == $inputCode
															.toLocaleUpperCase();
										}
									}
								}
							}

						}
					}).on('success.form.bv', function(e) {
				// 阻止默认提交
				e.preventDefault();
				// ajax提交表单
				submitForm();
			});
}


/**
 * 验证码
 */
function getCodeFromSession(){
	$.ajax({
		url:'getCode/getSession',
		async:false,
		success:function(data){
			if(data.code){
				$code = data.code;
			}
		}
	});
}

/**
 * 点击更换验证码
 */

function getCode(that){
	that.src='getCode?d='+ Math.random();
	getCodeFromSession();
}

/**
 * 获得首页通知
 */
function getPrimayNotice() {
	$.get('notice/primary', function(data) {
		if (data) {
			// 填充通知公告栏
			fillNoticeBoard(data);
		}
	});
}

/**
 * 填充通知公告栏
 * 
 * @param data
 */
function fillNoticeBoard(data) {
	for (var i = 0; i < data.length; i++) {
		var $notice = data[i];
		// 创建通知
		var $p = createNotice($notice);
		$('#notice_board').append($p);
	}
	// 更多通知按钮
	var $more = '<a href="#" style="background: royalblue; color: #FFFFFF; padding: 5px;">MORE&gt;</a>';
	$('#notice_board').append($more);

}

/**
 * 创建通知
 * 
 * @param notice
 */
function createNotice(notice) {
	var $p = $('<p></p>');
	var $a = $('<a href="#"></a>');
	var $span1 = $('<span class="notice_span">' + notice.title + "</span>");
	var $createDate = dateFormat(new Date(notice.createDate), 'yyyyMMdd');
	var $span2 = $('<span class="pull-right">' + $createDate + "</span>");
	$a.append($span1).append($span2);
	$p.append($a);
	return $p;
}

/**
 * 招聘计划选择事件
 */
function chooseRecruitPlan() {
	$('.nav-tabs a').unbind().click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	});
}





function loginname(){
	$('input[name=loginname').blur(function(){
	var $val=$('input[name=loginname]').val();
	$.ajax({
		url: "loginname",
		method:"post",
		data:{
			loginname:$val
		},
		datsType:'json',
			success:function(data){
				if(!data.message){
					$("#vlogin").show();
				}else{
					$("#vlogin").hide();
				}
			}
	});
	});
}
																					

/**
 * 登录事件
 */
function submitForm() {
	//$('input[type=button]').unbind().click(function(e) {
		
		/**
		 * preventDefault() 方法阻止元素发生默认的行为（例如，当点击提交按钮时阻止对表单的提交）
		 */
//		e.preventDefault();
		var $params = getParams($('form').serializeArray());
		$.ajax({
			url : "login",
			method : 'post',
			data : $params,
			dataType : 'json',
			/**
			 * resp 从UserController返回的一个值，这里应该是一个字符串
			 */
			success : function(resp) {
				if (resp.message) {
					window.location.href = "main";
				} else {
					$('#vpass').show();
					$('#vlogin').hide();
				}
			}
		});
//	});
}