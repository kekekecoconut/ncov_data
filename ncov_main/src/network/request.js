import axios from 'axios'

export function request (config) {
    const instance = axios.create({
        baseURL: 'http://localhost:8080',
        timeout: 5000
    })

    instance.interceptors.request.use(config => {
        return config
        // eslint-disable-next-line no-unused-vars
    }, err => {

    })

    instance.interceptors.response.use(res => {
        return res.data
    }, err => {
        console.log(err)
    })

    return instance(config)
}
