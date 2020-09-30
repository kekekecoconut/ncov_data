<template>
  <div class="wrap-container sn-container">
    <div class="sn-content">
      <div class="sn-title" style="color: #ffffff; font-size: 18px;">新疆现存确诊情况</div>
      <div class="sn-body" style="background-color: rgba(116,116,130,1)">
        <div class="wrap-container">
          <div class="echarts">
            <div :style="{height:'450px'}" ref="myEchart"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import echarts from "echarts";
  import axios from 'axios';
  import '../../../node_modules/echarts/map/js/province/xinjiang.js';
  import halloween from '../../assets/js/purple-passion';
  export default {
    name: "mapXinjiang",
    props: ["userJson"],
    data() {
      return {
        chart: null,
        listdata: []
      };
    },
    mounted() {
      this.chinaConfigure();
    },
    beforeDestroy() {
      if (!this.chart) {
        return;
      }
      this.chart.dispose();
      this.chart = null;
    },
    methods: {
      chinaConfigure() {
        var instance = axios.create({ headers: {'content-type': 'application/x-www-form-urlencoded'} });
        instance.post('http://localhost:8080/api/currentXinjiangConfirmed'
                // eslint-disable-next-line no-undef
        ).then(response => {
          console.log(response.data);
          var datak = response.data;
          var len = response.data.length;
          // eslint-disable-next-line no-undef
          var listdata=[];
          //      console.log(this.listdata);
          for(var i=0;i<len;i++){
            var info={};
            info.name=datak[i].name;
            info.value=datak[i].value;
            listdata.push(info);	//把info里面的数据追加到data里
          }
          console.log(listdata);
          let myChart = echarts.init(this.$refs.myEchart,'purple-passion'); //这里是为了获得容器所在位置
          window.onresize = myChart.resize;
          myChart.setOption({
            backgroundColor: 'transparent',
            tooltip: {
              trigger: 'item',
              showDelay: 0,
              transitionDuration: 0.2,
              formatter: function (params) {
                var value = (params.value + '').split('.');
                value = value[0].replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))/g, '$1,');
                return params.seriesName + '<br/>' + params.name + ': ' + value;
              }
            },
            visualMap: {
              left: 'right',
              min: 0,
              max: 230,
              text: ['High', 'Low'],
              calculable: true,
            },

            series: [
              {
                name: '现存确诊人数',
                type: 'map',
                roam: true,
                map: '新疆',
                emphasis: {
                  label: {
                    show: true
                  }
                },
                textFixed: {
                  Alaska: [20, -20]
                },
                data: listdata
              }
            ]
          });
        });
      }
    }
  }
</script>

<style lang="scss" scoped>
  .sn-container {
    left: 50px;
    top: 100px;
    height: 500px;

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
