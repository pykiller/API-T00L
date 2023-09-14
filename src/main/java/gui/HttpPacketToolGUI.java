package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import dingtalk.DingTalkPacketSender;
import javafx.scene.Node;
import weixin.WeiXinPacketSender;
import feishu.FeiShuPacketSender;

public class HttpPacketToolGUI extends Application {

    private TextArea logTextArea;
    private TextArea wxlogTextArea;
    private TextArea fslogTextArea;
    private TextField appKeyTextField;
    private PasswordField appSecretPasswordField;
    private TextField accessTokenTextField;
    private TextField wxappKeyTextField;
    private PasswordField wxappSecretPasswordField;
    private TextField wxaccessTokenTextField;
    private TextField fsappKeyTextField;
    private PasswordField fsappSecretPasswordField;
    private TextField fsaccessTokenTextField;
    private TextField proxyHostTextField;
    private TextField proxyPortTextField;
    private TextField mobileTextField;
    private TextField nameTextField;
    private TextField titleTextField;
    private TextField useridTextField;
    private TextField UserIdTextField;
    private TextField blackboardcontentTextField;
    private TextField blackboardtitleTextField;
    private TextField operation_useridTextField;
    private TextField deptid_listTextField;
    private CheckBox useProxyCheckBox;
    private TextField wxmobileTextField;
    private TextField wxnameTextField;
    private TextField wxtitleTextField;
    private TextField wxuseridTextField;
    private TextField wxUserIdTextField;
    private TextField wxuserTextField;
    private TextField fsmobileTextField;
    private TextField fsnameTextField;
    private TextField fstitleTextField;
    private TextField fsuseridTextField;
    private TextField fsUserIdTextField;
    private TextField fsuserTextField;
    private TextField fsdepartment_idTextField;
    private TextField fsaddUserdepartment_idTextField;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("API-T00l利用工具 V1.2 @PYkiller");

        // 创建一个根布局为TabPane，用于添加标签页
        TabPane tabPane = new TabPane();

        // 创建钉钉标签页
        Tab dingTalkTab = new Tab("钉钉");
        dingTalkTab.setContent(createDingTalkTabContent());

        // 创建企业微信标签页
        Tab weChatWorkTab = new Tab("企业微信");
        weChatWorkTab.setContent(createWeChatWorkTabContent());
        // 创建企业微信标签页

        Tab FeishuTab = new Tab("飞书");
        FeishuTab.setContent(createFeiShuTabContent());

        // 创建企业微信标签页
        Tab ProxySettingsTab = new Tab("代理设置");
        ProxySettingsTab.setContent(createProxySettingsContent());

        // 将标签页添加到TabPane
        tabPane.getTabs().addAll(dingTalkTab, weChatWorkTab,FeishuTab,ProxySettingsTab);

        // 创建一个根布局为BorderPane，将TabPane放在顶部
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(tabPane);
        borderPane.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        // 将BorderPane添加到Scene中
        Scene scene = new Scene(borderPane, 650, 670);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // 创建钉钉标签页的内容
    private Node createDingTalkTabContent() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(14);
        gridPane.setVgap(14);

        // 创建输入框和按钮
        // 添加勾选框到用户界面

        Label appKeyLabel = new Label("AppKey:");
        appKeyTextField = new TextField();

        Label appSecretLabel = new Label("AppSecret:");
        appSecretPasswordField = new PasswordField();

        Label accessTokenLabel = new Label("Access Token:");
        accessTokenTextField = new TextField();
        accessTokenTextField.setPromptText("输入 Access Token");



        Button getTokenButton = new Button("获取Token");
        Button getAdminButton = new Button("获取管理员信息");
        Button getAppButton = new Button("获取应用列表");
        Button getRoleButton = new Button("获取角色列表");
        useridTextField = new TextField("UserID");
        Button getUserButton = new Button("获取账号信息");
        Button getblackboardButton = new Button("发公告");
        deptid_listTextField = new TextField("部门ID");
        operation_useridTextField = new TextField("管理员userID");
        blackboardtitleTextField = new TextField("标题");
        blackboardcontentTextField = new TextField("内容");

        Button createUserButton = new Button("新建账号");
        Button delUserButton = new Button("删除账号");
        Label useridLabel = new Label("UserID:");
        UserIdTextField = new TextField("64537405");
        Label mobileLabel = new Label("手机号:");
        mobileTextField = new TextField("18888888888");
        Label nameLabel = new Label("用户名:");
        nameTextField = new TextField("Admin");
        Label titleLabel = new Label("职位:");
        titleTextField = new TextField("系统管理员");
        Label xForwardedForLabel = new Label("X-Forwarded-For:");
        TextField xForwardedForTextField = new TextField("127.0.0.1");


        logTextArea = new TextArea();
        logTextArea.setPrefHeight(50);
        logTextArea.setEditable(false);

        // 设置每个标签的最小宽度，以保持对齐
        appKeyLabel.setMinWidth(170);
        appSecretLabel.setMinWidth(170);
        accessTokenLabel.setMinWidth(100);
        appKeyTextField.setMinWidth(170);


        // 添加元素到GridPane中
        gridPane.add(appKeyLabel, 0, 0);
        gridPane.add(appKeyTextField, 1, 0);
        gridPane.add(appSecretLabel, 0, 1);
        gridPane.add(appSecretPasswordField, 1, 1);
        gridPane.add(accessTokenLabel, 2, 0);
        gridPane.add(accessTokenTextField, 3, 0);
        gridPane.add(getTokenButton, 0, 5);
        gridPane.add(getAdminButton, 1, 5);
        gridPane.add(getAppButton, 0, 6);
        gridPane.add(getRoleButton, 1, 6);
        gridPane.add(useridTextField, 1, 7);
        gridPane.add(getUserButton, 0, 7);
        gridPane.add(getblackboardButton, 0, 8);
        gridPane.add(deptid_listTextField, 0, 9);
        gridPane.add(operation_useridTextField, 1, 9);
        gridPane.add(blackboardtitleTextField, 0, 10);
        gridPane.add(blackboardcontentTextField, 1, 10);
        GridPane.setColumnSpan(createUserButton, 2); // 让按钮跨足两列
        gridPane.add(createUserButton, 2, 5);
        gridPane.add(delUserButton, 3, 5);
        gridPane.add(useridLabel, 2, 6);
        gridPane.add(UserIdTextField, 3, 6);
        gridPane.add(mobileLabel, 2, 7);
        gridPane.add(mobileTextField, 3, 7);
        gridPane.add(nameLabel, 2, 8);
        gridPane.add(nameTextField, 3, 8);
        gridPane.add(titleLabel, 2, 9);
        gridPane.add(titleTextField, 3, 9);
        gridPane.add(xForwardedForLabel, 0, 3);
        gridPane.add(xForwardedForTextField, 1, 3);

        // 设置GridPane的布局
        GridPane.setHgrow(logTextArea, Priority.ALWAYS);
        GridPane.setColumnSpan(logTextArea, 2);
        gridPane.add(logTextArea, 0, 12, 4, 14); // 让文本区域跨足两列并占据一行


        // 创建一个ScrollPane来包装日志文本区域，以便用户可以滚动查看
        ScrollPane logScrollPane = new ScrollPane(logTextArea);
        logScrollPane.setFitToWidth(true);
        logScrollPane.setFitToHeight(true);

        // 创建一个根布局为BorderPane，将GridPane放在顶部，日志ScrollPane放在中间
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(gridPane);
        borderPane.setCenter(logScrollPane);



        DingTalkPacketSender packetSender = new DingTalkPacketSender();

        getTokenButton.setOnAction(e -> {
            String appKey = appKeyTextField.getText();
            String appSecret = appSecretPasswordField.getText();
            String xForwardedFor = xForwardedForTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取Token的HTTP请求
            String tokenResponse = packetSender.executeHttpGetRequest("https://oapi.dingtalk.com/gettoken?appkey=" + appKey + "&appsecret=" + appSecret,xForwardedFor);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取Token的响应:\n" + tokenResponse + "\n");
        });

        getAdminButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String xForwardedFor = xForwardedForTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取HTTP请求
            String adminResponse = packetSender.executeHttpGetRequest("https://oapi.dingtalk.com/topapi/user/listadmin?access_token=" + accessToken,xForwardedFor);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取管理员的响应:\n" + adminResponse + "\n");
        });

        createUserButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String mobile = mobileTextField.getText();
            String name = nameTextField.getText();
            String title = titleTextField.getText();
            String userid = UserIdTextField.getText();
            String createUserRequestBody = packetSender.getCreateUserRequestBody(mobile, name, title,userid);
            String xForwardedFor = xForwardedForTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行新建账号的HTTP请求，将 access_token 添加到头部
            String createUserResponse = packetSender.executeHttpPostRequest("https://oapi.dingtalk.com/topapi/v2/user/create?access_token=" + accessToken, createUserRequestBody,xForwardedFor);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("新建账号的响应:\n" + createUserResponse + "\n");
        });
        delUserButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String xForwardedFor = xForwardedForTextField.getText();
            String UserId =  UserIdTextField.getText();


            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取HTTP请求
            String delUserResponse = packetSender.executeHttpGetRequest("https://oapi.dingtalk.com/topapi/v2/user/delete?access_token=" + accessToken + "&userid=" + UserId,xForwardedFor);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("删除用户的响应:\n" + delUserResponse + "\n");
        });

        getAppButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String xForwardedFor = xForwardedForTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取HTTP请求
            String AppResponse = packetSender.executeHttpGetRequest("https://oapi.dingtalk.com/chat/get?access_token=" + accessToken,xForwardedFor);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取应用列表的响应:\n" + AppResponse + "\n");
        });
        getRoleButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String xForwardedFor = xForwardedForTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取HTTP请求
            String getRoleResponse = packetSender.executeHttpGetRequest("https://oapi.dingtalk.com/topapi/role/list?access_token=" + accessToken,xForwardedFor);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取角色的响应:\n" + getRoleResponse + "\n");
        });
        getUserButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String xForwardedFor = xForwardedForTextField.getText();
            String userid = useridTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取HTTP请求
            String getUserResponse = packetSender.executeHttpGetRequest("https://oapi.dingtalk.com/topapi/v2/user/get?access_token=" + accessToken + "&userid=" + userid,xForwardedFor);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取账户信息的响应:\n" + getUserResponse + "\n");
        });

        getblackboardButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String deptid_list = deptid_listTextField.getText();
            String operation_userid = operation_useridTextField.getText();
            String content = blackboardcontentTextField.getText();
            String title = blackboardtitleTextField.getText();
            String getblackboardRequestBody = packetSender.getblackboardRequestBody(deptid_list,  operation_userid,  title,  content);
            String xForwardedFor = xForwardedForTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行新建账号的HTTP请求，将 access_token 添加到头部
            String getblackboardResponse = packetSender.executeHttpPostRequest("https://oapi.dingtalk.com/topapi/blackboard/create?access_token=" + accessToken, getblackboardRequestBody,xForwardedFor);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("发公告的响应:\n" + getblackboardResponse + "\n");
        });

        return gridPane;
    }

    // 创建企业微信标签页的内容
    private Node createWeChatWorkTabContent() {
        // 创建一个根布局为GridPane，用于更精确地控制布局
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(14);
        gridPane.setVgap(14);

        useProxyCheckBox = new CheckBox("使用代理");
        useProxyCheckBox.setSelected(false); // 默认情况下不使用代理
        useProxyCheckBox.setOnAction(e -> {
            ProxyManager.getInstance().setUseProxy(useProxyCheckBox.isSelected());
        });
        Label appKeyLabel = new Label("Corpid:");
        wxappKeyTextField = new TextField();

        Label appSecretLabel = new Label("Corpsecret:");
        wxappSecretPasswordField = new PasswordField();

        Label wxaccessTokenLabel = new Label("Access Token:");
        wxaccessTokenTextField = new TextField();
        wxaccessTokenTextField.setPromptText("输入 Access Token");

        Button getTokenButton = new Button("获取Token");
        Button getJoinButton = new Button("获取邀请二维码");
        Button getUserlistButton = new Button("获取用户列表");
        Button wxcreateUserButton = new Button("新建账号");
        Button delUserButton = new Button("删除账号");
        Label useridLabel = new Label("UserID:");
        wxUserIdTextField = new TextField("64537405");
        Label mobileLabel = new Label("手机号:");
        wxmobileTextField = new TextField("18888888888");
        Label nameLabel = new Label("用户名:");
        wxnameTextField = new TextField("管理员");
        Label usernameLabel = new Label("用户别称:");
        wxuserTextField = new TextField("zhangsan");
        Label titleLabel = new Label("职位:");
        wxtitleTextField = new TextField("系统管理员");
        wxuseridTextField = new TextField("UserID");
        Button getUserButton = new Button("获取账号信息");



        // 设置每个标签的最小宽度，以保持对齐
        appKeyLabel.setMinWidth(170);
        appSecretLabel.setMinWidth(170);
        wxaccessTokenLabel.setMinWidth(100);
        wxappKeyTextField.setMinWidth(170);


        // 添加元素到GridPane中
        gridPane.add(appKeyLabel, 0, 0);
        gridPane.add(wxappKeyTextField, 1, 0);
        gridPane.add(appSecretLabel, 0, 1);
        gridPane.add(wxappSecretPasswordField, 1, 1);
        gridPane.add(wxaccessTokenLabel, 2, 0);
        gridPane.add(wxaccessTokenTextField, 3, 0);
        gridPane.add(getTokenButton, 0, 6);
        gridPane.add(getJoinButton, 1, 6);
        gridPane.add(getUserlistButton, 0, 7);
        GridPane.setColumnSpan(wxcreateUserButton, 2); // 让按钮跨足两列
        gridPane.add(wxcreateUserButton, 2, 6);
        gridPane.add(delUserButton, 3, 6);
        gridPane.add(useridLabel, 2, 7);
        gridPane.add(wxUserIdTextField, 3, 7);
        gridPane.add(mobileLabel, 2, 8);
        gridPane.add(wxmobileTextField, 3, 8);
        gridPane.add(nameLabel, 2, 9);
        gridPane.add(wxnameTextField, 3, 9);
        gridPane.add(titleLabel, 2, 10);
        gridPane.add(wxtitleTextField, 3, 10);
        gridPane.add(usernameLabel, 2, 11);
        gridPane.add(wxuserTextField, 3, 11);
        gridPane.add(wxuseridTextField, 1, 8);
        gridPane.add(getUserButton, 0, 8);


        // 设置GridPane的布局
        wxlogTextArea = new TextArea();
        wxlogTextArea.setPrefHeight(50);
        wxlogTextArea.setEditable(false);
        // 设置GridPane的布局
        GridPane.setHgrow(wxlogTextArea, Priority.ALWAYS);
        GridPane.setColumnSpan(wxlogTextArea, 2);
        gridPane.add(wxlogTextArea, 0, 12, 4, 14); // 让文本区域跨足两列并占据一行


        // 创建一个ScrollPane来包装日志文本区域，以便用户可以滚动查看
        ScrollPane logScrollPane = new ScrollPane(wxlogTextArea);
        logScrollPane.setFitToWidth(true);
        logScrollPane.setFitToHeight(true);

        // 创建一个根布局为BorderPane，将GridPane放在顶部，日志ScrollPane放在中间
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(gridPane);
        borderPane.setCenter(logScrollPane);

        WeiXinPacketSender packetSender = new WeiXinPacketSender();

        getTokenButton.setOnAction(e -> {
            String corpid = wxappKeyTextField.getText();
            String corpsecret = wxappSecretPasswordField.getText();


            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取Token的HTTP请求
            String tokenResponse = packetSender.weixinHttpGetRequest("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + corpsecret);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            wxlogTextArea.appendText("获取Token的响应:\n" + tokenResponse + "\n");
        });
        getJoinButton.setOnAction(e -> {
            String accessToken = wxaccessTokenTextField.getText();
            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取Token的HTTP请求
            String tokenResponse = packetSender.weixinHttpGetRequest("https://qyapi.weixin.qq.com/cgi-bin/corp/get_join_qrcode?access_token=" + accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            wxlogTextArea.appendText("获取邀请二维码的响应:\n" + tokenResponse + "\n");
        });
        getUserlistButton.setOnAction(e -> {
            String accessToken = wxaccessTokenTextField.getText();
            String wxgetUserlistRequestBody = packetSender.wxgetUserlistRequestBody();
            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));


            String userlistResponse = packetSender.weixinHttpPostRequest("https://qyapi.weixin.qq.com/cgi-bin/user/list_id?access_token=" + accessToken,wxgetUserlistRequestBody);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            wxlogTextArea.appendText("获取用户列表的响应(默认1000条):\n" + userlistResponse + "\n");
        });

        wxcreateUserButton.setOnAction(e -> {
            String accessToken = wxaccessTokenTextField.getText();
            String mobile = wxmobileTextField.getText();
            String name = wxnameTextField.getText();
            String title = wxtitleTextField.getText();
            String userid = wxUserIdTextField.getText();
            String user = wxuserTextField.getText();

            String wxcreateUserRequestBody = packetSender.wxgetAddUserRequestBody(mobile, name, title,userid,user);


            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行新建账号的HTTP请求，将 access_token 添加到头部
            String wxcreateUserResponse = packetSender.weixinHttpPostRequest("https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=" + accessToken, wxcreateUserRequestBody);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            wxlogTextArea.appendText("新建账号的响应:\n" + wxcreateUserResponse + "\n");
        });

        delUserButton.setOnAction(e -> {
            String accessToken = wxaccessTokenTextField.getText();
            String UserId =  wxUserIdTextField.getText();


            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取HTTP请求
            String delUserResponse = packetSender.weixinHttpGetRequest("https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=" + accessToken + "&userid=" + UserId);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            wxlogTextArea.appendText("删除用户的响应:\n" + delUserResponse + "\n");
        });

        getUserButton.setOnAction(e -> {
            String accessToken = wxaccessTokenTextField.getText();
            String userid = wxuseridTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取HTTP请求
            String getUserResponse = packetSender.weixinHttpGetRequest("https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken + "&userid=" + userid);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            wxlogTextArea.appendText("获取账户信息的响应:\n" + getUserResponse + "\n");
        });

        return gridPane;
    }

    // 创建飞书标签页的内容
    private Node createFeiShuTabContent() {
        // 创建一个根布局为GridPane，用于更精确地控制布局
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(14);
        gridPane.setVgap(14);

        useProxyCheckBox = new CheckBox("使用代理");
        useProxyCheckBox.setSelected(false); // 默认情况下不使用代理
        useProxyCheckBox.setOnAction(e -> {
            ProxyManager.getInstance().setUseProxy(useProxyCheckBox.isSelected());
        });
        Label appKeyLabel = new Label("App_Id:");
        fsappKeyTextField = new TextField();

        Label appSecretLabel = new Label("App_Secret:");
        fsappSecretPasswordField = new PasswordField();

        Label fsaccessTokenLabel = new Label("T_Access Token:");
        fsaccessTokenTextField = new TextField();
        fsaccessTokenTextField.setPromptText("输入 T_Access Token");

        Button getTokenButton = new Button("获取Token");
        Button getinfoButton = new Button("获取企业信息");
        Button getdepartmentlistButton = new Button("获取根部门列表");
        Button fscreateUserButton = new Button("新建账号");
        Button fsdelUserButton = new Button("删除账号");
        Label useridLabel = new Label("UserID:");
        fsUserIdTextField = new TextField("8f3cg5a8");
        Label mobileLabel = new Label("手机号:");
        fsmobileTextField = new TextField("18888888888");
        Label nameLabel = new Label("用户名:");
        fsnameTextField = new TextField("管理员");
        Label fsdepartment_idsLabel = new Label("部门id:");
        fsaddUserdepartment_idTextField = new TextField();
        fsaddUserdepartment_idTextField.setPromptText("open_department_id,默认0");
        Label titleLabel = new Label("职位:");
        fstitleTextField = new TextField("系统管理员");
        fsuseridTextField = new TextField("UserID");
        Button getUserButton = new Button("获取账号信息");
        Button getdepartment_idButton = new Button("获取部门用户列表");
        fsdepartment_idTextField = new TextField();
        fsdepartment_idTextField.setPromptText("open_department_id,默认0");




        // 设置每个标签的最小宽度，以保持对齐
        appKeyLabel.setMinWidth(170);
        appSecretLabel.setMinWidth(170);
        fsaccessTokenLabel.setMinWidth(100);
        fsappKeyTextField.setMinWidth(170);



        // 添加元素到GridPane中
        gridPane.add(appKeyLabel, 0, 0);
        gridPane.add(fsappKeyTextField, 1, 0);
        gridPane.add(appSecretLabel, 0, 1);
        gridPane.add(fsappSecretPasswordField, 1, 1);
        gridPane.add(fsaccessTokenLabel, 2, 0);
        gridPane.add(fsaccessTokenTextField, 3, 0);
        gridPane.add(getTokenButton, 0, 6);
        gridPane.add(getinfoButton, 1, 6);
        gridPane.add(getdepartmentlistButton, 0, 7);
        GridPane.setColumnSpan(fscreateUserButton, 2); // 让按钮跨足两列
        gridPane.add(fscreateUserButton, 2, 6);
        gridPane.add(fsdelUserButton, 3, 6);
        gridPane.add(useridLabel, 2, 7);
        gridPane.add(fsUserIdTextField, 3, 7);
        gridPane.add(mobileLabel, 2, 8);
        gridPane.add(fsmobileTextField, 3, 8);
        gridPane.add(nameLabel, 2, 9);
        gridPane.add(fsnameTextField, 3, 9);
        gridPane.add(titleLabel, 2, 10);
        gridPane.add(fstitleTextField, 3, 10);
        gridPane.add(fsdepartment_idsLabel, 2, 11);
        gridPane.add(fsaddUserdepartment_idTextField, 3, 11);
        gridPane.add(fsuseridTextField, 1, 8);
        gridPane.add(getUserButton, 0, 8);
        gridPane.add(fsdepartment_idTextField, 1, 9);
        gridPane.add(getdepartment_idButton, 0, 9);


        // 设置GridPane的布局
        fslogTextArea = new TextArea();
        fslogTextArea.setPrefHeight(50);
        fslogTextArea.setEditable(false);
        // 设置GridPane的布局
        GridPane.setHgrow(fslogTextArea, Priority.ALWAYS);
        GridPane.setColumnSpan(fslogTextArea, 2);
        gridPane.add(fslogTextArea, 0, 12, 4, 14); // 让文本区域跨足两列并占据一行


        // 创建一个ScrollPane来包装日志文本区域，以便用户可以滚动查看
        ScrollPane logScrollPane = new ScrollPane(fslogTextArea);
        logScrollPane.setFitToWidth(true);
        logScrollPane.setFitToHeight(true);

        // 创建一个根布局为BorderPane，将GridPane放在顶部，日志ScrollPane放在中间
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(gridPane);
        borderPane.setCenter(logScrollPane);

        FeiShuPacketSender packetSender = new FeiShuPacketSender();

        getTokenButton.setOnAction(e -> {
            String app_id = fsappKeyTextField.getText();
            String app_secret = fsappSecretPasswordField.getText();
            String accessToken = fsaccessTokenTextField.getText();
            String fsTokenRequestBody = packetSender.fsTokenRequestBody(app_id,app_secret);


            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取Token的HTTP请求
            String tokenResponse = packetSender.feishuHttpPostRequest("https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal",fsTokenRequestBody,accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            fslogTextArea.appendText("获取Token的响应:\n" + tokenResponse + "\n");
        });

        getdepartment_idButton.setOnAction(e -> {
            String accessToken = fsaccessTokenTextField.getText();
            String department_id = fsdepartment_idTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行HTTP请求，将 access_token 添加到头部
            String department_idResponse = packetSender.feishuHttpGetRequest("https://open.feishu.cn/open-apis/contact/v3/users/find_by_department?department_id=" + department_id,accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            fslogTextArea.appendText("获取部门用户列表的响应:\n" + department_idResponse + "\n");
        });

        getdepartmentlistButton.setOnAction(e -> {
            String accessToken = fsaccessTokenTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行HTTP请求，将 access_token 添加到头部
            String departmentlistResponse = packetSender.feishuHttpGetRequest("https://open.feishu.cn/open-apis/contact/v3/departments/0/children?department_id_type=open_department_id&page_size=50&user_id_type=open_id",accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            fslogTextArea.appendText("获取根部门列表的响应:\n" + departmentlistResponse + "\n");
        });

        fscreateUserButton.setOnAction(e -> {
            String accessToken = fsaccessTokenTextField.getText();
            String mobile = fsmobileTextField.getText();
            String name = fsnameTextField.getText();
            String title = fstitleTextField.getText();
            String userid = fsUserIdTextField.getText();
            String department_ids = fsaddUserdepartment_idTextField.getText();

            String fsgetAddUserRequestBody = packetSender.fsgetAddUserRequestBody(mobile, name, title,userid,department_ids);

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行新建账号的HTTP请求，将 access_token 添加到头部
            String fscreateUserResponse = packetSender.feishuHttpPostRequest("https://open.feishu.cn/open-apis/contact/v3/users",fsgetAddUserRequestBody,accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            fslogTextArea.appendText("新建账号的响应:\n" + fscreateUserResponse + "\n");
        });
        fsdelUserButton.setOnAction(e -> {
            String accessToken = fsaccessTokenTextField.getText();
            String userid = fsUserIdTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行HTTP请求，将 access_token 添加到头部
            String fsdelUserResponse = packetSender.feishuHttpDELETERequest("https://open.feishu.cn/open-apis/contact/v3/users/" + userid + "?user_id_type=user_id",accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            fslogTextArea.appendText("删除用户的响应:\n" + fsdelUserResponse + "\n");
        });

        getinfoButton.setOnAction(e -> {
            String accessToken = fsaccessTokenTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行HTTP请求，将 access_token 添加到头部
            String infoResponse = packetSender.feishuHttpGetRequest("https://open.feishu.cn/open-apis/tenant/v2/tenant/query",accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            fslogTextArea.appendText("获取部门用户列表的响应:\n" + infoResponse + "\n");
        });

        getUserButton.setOnAction(e -> {
            String accessToken = fsaccessTokenTextField.getText();
            String userid = fsuseridTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行HTTP请求，将 access_token 添加到头部
            String userinfoResponse = packetSender.feishuHttpGetRequest("https://open.feishu.cn/open-apis/contact/v3/users/" + userid + "?department_id_type=open_department_id&user_id_type=user_id",accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            fslogTextArea.appendText("获取账号信息的响应:\n" + userinfoResponse + "\n");
        });


        return gridPane;
    }

    private Pane createProxySettingsContent() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(14);
        gridPane.setVgap(14);
        useProxyCheckBox = new CheckBox("使用代理");
        useProxyCheckBox.setSelected(false); // 默认情况下不使用代理
        useProxyCheckBox.setOnAction(e -> {
            ProxyManager.getInstance().setUseProxy(useProxyCheckBox.isSelected());
        });


        // 将useProxyCheckBox及其相关组件添加到proxyGridPane中
        Label proxyHostLabel = new Label("HTTP代理主机:");
        proxyHostTextField = new TextField("127.0.0.1");

        Label proxyPortLabel = new Label("HTTP代理端口:");
        proxyPortTextField = new TextField("8080");
        proxyHostLabel.setMinWidth(100);
        proxyPortLabel.setMinWidth(100);

        gridPane.add(proxyHostLabel, 2, 0);
        gridPane.add(proxyHostTextField, 3, 0);
        gridPane.add(proxyPortLabel, 2, 1);
        gridPane.add(proxyPortTextField, 3, 1);
        gridPane.add(useProxyCheckBox, 2, 2);

        // 返回代理设置标签页的内容
        return gridPane;
    }



}

