import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";
import ResourceCenter from './views/ResourceCenter'
import ProjectCenter from './views/ProjectCenter'
import ProjectDetail from './views/ProjectDetail'
import TalentsCenter from './views/TalentsCenter'
import TalentsDetail from './views/TalentsDetail'
import Register from './views/Register'
import NewProject from './views/NewProject'
import WorkStation from './views/workstation/WorkStation'
import MyProject from './views/workstation/myproject/MyProject'
import MyTeam from './views/workstation/myteam/MyTeam'
import TeamApply from './views/workstation/teamapply/TeamApply'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/home",
      name: "home",
      component: Home
    },
    {
      path: "/resource",
      name: "resource",
      component: ResourceCenter
    },
    {
      path: "/project",
      name: "project",
      component: ProjectCenter
    },
    {
      path: "/project_detail",
      name: "project_detail",
      component: ProjectDetail
    },
    {
      path: "/talents",
      name: "talents",
      component: TalentsCenter
    },
    {
      path: "/talents_detail",
      name: "talents_detail",
      component: TalentsDetail
    },
    {
      path: "/register",
      name: "register",
      component: Register
    },
    {
      path: "/newproject",
      name: "newproject",
      component: NewProject
    },
    {
      path: "/workstation",
      name: "workstation",
      component: WorkStation,
      redirect: '/workstation/myproject',
      children: [
        {
          path: 'myproject',
          name: 'myproject',
          component: MyProject
        },
        {
          path: 'myteam',
          name: 'myteam',
          component: MyTeam,
        },
        {
          path: 'teamapply',
          name: 'teamapply',
          component: TeamApply
        },
      ]
    },
    {
      path: "/",
      redirect: "/home"
    },

  ]
});
