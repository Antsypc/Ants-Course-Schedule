(function($) {

  'use strict';

  // 随机打散数组
  // https://css-tricks.com/snippets/javascript/shuffle-array
  function Shuffle(o) {
    for(var j, x, i = o.length; i; j = parseInt(Math.random() * i), x = o[--i], o[i] = o[j], o[j] = x);
    return o;
  }

  var backgrounds = [
    '/course/assets/img/backgrounds/3c9bcbc0-15dc-4a6f-a81f-5112936b7773.jpg',
    '/course/assets/img/backgrounds/5aad72f4-a78e-433a-815b-3a991794f4ba.jpg',
    '/course/assets/img/backgrounds/5e52f416-c95f-4752-85a3-256576d53bdc.jpg',
    '/course/assets/img/backgrounds/7e13fd5c-e8dc-47aa-925c-20a05c994cec.jpg',
    '/course/assets/img/backgrounds/84701384-aeb5-4d57-b0bd-821bbd3627d6.jpg',
    '/course/assets/img/backgrounds/99f56952-bef9-47f5-a513-f470911e7f49.jpg',
    '/course/assets/img/backgrounds/9b8b99ae-44d9-4db1-82fe-dab028dc730c.jpg',
    '/course/assets/img/backgrounds/9b8e717d-9795-4d54-b687-931aea15afb6.jpg',
    '/course/assets/img/backgrounds/a8f69aba-9700-4c81-88e2-6aee3d36f8f9.jpg',
    '/course/assets/img/backgrounds/d58141c9-9a0c-40b0-a408-5935fd70670f.jpg',
    '/course/assets/img/backgrounds/f821122b-3926-4780-825f-70fb947e3220.jpg',
    '/course/assets/img/backgrounds/fb78318a-d895-418f-ad80-172bbafc35e0.jpg'
  ];
  Shuffle(backgrounds);
  $.backstretch(backgrounds, {
    duration: 12000,
    fade: 750
  });

  var alertTemplate = $("#errormsg-template").html();
  function show_errormsg(msg, title, allowHTML) {
    var $alert = $(".alert");
    var isNew = false;
    title = title || "登录失败";

    if(!$alert.length) {
      isNew = true;
      $alert = $(alertTemplate);
    }

    if(allowHTML) {
      $alert.find("> h4").html(title);
      $alert.find("> .errormsg").html(msg);
    } else {
      $alert.find("> h4").text(title);
      $alert.find("> .errormsg").text(msg);
    }
    $alert.show();

    if(isNew) $alert.prependTo("form .errorbox");
  }
  function hide_errormsg() {
    $(".alert").remove();
  }

  // 从 URL 获取错误消息并显示
  var msg = location.search.match(/msg=([^&]+)/);
  if(msg) {
    msg = decodeURIComponent(msg[1]);
    var _title = location.search.match(/msgtitle=([^&]+)/);
    show_errormsg(msg, _title && decodeURIComponent(_title[1]));
  }

  // 登录前验证
  $('form').on('submit', function() {
    var $this = $(this);
    var $username = $this.find('input[name=username]');
    var $password = $this.find('input[name=password]');

    if(!$username.val()) return show_errormsg("用户名不能为空"), $username.focus(), false;
    if(!$password.val()) return show_errormsg("密码不能为空"), $password.focus(), false;

    hide_errormsg();
  });

})(jQuery);
