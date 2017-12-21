$(function() {
	// 进入首页，显示欢迎页
	getHtml('welcome');
	// 请求服务器session
	getSession();
	// 菜单栏点击事件绑定
	menueBind();
	
	
});


/**
 * 菜单栏事件绑定
 */
function menueBind() {
	$('#left_side_body a').unbind().click(function() {
		// 在主显示区加载页面
		getHtml($(this).attr('name'));
	});
}

/**
 * 请求服务器session
 */
function getSession() {
	$.get('main/getSession', function(data) {
		$('#userId').text(data.id);
		$('#perInfo').text(data.username);
	});
}

/**
 * 在主显示区加载页面
 * 
 * @param {Object}
 *            pageName
 */
function getHtml(pageName) {
	$.get('main/' + pageName, function(html) {
		$('#main').html(html);
	});
}


