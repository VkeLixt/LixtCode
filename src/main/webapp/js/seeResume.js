$(function(){
	$.getScript('js/tools.js');
	requestUser();
});

function requestUser(){
	// 请求session，获得当前用户
	$.get('main/getSession', function(data) {
		// 获取并保存用户id
		$('#baseForm .hide input[name=userId]').val(data.id);
		// 2.根据用户id，请求用户简历基本信息
		requestResume();
	});
}


function requestResume(){
	var $userId = $('#baseForm .hide input[name=userId]').val();
	$.get('look/'+$userId+'/showAllInfo',function(data){
		if(data){
			//显示基本信息数据
			showBaseInfo(data);
			//显示教育经历信息
			showEduInfo(data);
			//显示工作经历
			showWorkInfo(data);
			//显示HomeInfo
			showHomeInfo(data);
		}
	});
}

/**
 * 
 * @param data
 */
function showBaseInfo(data){
	//基本信息
	$('#baseForm input[name=id]').val(data.resumeBase.id);
	$('#baseForm #name').text(data.resumeBase.name);
	if(data.resumeBase.gender==1){
		$('#baseForm #gender').text('男');
	}else{
		$('#baseForm #gender').text('女');
	}
	$('#baseForm #birthday').text(dateFormat(new Date(data.resumeBase.birthday),'yyyy-MM-dd'));
	$('#baseForm #race').text(data.resumeBase.race);
	$('#baseForm #nativePlace').text(data.resumeBase.nativePlace);
	$('#baseForm #origin').text(data.resumeBase.origin);
	$('#baseForm #nationality').text(data.resumeBase.nationality);
	$('#baseForm #permanentAddress').text(data.resumeBase.permanentAddress);
	$('#baseForm #height').text(data.resumeBase.height);
	$('#baseForm #sourcePlace').text(data.resumeBase.sourcePlace);
	$('#baseForm #party').text(data.resumeBase.party);
	$('#baseForm #timeToJoinParty').text(dateFormat(new Date(data.resumeBase.timeToJoinParty),'yyyy-MM-dd'));
	$('#baseForm #highestEducation').text(data.resumeBase.highestEducation);
	$('#baseForm #highestDegree').text(data.resumeBase.highestDegree);
	$('#baseForm #educationSchool').text(data.resumeBase.educationSchool);
	$('#baseForm #major').text(data.resumeBase.major);
	$('#baseForm #currEmployer').text(data.resumeBase.currEmployer);
	$('#baseForm #position').text(data.resumeBase.position);
	$('#baseForm #timeToStartWork').text(dateFormat(new Date(data.resumeBase.timeToStartWork),'yyyy-MM-dd'));
	$('#baseForm #computerCertificate').text(data.resumeBase.computerCertificate);
	$('#baseForm #professionalQualification').text(data.resumeBase.professionalQualification);
	$('#baseForm #professionalSpeciality').text(data.resumeBase.professionalSpeciality);
	$('#baseForm #foreignLanguages').text(data.resumeBase.foreignLanguages);
	$('#baseForm #foreignLanguagesCertificate').text(data.resumeBase.foreignLanguagesCertificate);
	$('#baseForm #cardId').text(data.resumeBase.cardId);
	$('#baseForm #residenceAddress').text(data.resumeBase.residenceAddress);
	$('#baseForm #phone').text(data.resumeBase.phone);
	$('#baseForm #email').text(data.resumeBase.email);
	if(data.resumeBase.marriage==0){
		$('#baseForm #marriage').text('未婚');
		
	}else if(data.resumeBase.marriage==1){
		$('#baseForm #marriage').text('已婚');
		
	}else{
		$('#baseForm #marriage').text('离异');
	}
	$('#baseForm #remark').text(data.resumeBase.remark);
	if(data.resumeBase.isKinWorkHere==1){
		$('#baseForm #isKinWorkHere').text('有');
	}else{
		$('#baseForm #isKinWorkHere').text('无');
	}
}

function showEduInfo(data){
	$.each(data.resumeEdu,function(index,resumeEduInfo){
		$('#eduForm .table').append(
				"<tr>" +
					"<td class='hide'><input type='text' name='id'></td>" +
					"<td>开始时间：</td>" +
					"<td style='color:blue'>"+ dateFormat(new Date(resumeEduInfo.startTime),'yyyy-MM-dd')+"</td>" +
				"</tr><tr><td>结束时间：</td>" +
					"<td  style='color:blue'>"+ dateFormat(new Date(resumeEduInfo.endTime),'yyyy-MM-dd')+"</td>" +
				"</tr><tr><td>学校名称：" +
					"</td><td  style='color:blue'>"+resumeEduInfo.schoolName+"</td>" +
				"</tr><tr><td>所学专业：" +
						"</td><td  style='color:blue'>"+resumeEduInfo.major+"</td>" +
				"</tr><tr><td>所获学位：" +
						"</td><td  style='color:blue'>"+resumeEduInfo.degree+"</td><td></td></tr><tr><td><br></td></tr>");
	});
}


function showWorkInfo(data){
	$.each(data.resumeWork,function(index,resumeWorkInfo){
		$('#workForm .table').append(
				"<tr><td class='hide'><input type='text' name='id'></td>" +
				"<td>开始时间:</td><td style='color:blue'>"+dateFormat(new Date(resumeWorkInfo.startTime),'yyyy-MM-dd')+"</td></tr>" +
						"<tr><td>结束时间:</td><td style='color:blue'>"+dateFormat(new Date(resumeWorkInfo.endTime),'yyyy-MM-dd')+"</td></tr>" +
								"<tr><td>单位名称：</td><td style='color:blue'>"+resumeWorkInfo.unitName+"</td></tr>" +
										"<tr><td>职务：</td>	<td style='color:blue'>"+resumeWorkInfo.position+"</td></tr>"
		);
	});
}


function showHomeInfo(data){
	$.each(data.resumeHome,function(index,resumeHomeInfo){
		if(resumeHomeInfo.party=='---请选择---'){
			resumeHomeInfo.party='无';
		}
		$('#homeForm .table tbody').append(
				"<tr><td class='hide' id='id'></td><td><span>称谓:</span></td><td style='color:blue'>"+resumeHomeInfo.appellation+"</td></tr>" +
						"<tr><td><span>姓名:</span></td>	<td style='color:blue'>"+resumeHomeInfo.name+"</td></tr>" +
								"<tr><td><span>政治面貌:</span></td><td style='color:blue'>"+resumeHomeInfo.party+"</td></tr>" +
										"<tr><td><span>国籍:	</span></td><td style='color:blue'>"+resumeHomeInfo.nationality+"</td></tr>" +
												"<td><span> 出生年月:</span></td><td style='color:blue'>"+dateFormat(new Date(resumeHomeInfo.birthday),'yyyy-MM-dd')+"</td></tr>" +
														"<tr><td><span>工作单位及职务:</span></td><td style='color:blue'>"+resumeHomeInfo.workUnitPosition+"</td></tr>"
		);
	});
}

























