$(function(){
	var i = 0;
        var table = document.getElementById('table1');
        table.oncontextmenu = function ()
        {
            return false;
        }
	//test();
	//$(".tree").find("a").bind("rightclick",function(){
	//	test(this);
		//test2(this); // 正确
	//});
	$(".tree").find("a").each(function(){
//		this.oncontextmenu = function ()
//        {
//            return false;
//        }
		test(this);
	});
	var isHidden = $("#myMenu1").is(":hidden");
	if(!isHidden){
		var left = $("#myMenu1").css("left");
		alert(left);
	}
});
function test2(obj){
	alert($(obj).attr("href"));
}

function test(obj){
	$(obj).contextMenu('myMenu1', {
		/*menuStyle: {

	        border: '2px solid #000'

	      },

	      itemStyle: {

	        fontFamily : 'verdana',

	        backgroundColor : '#666',

	        color: 'white',

	        border: 'none',

	        padding: '1px'

	      },

	      itemHoverStyle: {

	        color: '#fff',

	        backgroundColor: '#0f0',

	        border: 'none'

	      },*/
    bindings: {

      'open': function(t) {

        alert('Trigger was '+t.id+'\nAction was Open');

      },

      'email': function(t) {

        alert('Trigger was '+t.id+'\nAction was Email');

      },

      'save': function(t) {

        alert('Trigger was '+t.id+'\nAction was Save');

      },

      'delete': function(t) {

        alert('Trigger was '+t.id+'\nAction was Delete');

      }

    }

  });
	
	/*if(i==0){
		var id = $("#open").closest("div").css("left");
		alert(id);
	}
	i++;*/
	
}