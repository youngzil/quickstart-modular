package com.alibaba.edas;

import com.taobao.pandora.boot.PandoraBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HSFProviderApplication {

  public static void main(String[] args) {

    // 通过 VM options 配置启动参数 -Djmenv.tbsite.net={$IP}，通过 main 方法直接启动。其中 {$IP} 为轻量配置中心的 IP 地址。列如本机启动轻量配置中心，则 {$IP} 为 127.0.0.1。
    System.setProperty("jmenv.tbsite.net", "127.0.0.1");
    System.setProperty("pandora.location", "/Users/yangzl/repo/com/taobao/pandora/taobao-hsf.sar/2019-06-stable/taobao-hsf.sar-2019-06-stable.jar");

    // 启动 Pandora Boot 用于加载 Pandora 容器
    PandoraBootstrap.run(args);
    SpringApplication.run(HSFProviderApplication.class, args);
    // 标记服务启动完成,并设置线程 wait。防止用户业务代码运行完毕退出后，导致容器退出。
    PandoraBootstrap.markStartupAndWait();
  }
}
