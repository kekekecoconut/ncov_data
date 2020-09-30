<template>
  <div class="wrap-container trigle">
    <div class="echarts">
      <div :style="{height:'500px',width:'720px'}" ref="myEchart"></div>
    </div>
  </div>

</template>

<script>
  import echarts from "echarts";
  import axios from 'axios';
  import '../../../node_modules/echarts/map/js/world.js';
  import halloween from '../../assets/js/purple-passion';
  export default {
    name: "worldMap",
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
        instance.post('http://localhost:8080/api/currentCountryConfirmed'
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
            title: {
              text: '全球疫情概况',
              x: 'center'
            },
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
              max: 200000,
              text: ['High', 'Low'],
              calculable: true,
            },

            series: [
              {
                name: '现存确诊人数',
                type: 'map',
                roam: true,
                map: 'world',
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
  .trigle {
    left: 600px;
    top: 100px;
    width: 720px;
    height: 500px;
  }
</style>
