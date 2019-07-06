<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>Tables - Ace Admin</title>

    <meta name="description" content="Static &amp; Dynamic Tables"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/font-awesome.min.css"/>

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-fonts.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace.min.css" id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/static/assets/css/ace-part2.min.css"/>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-rtl.min.css"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/static/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="${pageContext.request.contextPath}/static/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="/static/assets/js/html5shiv.min.js"></script>
    <script src="/static/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <!-- #section:basics/content.breadcrumbs -->
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>

                <li>
                    <a href="#">Tables</a>
                </li>
                <li class="active">Simple &amp; Dynamic</li>
            </ul><!-- /.breadcrumb -->

            <!-- #section:basics/content.searchbox -->
            <div class="nav-search" id="nav-search">
                <form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="Search ..." class="nav-search-input"
                                       id="nav-search-input" autocomplete="off"/>
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
                </form>
            </div><!-- /.nav-search -->

            <!-- /section:basics/content.searchbox -->
        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">
            <!-- #section:settings.box -->
            <div class="ace-settings-container" id="ace-settings-container">
                <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                    <i class="ace-icon fa fa-cog bigger-150"></i>
                </div>

                <div class="ace-settings-box clearfix" id="ace-settings-box">
                    <div class="pull-left width-50">
                        <!-- #section:settings.skins -->
                        <div class="ace-settings-item">
                            <div class="pull-left">
                                <select id="skin-colorpicker" class="hide">
                                    <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                    <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                    <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                    <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                </select>
                            </div>
                            <span>&nbsp; Choose Skin</span>
                        </div>

                        <!-- /section:settings.skins -->

                        <!-- #section:settings.navbar -->
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar"/>
                            <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                        </div>

                        <!-- /section:settings.navbar -->

                        <!-- #section:settings.sidebar -->
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar"/>
                            <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                        </div>

                        <!-- /section:settings.sidebar -->

                        <!-- #section:settings.breadcrumbs -->
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs"/>
                            <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                        </div>

                        <!-- /section:settings.breadcrumbs -->

                        <!-- #section:settings.rtl -->
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl"/>
                            <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                        </div>

                        <!-- /section:settings.rtl -->

                        <!-- #section:settings.container -->
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container"/>
                            <label class="lbl" for="ace-settings-add-container">
                                Inside
                                <b>.container</b>
                            </label>
                        </div>

                        <!-- /section:settings.container -->
                    </div><!-- /.pull-left -->

                    <div class="pull-left width-50">
                        <!-- #section:basics/sidebar.options -->
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover"/>
                            <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact"/>
                            <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight"/>
                            <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                        </div>

                        <!-- /section:basics/sidebar.options -->
                    </div><!-- /.pull-left -->
                </div><!-- /.ace-settings-box -->
            </div><!-- /.ace-settings-container -->

            <!-- /section:settings.box -->
            <div class="page-content-area">
                <div class="page-header">
                    <h1>
                        科目列表
                        <%--								<small>--%>
                        <%--									<i class="ace-icon fa fa-angle-double-right"></i>--%>
                        <%--									Static &amp; Dynamic Tables--%>
                        <%--								</small>--%>
                    </h1>
                </div><!-- /.page-header -->

                <!-- 按钮触发模态框 -->
<%--                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">--%>
<%--                    添加试题--%>
<%--                </button>--%>
                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    查看详细试题
                                </h4>
                            </div>
                            <div class="modal-body">
                                <label>试题科目&nbsp;&nbsp;</label><span class="sub-name"></span><br/>
                                <label>题目：&nbsp;&nbsp;</label><span class="content"></span>&nbsp;&nbsp;--&nbsp;&nbsp;(<span class="">单选题每题1分</span> )<br/>
                                <label>A:&nbsp;&nbsp;</label><span class="choose-a"></span><br/>
                                <label>B:&nbsp;&nbsp;</label><span class="choose-b"></span><br/>
                                <label>C:&nbsp;&nbsp;</label><span class="choose-c"></span><br/>
                                <label>D:&nbsp;&nbsp;</label><span class="choose-d"></span><br/>
                                <label style="font-weight: bold;">答案:&nbsp;&nbsp;</label><span class="answer" style="font-weight: bold;"></span><br/>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary">
                                    提交
                                </button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th colspan="8"><spring:message code="page.lang"/>:
                                            <a href="switchLang?localeType=zh_CN"><spring:message code="lang.cn"/></a>&nbsp;/&nbsp;
                                            <a href="switchLang?localeType=en_US"><spring:message code="lang.en"/></a>
                                        </th>
                                        <th><a href="subject/add" class="btn btn-primary btn-lg" style="font-size: 14px;">新增考试科目</a></th>

                                    </tr>
                                    <tr>
                                        <th></th>
                                        <th><spring:message code="subject.id"/></th>
                                        <th><spring:message code="subject.name"/></th>
                                        <%--<th><spring:message code="user.age"/></th>--%>
                                        <th><spring:message code="subject.description"/></th>
                                        <th><spring:message code="subject.testCount"/></th>
                                        <th><spring:message code="subject.totalScore"/></th>
                                        <th><spring:message code="subject.totalTime"/></th>
                                        <th>是否开启考试</th>
                                        <th><spring:message code="action.operate"/></th>
<%--                                        <th></th>--%>
                                    </tr>
                                    </thead>

                                    <tbody>

                                    <c:if test="${not empty subjectMessage}">
                                        <script type="text/javascript">
                                            alert("${subjectMessage}");
                                        </script>
                                    </c:if>
                                    <c:forEach items="${subjects}" var="subject">
                                        <tr>
                                            <td class="center">
                                                <label class="position-relative">
                                                    <input type="checkbox" class="ace"/>
                                                    <span class="lbl"></span>
                                                </label>
                                            </td>
                                            <td>${subject.subId}</td>
                                            <td>${subject.subjectName}</td>
                                            <td>${subject.description}</td>
                                            <td>${subject.testCount}</td>
                                            <td>${subject.totalScore}</td>
                                            <td>${subject.totalTime}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${subject.status == 0}">
                                                        <input name="switch-field-1" subid="${subject.subId}" class="ace ace-switch ace-switch-6 subject-status" type="checkbox"/>
                                                        <span class="lbl"></span>
                                                    </c:when>

                                                    <c:otherwise>
                                                        <input name="switch-field-1" subid="${subject.subId}" checked class="ace ace-switch ace-switch-6 subject-status" type="checkbox"/>
                                                        <span class="lbl"></span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td><a href="/subject/edit/${subject.subId}" class="btn btn-primary btn-xs" title="修改科目"><i class="ace-icon fa fa-pencil"></i></a>
                                               <a title="删除科目" class="btn btn-primary btn-xs" onclick="confirm('确定要删除该科目嘛？')?location.href='/subject/delete/${subject.subId}':''" href="javascript:void(0)">
                                                   <i class="ace-icon fa fa-trash-o"></i>
                                               </a>
                                                <a title="管理科目学生" class="btn btn-primary btn-xs manage-subject-student-btn"><i class="ace-icon fa fa-user-md"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <!-- 模态框（Modal） -->
                        <div class="modal fade" id="subjectStudentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                            &times;
                                        </button>
                                        <h4 class="modal-title" id="subjectStudentModalLabel">
                                            管理学生科目：<label id="modalSubjectName"></label>
                                        </h4>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" id="subjectId"/>
                                        <div id="subjectStudentContent" class="control-group">

                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                        </button>
                                        <button id="subjectStudentSaveBtn" type="button" class="btn btn-primary">
                                            保存
                                        </button>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal -->
                        </div>


                        <div class="hr hr-18 dotted hr-double"></div>

                        <div id="modal-table" class="modal fade" tabindex="-1">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header no-padding">
                                        <div class="table-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                <span class="white">&times;</span>
                                            </button>
                                            Results for "Latest Registered Domains
                                        </div>
                                    </div>


                                    <div class="modal-footer no-margin-top">
                                        <button class="btn btn-sm btn-danger pull-left" data-dismiss="modal">
                                            <i class="ace-icon fa fa-times"></i>
                                            Close
                                        </button>

                                        <ul class="pagination pull-right no-margin">
                                            <li class="prev disabled">
                                                <a href="#">
                                                    <i class="ace-icon fa fa-angle-double-left"></i>
                                                </a>
                                            </li>

                                            <li class="active">
                                                <a href="#">1</a>
                                            </li>

                                            <li>
                                                <a href="#">2</a>
                                            </li>

                                            <li>
                                                <a href="#">3</a>
                                            </li>

                                            <li class="next">
                                                <a href="#">
                                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                        </div><!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content-area -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <!-- #section:basics/footer -->
            <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							Application &copy; 2013-2014
						</span>

                &nbsp; &nbsp;
                <span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
            </div>

            <!-- /section:basics/footer -->
        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery1x.min.js'>" + "<" + "/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="${pageContext.request.contextPath}/static/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/static/assets/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/jquery.dataTables.bootstrap.js"></script>

<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/static/assets/js/ace-elements.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function ($) {
        var oTable1 =
            $('#sample-table-2')
            //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
                .dataTable({
                    bAutoWidth: false,
                    "aoColumns": [
                        {"bSortable": false},
                        null, null, null, null, null,
                        {"bSortable": false}
                    ],
                    "aaSorting": [],

                    //,
                    //"sScrollY": "200px",
                    //"bPaginate": false,

                    //"sScrollX": "100%",
                    //"sScrollXInner": "120%",
                    //"bScrollCollapse": true,
                    //Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
                    //you may want to wrap the table inside a "div.dataTables_borderWrap" element

                    //"iDisplayLength": 50
                });
        /**
         var tableTools = new $.fn.dataTable.TableTools( oTable1, {
					"sSwfPath": "../../copy_csv_xls_pdf.swf",
			        "buttons": [
			            "copy",
			            "csv",
			            "xls",
						"pdf",
			            "print"
			        ]
			    } );
         $( tableTools.fnContainer() ).insertBefore('#sample-table-2');
         */


        $(document).on('click', 'th input:checkbox', function () {
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function () {
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });
        });


        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            //var w2 = $source.width();

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }

    });


    $(".manage-subject-student-btn").click(function () {
        var subId = $(this).parents("td").siblings("td").eq(1).text();
        $.ajax({
            type: "POST",
            url: "${contextPath}/teacher/getAllStudent",
            data: {
                subjectId: subId
            },
            dataType: "json",
            success: function (data) {
                var htmlString = "";
                var selectedUser = data.selectedUser;

                for (var i = 0; i < data.allUser.length; i++) {
                    var user = data.allUser[i];
                    var checked = checkSelectedUser(selectedUser, user.userId) ? " checked='checked' " : "";

                    htmlString += "<div class='checkbox'>";
                    htmlString += "     <label>";
                    htmlString += "         <input name='subjectStudents' class='ace ace-checkbox-2' type='checkbox' value='"+ user.userId +"' " + checked + "/>";

                    htmlString += "         <span class='lbl'>"+user.userName+"</span>";
                    htmlString += "     </label>";
                    htmlString += "</div>";
                }

                $("#subjectStudentContent").html(htmlString);
                $("#subjectId").val(subId);
            }
        });

        $("#modalSubjectName").text($(this).parents("td").siblings("td").eq(1).text());
        $("#subjectStudentModal").modal("show");
    });

    function checkSelectedUser(selectedUsers, userId) {
        for (var i = 0; i < selectedUsers.length; i ++) {
            if (selectedUsers[i] === userId) {
                return true;
            }
        }
    }

    $("#subjectStudentSaveBtn").click(function () {
        var subjectStudents =  [];
        var checkedStudent = $("input[name='subjectStudents']:checked");
        for (var i = 0; i < checkedStudent.length; i++) {
            subjectStudents[i] = $(checkedStudent[i]).val();
        }

        $.ajax({
           type: "POST",
           url: "${contextPath}/teacher/saveSubjectStudents",
           data: {
               subjectStudents: subjectStudents,
               subjectId: $("#subjectId").val()
           },
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    alert("成功");
                    $("#subjectStudentModal").modal("hide");
                } else {
                    alert("失败");
                }
            }
        });
    })
</script>

<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace.onpage-help.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/docs/assets/js/themes/sunburst.css"/>

<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="${pageContext.request.contextPath}/static/assets/js/ace/elements.onpage-help.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/ace/ace.onpage-help.js"></script>
<script src="${pageContext.request.contextPath}/static/docs/assets/js/rainbow.js"></script>
<script src="${pageContext.request.contextPath}/static/docs/assets/js/language/generic.js"></script>
<script src="${pageContext.request.contextPath}/static/docs/assets/js/language/html.js"></script>
<script src="${pageContext.request.contextPath}/static/docs/assets/js/language/css.js"></script>
<script src="${pageContext.request.contextPath}/static/docs/assets/js/language/javascript.js"></script>
</body>
</html>
