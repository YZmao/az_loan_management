import Vue from "vue";
import axios from "axios";
import { Message } from "element-ui";

const ajax = axios.create({
    baseURL : "http://localhost:8080"
})


ajax.interceptors.response.use((res) => {
    console.log("打印返回数据！！！");
    console.log(res);
        return new Primise((reslove, reject)=>{
            reslove(res)
        })
    },
    (err) =>{
    console.log("异常",err.response)
        if(err.response.status === 400){
            Message.error(err.response.data().message);
        }else if(err.response.status === 401){
            Message.error("你未登录，请登录后操作！！");
        }else if(err.response.status === 500){
            Message.error("后端异常---》"+ err.response.data().message);
        }else {
            Message.error("未知错误！");
        }
    });

Vue.prototype.$ajax = ajax;