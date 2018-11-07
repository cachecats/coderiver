<!--大模块的最上面条件过滤器-->
<template>
  <div class="filter">
    <div class="row" v-for="(rowItem, rowIndex) in rowData">
      <span class="title">{{rowItem.name}}</span>
      <div class="label-wrapper">
        <span class="item" v-for="(item2, index2) in rowItem.items"
              :class="{active: row1SelectId === item2.id || row2SelectId === item2.id}"
              @click="selectItem(rowIndex, index2)">{{item2.name}}</span>
      </div>
    </div>
    <div class="sort-wrapper">
      <span class="title">排序</span>
      <el-select class="select" v-model="sort" placeholder="请选择" @change="sortChange" size="mini">
        <el-option
            v-for="item in sortData"
            :key="item.id"
            :label="item.name"
            :value="item.id"
        ></el-option>
      </el-select>
    </div>
  </div>
</template>

<script>

  const TALENTS = [
    {
      id: "role",
      name: "角色",
      items: [
        {id: 'roleAll', name: '全部'},
        {id: 'designer', name: '设计师'},
        {id: 'frontEnd', name: '前端工程师'},
        {id: 'backEnd', name: '后端工程师'},
        {id: 'mobile', name: '移动端工程师'},
        {id: 'game', name: '游戏工程师'},
        {id: 'pm', name: '产品经理'},
      ]
    },
    {
      id: 'experience',
      name: '经验',
      items: [
        {id: 'experienceAll', name: '全部'},
        {id: 'student', name: '在校生'},
        {id: '0year', name: '0年'},
        {id: '1-2year', name: '1-2年'},
        {id: '3-5year', name: '3-5年'},
        {id: '5-10year', name: '5-10年'},
        {id: '10more', name: '10年+'},
      ]
    }
  ];

  const PROJECTS = [
    {
      id: "type",
      name: "类型",
      items: [
        {id: 'typeAll', name: '全部'},
        {id: 'recruit', name: '队员招募中'},
        {id: 'success', name: '组队成功'}
      ]
    },
    {
      id: "schedule",
      name: "进度",
      items: [
        {id: 'scheduleAll', name: '全部'},
        {id: 'onDesign', name: '设计中'},
        {id: 'onDevelop', name: '研发中'},
        {id: 'done', name: '完成'},
      ]
    }
  ];

  const RESOURCES = [
    {
      id: "integrity",
      name: "完整度",
      items: [
        {id: 'integrityAll', name: '全部'},
        {id: 'axure', name: '原型图'},
        {id: 'design', name: '设计图'},
        {id: 'slicing', name: '切图'},
      ]
    },
    {
      id: "difficulty",
      name: "难度",
      items: [
        {id: 'difficultyAll', name: '全部'},
        {id: 'new', name: '新手'},
        {id: 'middle', name: '中级'},
        {id: 'advanced', name: '高级'},
      ]
    }
  ];

  const TALENTS_SORT = [{id: 0, name: '默认'}, {id: 1, name: '影响力'}, {id: 2, name: '经验'}];
  const PROJECT_SORT = [{id: 0, name: '默认'}, {id: 1, name: '热度'}, {id: 2, name: '难度'}];
  const RESOURCE_SORT = [{id: 0, name: '默认'}, {id: 1, name: '热度'}, {id: 2, name: '难度'}];

  export default {
    props: {
      flag: {
        type: String,
        required: true
      }
    },
    components: {},
    created() {
      //设置初始值为全选
      this.row1SelectId = this.rowData[0].items[0].id;
      this.row2SelectId = this.rowData[1].items[0].id;
    },
    data() {
      return {
        talents: TALENTS,
        projects: [],
        resources: [],
        row1SelectId: '',
        row2SelectId: '',
        sort: 0
      }
    },
    computed: {
      rowData() {
        if (this.flag === 'talents') {
          return TALENTS
        } else if (this.flag === 'project') {
          return PROJECTS
        } else if (this.flag === 'resource') {
          return RESOURCES
        }
      },
      sortData() {
        if (this.flag === 'talents') {
          return TALENTS_SORT
        } else if (this.flag === 'project') {
          return PROJECT_SORT
        } else if (this.flag === 'resource') {
          return RESOURCE_SORT
        }
      }
    },
    methods: {
      /**
       * 点击选中具体项
       */
      selectItem(index1, index2) {
        if (index1 === 0) {
          this.row1SelectId = this.rowData[0].items[index2].id
        } else if (index1 === 1) {
          this.row2SelectId = this.rowData[1].items[index2].id
        }
        console.log(this.row1SelectId, this.row2SelectId)
      },

      /**
       * 排序方式变化回调
       * @param value
       */
      sortChange(value) {
        console.log("sortChange", value)
      }
    },

  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";

  $text-size: 14px;
  $height: 50px;

  .filter {
    width: 100%;
    padding: 10px 20px;
    box-sizing: border-box;
    background-color: white;
    .row {
      display: flex;
      width: 100%;
      height: $height;
      line-height: $height;
      padding: 0 20px;
      box-sizing: border-box;
      .title {
        width: 60px;
        height: $height;
        line-height: $height;
        font-size: $text-size;
        color: $text-main;
        font-weight: 400;
      }
      .label-wrapper{
        flex: 1;
        border-bottom: 1px solid $border-fourth;
        .item {
          font-size: $text-size;
          color: $text-main;
          height: $height;
          line-height: $height;
          font-weight: normal;
          padding: 5px 15px;
          cursor: pointer;
          &:hover {
            color: $color-main;
          }
          &.active {
            color: $color-main;
            background: rgb(221, 239, 254);
          }
        }
      }

    }
    .sort-wrapper {
      width: 100%;
      height: $height;
      line-height: $height;
      padding: 0 20px;
      .title {
        display: inline-block;
        width: 60px;
        height: $height;
        line-height: $height;
        font-size: $text-size;
        color: $text-main;
        font-weight: 400;
      }
      .select {
        width: 100px;
      }
    }
  }

</style>
