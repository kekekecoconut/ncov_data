<template>
  <div class="wrap-container sn-container">
    <div class="sn-content" style="background-color: rgba(116,116,130,1)">
      <div class="sn-title" style="color: #ffffff">高死亡率国家</div>
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
    name: "countryDead",
    props: ["userJson"],
    data() {
      return {
        chart: null,
        country: [],
        rate:[]
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
        instance.post('http://localhost:8080/api/deadRate'
                // eslint-disable-next-line no-undef
        ).then(response => {
          console.log(response.data);
          var datak = response.data;
          var len = response.data.length;
          var country=[];
          var rate=[];
          for(var i=0;i<len;i++){
            country.push(datak[i].country);
            rate.push(datak[i].deadrate);
          }
          let myChart = echarts.init(this.$refs.myEchart,'purple-passion'); //这里是为了获得容器所在位置
          window.onresize = myChart.resize;
          myChart.setOption({
            backgroundColor: 'rgba(116,116,130,1)',
         //   backgroundColor:'#ffffff',
            tooltip: {
              trigger: 'axis',
              axisPointer: {
                type: 'shadow'
              }
            },
            legend: {
              data: '2020年'
            },
            grid: {
              left: 80,
              bottom: 50
            },
            xAxis: {
              type: 'value',
              boundaryGap: [0, 0.01]
            },
            yAxis: {
              type: 'category',
              data: country
            },
            series: [
              {
                type: 'bar',
                data: rate
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
  left: 680px;
  top: 640px;
  width: 600px;
  height: 400px;
  background-color: rgba(91,92,110,1);
  .chartsdom {
    width: 100%;
    height: 100%;
  }
}
</style>
