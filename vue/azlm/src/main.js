import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "@/utils/ajax"
//引入axios
import axios from 'axios';
import './plugins/axios.js';


//引入elementui
import "@/utils/elementui";

axios.defaults.baseURL = 'http://localhost:8080/';

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
