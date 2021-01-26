// 生成树形结构的函数
function generateTree() {
	// 1.准备生成树形结构的JSON数据，数据的来源是发送Ajax请求得到
	$.ajax({
		"url": "menu/get/whole/tree.json",
		"type":"post",
		"dataType":"json",
		"success":function(response){
			var result = response.result;
			if(result == "SUCCESS") {
				
				// 2.创建JSON对象用于存储对zTree所做的设置
				var setting = {
					"view": {
						"addDiyDom": myAddDiyDom,
						"addHoverDom": myAddHoverDom,
						"removeHoverDom": myRemoveHoverDom
					},
					"data": {
						"key": {
							"url": "maomi"
						}
					}
				};
				
				// 3.从响应体中获取用来生成树形结构的JSON数据
				var zNodes = response.data;
				
				// 4.初始化树形结构
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			}
			
			if(result == "FAILED") {
				layer.msg(response.message);
			}
		}
	});
}

//