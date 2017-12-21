$(function(){
	$.getScript('js/tools.js');
	
	
	getSessionUserId();
})


/**
 * 请求session，获取用户id
 */
function getSessionUserId() {


	// 请求session，获得当前用户
	$.get('main/getSession', function(data) {
		// 获取并保存用户id
		$('#baseForm .hide input[name=userId]').val(data.id);
		// 2.根据用户id，请求用户简历基本信息
		requestResumeBase();
	});
}

