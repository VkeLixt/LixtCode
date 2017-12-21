$(function() {
	// 导入tools.js
	$.getScript('js/tools.js', function() {
		console.log('导入js/tools.js成功！');
	});
	// 请求已投递信息
	requestResumeApplied();
});

/**
 * 请求已投递信息
 */
function requestResumeApplied() {
	$.get('recruit/' + $('#userId').text() + '/applied',
	function(data) {
		if (data) {
			// 填充数据
			fillData(data);
		}
	});
}

/**
 * 填充数据
 * 
 * @param data
 */
function fillData(data) {
	var $plan = data.recruitmentPlan;
	var $post = data.post;
	var $resume = data.resumeBase;
	if ($plan && $post && $resume) {
		var $tr = $('<tr>');
		var $td1 = $('<td class="requirement">' + $plan.name + '</td>');
		var $td2 = $('<td>' + $resume.personnelNumber + '</td>');
		var $td3 = $('<td>' + $post.organization.name + '</td>');
		var $td4 = $('<td>' + $post.organization.unitName + '</td>');
		var $td5 = $('<td>' + $post.name + '</td>');
		var $td6 = $('<td></td>');
		var $td7 = $('<td class="requirement" title="' + $post.requirements
				+ '">' + $post.requirements + '</td>');
		var $td8 = $('<td class="requirement" title="' + $post.remark + '">'
				+ $post.remark + '</td>');
		$tr.append($td1).append($td2).append($td3).append($td4).append($td5)
				.append($td6).append($td7).append($td8);
		$('#main tbody').html($tr);
	}
}
