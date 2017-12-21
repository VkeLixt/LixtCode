/**
 * 整理form表单提交数据
 * 
 * @param paramArr
 * @returns {Object}
 */
function getParams(paramArr) {
	var $params = new Object();
	
	/**
	 * each 遍历
	 */
	$.each(paramArr, function(index, obj) {
		if (obj.value && obj.value != '') {
			$params[obj.name] = obj.value;
		}
	});
	return $params;
}

/**
 * 日期格式化
 * 
 * @param date
 * @param pattern
 * @returns {String}
 */
/*function dateFormat(date, pattern) {
	var $dateString;
	if (pattern == "yyyy-MM-dd") {
		$dateString = '' + date.getFullYear() + '-' + (date.getMonth() + 1)
				+ '-' + date.getDate();
	} else if (pattern == "yyyyMMdd") {
		$dateString = '' + date.getFullYear() + (date.getMonth() + 1)
				+ date.getDate();
	}
	return $dateString;
}*/

function dateFormat(date, pattern) {
	var $dateString;
	var $monthStr;
	if (date.getMonth() + 1 < 10) {
		$monthStr = '0' + (date.getMonth() + 1);
	} else {
		$monthStr = date.getMonth() + 1;
	}
	var $dateStr;
	if (date.getDate() < 10) {
		$dateStr = '0' + date.getDate();
	} else {
		$dateStr = date.getDate();
	}
	if (pattern == "yyyy-MM-dd") {
		$dateString = '' + date.getFullYear() + '-' + $monthStr + '-'
				+ $dateStr;
	} else if (pattern == "yyyyMMdd") {
		$dateString = '' + date.getFullYear() + $monthStr + $dateStr;
	}
	return $dateString;
}