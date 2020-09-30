<template>
  <div class="wrap-container sn-container">
    <div class="sn-content">
      <div class="sn-title" style="color: #ffffff; font-size: 18px;">每日疫情数据</div>
      <div class="sn-body" style="background-color: rgba(116,116,130,1)">
        <div class="wrap-container">

          <div class="table">
            <table border="0" cellpadding="0" cellspacing="0" class="table-header">
              <tbody>
              <tr>
                <td width="25%">
                  <span>国 家</span>
                </td>
                <td width="25%">
                  <span>现存确诊</span>
                </td>
                <td width="25%">
                  <span>总确诊</span>
                </td>
                <td width="25%">
                  <span>治愈数</span>
                </td>
              </tr>
              </tbody>
            </table>

            <vue-seamless-scroll :data="listData" class="seamless-warp" :class-option="optionSetting">
              <table border="0" cellpadding="0" cellspacing="0" class="item" style="color: #ffffff">
                <tbody style="color: #ffffff">
                <tr v-for="(item, index) in listData" :key="index">
                  <td width="25%" style="color: #ffffff">
                    <span>{{ item.provinceName }}</span>
                  </td>
                  <td width="25%" style="color: #ffffff">
                    <span>{{ item.currentConfirmedCount }}</span>
                  </td>
                  <td width="25%" style="color: #ffffff">
                    <span>{{ item.confirmedCount }}</span>
                  </td>
                  <td width="25%" style="color: #ffffff">
                    <span>{{ item.curedCount }}</span>
                  </td>
                </tr>
                </tbody>
              </table>
            </vue-seamless-scroll>
          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import vueSeamlessScroll from 'vue-seamless-scroll'
  // eslint-disable-next-line no-unused-vars
  import {getCountryData} from '../../network/news'

  export default {
    name: "worldData",
    components: {
      vueSeamlessScroll
    },
    created() {
      getCountryData().then(res => {
        console.log(res)
        this.listData = res.data
      })
    },
    data() {
      return {
        listData: []
      }
    },
    computed: {
// eslint-disable-next-line no-irregular-whitespace
      optionSetting () {
        return {
          step: 0.5, // 数值越大速度滚动越快
          limitMoveNum: 2, // 开始无缝滚动的数据量 this.dataList.length
          hoverStop: true, // 是否开启鼠标悬停stop
          direction: 1, // 0向下 1向上 2向左 3向右
          // autoPlay: false,
          openWatch: true, // 开启数据实时监控刷新dom
          singleHeight: 0, // 单步运动停止的高度(默认值0是无缝不停止的滚动) direction => 0/1
          singleWidth: 0, // 单步运动停止的宽度(默认值0是无缝不停止的滚动) direction => 2/3
          waitTime: 1000 // 单步运动停止的时间(默认值1000ms)
        }
      }
    },
    mounted() {

    },
    methods: {

    },
    beforeDestroy() {

    }
  };
</script>

<style lang="scss" scoped>
  .sn-container {
    left: 1370px;
    top: 100px;
    bottom: 30px;
    height: 200px;

    .sn-content {
      background-color: rgba(116,116,130,1);
    }

    %table-style {
      width: 100%;
      height: 20px;

      table-layout: fixed;
      tr {
        td {
          padding: 10px 5px;
          text-align: center;
          background-color: transparent;
          white-space: nowrap;
          overflow: hidden;
          color: #eeeeee;
          font-size: 16px;
          //    font-style: inherit;
        }
      }
    }
    .table {
      .table-header {
        @extend %table-style;
      }
      .seamless-warp {
        height: 400px;
        overflow: hidden;
        visibility: visible;
        .colorRed {
          color: #FF4669;
        }
        .colorOrange {
          color: #FFC956;
        }
        .item {
          height: auto;
          @extend %table-style;
          tr {
            td {
              &.title {
                text-overflow: ellipsis;
                display: inline-block;
              }
            }
          }
        }
      }
    }
  }
</style>
