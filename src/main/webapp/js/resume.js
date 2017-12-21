$(function() {
	//请求用户ID
	getSessionUserId();
	
});

function getSessionUserId(){
	$.get('main/getSession',function(data){
		$('input[type=hidden').val(data.id);
		//加载简历列表
		loadRow();
	})
}

//根据ID加载简历
function loadRow(){
	var $userId = $('input[type=hidden').val();
	$.get('resume/'+ $userId + '/show',function(data){
		if(data){
			//填充列表数据
			fillList(data);
			//绑定操作按钮
			handlerBind();
		}else{
			if(confirm('当前没有简历可查看，是否需要创建？')){
			$('#main').html(getHtml('newResume'));
		}
		}
	});
};



function fillList(data){
	//清空列表数据
	$('tbody').html('');
	//添加数据
	$('tbody').append(fillData(data));
};


	
/**
 * 填充数据
 * 
 */


function fillData(resumeBase){
	var $tr=$('<tr></tr>');
	var $td1=$('<td class="hide">'+ resumeBase.id +'</td>');
	var $td2=$('<td>'+ resumeBase.name +'</td>');
	var $gender = resumeBase.gender == '1'?'男':'女';
	var $td3=$('<td>'+ $gender +'</td>');
	var $td4=$('<td>'+ resumeBase.resumeTypeDesc +'</td>');
	var $td5=$('<td><a href="#" class = "btn btn-default">查看简历</a>&emsp;<a href="#" class = "btn btn-success">编辑简历</a></td>');
	
	return $tr.append($td1).append($td2).append($td3).append($td4).append($td5);
	
};


//按钮绑定

function handlerBind(){
	$('.btn-default').unbind().click(function(){
		$('#main').html(function(){
			$('#main').html(getHtml('seeResume'));
		});
	});
	$('.btn-success').unbind().click(function(){
		$('#main').html(getHtml('newResume'));
	});
};