/*$(function() {
	// 进入首页，显示欢迎页
	getHtml('welcome');

	// 菜单栏点击事件绑定
	menueBind();
});

function menueBind() {
	$('#left_side_body a').unbind().click(function() {
		// 在主显示区加载页面
		getHtml($(this).attr('name'));
	});
}

*//**
 * 在主显示区加载页面
 * 
 * @param {Object}
 *            pageName
 *//*
function getHtml(pageName) {
	$.get('main/' + pageName, function(html) {
		$('#main').html(html);
	});
}*/

$(function() {
	// 导入tools.js
	$.getScript("js/tools.js");

	// 请求招聘计划数据
	getRecruitmentPlan(1);
});

/**
 * 请求招聘计划数据
 */
function getRecruitmentPlan(pageIndex) {
	var $data = new Object();
	if (pageIndex) {
		$data.pageIndex = pageIndex;
	}
	$.ajax({
		url : 'welcome/pageList',
		data : $data,
		success : function(data) {
			if (data) {
				// 请求成功，填充分页数据
				fillPlanPageList(data);
			}
		}
	});
}

/**
 * 填充分页列表
 * 
 * @param data
 */
function fillPlanPageList(data) {
	$('#recruitPlan').html('');
	$('#recruitPlan').append($('<legend>招聘计划</legend>'));
	var $div = $('<table class="table"><tbody></tbody></table>');
	$.each(data.list, function(index, plan) {
		var $span = $('<tr><td class="requirement" title="' + //
		plan.name + '">' + plan.name + //
		'</td><td><a href="#" >进入计划</a></td></tr>');
		$div.append($span);
	});
	$('#recruitPlan').append($div);
}