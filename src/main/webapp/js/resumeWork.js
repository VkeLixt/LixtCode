$(function(){
	workHandler();
});


//根据基本信息id，请求用户简历工作经历

function requestResumeWork(resumeId){
	$.get('resume/'+ resumeId +'/work',function(data){
		if(data){
			//填充简历工作经历
			fillResumeWorkList(data);
		}
	});
}


function fillResumeWorkList(workData){
	//清空
	$('#workTbody').html('');
	//填充
	$.each(workData,function(index,resumeWork){
		$('#workTbody').append(fillResumeWork(resumeWork));
	});
	/**
	 * 清楚列表
	 */
	clearWorkForm();
	/**
	 * 编辑
	 */
	editWorkForm();
	/**
	 * 复选框事件
	 */
	workTbody();
	workThead();
}


/**
 * 填充工作经历数据
 * 
 */

function fillResumeWork(resumeWork){
	var $tr = $('<tr></tr>');
	var $td1 = $('<td style="text-align:center;"><input type="checkbox"/></td>');
	var $td2 = $('<td>'+ dateFormat(new Date(resumeWork.startTime), 'yyyy-MM-dd') +'</td>');
	var $td3 = $('<td>'+ dateFormat(new Date(resumeWork.endTime), 'yyyy-MM-dd')+'</td>');
	var $td4 = $('<td>'+ resumeWork.unitName + '</td>');
	var $td5 = $('<td>'+ resumeWork.position + '</td>');
	var $td6 = $('<td><a href="#">编辑</a></td>');
	var $td7 = $('<td class="hide">' + resumeWork.id + '</td>');
	return $tr.append($td1).append($td2).append($td3).append($td4).append($td5).append($td6).append($td7);
}


/**
 * 更新删除事件
 */

function workHandler(){
	
	
	/**
	 * 保存事件
	 */
	saveWorkForm();
	/**
	 * 删除事件
	 */
	deleteWorkForm();
	
	
}


/**
 * 保存
 */
function saveWorkForm(){
	$('#savaWork').unbind().click(function(){
		var $formParams = getParams($('#workForm').serializeArray());
		if($('#workForm .hide input[name=id]').val()){
			if(confirm("是否更新...")){
				updateResumeWork($formParams);
			}
		}else{
			if(confirm("是否添加...")){
				addResumeWork($formParams);
			}
		}
	});
}

/**
 * 添加工作简历
 */
function addResumeWork(formParams){
	var $resumeId = $('#baseForm input[name=id]').val();
	formParams.resumeId = $resumeId;
	//提交add请求
	$.ajax({
		method:'post',
		url : 'resume/work/save',
		data: formParams,
		dataType:'json',
		success : function(data){
			if(data){
				alert("添加成功！");
				
				//加载列表
				requestResumeWork($resumeId);
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

function updateResumeWork(formResumeWork){
	var $resumeId = $('#baseForm input[name=id]').val();
	formResumeWork.resumeId = $resumeId;
	//提交事件
	$.ajax({
		method:'post',
		url:'resume/work/update',
		data:formResumeWork,
		dataType:'json',
		success:function(data){
			alert("更新成功！");
					
			requestResumeWork($resumeId);
		},
		error:function(){
			alert("服务器异常，更新失败！");
		}
	});
}

/**
 * 删除事件
 */


function deleteWorkForm(){
	$('#delWork').unbind().click(function(){
		if(workIsChooseAny()){
			deleteWorkHandler();
		}else{
			alert('你眼睛看哪里呢？选项还没有选中呢！白痴...')
		}
	});
}

function deleteWorkHandler(){
	$tdArr=[];
	$.each($('#workTbody input[type=checkbox]'),function(index,checkbox){
		if($(checkbox).is(':checked')){
			$tdArr.push($(checkbox).parent().siblings().eq(5).text());
		}
	});
	$.ajax({
		method:'post',
		url:'resume/work/delete',
		data:{
			ids:$tdArr
		},
		dataType:'json',
		success:function(data){
			if(data){
				var $resumeId = $('#baseForm input[name=id]').val();
				requestResumeWork($resumeId);
			}
		},
		error:function(){
			alert('他大爷的，服务器又出异常了......')
		}
	});
}

/**
 * 编辑事件
 */

function editWorkForm(){
	$('#workTbody a').unbind().click(function(e){
		e.preventDefault();
		//将数据显示到表单中
		showWorkFormList($(this));
	});
}

/**
 * 清空
 */

function clearWorkForm(){
	$('#workForm input[name=startTime]').val('');
	$('#workForm input[name=endTime]').val('');
	$('#workForm input[name=unitName]').val('');
	$('#workForm input[name=position]').val('');
	$('#workForm .hide input[name=id]').val('');
}

/**
 *表单显示数据
 */
function showWorkFormList(that){
	var $tdArray = that.parent().siblings();
	$('#workForm input[name=startTime]').val($tdArray.eq(1).text());
	$('#workForm input[name=endTime]').val($tdArray.eq(2).text());
	$('#workForm input[name=unitName]').val($tdArray.eq(3).text());
	$('#workForm input[name=position]').val($tdArray.eq(4).text());
	$('#workForm .hide input[name=id]').val($tdArray.eq(5).text());
}
/**
 * 判断复选框是否选中
 */
function workIsChooseAny(){
	var $count=0;
	$.each($('#workTbody input[type=checkbox]'),function(index,checkbox){
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
function workIsChooseAll(){
	var $row = $('#workTbody tr').length;
	var $count = 0;
	$.each($('#workTbody input[type=checkbox]'),function(index,checkbox){
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
function workThead(){
	$('#workThead input[type=checkbox]').eq(0).unbind().change(function(){
		if($(this).is(':checked')){
			$('#workTbody input[type=checkbox]').prop('checked',true);
		}else{
			$('#workTbody input[type=checkbox]').prop('checked',false);
		}
		
	});
}
/**
 * 判断数据行是否全选
 */

function workTbody(){
	$('#workTbody input[type=checkbox]').unbind().change(function(){
		if(workIsChooseAll()){
			$('#workThead input[type=checkbox]').eq(0).prop('checked',true);
		}else{
			$('#workThead input[type=checkbox]').eq(0).prop('checked',false);
		}
		
	});
}

