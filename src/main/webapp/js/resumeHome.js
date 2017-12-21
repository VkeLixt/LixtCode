$(function() {
	// 保存和删除教育经历事件
	homeHandler();
});


function requestResumeHome(resumeId){
	$.get('resume/'+resumeId+'/home',function(data){
		if(data){
			//填充列表
			fillHomeList(data);
		}
	});
}

//填充事件
function fillHomeList(data){
	$('#homeTbody').html('');
	$.each(data,function(index,resumeHome){
		$('#homeTbody').append(fillHomeData(resumeHome));
	});
	
	editHome();
	
	clearHomeForm();
	
	homeTbody();
	
	homeThead();
}

/**
 * 填充数据
 */

function fillHomeData(homeData){
	var $tr = $('<tr></tr>');
	var $td1 = $('<td style="text-align: center;"><input type="checkbox" /></td>');
	var $td2 = $('<td>' + homeData.appellation+ '</td>');
	var $td3 = $('<td>' + homeData.name + '</td>');
	var $td4 = $('<td>' + homeData.party+ '</td>');
	var $td5 = $('<td>' + homeData.nationality + '</td>');
	var $td6 = $('<td>' + dateFormat(new Date(homeData.birthday), 'yyyy-MM-dd')+ '</td>');
	var $td7 = $('<td>' + homeData.workUnitPosition+'</td>');
	var $td8 = $('<td><a href="#">编辑</a></td>');
	var $td9 = $('<td class="hide">' + homeData.id + '</td>');
	return $tr.append($td1).append($td2).append($td3).append($td4).append($td5)
			.append($td6).append($td7).append($td8).append($td9);
}


/**
 *编辑事件
 */
function editHome() {
	$('#homeTbody a').unbind().click(function(e) {
		e.preventDefault();
		// 将行数据加载到表单中
		showHomeDateList($(this));
	});
}

/**
 * 加载数据行
 */
function showHomeDateList(that) {
	var $tdArr = that.parent().siblings();
	$('#homeForm input[name=appellation]').val($tdArr.eq(1).text());
	$('#homeForm input[name=name]').val($tdArr.eq(2).text());
	$('#homeForm select[name=party]').val($tdArr.eq(3).text());
	$('#homeForm input[name=nationality]').val($tdArr.eq(4).text());
	$('#homeForm input[name=birthday]').val($tdArr.eq(5).text());
	$('#homeForm textarea[name=workUnitPosition').val($tdArr.eq(6).text());
	$('#homeForm .hide input[name=id]').val($tdArr.eq(7).text());
}

/**
 * 清空
 */

function clearHomeForm(){
	$('#homeForm input[name=appellation]').val('');
	$('#homeForm input[name=name]').val('');
	$('#homeForm select[name=party]').val('---请选择---');
	$('#homeForm input[name=nationality]').val('');
	$('#homeForm input[name=birthday').val('');
	$('#homeForm textarea[name=workUnitPosition').val('');
	$('#homeForm .hide input[name=id]').val('');
}

/**
 * 
 * 更新删除事件
 * 
 */
function homeHandler(){
	//更新
	saveHomeForm();
	//删除
	deleteHomeForm();
}

//添加事件
function saveHomeForm(){
	$('#saveHome').unbind().click(function() {
		// 获取简历基本信息栏数据
		var $formParams = getParams($('#homeForm').serializeArray());
		if ($('#homeForm .hide input[name=id]').val()) {
			if (confirm('确认更新吗？')) {
				// 存在保存按钮实现更新操作
				updateResumeHome($formParams);
			}
		} else {
			if (confirm('确认新增吗？')){
				// 不存在保存按钮实现添加操作
				addResumeHome($formParams);
				
			}
		}
	});
}

/**
 * 添加事件
 */
function addResumeHome(formParams){
	var $resumeId = $('#baseForm input[name=id]').val();
	formParams.resumeId = $resumeId;
	//提交add请求
	$.ajax({
		method:'post',
		url : 'resume/home/save',
		data: formParams,
		dataType:'json',
		success : function(data){
			if(data){
				alert("添加成功！");
				
				//加载列表
				requestResumeHome($resumeId);
			}
		},
		error:function(){
			alert("服务器异常，添加失败！")
		}
	});
}

/**
 * 更新事件
 */

function updateResumeHome(formResumehome){
	var $resumeId = $('#baseForm input[name=id]').val();
	formResumehome.resumeId = $resumeId;
	//提交事件
	$.ajax({
		method:'post',
		url:'resume/home/update',
		data:formResumehome,
		dataType:'json',
		success:function(data){
			alert("更新成功！");
					
			requestResumeHome($resumeId);
		},
		error:function(){
			alert("服务器异常，更新失败！");
		}
	});
}

/**
 * 删除事件
 */


function deleteHomeForm(){
	$('#delHome').unbind().click(function(){
		if(homeIsChooseAny()){
			deleteHomeHandler();
		}else{
			alert('你眼睛看哪里呢？选项还没有选呢！白痴...');
		}
	});
}


function deleteHomeHandler(){
	var $tdArr = [];
	$.each($('#homeTbody input[type=checkbox]'),function(index,checkbox){
		if($(checkbox).is(':checked')){
			$tdArr.push($(checkbox).parent().siblings().eq(7).text());
		}
	});
	$.ajax({
		method:'post',
		url:'resume/home/delete',
		data:{
			ids:$tdArr
		},
		dataType:'json',
		success : function(data){
			if(data){
				var $resumeId = $('#baseForm input[name=id]').val();
				requestResumeHome($resumeId);
			}
		},
		error:function(){
			alert('他大爷的，服务器又出异常了0......')
		}
	});
}

/**
 * 判断复选框是否选中
 */
function homeIsChooseAny(){
	var $count=0;
	$.each($('#homeTbody input[type=checkbox]'),function(index,checkbox){
		if($(checkbox).is(':checked')){
			$count++;
		}
	});
	if($count>0){
		return true;
	}else{
		return false;
	}
}

/**
 * 判断是否全选
 */
function homeIsChooseAll(){
	var $row = $('#homeTbody tr').length;
	var $count = 0;
	$.each($('#homeTbody input[type=checkbox]'),function(index,checkbox){
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
 * 判断标题是否选中
 */
function homeThead(){
	$('#homeThead input[type=checkbox]').eq(0).unbind().change(function(){
		if($(this).is(':checked')){
			$('#homeTbody input[type=checkbox]').prop('checked',true);
		}else{
			$('#homeTbody input[type=checkbox]').prop('checked',false);
		}
		
	});
}
/**
 * 判断数据行是否全选
 */

function homeTbody(){
	$('#homeTbody input[type=checkbox]').unbind().change(function(){
		if(homeIsChooseAll()){
			$('#homeThead input[type=checkbox]').eq(0).prop('checked',true);
		}else{
			$('#homeThead input[type=checkbox]').eq(0).prop('checked',false);
		}
		
	});
}
