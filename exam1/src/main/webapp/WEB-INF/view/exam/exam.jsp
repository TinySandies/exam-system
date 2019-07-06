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

    <style type="text/css">
        td {
            width: 80px;
            height: 24px;
            font-size: 12px;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        th {
            width: 80px;
            height: 24px;
            font-size: 16px;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
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
                    <h1 style="float: left;">
                        教师管理页面 》 试题列表
                    </h1>

                    <!-- 按钮触发模态框 -->
                    <button class="btn btn-primary btn-lg" style="font-size: 16px;float: right;" data-toggle="modal" id="addExamBtn">
                        添加试题
                    </button>
                </div><!-- /.page-header -->

                <!-- 按钮触发模态框 -->
<%--                <button class="btn btn-primary btn-lg" data-toggle="modal" id="addExamBtn">--%>
<%--                    添加试题--%>
<%--                </button>--%>
                <!-- 模态框（Modal） -->
                <div class="modal fade" id="addTestModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="addModalLabel">
                                    添加试题
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form id="addTestForm" method="post" action="/teacher/saveTest" class="testForm">
                                    <label>试题科目&nbsp;&nbsp;</label><select name="subId">
                                        <option></option>
                                    </select>
                                    <br/>
                                    <label>试题类型&nbsp;&nbsp;</label><select name="testType"></select><br/>
                                    <label>题干：&nbsp;&nbsp;</label>
                                        <textarea name="content" cols="50" rows="1"
                                                  placeholder="填写题目内容"></textarea><br/>
                                    <p><label>A:&nbsp;&nbsp;</label><input type="text" name="chooseA"
                                                                           placeholder="请填写A答案"/></p><br/>
                                    <p><label>B:&nbsp;&nbsp;</label><input type="text" name="chooseB"
                                                                           placeholder="请填写B答案"/></p><br/>
                                    <p><label>C:&nbsp;&nbsp;</label><input type="text" name="chooseC"
                                                                           placeholder="请填写C答案"/></p><br/>
                                    <p><label>D:&nbsp;&nbsp;</label><input type="text" name="chooseD"
                                                                           placeholder="请填写D答案"/></p><br/>
                                    <p><label style="font-weight: bold;">答案:&nbsp;&nbsp;</label><span
                                            class="answerTotal"
                                            style="font-weight: bold;">
                                <input type="radio" name="answer" value="A" checked/>
                                <input type="checkbox" name="answer" value="A" checked/>选项A

                                <input type="radio" name="answer" value="B" checked/>
                                <input type="checkbox" name="answer" value="B" checked/>选项B

                                <input type="radio" name="answer" value="C" checked/>
                                <input type="checkbox" name="answer" value="C" checked/>选项C

                                <input type="radio" name="answer" value="D" checked/>
                                <input type="checkbox" name="answer" value="D" checked/>选项D
                            </span></p><br/>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary" id="addExamTest">
                                    提交
                                </button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

                <%--                <!-- 按钮触发模态框 -->--%>
                <%--                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">--%>
                <%--                    查看试题--%>
                <%--                </button>--%>
                <!-- 模态框（Modal） -->
                <div class="modal fade" id="showTestModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="showModalLabel">
                                    查看详细试题
                                </h4>
                            </div>
                            <div class="modal-body">
                                <label>试题科目&nbsp;&nbsp;</label><span class="sub-name"></span><br/>
                                <label>试题类型&nbsp;&nbsp;</label><span class="test-type"></span><br/>
                                <label>试题分数&nbsp;&nbsp;</label><span class="test-type-score"></span><br/>
                                <label>题目：&nbsp;&nbsp;</label><span
                                    class="content"></span>&nbsp;&nbsp;--&nbsp;&nbsp;(<span class="">单选题每题1分</span>
                                )<br/>
                                <label>A:&nbsp;&nbsp;</label><span class="choose-a"></span><br/>
                                <label>B:&nbsp;&nbsp;</label><span class="choose-b"></span><br/>
                                <label>C:&nbsp;&nbsp;</label><span class="choose-c"></span><br/>
                                <label>D:&nbsp;&nbsp;</label><span class="choose-d"></span><br/>
                                <label style="font-weight: bold;">答案:&nbsp;&nbsp;</label><span class="answer"
                                                                                               style="font-weight: bold;"></span><br/>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <%--                                <button type="button" class="btn btn-primary">--%>
                                <%--                                    提交--%>
                                <%--                                </button>--%>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>


                <!-- 模态框（Modal） -->
                <div class="modal fade" id="editTestModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="editModalLabel">
                                    修改试题
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form id="editTestForm" method="post" action="/teacher/editTest" class="testForm">
                                    <label>试题科目&nbsp;&nbsp;</label><select name="subId">
                                        <option></option>
                                    </select>
                                    <br/>
                                    <label>试题类型&nbsp;&nbsp;</label><select name="testType"></select><br/>
                                    <p><label>题干：&nbsp;&nbsp;</label>
                                        <textarea name="content" cols="50" rows="1"
                                                  placeholder="填写题目内容"></textarea></p> <br/>
                                    <p><label>A:&nbsp;&nbsp;</label><input type="text" name="chooseA"
                                                                           placeholder="请填写A答案"/></p><br/>
                                    <p><label>B:&nbsp;&nbsp;</label><input type="text" name="chooseB"
                                                                           placeholder="请填写B答案"/></p><br/>
                                    <p><label>C:&nbsp;&nbsp;</label><input type="text" name="chooseC"
                                                                           placeholder="请填写C答案"/></p><br/>
                                    <p><label>D:&nbsp;&nbsp;</label><input type="text" name="chooseD"
                                                                           placeholder="请填写D答案"/></p><br/>
                                    <p><label style="font-weight: bold;">答案:&nbsp;&nbsp;</label><span
                                            class="answerTotal"
                                            style="font-weight: bold;">
                                <input type="radio" name="answer" value="A" checked/>
                                <input type="checkbox" name="answer" value="A" checked/>选项A

                                <input type="radio" name="answer" value="B" checked/>
                                <input type="checkbox" name="answer" value="B" checked/>选项B

                                <input type="radio" name="answer" value="C" checked/>
                                <input type="checkbox" name="answer" value="C" checked/>选项C

                                <input type="radio" name="answer" value="D" checked/>
                                <input type="checkbox" name="answer" value="D" checked/>选项D
                            </span></p><br/>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary" id="editTestBtn">
                                    修改
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
                                    <%--                                    <tr>--%>
                                    <%--                                        <th colspan="7"><spring:message code="page.lang"/>:--%>
                                    <%--                                            <a href="switchLang?localeType=zh_CN"><spring:message code="lang.cn"/></a>&nbsp;/&nbsp;--%>
                                    <%--                                            <a href="switchLang?localeType=en_US"><spring:message code="lang.en"/></a>--%>
                                    <%--                                        </th>--%>
                                    <%--                                        <th colspan="3"><a href="subject/add"><spring:message code="action.add"/></a>--%>
                                    <%--                                        </th>--%>

                                    <%--                                    </tr>--%>
                                    <tr>
                                        <th><spring:message code="exam.id"/></th>
                                        <th><spring:message code="subject.name"/></th>
                                        <th><spring:message code="exam.testType"/></th>
                                        <th><spring:message code="exam.content"/></th>
                                        <%--<th><spring:message code="user.age"/></th>--%>
                                        <th><spring:message code="exam.answerA"/></th>
                                        <th><spring:message code="exam.answerB"/></th>
                                        <th><spring:message code="exam.answerC"/></th>
                                        <th><spring:message code="exam.answerD"/></th>
                                        <th><spring:message code="exam.answer"/></th>
                                        <th><spring:message code="exam.testTypeScore"/></th>
                                        <th style="width: 120px;"><spring:message code="action.operate"/></th>
                                        <%--                                        <th></th>--%>
                                    </tr>
                                    </thead>

                                    <tbody>

                                    <c:if test="${not empty subjectMessage}">
                                        <script type="text/javascript">
                                            alert("${subjectMessage}");
                                        </script>
                                    </c:if>
                                    <c:forEach items="${allExam}" var="exam">
                                        <tr>
                                                <%--                                            <td class="center">--%>
                                                <%--                                                <label class="position-relative">--%>
                                                <%--                                                    <input type="checkbox" class="ace"/>--%>
                                                <%--                                                    <span class="lbl"></span>--%>
                                                <%--                                                </label>--%>
                                                <%--                                            </td>--%>
                                            <td id="examID">${exam.id}</td>
                                            <td>${exam.subjectName}</td>
                                            <td>${exam.testType}</td>
                                            <td>${exam.content}</td>
                                            <td>${exam.chooseA}</td>
                                            <td>${exam.chooseB}</td>
                                            <td>${exam.chooseC}</td>
                                            <td>${exam.chooseD}</td>
                                            <td>${exam.answer}</td>
                                            <td>${exam.testTypeScore}</td>
                                            <td><a title="查看试题"
                                                   class="btn btn-primary btn-xs show-test"><i
                                                    class="ace-icon fa fa-comment"></i></a>
                                                <a title="修改试题" class="btn btn-primary btn-xs edit-test"
                                                ><i class="ace-icon fa fa-pencil"></i></a>
                                                <a title="删除试题" class="btn btn-primary btn-xs delete-test"
                                                   id="deleteExamBtn"><i class="ace-icon fa fa-trash-o"></i>
                                                    <input type="hidden" value="${exam.id}"/></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

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

    })
</script>

<script type="text/javascript">
    //查看试题
    $(".show-test").click(function () {
        var testId = $(this).parent().siblings().eq(0).text();
        $.ajax({
            type: 'POST',
            url: '${contextPath}/teacher/getTestById',
            data: {
                testId: testId
            },
            dataType: "json",
            success: function (data) {
                $("#showTestModal .sub-name").text(data.subjectName);
                $("#showTestModal .content").text(data.content);
                $("#showTestModal .test-type").text(data.testType);
                // $("#showTestModal .").text(data.subjectName);
                $("#showTestModal .test-type-score").text(data.testTypeScore);
                $("#showTestModal .choose-a").text(data.chooseA);
                $("#showTestModal .choose-b").text(data.chooseB);
                $("#showTestModal .choose-c").text(data.chooseC);
                $("#showTestModal .choose-d").text(data.chooseD);
                $("#showTestModal .answer").text(data.answer);
            }
        });
        $("#showTestModal").modal("show");
    });

    //修改试题
    $(".edit-test").click(function () {
        var testId = $(this).parent().siblings().eq(0).text();
        $.ajax({
            type: "POST",
            url: "${contextPath}/teacher/getSubjectAndTypes",
            data: {},
            dataType: "json",
            success: function (data) {
                $("#editTestForm select[name='subId']").empty();
                $("#editTestForm select[name='testType']").empty();

                $.each(data.subjectList, function (index, item) {
                    $("#editTestForm select[name='subId']").append("<option value='" + item.subId + "'>" + item.subjectName + "</option>");
                });

                $.each(data.testTypeList, function (index, item) {
                    $("#editTestForm select[name='testType']").append("<option value='" + item.id + "'>" + item.testType + "</option>");
                });

                // $("#addTestForm select[name='testType']").trigger("char");
            }
        });
        // alert(testId);
        $.ajax({
            type: 'POST',
            url: '${contextPath}/teacher/getTestById',
            data: {
                testId: testId
            },
            dataType: "json",
            success: function (data) {
                // alert(data.subjectName);
                // $("#editTestForm .sub-name").html("<input type='text' value='"+data.subjectName+"' />");
                // $("#editTestForm .content").html("<textarea>"+data.content+"</textarea>");
                // $("#editTestForm .test-type").html(data.testType);
                // // $("#showTestModal .").text(data.subjectName);
                // $("#editTestForm .test-type-score").html(data.testTypeScore);
                // $("#editTestForm .choose-a").html("<input type='text' value='"+data.chooseA+"' />");
                // $("#editTestForm .choose-b").html("<input type='text' value='"+data.chooseB+"' />");
                // $("#editTestForm .choose-c").html("<input type='text' value='"+data.chooseC+"' />");
                // $("#editTestForm .choose-d").html("<input type='text' value='"+data.chooseD+"' />");
                // $("#editTestForm .answer").html("<input type='text' value='"+data.answer+"' />");

                // $("#editTestForm .sub-name").val(data.subjectName);
                // $("#editTestForm .content").val(data.content);
                // $("#editTestForm .test-type").val(data.testType);
                // // $("#showTestModal .").text(data.subjectName);
                // $("#editTestForm .test-type-score").val(data.testTypeScore);
                // $("#editTestForm .choose-a").val(data.chooseA);
                // $("#editTestForm .choose-b").val(data.chooseB);
                // $("#editTestForm .choose-c").val(data.chooseC);
                // $("#editTestForm .choose-d").val(data.chooseD);
                // $("#editTestForm .answer").val(data.answer);

                // $("#editTestForm select[name = 'subId']").val();
                // $("#editTestForm select[name = 'testType']").val(data.testType);
                // $("#editTestForm select[name = 'subId']").children("option:eq(0)").text(data.subjectName);
                $("#editTestForm textarea[name = 'content']").val(data.content);
                // alert(subjectName);
                $("#editTestForm input[name = 'chooseA']").val(data.chooseA);
                $("#editTestForm input[name = 'chooseB']").val(data.chooseB);
                $("#editTestForm input[name = 'chooseC']").val(data.chooseC);
                $("#editTestForm input[name = 'chooseD']").val(data.chooseD);
            }
        });
        $("#editTestModal").modal("show");
    });

    $("#addExamTest").click(function () {
        // if ($('#addTestForm').validate()) {
        //     alert();
        var subId = $("#addTestForm select[name = 'subId']").val();
        var testType = $("#addTestForm select[name = 'testType']").val();
        var subjectName = $("#addTestForm select[name = 'subId']").children("option:eq(0)").text();
        var content = $("#addTestForm textarea[name = 'content']").val();
        // alert(subjectName);
        var chooseA = $("#addTestForm input[name = 'chooseA']").val();
        var chooseB = $("#addTestForm input[name = 'chooseB']").val();
        var chooseC = $("#addTestForm input[name = 'chooseC']").val();
        var chooseD = $("#addTestForm input[name = 'chooseD']").val();
        var answerString = '';
        if (testType == 1) {
            answerString += $("#addTestForm input[name='answer']:radio:checked").val();
        } else if (testType == 2) {
            var array = $("#addTestForm input[name='answer']:checkbox:checked");
            $.each(array, function (index, item) {
                answerString += (index === 0 ? $(item).val() : (',' + $(item).val()));
            });
        } else {
            alert("没有试题类型！");
        }

        $.ajax({
            type: "POST",
            url: '${contextPath}/teacher/saveTest',
            data: {
                subId: subId,
                testType: testType,
                subjectName: subjectName,
                content: content,
                chooseA: chooseA,
                chooseB: chooseB,
                chooseC: chooseC,
                chooseD: chooseD,
                answer: answerString
            },
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    alert('添加成功！');
                    window.location.reload();
                } else {
                    var messageMap = data.messageMap;
                    for (var key in messageMap) {
                        var value = messageMap[key];
                        $("#addTestForm input[name='" + key + "']").after("<label class=jsr303-message-label>" + value + "</label>");
                        alert("添加失败！" + messageMap['message']);
                    }
                }
            }
        })
        // }
    });

    //修改试题
    $("#editTestBtn").click(function () {
        // if ($('#addTestForm').validate()) {
        //     alert();
        var id = $("#examID").text();
        var subId = $("#editTestForm select[name = 'subId']").val();
        var testType = $("#editTestForm select[name = 'testType']").val();
        var subjectName = $("#editTestForm select[name = 'subId']").children("option:eq(0)").text();
        var content = $("#editTestForm textarea[name = 'content']").val();
        // alert(id);
        var chooseA = $("#editTestForm input[name = 'chooseA']").val();
        var chooseB = $("#editTestForm input[name = 'chooseB']").val();
        var chooseC = $("#editTestForm input[name = 'chooseC']").val();
        var chooseD = $("#editTestForm input[name = 'chooseD']").val();
        var answerString = '';
        if (testType == 1) {
            answerString += $("#editTestForm input[name='answer']:radio:checked").val();
        } else if (testType == 2) {
            var array = $("#editTestForm input[name='answer']:checkbox:checked");
            $.each(array, function (index, item) {
                answerString += (index === 0 ? $(item).val() : (',' + $(item).val()));
            });
        } else {
            alert("没有试题类型！");
        }

        $.ajax({
            type: "POST",
            url: '${contextPath}/teacher/editTest',
            data: {
                id: id,
                subId: subId,
                testType: testType,
                subjectName: subjectName,
                content: content,
                chooseA: chooseA,
                chooseB: chooseB,
                chooseC: chooseC,
                chooseD: chooseD,
                answer: answerString
            },
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    alert('修改成功！');
                    window.location.reload();
                } else {
                    var messageMap = data.messageMap;
                    for (var key in messageMap) {
                        // var value = messageMap[key];
                        // $("#addTestForm input[name='" + key + "']").after("<label class=jsr303-message-label>" + value + "</label>");
                        alert("修改失败！" + messageMap['message']);
                    }
                }
            }
        })
        // }
    });

    //添加试题按钮
    $("#addExamBtn").click(function () {
        $.ajax({
            type: "POST",
            url: "${contextPath}/teacher/getSubjectAndTypes",
            data: {},
            dataType: "json",
            success: function (data) {
                $("#addTestForm select[name='subId']").empty();
                $("#addTestForm select[name='testType']").empty();

                $.each(data.subjectList, function (index, item) {
                    $("#addTestForm select[name='subId']").append("<option value='" + item.subId + "'>" + item.subjectName + "</option>");
                });

                $.each(data.testTypeList, function (index, item) {
                    $("#addTestForm select[name='testType']").append("<option value='" + item.id + "'>" + item.testType + "</option>");
                });

                // $("#addTestForm select[name='testType']").trigger("char");
            }
        });
        $("#addTestModal").modal("show");
    });

    //试题类型切换
    $(".testForm select[name='testType']").change(function () {
        //////////////////////////////////////////////////////////////
        $(".testForm .test-type-score").text("本题" + $(this).find("option:checked").attr("score") + "分");

        var testType = $(this).val();
        if (testType == 1) {
            $(".testForm .answerTotal input:radio").show();
            $(".testForm .answerTotal input:checkbox").hide();
        } else if (testType == 2) {
            $(".testForm .answerTotal input:checkbox").show();
            $(".testForm .answerTotal input:radio").hide();
        } else {
            alert("没有这些试题类型！");
        }
    });

    //删除考题
    $(".delete-test").click(function () {
        var examId = window.confirm("你确定要删除该试题吗？") ? $(this).children("input").val(): -1;
        if (examId === -1) return;
        // alert(examId);
        $.ajax({
            type: "POST",
            url: '${contextPath}/teacher/deleteTest',
            data: {
                examId: examId
            },
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    alert('删除成功！');
                    window.location.reload();
                } else {
                    var messageMap = data.messageMap;
                    for (var key in messageMap) {
                        var value = messageMap[key];
                        // $("#addTestForm input[name='" + key + "']").after("<label class=jsr303-message-label>" + value + "</label>");
                        alert("删除失败！" + messageMap['message']);
                    }
                }
            }
        })
    });


    //修改考题
    // $("#addTestForm select[name='testType']").change(function () {
    //     //////////////////////////////////////////////////////////////
    //     $("#addTestForm .test-type-score").text("本题" + $(this).find("option:checked").attr("score") + "分");
    //
    //     var testType = $(this).val();
    //     if (testType == 1) {d
    //         $("#addTestForm .answerTotal input:radio").show();
    //         $("#addTestForm .answerTotal input:checkbox").hide();
    //     } else if (testType == 2) {
    //         $("#addTestForm .answerTotal input:checkbox").show();
    //         $("#addTestForm .answerTotal input:radio").hide();
    //     } else {
    //         alert("没有这些试题类型！");
    //     }
    // });
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
