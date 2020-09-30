<template>
  <div class="wrap-container sn-container">
    <div class="sn-content" style="background-color: rgba(116,116,130,1)">
      <div class="sn-title" style="color: #ffffff">重点国家每日新增确诊</div>
      <div class="sn-body">
        <div class="wrap-container">
          <div class="chartsdom" ref="myEchart"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import echarts from "echarts";
  import axios from 'axios';
  import halloween from '../../assets/js/purple-passion';
  export default {
    name: "increasedLine",
    props: ["userJson"],
    data() {
      return {
        chart: null,
        country: [],
        date: [],
        increased1:[],
        increased2:[],
        increased3:[],
        increased4:[]
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
        instance.post('http://localhost:8080/api/confirmedIncreased'
                // eslint-disable-next-line no-undef
        ).then(response => {
          console.log(response.data);
          var datak = response.data;
          var len = response.data.length;
          var country=[];
          var date=datak[0].date;
          var increased1=datak[0].increased;
          var increased2=datak[1].increased;
          var increased3=datak[2].increased;
          var increased4=datak[3].increased;
          for(var i=0;i<len;i++){
            country.push(datak[i].country);
          }
          let myChart = echarts.init(this.$refs.myEchart,'purple-passion'); //这里是为了获得容器所在位置
          window.onresize = myChart.resize;
          myChart.setOption({
            backgroundColor: 'rgba(116,116,130,1)',
            tooltip: {
              trigger: 'axis',
              axisPointer: {
                type: 'shadow'
              }
            },
            grid: {
              left: 80,
              bottom: 50
            },
            xAxis: {
              type: 'category',
              data:date
            },
            yAxis: {
              type: 'value'
            },
            series: [
              {
                name: '美国',
                type: 'line',
                data: increased1
              },
              {
                name: '巴西',
                type: 'line',
                data: increased2
              },
              {
                name: '俄罗斯',
                type: 'line',
                data: increased3
              },
              {
                name: '英国',
                type: 'line',
                data: increased4
              }
            ]
          });
        });
      }
    }
  };
</script>

<style lang="scss" scoped>
  .sn-container {
    left: 1320px;
    top: 640px;
    width: 550px;
    height: 400px;
    background-color: rgba(91,92,110,1);
    .chartsdom {
      width: 100%;
      height: 100%;
    }
  }
</style>
