<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="formUrl" value="/admin-guideline-listen-edit.html"/>
<html>
<head>
    <title><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/> </title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#"><fmt:message key="label.web.home" bundle="${lang}"/></a>
                </li>
                <li class="active"><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <a href="${listenGuidelineEditUrl}" type="button">Add</a>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <%--<form action="${formUrl}" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><fmt:message key="label.guideline.title" bundle="${lang}"/></label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.title"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><fmt:message key="label.grammarguideline.upload.image" bundle="${lang}"/></label>
                            <div class="col-sm-9">
                                <input type="file" name="file"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><fmt:message key="label.guideline.context" bundle="${lang}"/></label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.context"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="submit" class="btn btn-white btn-warning btn-bold" value="<fmt:message key="label.done" bundle="${lang}" />">
                            </div>
                        </div>
                    </form>--%>
                    <%--Demo--%>
                    <%--<div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><fmt:message key="label.guideline.context" bundle="${lang}"/></label>
                        <div class="col-sm-9">
                            <h1>Thais Thanh Tuan</h1>
                            <p class="textHide">51403035</p>
                            <p>0938380039</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button id="clickHide">Click here</button>
                        </div>
                    </div>--%>
                    <%--<div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><fmt:message key="label.guideline.context" bundle="${lang}"/></label>
                        <div class="col-sm-9">
                            <input id="value" value="Thai Thanh Tuan"/>
                        </div>
                    </div>
                    <br/>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><fmt:message key="label.guideline.context" bundle="${lang}"/></label>
                        <div class="col-sm-9">
                            <p id="getValue">Nothing value</p>
                        </div>
                    </div>
                    <br/>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button onclick="usingValAction()">Click here</button>
                        </div>
                    </div>--%>
                    <%--demo css nethod--%>
                    <%--<div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><fmt:message key="label.guideline.context" bundle="${lang}"/></label>
                        <div class="col-sm-9">
                            <p id="cssmethod">Nothing value</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button onclick="demoCssMethod()">Click here</button>
                        </div>
                    </div>--%>
                    <%--demo change method--%>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><fmt:message key="label.guideline.context" bundle="${lang}"/></label>
                        <div class="col-sm-9">
                            <input type="checkbox" id="sex" onchange="usingOnChange()"/>
                            <p id="sexChange"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--Demo--%>
<script>
    $(document).ready(function () {
        hideParagarpWhenClickButton();
    });
    function hideParagarpWhenClickButton() {
        $("#clickHide").click(function () {
            $(".textHide").hide();
        })
    }
    function usingValAction() {
        var value = $('#value').val();
        $('#getValue').html(value);
    }
    function demoCssMethod() {
        $('#cssmethod').css("color","red");
    }
    //each function
    var arr = [12,5,43,66,7,8];
    $.each(arr, function (index,value) {
        console.log("Value: "+value +" - position:" +index);
    })
    function usingOnChange() {
        if($('#sex').prop('checked') == true) {
            $('#sexChange').html('<h1>Male</h1>');
        }
        else {
            $('#sexChange').html('<h1>Female</h1>');
        }
    }
</script>
</body>
</html>
