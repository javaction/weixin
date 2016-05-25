   // jQuery UI alert弹出提示
 function jqalert(text, title, fn) {
    var html =
    '<div class="dialog" id="dialog-message">' +
    '  <p>' +
    '    <span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 0 0;"></span>' + text +
    '  </p>' +
    '</div>';
    return $(html).dialog({
      //autoOpen: false,
      resizable: false,
      modal: true,
      show: {
        effect: 'fade',
        duration: 300
      },
      title: title || getLg("prompt", "BasicOperation"),
      open:dialogOpen,
      close: function() {
            $(this).dialog( "destroy" ).remove();
        },
      buttons: {
        Ok: function() {
          var dlg = $(this).dialog("close");
          fn && fn.call(dlg);
          $(this).dialog( "destroy" ).remove();
        }
      }      
    });
  }
   function jqMes(text, title) {
    var html =
    '<div class="dialog" id="dialog-confirm">' +
    '  <p>' +
    '    <span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 0 0;"></span>' + text +
    '  </p>' +
    '</div>';
    return $(html).dialog({
      //autoOpen: false,
      resizable: false,
      modal: true,
       hide:"slide",
      show: {
        effect: 'slide',
        duration: 300
      },
      width:500,
      title: title || getLg("prompt", "BasicOperation"),
      open:dialogOpen,
      close: function() {
            $(this).dialog( "destroy" ).remove();
        }      
    });
  }
  // jQuery UI confirm弹出确认提示
   function jqconfirm(text, title,fn1,fn2) {
    var html =
    '<div class="dialog" id="dialog-confirm">' +
    '  <p>' +
    '    <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>' + text +
    '  </p>' +
    '</div>';
    return $(html).dialog({
      //autoOpen: false,
      resizable: false,
      modal: true,
       hide:"slide",
      show: {
        effect: 'slide'//,
        //duration: 300
      },
      title: title ||  getLg("prompt", "BasicOperation"),
      open:dialogOpen,
       close: function() {
           var dlg = $(this).dialog("close");
            // fn2 && fn2(dlg, false);
            $(this).dialog( "destroy" ).remove();
        },
      buttons: {
        Ok: function() {
         var dlg = function(){}
         fn1 && fn1.call(dlg, true);
           $(this).dialog( "destroy" ).remove();
        },
        Cancel: function() {
              var dlg = function(){}
             fn2 && fn2.call(dlg, false);
           $(this).dialog( "destroy" ).remove();
        }
      }
    });
  }
  //2
    function jqconfirm2(text, title,fn1,fn2,fn3) {
    var html =
    '<div class="dialog" id="dialog-confirm">' +
    '  <p>' +
    '    <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>' + text +
    '  </p>' +
    '</div>';
    return $(html).dialog({
      //autoOpen: false,
      resizable: false,
      modal: true,
       hide:"slide",
      show: {
        effect: 'slide'
        //duration: 300
      },
      title: title ||  getLg("prompt", "BasicOperation"),
      open:dialogOpen,
       close: function() {
           var dlg = $(this).dialog("close");
             //fn2 && fn2(dlg, false);
            $(this).dialog( "destroy" ).remove();
        },
      buttons: {
        Yes: function() {
        var dlg = function(){}
         fn1 && fn1.call(dlg, true);
           $(this).dialog( "destroy" ).remove();
        },
        No: function() {
            var dlg = function(){}
             fn2 && fn2.call(dlg, true);
           $(this).dialog( "destroy" ).remove();
        },
        Cancel:function() {
             var dlg = function(){}
             fn3 && fn3.call(dlg, false);
           $(this).dialog( "destroy" ).remove();
        }
      }
    });
  }
  // jQuery UI alert弹出提示,一定间隔之后自动关闭
   function jqtimeralert(text, title, fn, timerMax) {
    var dd = $(
    '<div class="dialog" id="dialog-message">' +
    '  <p>' +
    '    <span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 0 0;"></span>' + text +
    '  </p>' +
    '</div>');
    dd[0].timerMax = timerMax || 3;
    return dd.dialog({
      //autoOpen: false,
      resizable: false,
      modal: true,
      show: {
        effect: 'fade',
        duration: 300
      },
      open: function(e, ui) {
        var me = this,
          dlg = $(this),
          btn = dlg.parent().find(".ui-button-text").text(getLg("affirm", "BasicOperation")+"(" + me.timerMax + ")");
        --me.timerMax;
        me.timer = window.setInterval(function() {
          btn.text(getLg("affirm", "BasicOperation")+"(" + me.timerMax + ")");
          if (me.timerMax-- <= 0) {
            dlg.dialog("close");
            fn && fn.call(dlg);
            window.clearInterval(me.timer); // 时间到了清除计时器
          }
        }, 1000);
      },
      title: title ||  getLg("prompt", "BasicOperation"),
      buttons: {
        Ok: function() {
          var dlg = $(this).dialog("close");
          fn && fn.call(dlg);
          window.clearInterval(this.timer); // 清除计时器
        }
      },
      close: function() {
        window.clearInterval(this.timer); // 清除计时器
      }
    });
  }
  
  // jQuery UI 弹出iframe窗口
   function jqopen(url, options) {
    var html =
    '<div class="dialog" id="dialog-window" title="'+getLg("prompt", "BasicOperation")+'">' +
    ' <iframe src="' + url + '" frameBorder="0" style="border: 0; " scrolling="auto" width="100%" height="100%"></iframe>' +
    '</div>';
    return $(html).dialog($.extend({
      modal: true,
      closeOnEscape: false,
      draggable: false,
      resizable: false,
      close: function(event, ui) {
        $(this).dialog("destroy").remove(); // 关闭时销毁
      }
    }, options));
  }
  //让dialog让的文字可以国际化
function dialogOpen(){
    $('.ui-dialog-buttonpane').find('button:contains("Ok")').text(getLg("affirm", "BasicOperation")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Cancel")').text(getLg("cancel", "BasicOperation")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Search")').text(getLg("search", "BasicOperation")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Export")').text(getLg("export", "MeasVal")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Cover")').text(getLg("cover", "main")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Skip")').text(getLg("skip", "main")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Close")').text(getLg("close", "main")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Yes")').text(getLg("yes", "main")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("No")').text(getLg("no", "main")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Alarm")').text(getLg("alarmLook", "Count")).width(150).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Lose")').text(getLg("loseLook", "Count")).width(150).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Statistics")').text(getLg("statistics", "Count")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("ChangeMeter")').text(getLg("changeMeter", "main")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Save")').text(getLg("save", "HyParameter")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("RelevancyDelCus")').text(getLg("relevancyDelCus", "Meter")).width(200).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("RelevancyRetainCus")').text(getLg("relevancyRetainCus", "Meter")).width(200).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("KeepRelevancyMeter")').text(getLg("saveRelevancyMeter", "Meter")).width(150).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("saveRelevancy")').text(getLg("saveRelevancy", "DeviceManagement")).width(130).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Edit")').text(getLg("edit", "BasicOperation")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Do")').text(getLg("do", "MeasVal")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Relevance")').text(getLg("relevance", "Meter")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("ControlMemoryXchange")').text(getLg("controlMemoryXchange", "HyCustomer")).width(70).height(20);
    $('.ui-dialog-buttonpane').find('button:contains("Next")').text(getLg("next", "BasicOperation")).width(70).height(20);
}
/*按钮可用与不可用的状态切换
 * @id dialog id
 * @str 按钮包含的内容
 * @flag 设置attr和remove attr
 */
function dialogButton(id,str,flag){
    if(flag){
       // $('#'+id+" " +'+'+""+ '.ui-dialog-buttonpane').find('button:contains('+str+')').attr("disabled", "disabled");
        $('#'+id+'+'+ '.ui-dialog-buttonpane').find('button:contains('+str+')').attr("disabled", "disabled");
    }else{
        $('#'+id+'+'+ '.ui-dialog-buttonpane').find('button:contains('+str+')').removeAttr("disabled");
    }
}
