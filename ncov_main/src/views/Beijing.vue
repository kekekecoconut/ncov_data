<template>
    <div class="home-container">
        <div class="wrap" ref="editor">
            <div class="top"></div>
            <div class="center">
                <div class="item center">
                    <div class="resume">
                        <div class="resume-hd">
                            <ul>
                                <li style="color: #5afafd">
                                    <countTo :startVal='startVal' :endVal='90539' :duration='3000' separator=""></countTo>
                                </li>
                                <li>
                                    <countTo :startVal='startVal' :endVal='477' :duration='6000' separator=""></countTo>
                                </li>
                                <li>
                                    <countTo :startVal='startVal' :endVal='4735' :duration='6000' separator=""></countTo>
                                </li>
                            </ul>
                        </div>
                        <div class="resume-bd">
                            <ul>
                                <li>全国累计确诊</li>
                                <li>全国现存确诊</li>
                                <li>全国累计死亡</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <data-china />
            <country-variety />
            <risk-advice />
            <new-news />
            <key-cloud />
            <map-beijing />
            <map-china />

            <div class="divider"></div>

        </div>

    </div>
</template>

<script>
    import { screenSize } from '@/assets/js/utils'
    import countTo from 'vue-count-to'
    import IncreasedLine from "../components/increasedLine/index";
    import WordCloud from "../components/worldCloud/index";
    import News from "../components/news/index";
    import WorldData from "../components/worldData/index";
    import CountryDead from "../components/countryDead/index";
    import CountryVariety from "../components/countryVariety/index";
    import WorldMap from "../components/worldMap/index";
    import MapChina from "../components/mapChina/index";
    import DataChina from "../components/dataChina/index";
    import MapBeijing from "../components/mapBeijing/index";
    import KeyCloud from "../components/keyCloud/index";
    import NewNews from "../components/newNews/index";
    import RiskAdvice from "../components/riskAdvice/index";

    export default {
        name: 'Beijing',
        components: {
            RiskAdvice,
            NewNews,
            KeyCloud,
            MapBeijing,
            DataChina,
            MapChina,
            CountryDead,
            WorldData,
            WorldMap,
            News,
            countTo
        },
        data() {
            return {

            }
        },
        computed: {

        },
        created() {
        },
        mounted() {
            screenSize(this.$refs.editor);
        },
        methods: {

        }
    }
</script>


<style lang="scss" scoped>
    .home-container {
        position: absolute;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        .wrap {
            transform-origin: 0px 0px 0px;
            background-size: contain;
            background-position: 50% 0;
            background-color: rgba(91,92,110,1);
          //  background-color: transparent;
            min-width: auto;
            width: 1920px;
            min-height: auto;
            height: 1080px;
            overflow: auto;
            .top {
                position: absolute;
                left: 0;
                top: 0;
                width: 100%;
                height: 80px;
                background-color: transparent;
              //  background: url(../assets/img/top_nav.png) no-repeat;
                background-position: 65% 0;
                border: none;
                overflow: hidden;
            }
            .divider {
                position: absolute;
                left: 50px;
                top: 3253px;
                width: 90%;
                height: 50px;
                width: 300px;
                border: none;
                background: transparent;
            }
            .center{
            //    left: 600px;
            //    top: 20px;
                width: 100%;
                height: 72px;
                &:before {
                    content: "";
                    position: absolute;
                    width: 30px;
                    height: 10px;
                    border-top: 2px solid #02a6b5;
                    border-left: 2px solid #02a6b5;
                    top: 0;
                    left: 0;
                }
                &:after {
                    content: "";
                    position: absolute;
                    width: 30px;
                    height: 10px;
                    border-bottom: 2px solid #02a6b5;
                    border-right: 2px solid #02a6b5;
                    right: 0;
                    bottom: 0;
                }
                .item {
                    background-color: rgba(101, 132, 226, 0.1);
                    flex: 3;

                    &.center {
                        flex: 5;
                        margin: 0 0.125rem 0.1rem;
                        overflow: hidden;

                        .resume {
                 //           background: rgba(101, 132, 226, 0.1);
                            padding: 0.1875rem;
                            .resume-hd {
                                position: relative;
                    //            border: 1px solid rgba(25, 186, 139, 0.17);
                                ul {
                                    display: flex;
                             /*       %li-line {
                                        content: "";
                                        position: absolute;
                                        height: 100%;
                                        width: 1px;
                                        background: rgba(255, 255, 255, 0.2);
                                        top: 0px;
                                    }*/
                                    li {
                                        position: relative;
                                        flex: 1;
                                        text-align: center;
                                        top: 20px;
                                        height: 50px;
                                        line-height: 1.2rem;
                                        font-size: 20px;
                                        color: #ffeb7b;
                                        padding: 0.05rem 0;
                                        font-family: 'DIGITALDREAMFAT';
                                        font-weight: bold;
                                   /*     &:nth-child(2) {
                                            &:after {
                                                @extend %li-line;
                                                right: 0;
                                            }
                                            &:before {
                                                @extend %li-line;
                                                left: 0;
                                            }
                                        }*/
                                    }
                                }

                            }
                            .resume-bd {
                                ul {
                                    display: flex;
                                    li {
                                        flex: 1;
                                        height: 0.5rem;
                                        line-height: 0.5rem;
                                        text-align: center;
                                        font-size: 0.225rem;
                                        color: rgba(255, 255, 255, 0.7);
                                        padding-top: 0.125rem;
                                    }
                                }
                            }
                        }
                    }

                    .panel {
                        position: relative;
                        height: 3.875rem;
                  //      border: 1px solid rgba(25, 186, 139, 0.17);
                  //      background: rgba(255, 255, 255, 0.04) url(../assets/img/brand/line.png);
                        padding: 0 0.1875rem 0;
                        margin-bottom: 0.1875rem;
                        &:before {
                            position: absolute;
                            top: 0;
                            left: 0;
                            content: "";
                            width: 10px;
                            height: 10px;
                            border-top: 2px solid #02a6b5;
                            border-left: 2px solid #02a6b5;
                        }
                        &:after {
                            position: absolute;
                            top: 0;
                            right: 0;
                            content: "";
                            width: 10px;
                            height: 10px;
                            border-top: 2px solid #02a6b5;
                            border-right: 2px solid #02a6b5;
                        }

                        .panel-footer {
                            position: absolute;
                            left: 0;
                            bottom: 0;
                            width: 100%;
                            &:before {
                                position: absolute;
                                bottom: 0;
                                left: 0;
                                content: "";
                                width: 10px;
                                height: 10px;
                                border-bottom: 2px solid #02a6b5;
                                border-left: 2px solid #02a6b5;
                            }
                            &:after {
                                position: absolute;
                                bottom: 0;
                                right: 0;
                                content: "";
                                width: 10px;
                                height: 10px;
                                border-bottom: 2px solid #02a6b5;
                                border-right: 2px solid #02a6b5;
                            }
                        }

                        h2 {
                            height: 0.6rem;
                            line-height: 0.6rem;
                            text-align: center;
                            color: #fff;
                            font-size: 0.225rem;
                            font-weight: 400;
                            a {
                                margin: 0 0.1875rem;
                                color: #fff;
                                text-decoration: none;
                            }
                        }
                        .chart {
                            height: 3rem;
                        }
                    }
                }

            }

        }
    }

    @-webkit-keyframes rotate {
        from {
            transform: translate(-50%, -50%) rotate(0deg);
        }
        to {
            transform: translate(-50%, -50%) rotate(360deg);
        }
    }
    @keyframes rotate {
        from {
            transform: translate(-50%, -50%) rotate(0deg);
        }
        to {
            transform: translate(-50%, -50%) rotate(360deg);
        }
    }

    @-webkit-keyframes rotate1 {
        from {
            transform: translate(-50%, -50%) rotate(0deg);
        }
        to {
            transform: translate(-50%, -50%) rotate(-360deg);
        }
    }
    @keyframes rotate1 {
        from {
            transform: translate(-50%, -50%) rotate(0deg);
        }
        to {
            transform: translate(-50%, -50%) rotate(-360deg);
        }
    }

    @media screen and (max-width: 1024px) {
        html {
            font-size: 42px !important;
        }
    }
    @media screen and (min-width: 1920px) {
        html {
            font-size: 80px !important;
        }
    }
</style>
