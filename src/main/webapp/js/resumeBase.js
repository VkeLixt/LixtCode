$(function(){
	//保存基本信息事件
	saveBaseFunc();
});


//请求简历基本信息

function requestResumeBase(){
	var $userId = $('#baseForm .hide input[name=userId]').val();
	$.get('resume/'+ $userId +'/base',function(data){
		if(data){
			//填充基本信息表单
			fillBaseForm(data);
			//根据基本信息id，请求用户简历教育经历
			requestResumeEducation(data.id);
			//根据基本信息id，请求用户简历工作经历
			requestResumeWork(data.id);
			//根据基本信息id，请求家庭成员及主要社会关系信息
			requestResumeHome(data.id);
		}
	});
}

function fillBaseForm(baseData){
	//ID
	$('#baseForm input[name=id]').val(baseData.id);
	//userId
	$('#baseForm input[name=userId]').val(baseData.userId);
	//name
	$('#baseForm input[name=name]').val(baseData.name);
	//sex
	$('#baseForm input[name=gender]').removeAttr('checked');
	$('#baseForm input[name=gender][value='+ baseData.gender +']').attr('checked',true);
	
	//birthday
	$('#baseForm input[name=birthday]').val(dateFormat(new Date(baseData.birthday), 'yyyy-MM-dd'));
	//民族
	$('#baseForm input[name=race').val(baseData.race);
	// 出生地
	$('#baseForm input[name=nativePlace]').val(baseData.nativePlace);
	// 籍贯
	$('#baseForm input[name=origin]').val(baseData.origin);
	// 国籍
	$('#baseForm input[name=nationality]').val(baseData.nationality);
	// 户口所在地
	$('#baseForm input[name=permanentAddress]').val(baseData.permanentAddress);
	// 身高
	$('#baseForm input[name=height]').val(baseData.height);
	// 生源地
	$('#baseForm input[name=sourcePlace]').val(baseData.sourcePlace);
	// 政治面貌
	$('#baseForm select[name=party]').val(baseData.party);
	// 入党时间
	$('#baseForm input[name=timeToJoinParty]').val(
			dateFormat(new Date(baseData.timeToJoinParty), 'yyyy-MM-dd'));
	// 最高学历
	$('#baseForm select[name=highestEducation]').val(baseData.highestEducation);
	// 最高学位
	$('#baseForm input[name=highestDegree]').val(baseData.highestDegree);
	// 毕业学校
	$('#baseForm input[name=educationSchool]').val(baseData.educationSchool);
	// 专业
	$('#baseForm input[name=major]').val(baseData.major);
	// 现工作单位
	$('#baseForm input[name=currEmployer]').val(baseData.currEmployer);
	// 职务
	$('#baseForm input[name=position]').val(baseData.position);
	// 参加工作时间
	$('#baseForm input[name=timeToStartWork]').val(
			dateFormat(new Date(baseData.timeToStartWork), 'yyyy-MM-dd'));
	// 计算机水平证书
	$('#baseForm select[name=computerCertificate]').val(
			baseData.computerCertificate);
	// 专业技术资格
	$('#baseForm input[name=professionalQualification]').val(
			baseData.professionalQualification);
	// 专业特长
	$('#baseForm input[name=professionalSpeciality]').val(
			baseData.professionalSpeciality);
	// 外语语种
	$('#baseForm input[name=foreignLanguages]').val(baseData.foreignLanguages);
	// 外语水平证书
	$('#baseForm select[name=foreignLanguagesCertificate]').val(
			baseData.foreignLanguagesCertificate);
	// 身份证号
	$('#baseForm input[name=cardId]').val(baseData.cardId);
	// 家庭住址
	$('#baseForm input[name=residenceAddress]').val(baseData.residenceAddress);
	// 手机号码
	$('#baseForm input[name=phone]').val(baseData.phone);
	// 电子邮箱
	$('#baseForm input[name=email]').val(baseData.email);
	// 婚姻状况
	$('#baseForm input[name=marriage]').removeAttr('checked');
	$('#baseForm input[name=marriage][value=' + baseData.marriage + ']').attr(
			'checked', true);
	// 奖励及年度考核情况
	$('#baseForm textarea[name=remark]').val(baseData.remark);
	// 是否有亲属在本行工作
	$('#baseForm input[name=isKinWorkHere]').removeAttr('checked');
	$('#baseForm input[name=isKinWorkHere][value='
					+ baseData.isKinWorkHere + ']').attr('checked', true);
	
}


//保存基本信息
function saveBaseFunc(){
	$('#saveBase').click(function(){
		//获取简历基本信息栏数据
		var $formParams = getParams($('#baseForm').serializeArray());
		if($('#baseForm input[name=id]').val()){
			if(confirm("是否更新？")){
				//更新操作
				updateResumeBase($formParams);
			}
		}else{
			if(confirm('是否增加？')){
				addResumeBase($formParams);
			}
		}
	});
}


//添加基本信息
function addResumeBase(formParams){
	//ajax提交
	$.ajax({
		method:'post',
		url:'resume/base/save',
		data:formParams,
		dataType:'json',
		success:function(data){
			if(data){
				alert('保存成功');
			}
		},
		error:function(){
			alert('服务器异常，更新失败');
		}
	})		
}

//更新基本信息
function updateResumeBase(formParams){
	//ajax提交
	$.ajax({
		method:'post',
		url:'resume/base/update',
		data:formParams,
		dataType:'json',
		success:function(data){
			if(data){
				alert('更新成功');
			}
		},
		error:function(){
			alert('服务器异常，更新失败')
		}
	})
}