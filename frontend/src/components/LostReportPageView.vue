<template>

    <v-data-table
        :headers="headers"
        :items="lostReportPage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'LostReportPageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "lostReportId", value: "lostReportId" },
                { text: "deviceId", value: "deviceId" },
                { text: "lostReportStatus", value: "lostReportStatus" },
            ],
            lostReportPage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/lostReportPages'))

            temp.data._embedded.lostReportPages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.lostReportPage = temp.data._embedded.lostReportPages;
        },
        methods: {
        }
    }
</script>

