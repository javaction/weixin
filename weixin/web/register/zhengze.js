/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//将form中的值转换为键值对。
function getFormJson(form) {
    var o = {};
    var a = $('#'+form).serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });

    return o;
}

//jquery讀取json文件數據 。//此方法可以读取数据，你再自己写校验的方法。 ///我这里直接给提交按钮加的onclick事件，
$(function(){

    $("#btnn").click(function(){
        $.getJSON("zhengze.json",function(data){
            var s; //存储数据的变量
            alert("zhuce.....");
            $.each(data, function(infoIndex,info){
                s += "姓名："+info["name"];
                s += "性别："+info["sex"];
                s += "邮箱："+info["email"];
                s += "<hr>"
                            
            })
            
            //            $.each(data, function(infoIndex,info){
            //                s += "姓名："+info["username"];
            //                s += "性别："+info["password"];
            //                //  s += "邮箱："+info["email"];
            //                s += "<hr>"
            //                
            //            })
            
            alert(s);
        })
        
    })
    
});




//保存注册信息,目前不能写入
function saveFormJson(){
    var dataStr = getFormJson("my-form"); 
    
    var data = JSON.stringify(dataStr);  // 示例:{"username":"admin12","password":"Asd123"}
    alert("--dataStr:"+data);
//     var data = $("#my-form").serializeArray(); //自动将form表单封装成json  
//     alert(JSON.stringify(data));  
//     var jsonuserinfo = $('#my-form').serializeObject();  
//     alert(JSON.stringify(jsonuserinfo)); 
    
//    var zheng , ze;
//    try{
//        // alert("-----"+data)
//        //  zheng = new ActiveXObject("Scripting.FileSystemObject");
//        zheng = new ActiveXObject("Scripting.FileSystemObject");
//        alert("********123123*");
//        //        ze = zheng.OpenTextFile("D:\\mytestgit\\weixin\\weixin\\web\\register\\zhengze.json",8,true);  //測試寫入
//        ze = zheng.CreateTextFile("D:\\mytestgit\\weixin\\weixin\\web\\register\\zhengze.json",2,true);  //測試寫入
//        ze.WriteLine(data);
//    //        ze.close();    
//    }catch(err){
//        alert("错误。");
//    }finally{        
//    //  ze.Close();
//    }
//
//    var fso, tf; 
//    fso = new ActiveXObject("Scripting.FileSystemObject"); 
//    // 创建新文件 
//    tf = fso.CreateTextFile("c:\\testfile.txt", true); 

    
}

//測試，，這個不可以寫入
//function saveFormJson() {
////    var id = $('#testText1')[0].value;
////    var name = $('#testText2')[0].value;
//     var id = "123";
//    var name = "456";
//    var str = '{mydata:[' + '{id:' + id + ',name:' + name + '}' + ']}';
// 
//    str = "{MyData:[{id:'" + id + "',name:'" + name + "'}]}";
// 
//    //var json = eval('(' + str + ')');
// 
//    var fso, tf;
//    try{
//        fso = new ActiveXObject("Scripting.FileSystemObject");
////        tf = fso.CreateTextFile("F:\\BaiduYun\\MyHtml\\DB_USER.json", true);
//        tf = fso.CreateTextFile("D:\\mytestgit\\weixin\\weixin\\web\\register\\zhengze1.json", true);
//        tf.WriteLine(str);
//    }catch(err){
// 
// 
//    }finally{
//        //tf.Close();
//    }
//}



//--------------华丽丽的分割线---------------------
/**
 * 点击登陆按钮，实现校验，登陆
 * 注意：读取的json数据需要是数组形式的json格式数据，即需要带‘[]’
 * 很久不写function,我写的不一定规范，作为参考吧
 */
$(function(){ 
    $("#loginBtn").click(function(){
        $.getJSON("action.json",function(data){
            var uname,upass; 
            $.each(data, function(infoIndex,info){
                uname = info["username"];
                upass = info["password"];

            })
            //            s = uname +"----"+ upass;
            
            //获取form中写入的信息
            var $uname = $("#username").val();
            var $pass = $("#pass").val();
            
            // alert($uname+"-------"+$pass); 
            if(uname == $uname&&upass==$pass){
                //   window.location.href='http://www.baidu.com';
                window.location.href='success.html';
            }else{
                alert("账户或密码错误");
                
            }
            
            
            
        })
        
    })
    
});



//////
////没测试，传入的是什么
function searchSingle(){
    
    var data = '';
    var arr = [];
    if(!data){//无数据
        return arr;
    }else if(data.length == undefined){//有一条json格式的数据
        arr.push(data);
        return arr;
    }
    return data;
}