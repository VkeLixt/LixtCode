$(function() {

	// 导入tools.js
	$.getScript("js/tools.js");

	
	// 根据id请求招聘计划数据
	selectRecruitmentPlan();
	
	
	// 请求招聘计划数据
	loadPlanList();

});


/**
 * 请求计划列表，加载下拉列表
 */

function loadPlanList(){
	//请求计划列表
	
	$.ajax({
		url:'recruit/listWithNoPost',
		success:function(data){
			//先清空select下拉列表
			$('select').html('');
			//如果有招聘计划
			if(data){
				$('select').append(fillSelect(data));
				//加载第一条计划
				getRecruitmentPlanById($('select').val(),1);
			}else{
				//如果没有招聘计划
				$('select').append(
						$('<option selected>-----请选择招聘计划-----</option>'));
			}
		}
	})
	
}


/**
 * 选择计划
 */
function selectRecruitmentPlan() {
	$('select').unbind().change(function() {
			getRecruitmentPlanById($(this).val(), 1);
	});
}

/**
 * 根据id查询招聘计划
 */
function getRecruitmentPlanById(id,pageIndex) {
	$.ajax({
		url : 'recruit/'+ id,
		data:{
			pageIndex:pageIndex
		},
		success : function(pageModel) {
			if (pageModel) {
				// 请求成功，填充岗位数据
				fillPlanAndPost(pageModel);
			}
		}
	});
}



/**
 * 填充计划栏
 * 
 * @param data
 * @returns
 */
function fillSelect(data) {
	var $optionArr = new Array();
	// 遍历计划数组
	$.each(data,//
	function(index, plan) {
		var $option;
		if (index == 0) {
			$option = $('<option selected value=' + plan.id + '>' + plan.name
					+ '</option>')
		} else {
			$option = $('<option value=' + plan.id + '>' + plan.name
					+ '</option>')
		}
		$optionArr.push($option);
	});
	return $optionArr;
}

/**
 * 填充计划和岗位等信息
 * 
 * @param pageModel
 */
function fillPlanAndPost(pageModel) {
	// 先清空列表
	$('tbody').html('');
	// 填充数据
	var $data = pageModel.list;
	$index = 0;// 声明全局变量，保存记录索引
	for (var i = 0; i < $data.length; i++) {
		var $combo = $data[i];
		// 填充数据栏
		$('tbody').append(fillData($combo));
	}
	// 清空分页栏
	$('#pagination').html('');
	// 加载分页栏
	fillPage(pageModel);
	
	applyRecruitment();
}

/**
 * 填充数据栏
 * 
 * @param list
 * @returns
 */
function fillData(combo) {
	var $comboPost = combo.post;
	var $comPlan = combo.recruitmentPlan;
	var $tr = $('<tr>');
	var $td = $('<td>' + ($index + 1) + '</td>');
	var $td1 = $('<td><a href="#">申请职位</a></td>');
	var $td2 = $('<td class="hide">'+ $comboPost.id+'</td>');
	var $td3 = $('<td>' + $comboPost.organization.name + '</td>');
	var $td4 = $('<td>' + $comboPost.name + '</td>');
	var $td5 = $('<td class="requirement" title="' + $comboPost.requirements
			+ '">' + $comboPost.requirements + '</td>');
	var $td6 = $('<td>'
			+ dateFormat(new Date($comPlan.startTime), 'yyyy-MM-dd') + '</td>');
	var $td7 = $('<td>' + dateFormat(new Date($comPlan.endTime), 'yyyy-MM-dd')
			+ '</td>');
	var $td8 = $('<td>' + $comboPost.resumeType.name + '</td>');
	var $td9 = $('<td class="requirement" title="' + $comPlan.remark + '">'
			+ $comPlan.remark + '</td>');
	$tr.append($td).append($td1).append($td2).append($td3).append($td4).append($td5)
			.append($td6).append($td7).append($td8).append($td9);
	$index++;
	return $tr;
}

/**
 * 填充分页栏
 * 
 * @param pageModel
 * @returns
 */
function fillPage(pageModel) {
	// 分页按钮栏
	var $ul = $('<ul class="pagination pagination-md col-sm-6" style="margin: 0;"></ul>');
	// 当前页
	var $pageIndex = pageModel.pageIndex;
	// 总页数
	var $totalSize = pageModel.totalSize;
	// 上页
	var $preIndex = $pageIndex - 1 > 0 ? ($pageIndex - 1) : 1;
	// 下页
	var $nextIndex = $pageIndex + 1 < $totalSize ? ($pageIndex + 1)
			: $totalSize;
	// li元素
	var $id = $('select').val();
	var $li1 = $('<li><a href="#" onclick="getRecruitmentPlanById(' + $id
			+ ',1)">首页</a></li>');
	var $li2 = $('<li><a href="#" onclick="getRecruitmentPlanById(' + $id + ','
			+ $preIndex + ')">&laquo;</a></li>');
	var $li3 = $('<li><a href="#" onclick="getRecruitmentPlanById(' + $id
			+ ',1)">1</a></li>');
	var $li4 = $('<li><a href="#" onclick="getRecruitmentPlanById(' + $id
			+ ',2)">2</a></li>');
	var $li5 = $('<li><a href="#" onclick="getRecruitmentPlanById(' + $id
			+ ',3)">3</a></li>');
	var $li6 = $('<li><a href="#" onclick="getRecruitmentPlanById(' + $id + ','
			+ $nextIndex + ')">&raquo;</a></li>');
	var $li7 = $('<li><a href="#" onclick="getRecruitmentPlanById(' + $id + ','
			+ $totalSize + ')">尾页</a></li>');
	$ul.append($li1).append($li2).append($li3).append($li4).append($li5)
			.append($li6).append($li7);
	// 分页信息栏
	var $div = $('<div class="col-sm-6 pull-right"></div>');
	var $toRecord = pageModel.pageSize * $pageIndex;
	var $desc = '每页显示 '
			+ pageModel.pageSize
			+ ' 条记录, Page '
			+ $pageIndex
			+ ' of '
			+ $totalSize
			+ ', Displaying '
			+ (pageModel.firstLimitParam + 1)
			+ ' to '
			+ ($toRecord >= pageModel.recordCount ? pageModel.recordCount
					: $toRecord) + ' of ' + pageModel.recordCount + ' items.';
	$div.text($desc);
	// 整合分页栏
	$('#pagination').append($ul).append($div);
}



//申请职位事件
function applyRecruitment(){
	$('#main a').unbind().click(function(e){
		e.preventDefault();
		//请求判断当前用户是否含有简历
		containsResume($(this));
	});
}


function containsResume(that){
	$.get('recruit/'+$('#userId').text()+'/checkResume',function(data){
		if(data.status){
			isPostApplied(that);
		}else{
			if(confirm('您还没有简历，是否前往创建？')){
				getHtml('newResume');
			}
		}
	});
}

//判断简历是否已投递
function isPostApplied(that){
	$.get('recruit/'+$('#userId').text()+'/isApplied',function(data){
		
		if(data.status){
			alert('简历不可重复投递');
		}else{
			var $postId = that.parent().siblings().eq(1).text();
			var $resumeType = that.parent().siblings().eq(7).text();
			setPostIdToResumeBase(data.resumeId,$postId,$resumeType);
		}
	});
}

//未投递过简历，将岗位id和简历类型更新到基本信息表中
function setPostIdToResumeBase(resumeId,postId,resumeType){
	$.ajax({
		method:'post',
		url:'resume/base/update',
		data:{
			id : resumeId,
			postId : postId,
			resumeTypeDesc : resumeType
		},
		success:function(data){
			if(data){
				alert('投递成功，请前往已投递页面查看...');
			}
		},
		error : function(){
			alert('服务器异常，请联系管理员...');
		}
	});
}











