$(function() {
	// 保存和删除教育经历事件
	eduHandler();
});

/**
 * 根据基本信息id，请求用户简历教育经历
 * 
 * @param resumeId
 */
function requestResumeEducation(resumeId) {
	$.get('resume/' + resumeId + '/education', function(data) {
		if (data) {
			// 2-2-1.填充教育经历列表
			fillResumeEducationList(data);
		}
	});
}

/**
 * 填充教育经历列表
 * 
 * @param eduData
 */
function fillResumeEducationList(eduData) {
	// 1.清空列表
	$('#eduTbody').html('');
	// 2.填充数据
	$.each(eduData, function(index, resumeEducation) {
		$('#eduTbody').append(fillResumeEducationData(resumeEducation));
	});
	// 3.列表编辑事件
	editEduFunc();
	//清空表单事件
	
	clearEduForm();
	
	/**
	 * 复选框事件
	 */
	eduThead();
	
	eduTbody();
	
}

/**
 * 填充教育经历数据
 * 
 * @param resumeEducation
 * @returns
 */
function fillResumeEducationData(resumeEducation) {
	var $tr = $('<tr></tr>');
	var $td1 = $('<td style="text-align: center;"><input type="checkbox" /></td>');
	var $td2 = $('<td>'
			+ dateFormat(new Date(resumeEducation.startTime), 'yyyy-MM-dd')
			+ '</td>');
	var $td3 = $('<td>'
			+ dateFormat(new Date(resumeEducation.endTime), 'yyyy-MM-dd')
			+ '</td>');
	var $td4 = $('<td>' + resumeEducation.schoolName + '</td>');
	var $td5 = $('<td>' + resumeEducation.major + '</td>');
	var $td6 = $('<td>' + resumeEducation.degree + '</td>');
	var $td7 = $('<td><a href="#">编辑</a></td>');
	var $td8 = $('<td class="hide">' + resumeEducation.id + '</td>');
	return $tr.append($td1).append($td2).append($td3).append($td4).append($td5)
			.append($td6).append($td7).append($td8);

}

/**
 * 绑定保存和删除教育经历事件
 */
function eduHandler() {
	// 1.保存教育经历事件
	saveEduFunc();
	// 2.删除教育经历事件
	delEduFunc();

}

/**
 * 绑定编辑教育经历事件
 */
function editEduFunc() {
	$('#eduTbody a').unbind().click(function(e) {
		e.preventDefault();
		// 将行数据加载到表单中
		loadTrToEduForm($(this));
	});
}

/**
 * 保存教育经历
 */
function saveEduFunc() {
	$('#saveEdu').unbind().click(function() {
		// 获取简历基本信息栏数据
		var $formParams = getParams($('#eduForm').serializeArray());
		if ($('#eduForm .hide input[name=id]').val()) {
			if (confirm('确认更新吗？')) {
				// 存在保存按钮实现更新操作
				updateResumeEdu($formParams);
			}
		} else {
			if (confirm('确认新增吗？')){
				// 不存在保存按钮实现添加操作
				addResumeEdu($formParams);
				
			}
		}
	});
}

/**
 * 判断复选框是否选中
 */
function isChooseedAny(){
	var $count=0;
	//遍历复选框
	$.each($('#eduTbody input[type=checkbox]'),
		function(index,checkbox){
		if($(checkbox).is(':checked')){
			$count++;
		}
	});
	if($count>0){
		return true;
	}
	return false;
}


/**
 * 判断是否全选
 */

function isChooseAll(){
	var $row=$('#eduTbody tr').length;
	var $count=0;
	$.each($('#eduTbody input[type=checkbox]'),function(index,checkbox){
		if($(checkbox).is(':checked')){
			$count++;
		}
	});
	if($row == $count){
		return true;
	}else{
		return false;
	}
}



/**
 * 判断标题复选框是否checked
 */

function eduThead(){
	$('#eduThead input[type=checkbox').eq(0).unbind().change(function(){
		if($(this).is(':checked')){
			$('#eduTbody input[type=checkbox]').prop('checked',true);
		}else{
			$('#eduTbody input[type=checkbox').prop('checked',false);
		}
	});
}


/**
 * 判断数据行复选框是否全checked	
 */


function eduTbody(){
	$('#eduTbody input[type=checkbox]').unbind().change(function(){
		if(isChooseAll()){
			$('#eduThead input[type=checkbox]').eq(0).prop('checked',true);
		}else{
			$('#eduThead input[type=checkbox]').eq(0).prop('checked',false);
		}
	});
}




/**
 * 删除教育经历
 */
function delEduFunc() {
	$('#delEdu').unbind().click(function() {
		if(isChooseedAny()){
			delHandler();
		}else{
			alert('你选都没选，就想删除？想太多了吧你！！');
		}
	});
}

/**
 * 删除教育经历
 */

function delHandler(){

	var $idArr = [];
	$.each($('#eduTbody input[type=checkbox]'),
	function (index,checkbox){
		
		//判断是否选择的选项
		if($(checkbox).is(':checked')){
			//如果选项不为空，则添加到idArr中
			$idArr.push($(checkbox).parent().siblings().eq(6).text());
		}
	});
	
	//删除请求
	$.ajax({
		url:'resume/education/del',
		method:'post',
		data:{
			ids : $idArr
		},
		dataType : 'json',
		success : function(data){
			if(data){
				//重新加载
				var $resumeId = $('#baseForm input[name=id]').val();
				requestResumeEducation($resumeId);
			}
		},
		error:function(){
			alert('服务器异常，请联系管理员！');
		}
	});
}


/**
 * 添加教育经历
 * 
 * @param formParams
 */
function addResumeEdu(formParams) {
	var $resumeId = $('#baseForm input[name=id]').val();
	formParams.resumeId = $resumeId;
	// 提交请求
	$.ajax({
		method : 'post',
		url : 'resume/education/save',
		data : formParams,
		dataType : 'json',
		success : function(data) {
			if (data) {
				alert('保存成功！');
				// 重新加载教育经历列表
				requestResumeEducation($resumeId);
			}
		},
		error : function() {
			alert('服务器异常，更新失败！');
		}
	})
}

/**
 * 更新教育经历
 * 
 * @param formParams
 */
function updateResumeEdu(formParams) {
	var $resumeId = $('#baseForm input[name=id]').val();
	formParams.resumeId = $resumeId;
	// 提交请求
	$.ajax({
		method : 'post',
		url : 'resume/education/update',
		data : formParams,
		dataType : 'json',
		success : function(data) {
			if (data) {
				alert('保存成功！');
				// 重新加载教育经历列表
				requestResumeEducation($resumeId);
			}
		},
		error : function() {
			alert('服务器异常，更新失败！');
		}
	})
}


/**
 * 清空
 */

function clearEduForm(){
	$('#eduForm input[name=startTime]').val('');
	$('#eduForm input[name=endTime]').val('');
	$('#eduForm input[name=schoolName]').val('');
	$('#eduForm input[name=major]').val('');
	$('#eduForm input[name=degree]').val('');
	$('#eduForm .hide input[name=id]').val('');
}

/**
 * 将行数据加载到教育经历表单中
 */
function loadTrToEduForm(that) {
	var $tdArr = that.parent().siblings();
	console.log($tdArr.eq(6).text());
	$('#eduForm input[name=startTime]').val($tdArr.eq(1).text());
	$('#eduForm input[name=endTime]').val($tdArr.eq(2).text());
	$('#eduForm input[name=schoolName]').val($tdArr.eq(3).text());
	$('#eduForm input[name=major]').val($tdArr.eq(4).text());
	$('#eduForm input[name=degree]').val($tdArr.eq(5).text());
	$('#eduForm .hide input[name=id]').val($tdArr.eq(6).text());
}