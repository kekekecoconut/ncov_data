import {request} from "./request";

export function getNewsData() {
    return request({
        url: '/api/newsList'
    })
}

export function getConfirmedData() {
    return request({
        url: '/api/confirmedData'
    })
}

export function getCountryData() {
    return request({
        url: '/api/allCountry'
    })
}

export function getChinaData() {
    return request({
        url: '/api/allProvinces'
    })
}

export function getWorldClouds() {
    return request({
        url: '/api/worldClouds'
    })
}

export function getCountryConfirmed() {
    return request({
        url: '/api/currentCountryConfirmed'
    })
}
