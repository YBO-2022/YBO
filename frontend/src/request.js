import axios from "axios";

const SERVER_URL = "http://ybophase1-env.eba-xrkwqpmp.ap-northeast-2.elasticbeanstalk.com/api"
const request = axios.create({
  baseURL: process.env.NODE_ENV === 'development' ? SERVER_URL : '/api',
});
export default request;
