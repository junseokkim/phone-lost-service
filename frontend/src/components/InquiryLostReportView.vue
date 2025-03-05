<template>

    <v-data-table
        :headers="headers"
        :items="inquiryLostReport"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'InquiryLostReportView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            inquiryLostReport : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/inquiryLostReports'))

            temp.data._embedded.inquiryLostReports.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.inquiryLostReport = temp.data._embedded.inquiryLostReports;
        },
        methods: {
        }
    }
</script>

