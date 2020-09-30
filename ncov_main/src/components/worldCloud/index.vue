<template>
    <div class="wrap-container sn-container">
        <div class="sn-content" style="background-color: rgba(116,116,130,1)">
            <div class="sn-title" style="color: #ffffff">疫情关键字</div>
            <div class="sn-body">
                <div class="wrap-container">
                    <div class="chartsdom" ref="myEchart"></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import '../../assets/js/echarts-wordcloud.min'
    import {getWorldClouds} from '../../network/news'
    import axios from "axios";

    export default {
        name: "wordCloud",
        data() {
            return {
                timer: null,
                listdata:[]
            }
        },
        created() {
            getWorldClouds().then(res => {
                console.log(res)
                this.listData = res.data
            })
        },
        mounted() {
            this.getEchartRight1();
            this.timer = setInterval(() => {
                this.getEchartRight1();
            }, 5000)
        },
        methods: {
            getEchartRight1() {
                var instance = axios.create({ headers: {'content-type': 'application/x-www-form-urlencoded'} });
                instance.post('http://localhost:8080/api/worldClouds'
                    // eslint-disable-next-line no-undef
                ).then(response => {
                    console.log(response.data);
                    var datak = response.data;
                    var len = response.data.length;
                    // eslint-disable-next-line no-undef
                    var listdata = [];
                    //      console.log(this.listdata);
                    for (var i = 0; i < len; i++) {
                        var info = {};
                        info.name = datak[i].name;
                        info.value = datak[i].value;
                        listdata.push(info);	//把info里面的数据追加到data里
                    }
                    console.log(listdata);
                    let myChart = echarts.init(this.$refs.myEchart);
                    let option = {
                        // tooltip: {
                        //   show: false
                        // },
                        series: [{
                            type: 'wordCloud',
                            gridSize: 1,
                            sizeRange: [12, 50],
                            rotationRange: [-90, 90],
                            rotationStep: 45,
                            shape: 'diamond',
                            width: '90%',
                            textPadding: 0,
                            autoSize: {
                                enable: true,
                                minSize: 6
                            },
                            textStyle: {
                                normal: {
                                    textBorderColor: 'rgba(255,255,255,1)',
                                    textBorderWidth: 1.5,
                                    color: () => {
                                        return 'rgb(' + [
                                            Math.round(Math.random() * 160),
                                            Math.round(Math.random() * 160),
                                            Math.round(Math.random() * 160),1
                                        ].join(',') + ')';
                                    }
                                },
                                emphasis: {
                                    fontSize: 20,
                                    // shadowBlur: 10,
                                    // shadowColor: 'rgba(255,255,255, .1)'
                                }
                            },
                            data: listdata
                        }]
                    }
                    myChart.setOption(option, true);
                    window.addEventListener('resize', () => {
                        myChart.resize();
                    });
                });
            },
        },
        beforeDestroy() {
            clearInterval(this.timer);
        }
    };
</script>

<style lang="scss" scoped>
    .sn-container {
        left: 1370px;
        top: 325px;
        width: 500px;
        height: 285px;
        background-color: rgba(91,92,110,1);
        .chartsdom {
            width: 100%;
            height: 100%;
        }
    }
</style>
