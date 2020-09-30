import countryDead from './countryDead' // 登录界面背景图动画
import countryVariety from './countryVariety' // 自定义全局模态框
import increasedLine from './increasedLine' // 司南排名图
import news from './news' // 新闻无缝滚动
import worldCloud from './worldCloud' // 金字塔动画
import worldData from './worldData'
import worldMap from './worldMap'

const components = {
  countryDead,
  countryVariety,
  increasedLine,
  news,
  worldCloud,
  worldData,
  worldMap
};

const install = (Vue = {}) => {
  if (install.installed) return;
  Object.keys(components).forEach(component => {
    Vue.component(components[component].name, components[component]);
  });

  install.installed = true;
};

install.installed = false;

if (typeof window !== "undefined" && window.Vue) {
  install(window.Vue);
  install.installed = true;
}

const Vcomp = {
  ...components,
  install
};


export default Vcomp
