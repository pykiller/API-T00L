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

public class HttpPacketToolGUI extends Application {

    private TextArea logTextArea;
    private TextField appKeyTextField;
    private PasswordField appSecretPasswordField;
    private TextField accessTokenTextField;
    private TextField proxyHostTextField;
    private TextField proxyPortTextField;
    private TextField mobileTextField;
    private TextField nameTextField;
    private TextField titleTextField;
    private TextField useridTextField;
    private TextField UserIdTextField;
    private TextField userTextField;
    private TextField blackboardcontentTextField;
    private TextField blackboardtitleTextField;
    private TextField operation_useridTextField;
    private TextField deptid_listTextField;
    private CheckBox useProxyCheckBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("API-T00l利用工具 V1.0 @PYkiller");

        // 创建一个根布局为TabPane，用于添加标签页
        TabPane tabPane = new TabPane();

        // 创建钉钉标签页
        Tab dingTalkTab = new Tab("钉钉");
        dingTalkTab.setContent(createDingTalkTabContent());

        // 创建企业微信标签页
        Tab weChatWorkTab = new Tab("企业微信");
        weChatWorkTab.setContent(createWeChatWorkTabContent());

        // 将标签页添加到TabPane
        tabPane.getTabs().addAll(dingTalkTab, weChatWorkTab);

        // 创建一个根布局为BorderPane，将TabPane放在顶部
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(tabPane);
        borderPane.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        // 将BorderPane添加到Scene中
        Scene scene = new Scene(borderPane, 650, 690);
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
        useProxyCheckBox = new CheckBox("使用代理");
        useProxyCheckBox.setSelected(false); // 默认情况下不使用代理
        useProxyCheckBox.setOnAction(e -> {
            ProxyManager.getInstance().setUseProxy(useProxyCheckBox.isSelected());
        });
        Label appKeyLabel = new Label("AppKey:");
        appKeyTextField = new TextField();

        Label appSecretLabel = new Label("AppSecret:");
        appSecretPasswordField = new PasswordField();

        Label accessTokenLabel = new Label("Access Token:");
        accessTokenTextField = new TextField();
        accessTokenTextField.setPromptText("输入 Access Token");

        Label proxyHostLabel = new Label("HTTP代理主机:");
        proxyHostTextField = new TextField("127.0.0.1");

        Label proxyPortLabel = new Label("HTTP代理端口:");
        proxyPortTextField = new TextField("8080");

        Button getTokenButton = new Button("获取Token");
        Button getAdminButton = new Button("获取管理员信息");
        Button getAppButton = new Button("获取应用列表");
        Button getRoleButton = new Button("获取角色列表");
        useridTextField = new TextField("userID");
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
        accessTokenLabel.setMinWidth(170);
        proxyHostLabel.setMinWidth(100);
        proxyPortLabel.setMinWidth(100);

        // 添加元素到GridPane中
        gridPane.add(appKeyLabel, 0, 0);
        gridPane.add(appKeyTextField, 1, 0);
        gridPane.add(appSecretLabel, 0, 1);
        gridPane.add(appSecretPasswordField, 1, 1);
        gridPane.add(accessTokenLabel, 0, 2);
        gridPane.add(accessTokenTextField, 1, 2);
        gridPane.add(proxyHostLabel, 2, 0);
        gridPane.add(proxyHostTextField, 3, 0);
        gridPane.add(proxyPortLabel, 2, 1);
        gridPane.add(proxyPortTextField, 3, 1);
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
        gridPane.add(useProxyCheckBox, 2, 2);
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

            // 执行获取管理员的HTTP请求，将 access_token 添加到头部
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

                    // 执行获取管理员的HTTP请求，将 access_token 添加到头部
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

            // 执行获取管理员的HTTP请求，将 access_token 添加到头部
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

            // 执行获取管理员的HTTP请求，将 access_token 添加到头部
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

            // 执行获取管理员的HTTP请求，将 access_token 添加到头部
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
        appKeyTextField = new TextField();

        Label appSecretLabel = new Label("Corpsecret:");
        appSecretPasswordField = new PasswordField();

        Label accessTokenLabel = new Label("Access Token:");
        accessTokenTextField = new TextField();
        accessTokenTextField.setPromptText("输入 Access Token");

        Label proxyHostLabel = new Label("HTTP代理主机:");
        proxyHostTextField = new TextField("127.0.0.1");

        Label proxyPortLabel = new Label("HTTP代理端口:");
        proxyPortTextField = new TextField("8080");

        Button getTokenButton = new Button("获取Token");
        Button getJoinButton = new Button("获取邀请二维码");
        Button getUserlistButton = new Button("获取用户列表");
        Button wxcreateUserButton = new Button("新建账号");
        Button delUserButton = new Button("删除账号");
        Label useridLabel = new Label("UserID:");
        UserIdTextField = new TextField("64537405");
        Label mobileLabel = new Label("手机号:");
        mobileTextField = new TextField("18888888888");
        Label nameLabel = new Label("用户名:");
        nameTextField = new TextField("管理员");
        Label usernameLabel = new Label("用户别称:");
        userTextField = new TextField("zhangsan");
        Label titleLabel = new Label("职位:");
        titleTextField = new TextField("系统管理员");
        useridTextField = new TextField("userID");
        Button getUserButton = new Button("获取账号信息");



        // 设置每个标签的最小宽度，以保持对齐
        appKeyLabel.setMinWidth(170);
        appSecretLabel.setMinWidth(170);
        accessTokenLabel.setMinWidth(170);
        proxyHostLabel.setMinWidth(100);
        proxyPortLabel.setMinWidth(100);

        // 添加元素到GridPane中
        gridPane.add(appKeyLabel, 0, 0);
        gridPane.add(appKeyTextField, 1, 0);
        gridPane.add(appSecretLabel, 0, 1);
        gridPane.add(appSecretPasswordField, 1, 1);
        gridPane.add(accessTokenLabel, 0, 2);
        gridPane.add(accessTokenTextField, 1, 2);
        gridPane.add(proxyHostLabel, 2, 0);
        gridPane.add(proxyHostTextField, 3, 0);
        gridPane.add(proxyPortLabel, 2, 1);
        gridPane.add(proxyPortTextField, 3, 1);
        gridPane.add(useProxyCheckBox, 2, 2);
        gridPane.add(getTokenButton, 0, 6);
        gridPane.add(getJoinButton, 1, 6);
        gridPane.add(getUserlistButton, 0, 7);
        GridPane.setColumnSpan(wxcreateUserButton, 2); // 让按钮跨足两列
        gridPane.add(wxcreateUserButton, 2, 6);
        gridPane.add(delUserButton, 3, 6);
        gridPane.add(useridLabel, 2, 7);
        gridPane.add(UserIdTextField, 3, 7);
        gridPane.add(mobileLabel, 2, 8);
        gridPane.add(mobileTextField, 3, 8);
        gridPane.add(nameLabel, 2, 9);
        gridPane.add(nameTextField, 3, 9);
        gridPane.add(titleLabel, 2, 10);
        gridPane.add(titleTextField, 3, 10);
        gridPane.add(usernameLabel, 2, 11);
        gridPane.add(userTextField, 3, 11);
        gridPane.add(useridTextField, 1, 8);
        gridPane.add(getUserButton, 0, 8);


        // 设置GridPane的布局
        logTextArea = new TextArea();
        logTextArea.setPrefHeight(50);
        logTextArea.setEditable(false);
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

        WeiXinPacketSender packetSender = new WeiXinPacketSender();

        getTokenButton.setOnAction(e -> {
            String corpid = appKeyTextField.getText();
            String corpsecret = appSecretPasswordField.getText();


            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取Token的HTTP请求
            String tokenResponse = packetSender.weixinHttpGetRequest("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + corpsecret);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取Token的响应:\n" + tokenResponse + "\n");
        });
        getJoinButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取Token的HTTP请求
            String tokenResponse = packetSender.weixinHttpGetRequest("https://qyapi.weixin.qq.com/cgi-bin/corp/get_join_qrcode?access_token=" + accessToken);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取邀请二维码的响应:\n" + tokenResponse + "\n");
        });
        getUserlistButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String wxgetUserlistRequestBody = packetSender.wxgetUserlistRequestBody();
            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));


            String userlistResponse = packetSender.weixinHttpPostRequest("https://qyapi.weixin.qq.com/cgi-bin/user/list_id?access_token=" + accessToken,wxgetUserlistRequestBody);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取用户列表的响应(默认1000条):\n" + userlistResponse + "\n");
        });

        wxcreateUserButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String mobile = mobileTextField.getText();
            String name = nameTextField.getText();
            String title = titleTextField.getText();
            String userid = UserIdTextField.getText();
            String user = userTextField.getText();

            String wxcreateUserRequestBody = packetSender.wxgetAddUserRequestBody(mobile, name, title,userid,user);


            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行新建账号的HTTP请求，将 access_token 添加到头部
            String wxcreateUserResponse = packetSender.weixinHttpPostRequest("https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=" + accessToken, wxcreateUserRequestBody);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("新建账号的响应:\n" + wxcreateUserResponse + "\n");
        });

        delUserButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String UserId =  UserIdTextField.getText();


            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取管理员的HTTP请求，将 access_token 添加到头部
            String delUserResponse = packetSender.weixinHttpGetRequest("https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=" + accessToken + "&userid=" + UserId);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("删除用户的响应:\n" + delUserResponse + "\n");
        });

        getUserButton.setOnAction(e -> {
            String accessToken = accessTokenTextField.getText();
            String userid = useridTextField.getText();

            // 设置全局代理
            ProxyManager.getInstance().setProxy(proxyHostTextField.getText(), Integer.parseInt(proxyPortTextField.getText()));

            // 执行获取管理员的HTTP请求，将 access_token 添加到头部
            String getUserResponse = packetSender.weixinHttpGetRequest("https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken + "&userid=" + userid);

            // 清除代理设置，以便后续请求不使用代理
            ProxyManager.getInstance().clearProxy();

            logTextArea.appendText("获取账户信息的响应:\n" + getUserResponse + "\n");
        });

        return gridPane;
    }


}

