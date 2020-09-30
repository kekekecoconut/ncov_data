<template>
  <div class="wrap-container sn-container">
    <div class="sn-content" style="background-color: rgba(116,116,130,1)">
      <div class="sn-title" style="color: #ffffff">全国新增确诊</div>
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
        instance.post('http://localhost:8080/api/currentVariety'
                // eslint-disable-next-line no-undef
        ).then(response => {
          console.log(response.data);
          var datak = response.data;
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
              data: ['2020-03-03', '2020-03-15', '2020-04-03', '2020-04-15', '2020-05-03', '2020-05-15', '2020-06-03', '2020-06-15', '2020-07-03', '2020-07-15', '2020-08-03', '2020-08-15', '2020-09-06']
            },
            yAxis: {
              type: 'value'
            },
            series: [{
              data: datak,
              type: 'line'
            }]
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
