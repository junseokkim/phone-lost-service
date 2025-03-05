
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import LostphonereportLostPhoneReportManager from "./components/listers/LostphonereportLostPhoneReportCards"
import LostphonereportLostPhoneReportDetail from "./components/listers/LostphonereportLostPhoneReportDetail"

import PhonemanagementDeviceManager from "./components/listers/PhonemanagementDeviceCards"
import PhonemanagementDeviceDetail from "./components/listers/PhonemanagementDeviceDetail"
import PhonemanagementRemoteLockManager from "./components/listers/PhonemanagementRemoteLockCards"
import PhonemanagementRemoteLockDetail from "./components/listers/PhonemanagementRemoteLockDetail"

import InqurySelfPhoneView from "./components/InqurySelfPhoneView"
import InqurySelfPhoneViewDetail from "./components/InqurySelfPhoneViewDetail"
import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"

import DevicerecoveryRecoveryManager from "./components/listers/DevicerecoveryRecoveryCards"
import DevicerecoveryRecoveryDetail from "./components/listers/DevicerecoveryRecoveryDetail"

import PhonerentalRentalManager from "./components/listers/PhonerentalRentalCards"
import PhonerentalRentalDetail from "./components/listers/PhonerentalRentalDetail"

import ServicemanagementImeiBlockManager from "./components/listers/ServicemanagementImeiBlockCards"
import ServicemanagementImeiBlockDetail from "./components/listers/ServicemanagementImeiBlockDetail"
import ServicemanagementUsimBlockManager from "./components/listers/ServicemanagementUsimBlockCards"
import ServicemanagementUsimBlockDetail from "./components/listers/ServicemanagementUsimBlockDetail"

import 본인기기Imei차단정보조회View from "./components/본인기기Imei차단정보조회View"
import 본인기기Imei차단정보조회ViewDetail from "./components/본인기기Imei차단정보조회ViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/lostphonereports/lostPhoneReports',
                name: 'LostphonereportLostPhoneReportManager',
                component: LostphonereportLostPhoneReportManager
            },
            {
                path: '/lostphonereports/lostPhoneReports/:id',
                name: 'LostphonereportLostPhoneReportDetail',
                component: LostphonereportLostPhoneReportDetail
            },

            {
                path: '/phonemanagements/devices',
                name: 'PhonemanagementDeviceManager',
                component: PhonemanagementDeviceManager
            },
            {
                path: '/phonemanagements/devices/:id',
                name: 'PhonemanagementDeviceDetail',
                component: PhonemanagementDeviceDetail
            },
            {
                path: '/phonemanagements/remoteLocks',
                name: 'PhonemanagementRemoteLockManager',
                component: PhonemanagementRemoteLockManager
            },
            {
                path: '/phonemanagements/remoteLocks/:id',
                name: 'PhonemanagementRemoteLockDetail',
                component: PhonemanagementRemoteLockDetail
            },

            {
                path: '/phonemanagements/inqurySelfPhones',
                name: 'InqurySelfPhoneView',
                component: InqurySelfPhoneView
            },
            {
                path: '/phonemanagements/inqurySelfPhones/:id',
                name: 'InqurySelfPhoneViewDetail',
                component: InqurySelfPhoneViewDetail
            },
            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },

            {
                path: '/devicerecoveries/recoveries',
                name: 'DevicerecoveryRecoveryManager',
                component: DevicerecoveryRecoveryManager
            },
            {
                path: '/devicerecoveries/recoveries/:id',
                name: 'DevicerecoveryRecoveryDetail',
                component: DevicerecoveryRecoveryDetail
            },

            {
                path: '/phonerentals/rentals',
                name: 'PhonerentalRentalManager',
                component: PhonerentalRentalManager
            },
            {
                path: '/phonerentals/rentals/:id',
                name: 'PhonerentalRentalDetail',
                component: PhonerentalRentalDetail
            },

            {
                path: '/servicemanagements/imeiBlocks',
                name: 'ServicemanagementImeiBlockManager',
                component: ServicemanagementImeiBlockManager
            },
            {
                path: '/servicemanagements/imeiBlocks/:id',
                name: 'ServicemanagementImeiBlockDetail',
                component: ServicemanagementImeiBlockDetail
            },
            {
                path: '/servicemanagements/usimBlocks',
                name: 'ServicemanagementUsimBlockManager',
                component: ServicemanagementUsimBlockManager
            },
            {
                path: '/servicemanagements/usimBlocks/:id',
                name: 'ServicemanagementUsimBlockDetail',
                component: ServicemanagementUsimBlockDetail
            },

            {
                path: '/servicemanagements/본인기기Imei차단정보조회',
                name: '본인기기Imei차단정보조회View',
                component: 본인기기Imei차단정보조회View
            },
            {
                path: '/servicemanagements/본인기기Imei차단정보조회/:id',
                name: '본인기기Imei차단정보조회ViewDetail',
                component: 본인기기Imei차단정보조회ViewDetail
            },


    ]
})
