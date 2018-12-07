# coderiver

致力于打造全平台全栈精品开源项目

## 技术栈

本项目Android端的开发宗旨是“不断学习，不断挖坑，不断优化”

所以经B组成员讨论，Android端采用当前最新最热的框架进行开发，

模块化开发 + Kotlin + MVVM + RxJava + Glide + ARouter + Dagger2

<ul>
  <li>
Kotlin ：2017年Kotlin 成为 Android 官方开发语言，而Kotlin又以简洁、安全、实用高效著称，本着学习进步的态度，Kotlin成为本项目开发的不二之选。
  </li>
  <li>
MVVM ：低耦合、可重用、双向绑定
  </li>    
  <li>
RxJava ： 可以让异步操作更加简洁
  <li>
  <li>
Glide ：图片加载
  <li>
  <li>
ARouter ： 一个用于帮助 Android App 进行组件化改造的框架 —— 支持模块间的路由、通信、解耦
  <li>
  <li>
Dagger2 ：Android最棒的依赖注入框架
  <li>
  <li>
模块化开发 ：解耦，各模块可独立运行，加快编译时间。
  </li>
</ul>

## 文件目录

清晰的文件树是项目结构化关键的一部分，请描述当前的结构

> e.g.

```
.
├── client
│   ├── components
│   ├── constant
│   ├── container
│   ├── public
│   ├── redux
│   │   ├── actions
│   │   ├── reducers
│   │   └── store
│   ├── resources
│   │   └── less
│   ├── routes
│   └── util
├── tmp
│   └── dll
└── tools
    ├── commands
    ├── configs
    │   ├── dev
    │   └── prod
    └── utils
```

## 环境依赖

（Mac ，Window，Linux）系统下运行程序的相关环境

> e.g.

For Mac

- nodejs >= 8.0
- yarn >= 1.7

## 运行

项目开发步骤

> e.g.

1. yarn
2. yarn run start
3. yarn run build

## 部署

部署到服务器的相关流程

[^notice]: 此文档为项目主要内容，每个小组根据自己情况完善`README`
