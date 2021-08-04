/**
 @Name：用户登入和注册等
 */

layui.use(['form'], function(){
  var $ = layui.$
  ,layer = layui.layer
  ,form = layui.form;

   var $body = $('body');

    //更换图形验证码
    $body.on('click', '#LAY-user-get-vercode', function(){
        var othis = $(this);
        this.src = 'https://www.oschina.net/action/user/captcha?t='+ new Date().getTime()
    });

    //自定义验证
    form.verify({
        username: function(value, item){ //value：表单的值、item：表单的DOM对象
          if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
            return '用户名不能有特殊字符';
          }
          if(/(^\_)|(\__)|(\_+$)/.test(value)){
            return '用户名首尾不能出现下划线\'_\'';
          }
          if(/^\d+\d+\d$/.test(value)){
            return '用户名不能全为数字';
          }
        }
        //我们既支持上述函数式的方式，也支持下述数组的形式
        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
        ,password: [
          /^[\S]{6,12}$/
          ,'密码必须6到12位，且不能出现空格'
        ]
        ,vercode: function(value, item){
            var reg = /^[A-Za-z0-9]{4}$/;
            if(!reg.test(value)){
                return '验证码由4位字母或数字组成';
            }
        }
    });

    //监听提交
    form.on('submit(LAY-user-login-submit)', function(data){
        console.log(data.field)
        //请求成功后，写入 access_token
        $.ajax({
            url:"/user/login",
            data:data.field,
            type:"POST",
            dataType:"json",
            success:function (res){
                if(res.code == 501){
                    layer.msg(res.msg)
                }else if(res.code == 500){
                    layer.msg(res.msg)
                }else if(res.code == 200){
                    sessionStorage.setItem("user",JSON.stringify(res.data));
                    //登入成功的提示与跳转
                    layer.msg(res.msg, {
                        offset: '15px'
                        ,icon: 1
                        ,time: 1000
                    }, function(){
                        location.href = '/index.html'; //后台主页
                    });
                }
            }
        })

        return false;
    });

});
