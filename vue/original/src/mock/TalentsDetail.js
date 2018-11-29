const info = {
  "id": "10001",
  "name": "张三",
  "sex": 1,
  "roleId": "frontEnd",
  "roleName": "前端工程师",
  "likeNum": 32,
  "avatar": "",
  "city": "天津",
  "experienceId": "3-5year",
  "experienceName": "3-5年",
  "skill": "HTML5，Vue，React，Python",
  "teamId": "team001",
  "teamName": "银河战队",
  "recordSuccess": 1,
  "recordFail": 0,
  "recordDeveloping": 1,
  "workdayIdleStartTime": "20:00",
  "workdayIdleEndTime": "23:00",
  "weekendIdleStartTime": "8:00",
  "weekendIdleEndTime": "23:00",
  "influence": 86,
  "introduce": "热衷于技术实现;\n" +
  "擅长Web前端、微信公众号、 微信小程序、app（ios）\n" +
  "主要语言：OC Swift WeUI JavaScrip;其他技术：HTML5、JS\n" +
  "熟悉常用 Core Data , Core Graphics, Core Animation,和OpenGLES框架，微信小程序熟练使用WEUI等框架，擅长Vue ,ionic ,BootStrap等框架;已完成 一路乐旅游 等项目;\n" +
  "目前对大数据、AI、HTML游戏技术比较感兴趣;",
  eduExperience: [
    {
      id: "1000101",
      startDate: '2012-9',
      endDate: '2016-6',
      school: '北京大学',
      major: '计算机科学与技术',
      degree: '本科',
      desc:"大一获得三等奖学金 过英语四级 计算机二级 参加江西省电子制作大赛"
    },
    {
      id: "1000101",
      startDate: '2012-9',
      endDate: '2016-6',
      school: '北京大学',
      major: '计算机科学与技术',
      degree: '本科',
      desc:"大一获得三等奖学金 过英语四级 计算机二级 参加江西省电子制作大赛. 大一获得三等奖学金 过英语四级 计算机二级 参加江西省电子制作大赛. 大一获得三等奖学金 过英语四级 计算机二级 参加江西省电子制作大赛"
    }
  ],
  workExperience: [
    {
      id: "1000201",
      startDate: '2017-10',
      endDate: '至今',
      company: '上海拉扎斯网络科技有限公司',
      position: '前端工程师',
      desc: '负责前端页面的研发，项目维护工作'
    },
    {
      id: "1000201",
      startDate: '2016-10',
      endDate: '2017-09',
      company: '北京小二货科技有限公司',
      position: '前端工程师',
      desc: '负责前端页面的研发，项目维护工作'
    }
  ]
};

const projectRecord = [
  {
    type: 'success',
    code: 1,
    text: '已完成',
    data: [
      {
        id: "success001",
        name: "旷野30年",
        roleId: "frontEnd",
        roleName: "前端工程师",
        img: "http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=5e4227ab79f08202399f997c23929198/5bafa40f4bfbfbed586df5f772f0f736afc31f06.jpg"
      },
      {
        id: "success002",
        name: "西部世界之无脉法门哈哈哈哈",
        roleId: "frontEnd",
        roleName: "前端工程师",
        img: "http://img.pintu360.com/other/20170505/2c7d8cb9-59b8-498d-a0a0-37ea00135d6b.jpg"
      },
      {
        id: "success002",
        name: "西部世界之无脉法门哈哈哈哈",
        roleId: "frontEnd",
        roleName: "前端工程师",
        img: "http://img.pintu360.com/other/20170505/2c7d8cb9-59b8-498d-a0a0-37ea00135d6b.jpg"
      },
      {
        id: "success002",
        name: "西部世界之无脉法门哈哈哈哈",
        roleId: "frontEnd",
        roleName: "前端工程师",
        img: "http://img.pintu360.com/other/20170505/2c7d8cb9-59b8-498d-a0a0-37ea00135d6b.jpg"
      },
      {
        id: "success001",
        name: "旷野30年",
        roleId: "frontEnd",
        roleName: "前端工程师",
        img: "http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=5e4227ab79f08202399f997c23929198/5bafa40f4bfbfbed586df5f772f0f736afc31f06.jpg"
      },
      {
        id: "success002",
        name: "西部世界之无脉法门哈哈哈哈",
        roleId: "frontEnd",
        roleName: "前端工程师",
        img: "http://img.pintu360.com/other/20170505/2c7d8cb9-59b8-498d-a0a0-37ea00135d6b.jpg"
      },
    ]
  },
  {
    type: 'developing',
    code: 2,
    text: '进行中',
    data: [
      {
        id: "developing001",
        name: "科技危机",
        roleId: "backEnd",
        roleName: "后端工程师",
        img: "http://i.dimg.cc/d9/91/b1/82/62/d8/7e/0b/ea/00/6a/95/b9/05/af/fe.jpg"
      },
    ]
  }
];


export {info, projectRecord}