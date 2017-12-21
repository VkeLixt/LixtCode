$(function(){
	// 初始化用户相片请求路径
	initRequestPath();
	// 选择图片回显
	echoImg();
	// 上传相片事件
	uploadPhoto();
});



/**
 * 初始化用户相片请求路径
 */
function initRequestPath() {
	$('fieldset #img').attr('src',
			'photo/' + $('#userId').text() + '/get?' + Math.random())
}


/**
 * 选择图片回显
 */
function echoImg() {
	$('#uploadFile').unbind().change(function(e) {
		// 创建FileReader对象
		var freader = new FileReader();
		// 设置回显图片文件
		freader.readAsDataURL(e.target.files.item(0));
		
		// 回显重载
		freader.onload = function(e) {
			$('fieldset #img').attr('src', e.target.result);
		}
	});
}


/**
 * 上传相片事件
 */
function uploadPhoto() {
	$('#upload').unbind().click(function(e) {
		e.preventDefault();
		// 1.判断是否选取了相片
		if ($('#uploadFile').val()) {
			upload();
		} else {
			alert('请先选取相片...');
		}
	});
}


/**
 * 上传相片
 */
function upload() {
	// 2.判断当前用户是否已有相片
	$.get('photo/' + $('#userId').text() + '/isExist',//
	function(data) {
		if (data) {
			// 用户已有相片，更新相片
			updatePhoto();
		} else {
			// 用户未有相片，保存相片
			savePhoto();
		}
	});
}


/**
 * 保存相片
 */
function savePhoto() {
	var $url = 'photo/' + $('#userId').text() + "/uploadSave";
	uploadFunc($url);
}




/**
 * 更新相片
 */
function updatePhoto() {
	var $url = 'photo/' + $('#userId').text() + "/uploadUpdate";
	uploadFunc($url);
}





/**
 * 文件上传
 * 
 * @param url
 */
function uploadFunc(url) {
	// 创建表单数据对象
	var formData = new FormData();
	// 获得表单上传控件文件名称
	var $name = $("#uploadFile").val();
	// 封装上传文件数据和属性
	formData.append("file", $("#uploadFile")[0].files[0]);
	formData.append("name", $name);
	// ajax异步请求
	$.ajax({
		url : url,
		type : 'POST',
		data : formData,
		// 告诉jQuery不要去处理发送的数据
		processData : false,
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		beforeSend : function() {
			// alert("正在进行，请稍候");
		},
		success : function(data) {
			alert(data.message);
		},
		error : function(data) {
			alert("服务器异常，请联系管理员!");
		}
	});
}









