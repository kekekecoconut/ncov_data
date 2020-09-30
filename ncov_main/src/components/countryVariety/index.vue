<template>
  <div class="wrap-container sn-container">
    <div class="sn-content" style="background-color: rgba(116,116,130,1)">
      <div class="sn-title" style="color: #ffffff">重点国家确诊人数变化</div>
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
  // eslint-disable-next-line no-unused-vars
  import axios from 'axios';
  import halloween from '../../assets/js/purple-passion';
  //import '../../node_modules/echarts/map/js/china.js' // 引入中国地图数据
  export default {
    name: "countryVariety",
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
        instance.post('http://localhost:8080/api/allDateConfirmed'
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
            info.type='line';
            info.areaStyle={};
            info.data=datak[i].data;
            listdata.push(info);	//把info里面的数据追加到data里
          }
          console.log(listdata);
          let myChart = echarts.init(this.$refs.myEchart,'purple-passion'); //这里是为了获得容器所在位置
          window.onresize = myChart.resize;
          myChart.setOption({
                   backgroundColor: 'rgba(116,116,130,1)',
        //    title: {
        //      text: '疫情情况',
       //       x: 'center'
        //    },
            grid: {
              left: 100,
              bottom: 50
            },
            tooltip: {
              trigger: 'axis',
              transitionDuration: 0.2,
              axisPointer: {
                type: 'cross',
                label: {
                  //   backgroundColor: '#6a7985'
                }
              }
            },
            legend: {
              data: ['英国', '印度', '俄罗斯', '巴西', '美国'],
              left: 0
            },
            toolbox: {
              feature: {
                saveAsImage: {}
              }
            },
            xAxis: [
              {
                type: 'category',
                boundaryGap: false,
                data: ['2020-04-15', '2020-05-15', '2020-06-15', '2020-07-15', '2020-08-24']
              }
            ],
            yAxis: [
              {
                type: 'value'
              }
            ],
            series: listdata
          });
        });
      }
    }
  }
</script>

<style lang="scss" scoped>
.sn-container {
  left: 50px;
  top: 640px;
  width: 600px;
  height: 400px;
  background-color: rgba(91,92,110,1);
  .chartsdom {
    width: 100%;
    height: 95%;
  }
}
</style>
