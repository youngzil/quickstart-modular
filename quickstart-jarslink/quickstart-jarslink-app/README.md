使用说明
分别运行打包quickstart-modular-jarslink-service-a和quickstart-modular-jarslink-service-b打成jar包
ModuleRefreshSchedulerImpl类中的PATH参数值换成你本地路径
启动ModuleApplication中的main方法
浏览器请求http://ip:8999/jarslink/service-a/user/*your-name*获取模块用户信息
浏览器请求http://ip:8999/jarslink/service-b/order/*order-id*获取模块订单信息


测试步骤：
先打包service-a和service-b，然后启动ModuleApplication中的main方法
访问
http://localhost:8999/info
http://localhost:8999/jarslink/service-a/user/yangzl
http://localhost:8999/jarslink/service-b/order/1111

然后修改service-a和service-b中的代码，重新打包，再次访问上诉链接


模块
moduel-main 用于加载模块JAR包，对外提供服务
service-a 获取用户信息Action
service-b 获取订单信息Action


类名	说明
young.hu.jarslink.main.MainController	接收外部HTTP请求并将请求转发到具体模块
young.hu.jarslink.main.ModuleConfiguration	Bean配置
young.hu.jarslink.main.ModuelRefreshSchedulerImpl	模块加载器配置
young.hu.jarslink.a.actions.UserAction	获取用户信息Action
young.hu.jarslink.b.actions.OrderAction	获取订单信息Action

