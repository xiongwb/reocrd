layui.use(['form', 'table', 'treetable', 'jquery', 'layer', 'admin', 'laydate'], function() {
  var $ = layui.jquery;
  var table = layui.table;
  var treetable = layui.treetable;
  var admin = layui.admin;
  var form = layui.form;
  var layer = layui.layer;
  var laydate = layui.laydate;

  init();

  function init() {
    form.render();
    initTable();
    bindBtnClick();
  }

  function initTable() {
    table.render({
      elem: '#mProjects #table',
      url: 'json/basic-data/projects/projects-table.json',
      page: true,
      cols: [[
        { type: 'checkbox' },
        { field: 'projectName', title: '项目名称' },
        { field: 'projectNo', title: '项目编号' },
        { field: 'projectManager', title: '项目经理' },
        { field: 'productManager', title: '产品经理' },
        { field: 'projectStartDateT_begin', title: '项目开始时间' },
        { field: 'projectDescribe', title: '项目描述' },
        { align: 'center', toolbar: '#tableBarUser', title: '操作', minWidth: 200 }
      ]],
    });
  }

  function bindBtnClick() {
    $('#mProjects #fProjects #btnSearch').click(function() {
      console.log($('#btnReset')[0]);
    });
    $('#mProjects #fProjects #btnAdd').click(function() {
      admin.open({
        type: 1,
        title: '录入',
        area: '800px',
        offset: 'auto',
        maxmin: true,
        content: $('#mProjects #popup').html(),
        btn: ['确定', '取消'],
        btn1: function() {
          $('#btnSubmit').click();
        },
        btn2: function() {
          layer.alert('取消');
          return false;
        },
        success: function() {
          $('#btnSubmit').click(function() {
            var arr = $('#fNewProject').serializeArray();
            var data = {};
            for (var i = 0; i < arr.length; i++) {
              data[arr[i].name] = arr[i].value;
            }
            setTimeout(function() {
              if ($('.layui-form-danger').length === 0) {
                admin.ajax({
                  url: '/api',
                  type: 'post',
                  contentType: 'application/json',
                  dataType: 'json',
                  processData: false,
                  data: JSON.stringify(data),
                  success: function() {
                    console.log('ok');
                  },
                });
              }
            }, 100);
          });
        },
      });
      initDateInput();
    });
  }

  function initDateInput() {
    document.querySelectorAll('.layui-date').forEach(function(item) {
      laydate.render({
        elem: item,
      });
    });
  }
});
